/**
 * 
 */
package org.openntf.red.nsf.impl.couch;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openntf.red.nsf.endpoint.View;
import org.openntf.red.nsf.endpoint.ViewEntry;
import org.openntf.red.nsf.endpoint.ViewEntryCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

//import javolution.util.FastTable;

/**
 * @author Vladimir Kornienko
 *
 */
public class CouchViewEntryCollection implements ViewEntryCollection<CouchEndpoint, CouchEndpointFactory, CouchView> {

	private static Logger log = Logger.getLogger(CouchViewEntryCollection.class.getName());

	private WebTarget target;
	private ObjectNode selection;
	private long offset;
	private long cachesize;
	private long lastentryidx;
	private ObjectNode cache;
	private ArrayNode cacheView;
	private CouchView parent;
	private ObjectMapper mapper;

	/**
	 * 
	 */
	CouchViewEntryCollection(WebTarget _target, ObjectNode _selection, CouchView _parent) {
		// init variables
		target = _target;
		selection = _selection;
		parent = _parent;
		offset = 0;
		lastentryidx = -1;
		// TODO make this configurable
		cachesize = Defaults.DEFAULT_PAGE_SIZE;
		cache = null;
		mapper = new ObjectMapper();
	}

	@Override
	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String name, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object removeProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouchEndpointFactory getAncestorFactory() {
		return parent.getAncestorFactory();
	}

	@Override
	public CouchEndpoint getAncestorEndpoint() {
		return parent.getAncestorEndpoint();
	}

	@Override
	public CouchView getParent() {
		return parent;
	}

	public static class Defaults {
		// misc values
		public static final long DEFAULT_PAGE_SIZE = 30;
		// view system
		public static final String VIEW_RESULTS_WRAPPER = "docs";
		// field names
		public static final String SELECTION_FIELD_OFFSET = "skip";
		public static final String SELECTION_FIELD_PAGESIZE = "limit";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getFirstEntry() {
		if (offset == 0 && null != cacheView && cacheView.size() > 0)
			return new CouchViewEntry((ObjectNode) ((ArrayNode) cache.get(Defaults.VIEW_RESULTS_WRAPPER)).get(0), 0,
					this);
		firstPage();
		if (cacheView.size() == 0)
			return null;
		ObjectNode rawentry = (ObjectNode) ((ArrayNode) cache.get(Defaults.VIEW_RESULTS_WRAPPER)).get(0);

		return new CouchViewEntry(rawentry, 0, this);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getNextEntry(ViewEntry entry) {
		long idx = entry.getIndex();
		// TODO recycle entry? - most likely not (should be done on the API
		// layer)

		return getNthEntry(idx + 1);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getLastEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getNthEntry(long n) {
		// TODO Auto-generated method stub
		if (n >= offset && n < offset + cachesize)
			return new CouchViewEntry(
					(ObjectNode) ((ArrayNode) cache.get(Defaults.VIEW_RESULTS_WRAPPER)).get((int) (n - offset)), n,
					this);
		// paginate to the correct page
		// TODO maybe use a more efficient mechanism?
		while(n < offset)
			offset -= cachesize;
		while(n >= offset + cachesize)
			offset += cachesize;
		// clear cache
		if (null != cacheView)
			cacheView.removeAll();
		cacheView = null;
		if (null != cache)
			cache.removeAll();
		cache = null;
		selection.put(Defaults.SELECTION_FIELD_OFFSET, offset);
		selection.put(Defaults.SELECTION_FIELD_PAGESIZE, cachesize);
		queryPage();
		// if no entries available or ran into end of collection
		if (cacheView.size() == 0 || (n - offset) >= cacheView.size())
			return null;
		
		ObjectNode rawentry = (ObjectNode) ((ArrayNode) cache.get(Defaults.VIEW_RESULTS_WRAPPER)).get((int)(n - offset));
		
		return new CouchViewEntry(rawentry, n, this);
	}

	void firstPage() {
		offset = 0;
		if (null != cacheView)
			cacheView.removeAll();
		cacheView = null;
		if (null != cache)
			cache.removeAll();
		cache = null;
		selection.put(Defaults.SELECTION_FIELD_OFFSET, offset);
		selection.put(Defaults.SELECTION_FIELD_PAGESIZE, cachesize);
		queryPage();
	}

	void lastPage() {

	}

	private void queryPage() {
		log.finest("Will be posting: [" + selection.toString() + "]");
		log.finest("Querying target: " + target.toString());
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(selection.toString(), MediaType.APPLICATION_JSON_TYPE));
		log.finest("Query response status: " + response.getStatus());
		if (response.getStatus() != Response.Status.OK.getStatusCode())
			return;
		// TODO maybe something else here (exception)?
		try {
			String sresult = response.readEntity(String.class);//.replaceAll("[\n]", "");
			log.finest("Came back: [" + sresult + "]");
			//JsonNode node = mapper.readTree(sresult);
			//log.finest("Parsed: " + node);
			cache = (ObjectNode) mapper.readTree(sresult);
			log.finest("cache: [" + cache.toString() + "]");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (null == cache)
			return;
		if (!cache.has(Defaults.VIEW_RESULTS_WRAPPER)) {
			cache.removeAll();
			cache = null;
			return;
		}
		cacheView = (ArrayNode) cache.get(Defaults.VIEW_RESULTS_WRAPPER);
	}
	
	private long findLastElementIdx() {
		return -1;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ViewEntry getPrevEntry(ViewEntry entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public View getAncestorView() {
		// TODO Auto-generated method stub
		return parent;
	}
}
