package org.openntf.red;

import java.io.Externalizable;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.openntf.red.NoteCollection.SelectOption;
import org.openntf.red.annotations.Legacy;
import org.openntf.red.design.DatabaseDesign;
import org.openntf.red.events.EnumEvent;
import org.openntf.red.events.IDominoEvent;
import org.openntf.red.events.IDominoEventFactory;
import org.openntf.red.schema.IDatabaseSchema;
import org.openntf.red.transactions.IDatabaseTransaction;
import org.openntf.red.types.SessionDescendant;
import org.openntf.red.util.AutoMime;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * The Interface Database.
 */
public interface Database extends lotus.domino.Database, org.openntf.red.Base, SessionDescendant,
		ExceptionDetails, Externalizable {

	/**
	 * Generic database utilities
	 * 
	 * @deprecated RPr: As far as I know, this was only used in the DbDirectory
	 */
	@Deprecated
	public enum Utils {
		;
		/**
		 * Checks whether the database is a template with .ntf (Notes Template
		 * Facility) file type
		 * 
		 * @param db
		 *            Database to check
		 * @return boolean whether the database has a .ntf suffix or not
		 * @since org.openntf.domino 4.5.0
		 */
		public static boolean isTemplate(final Database db) {
			return db.getFilePath().toLowerCase().endsWith(".ntf");
		}

		/**
		 * Checks whether the database is a database with .nsf-style (Notes
		 * Storage Facility) file type
		 * 
		 * @param db
		 *            Database to check
		 * @return boolean whether the database has a .nsf, .nsh or .nsg suffix
		 *         or not
		 * @since org.openntf.domino 4.5.0
		 */
		public static boolean isDatabase(final Database db) {
			String path = db.getFilePath().toLowerCase();
			return (path.endsWith(".nsf") || path.endsWith(".nsh") || path.endsWith(".nsg"));
		}

		/**
		 * Checks whether replication is disabled for the specified Database
		 * 
		 * @param db
		 *            Database to check
		 * @return boolean whether
		 *         {@link org.openntf.domino.Database#isReplicationDisabled()}
		 *         is true
		 * @since org.openntf.domino 4.5.0
		 */
		public static boolean isReplicaCandidate(final Database db) {
			boolean result = true;
			result = db.isReplicationDisabled();
			return result;
		}

		/**
		 * Not currently implemented, just returns true
		 * 
		 * @param db
		 *            Database to check
		 * @return boolean, currently always returns true
		 * @since org.openntf.domino 4.5.0
		 */
		public static boolean isTemplateCandidate(final Database db) {
			boolean result = true;
			// TODO do we actually want to add any future checks for this?
			return result;
		}
	}

	/**
	 * Comparator to allow easy checking whether two databases have the same
	 * filepath (e.g. on different servers)
	 * 
	 * @Deprecated better use the DatabaseHolder for sorting
	 * @since org.openntf.domino 4.5.0
	 */
	@Deprecated
	public final static Comparator<Database> FILEPATH_COMPARATOR = new Comparator<Database>() {
		@Override
		public int compare(final Database o1, final Database o2) {
			return o1.getFilePath().compareToIgnoreCase(o2.getFilePath());
		}
	};

	/**
	 * Comparator to alow easy checking whether database A was modified
	 * before/after database B
	 * 
	 * @Deprecated better use the DatabaseHolder for sorting
	 * @since org.openntf.domino 4.5.0
	 */
	@Deprecated
	public final static Comparator<Database> LASTMOD_COMPARATOR = new Comparator<Database>() {
		@Override
		public int compare(final Database o1, final Database o2) {
			return o1.getLastModifiedDate().compareTo(o2.getLastModifiedDate());
		}
	};

	/**
	 * Comparator to allow easy checking whether two databases have the same
	 * title
	 * 
	 * @Deprecated better use the DatabaseHolder for sorting
	 * @since org.openntf.domino 4.5.0
	 */
	@Deprecated
	public final static Comparator<Database> TITLE_COMPARATOR = new Comparator<Database>() {
		@Override
		public int compare(final Database o1, final Database o2) {
			return o1.getTitle().compareToIgnoreCase(o2.getTitle());
		}
	};

	/**
	 * Comparator to allow easy checking whether two databases have the same API
	 * path (server!!filepath)
	 * 
	 * @Deprecated better use the DatabaseHolder for sorting
	 * @since org.openntf.domino 4.5.0
	 */
	@Deprecated
	public final static Comparator<Database> APIPATH_COMPARATOR = new Comparator<Database>() {
		@Override
		public int compare(final Database o1, final Database o2) {
			return o1.getApiPath().compareToIgnoreCase(o2.getApiPath());
		}
	};

	/**
	 * Enum to allow easy access to database options for use with
	 * {@link org.openntf.domino.Database#getOption(DBOption)} method
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	// TODO: Remove OPTIMIZAION for 3.0
	public static enum DBOption {
		LZ1(Database.DBOPT_LZ1), LZCOMPRESSION(Database.DBOPT_LZCOMPRESSION), MAINTAINLASTACCESSED(
				Database.DBOPT_MAINTAINLASTACCESSED), MOREFIELDS(Database.DBOPT_MOREFIELDS), NOHEADLINEMONITORS(
						Database.DBOPT_NOHEADLINEMONITORS), NOOVERWRITE(Database.DBOPT_NOOVERWRITE), NORESPONSEINFO(
								Database.DBOPT_NORESPONSEINFO), NOTRANSACTIONLOGGING(
										Database.DBOPT_NOTRANSACTIONLOGGING), NOUNREAD(
												Database.DBOPT_NOUNREAD), OPTIMIZAION(
														Database.DBOPT_OPTIMIZATION), OPTIMIZATION(
																Database.DBOPT_OPTIMIZATION), REPLICATEUNREADMARKSTOANY(
																		Database.DBOPT_REPLICATEUNREADMARKSTOANY), REPLICATEUNREADMARKSTOCLUSTER(
																				Database.DBOPT_REPLICATEUNREADMARKSTOCLUSTER), REPLICATEUNREADMARKSNEVER(
																						Database.DBOPT_REPLICATEUNREADMARKSNEVER), SOFTDELETE(
																								Database.DBOPT_SOFTDELETE), COMPRESSDESIGN(
																										Database.DBOPT_COMPRESSDESIGN), COMPRESSDOCUMENTS(
																												Database.DBOPT_COMPRESSDOCUMENTS), OUTOFOFFICEENABLED(
																														Database.DBOPT_OUTOFOFFICEENABLED), NOSIMPLESEARCH(
																																Database.DBOPT_NOSIMPLESEARCH), USEDAOS(
																																		Database.DBOPT_USEDAOS);

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new dB option.
		 * 
		 * @param value
		 *            the value
		 */
		private DBOption(final int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}

		public static DBOption valueOf(final int value) {
			for (DBOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to database signing options for use with
	 * {@link org.openntf.domino.Database} sign methods
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public static enum SignDocType {

		/** The acl. */
		ACL(Database.DBSIGN_DOC_ACL),
		/** The agent. */
		AGENT(Database.DBSIGN_DOC_AGENT),
		/** The all. */
		ALL(Database.DBSIGN_DOC_ALL),
		/** The data. */
		DATA(Database.DBSIGN_DOC_DATA),
		/** The form. */
		FORM(Database.DBSIGN_DOC_FORM),
		/** The help. */
		HELP(Database.DBSIGN_DOC_HELP),
		/** The icon. */
		ICON(Database.DBSIGN_DOC_ICON),
		/** The replformula. */
		REPLFORMULA(Database.DBSIGN_DOC_REPLFORMULA),
		/** The sharedfield. */
		SHAREDFIELD(Database.DBSIGN_DOC_SHAREDFIELD),
		/** The view. */
		VIEW(Database.DBSIGN_DOC_VIEW);

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new sign doc type.
		 * 
		 * @param value
		 *            the value
		 */
		private SignDocType(final int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}

		public static SignDocType valueOf(final int value) {
			for (SignDocType opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to options for
	 * {@link org.openntf.domino.Database} compact methods
	 * 
	 * @since org.openntf.domino 1.0.0
	 */
	public static enum CompactOption {
		ARCHIVE_DELETE_COMPACT(Database.CMPC_ARCHIVE_DELETE_COMPACT), ARCHIVE_DELETE_ONLY(
				Database.CMPC_ARCHIVE_DELETE_ONLY), CHK_OVERLAP(Database.CMPC_CHK_OVERLAP), COPYSTYLE(
						Database.CMPC_COPYSTYLE), DISABLE_DOCTBLBIT_OPTMZN(
								Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN), DISABLE_LARGE_UNKTBL(
										Database.CMPC_DISABLE_LARGE_UNKTBL), DISABLE_RESPONSE_INFO(
												Database.CMPC_DISABLE_RESPONSE_INFO), DISABLE_TRANSACTIONLOGGING(
														Database.CMPC_DISABLE_TRANSACTIONLOGGING), DISABLE_UNREAD_MARKS(
																Database.CMPC_DISABLE_UNREAD_MARKS), DISCARD_VIEW_INDICIES(
																		Database.CMPC_DISCARD_VIEW_INDICES), ENABLE_DOCTBLBIT_OPTMZN(
																				Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN), ENABLE_LARGE_UNKTBL(
																						Database.CMPC_ENABLE_LARGE_UNKTBL), ENABLE_RESPONSE_INFO(
																								Database.CMPC_ENABLE_RESPONSE_INFO), ENABLE_TRANSACTIONLOGGING(
																										Database.CMPC_ENABLE_TRANSACTIONLOGGING), ENABLE_UNREAD_MARKS(
																												Database.CMPC_ENABLE_UNREAD_MARKS), IGNORE_COPYSTYLE_ERRORS(
																														Database.CMPC_IGNORE_COPYSTYLE_ERRORS), MAX_4GB(
																																Database.CMPC_MAX_4GB), NO_LOCKOUT(
																																		Database.CMPC_NO_LOCKOUT), RECOVER_INPLACE(
																																				Database.CMPC_RECOVER_INPLACE), RECOVER_REDUCE_INPLACE(
																																						Database.CMPC_RECOVER_REDUCE_INPLACE), REVERT_FILEFORMAT(
																																								Database.CMPC_REVERT_FILEFORMAT);

		private final int value_;

		private CompactOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static CompactOption valueOf(final int value) {
			for (CompactOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to FTIndex options for
	 * {@link org.openntf.domino.Database#createFTIndex(java.util.Set, boolean)}
	 * method
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTIndexOption {
		ALL_BREAKS(Database.FTINDEX_ALL_BREAKS), ATTACHED_BIN_FILES(
				Database.FTINDEX_ATTACHED_BIN_FILES), ATTACHED_FILES(Database.FTINDEX_ATTACHED_FILES), CASE_SENSITIVE(
						Database.FTINDEX_CASE_SENSITIVE), ENCRYPTED_FIELDS(Database.FTINDEX_ENCRYPTED_FIELDS);

		private final int value_;

		private FTIndexOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTIndexOption valueOf(final int value) {
			for (FTIndexOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to fixup options for
	 * {@link org.openntf.domino.Database#fixup(java.util.Set)} method
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FixupOption {
		INCREMENTAL(Database.FIXUP_INCREMENTAL), NODELETE(Database.FIXUP_NODELETE), NOVIEWS(
				Database.FIXUP_NOVIEWS), QUICK(Database.FIXUP_QUICK), REVERT(
						Database.FIXUP_REVERT), TXLOGGED(Database.FIXUP_TXLOGGED), VERIFY(Database.FIXUP_VERIFY);

		private final int value_;

		private FixupOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FixupOption valueOf(final int value) {
			for (FixupOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to FTIndex frequency options for
	 * {@link org.openntf.domino.Database#setFTIndexFrequency(FTIndexFrequency)}
	 * method
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTIndexFrequency {
		DAILY(Database.FTINDEX_DAILY), HOURLY(Database.FTINDEX_HOURLY), IMMEDIATE(
				Database.FTINDEX_IMMEDIATE), SCHEDULED(Database.FTINDEX_SCHEDULED);

		private final int value_;

		private FTIndexFrequency(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTIndexFrequency valueOf(final int value) {
			for (FTIndexFrequency opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to provide easy access to FTDomain sort options, used by
	 * {@link org.openntf.domino.Database} FTDomainSearch methods
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTDomainSortOption {
		SCORES(Database.FT_SCORES), DATE_DES(Database.FT_DATE_DES), DATE_ASC(Database.FT_DATE_ASC);

		private final int value_;

		private FTDomainSortOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTDomainSortOption valueOf(final int value) {
			for (FTDomainSortOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to FTDomain search option, used by
	 * {@link org.openntf.domino.Database#FTDomainSearch(String, int, FTDomainSortOption, java.util.Set, int, int, String)}
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTDomainSearchOption {
		DATABASE(Database.FT_DATABASE), FILESYSTEM(Database.FT_FILESYSTEM), FUZZY(Database.FT_FUZZY), STEMS(
				Database.FT_STEMS);

		private final int value_;

		private FTDomainSearchOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTDomainSearchOption valueOf(final int value) {
			for (FTDomainSearchOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to FTSearch sort options for use by
	 * {@link org.openntf.domino.Database} FTSearch methods
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTSortOption {
		SCORES(Database.FT_SCORES), DATE_DES(Database.FT_DATE_DES), DATE_ASC(Database.FT_DATE_ASC), DATECREATED_DES(
				Database.FT_DATECREATED_DES), DATECREATED_ASC(Database.FT_DATECREATED_ASC);

		private final int value_;

		private FTSortOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTSortOption valueOf(final int value) {
			for (FTSortOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to FTSearch options for use by
	 * {@link org.openntf.domino.Database} FTSearch methods
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum FTSearchOption {
		FUZZY(Database.FT_FUZZY), STEMS(Database.FT_STEMS);

		private final int value_;

		private FTSearchOption(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTSearchOption valueOf(final int value) {
			for (FTSearchOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to provide easy access to modified documents class, for use with
	 * {@link org.openntf.domino.Database} getModifiedDocuments methods
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum ModifiedDocClass {
		ACL(Database.DBMOD_DOC_ACL), AGENT(Database.DBMOD_DOC_AGENT), ALL(Database.DBMOD_DOC_ALL), DATA(
				Database.DBMOD_DOC_DATA), FORM(Database.DBMOD_DOC_FORM), HELP(Database.DBMOD_DOC_HELP), ICON(
						Database.DBMOD_DOC_ICON), REPLFORMULA(Database.DBMOD_DOC_REPLFORMULA), SHAREDFIELD(
								Database.DBMOD_DOC_SHAREDFIELD), VIEW(Database.DBMOD_DOC_VIEW);

		private final int value_;

		private ModifiedDocClass(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static ModifiedDocClass valueOf(final int value) {
			for (ModifiedDocClass opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * Enum to allow easy access to database types for use with
	 * {@link org.openntf.domino.Database#getType()} method
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public static enum Type {
		ADDR_BOOK(Database.DBTYPE_ADDR_BOOK), IMAP_SVR_PROXY(Database.DBTYPE_IMAP_SVR_PROXY), LIBRARY(
				Database.DBTYPE_LIBRARY), LIGHT_ADDR_BOOK(Database.DBTYPE_LIGHT_ADDR_BOOK), MAILBOX(
						Database.DBTYPE_MAILBOX), MAILFILE(Database.DBTYPE_MAILFILE), MULTIDB_SRCH(
								Database.DBTYPE_MULTIDB_SRCH), NEWS_SVR_PROXY(
										Database.DBTYPE_NEWS_SVR_PROXY), PERS_JOURNAL(
												Database.DBTYPE_PERS_JOURNAL), PORTFOLIO(
														Database.DBTYPE_PORTFOLIO), STANDARD(
																Database.DBTYPE_STANDARD), SUBSCRIPTIONS(
																		Database.DBTYPE_SUBSCRIPTIONS), WEB_APP(
																				Database.DBTYPE_WEB_APP);

		private final int value_;

		private Type(final int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		/**
		 * Return the {@link Database.Type} of a numeric value
		 * 
		 * @param value
		 *            the numeric value
		 * @return a {@link Database.Type} Object
		 */
		public static Type valueOf(final int value) {
			for (Type opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getACLActivityLog()
	 */
	@Override
	@Deprecated
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<String> getACLActivityLog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compact()
	 */
	@Override
	public int compact();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int)
	 */
	@Override
	@Deprecated
	public int compactWithOptions(final int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int, java.lang.String)
	 */
	@Override
	@Deprecated
	public int compactWithOptions(final int options, final String spaceThreshold);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(java.lang.String)
	 */
	@Override
	public int compactWithOptions(final String options);

	/*
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String)
	 */
	@Override
	public Database createCopy(final String server, final String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String,
	 * int)
	 */
	@Override
	@Deprecated
	public Database createCopy(final String server, final String dbFile, final int maxSize);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocument()
	 */
	@Override
	public Document createDocument();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocumentCollection()
	 */
	@Override
	public DocumentCollection createDocumentCollection();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String,
	 * java.lang.String, boolean)
	 */
	@Override
	public Database createFromTemplate(final String server, final String dbFile, final boolean inherit);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String,
	 * java.lang.String, boolean, int)
	 */
	@Override
	public Database createFromTemplate(final String server, final String dbFile, final boolean inherit,
			final int maxSize);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFTIndex(int, boolean)
	 */
	@Override
	@Deprecated
	public void createFTIndex(final int options, final boolean recreate);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createNoteCollection(boolean)
	 */
	@Override
	public NoteCollection createNoteCollection(final boolean selectAllFlag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String)
	 */
	@Override
	public Outline createOutline(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String, boolean)
	 */
	@Override
	public Outline createOutline(final String name, final boolean defaultOutline);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public View createQueryView(final String viewName, final String query);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createQueryView(final String viewName, final String query, final lotus.domino.View templateView);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String,
	 * java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createQueryView(final String viewName, final String query, final lotus.domino.View templateView,
			final boolean prohibitDesignRefresh);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createReplica(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Database createReplica(final String server, final String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView()
	 */
	@Override
	public View createView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String)
	 */
	@Override
	public View createView(final String viewName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createView(final String viewName, final String selectionFormula);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String,
	 * lotus.domino.View)
	 */
	@Override
	public View createView(final String viewName, final String selectionFormula, final lotus.domino.View templateView);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String,
	 * lotus.domino.View, boolean)
	 */
	@Override
	public View createView(final String viewName, final String selectionFormula, final lotus.domino.View templateView,
			final boolean prohibitDesignRefresh);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#enableFolder(java.lang.String)
	 */
	@Override
	public void enableFolder(final String folder);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup()
	 */
	@Override
	public void fixup();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup(int)
	 */
	@Override
	@Deprecated
	public void fixup(final int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTDomainSearch(java.lang.String, int, int,
	 * int, int, int, java.lang.String)
	 */
	@Override
	@Deprecated
	public Document FTDomainSearch(final String query, final int maxDocs, final int sortOpt, final int otherOpt,
			final int start, final int count, final String entryForm);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String)
	 */
	@Override
	public DocumentCollection FTSearch(final String query);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int)
	 */
	@Override
	public DocumentCollection FTSearch(final String query, final int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int, int, int)
	 */
	@Override
	@Deprecated
	public DocumentCollection FTSearch(final String query, final int maxDocs, final int sortOpt, final int otherOpt);

	/**
	 * FT search.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @return the document collection
	 */
	public DocumentCollection FTSearch(final String query, final int maxDocs, final FTSortOption sortOpt,
			final int otherOpt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearchRange(java.lang.String, int, int, int,
	 * int)
	 */
	@Override
	@Deprecated
	public DocumentCollection FTSearchRange(final String query, final int maxDocs, final int sortOpt,
			final int otherOpt, final int start);

	/**
	 * FT search range.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @param start
	 *            the start
	 * @return the document collection
	 */
	public DocumentCollection FTSearchRange(final String query, final int maxDocs, final FTSortOption sortOpt,
			final int otherOpt, final int start);

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see lotus.domino.Database#getACL()
	 */
	@Override
	public ACL getACL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgent(java.lang.String)
	 */
	@Override
	public Agent getAgent(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgents()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<Agent> getAgents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllDocuments()
	 */
	@Override
	public DocumentCollection getAllDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments()
	 */
	@Override
	public DocumentCollection getAllReadDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllReadDocuments(final String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments()
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments(final String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCategories()
	 */
	@Override
	public String getCategories();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCreated()
	 */
	@Override
	public DateTime getCreated();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCurrentAccessLevel()
	 */
	@Override
	public int getCurrentAccessLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDB2Schema()
	 */
	@Override
	public String getDB2Schema();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDesignTemplateName()
	 */
	@Override
	public String getDesignTemplateName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByID(java.lang.String)
	 */
	@Override
	public Document getDocumentByID(final String noteid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByUNID(java.lang.String)
	 */
	@Override
	public Document getDocumentByUNID(final String unid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(final String url, final boolean reload);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean,
	 * boolean, boolean, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(final String url, final boolean reload, final boolean reloadIfModified,
			final boolean urlList, final String charSet, final String webUser, final String webPassword,
			final String proxyUser, final String proxyPassword, final boolean returnImmediately);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileFormat()
	 */
	@Override
	public int getFileFormat();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileName()
	 */
	@Override
	public String getFileName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFilePath()
	 */
	@Override
	public String getFilePath();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFolderReferencesEnabled()
	 */
	@Override
	public boolean getFolderReferencesEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForm(java.lang.String)
	 */
	@Override
	public Form getForm(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForms()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<Form> getForms();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFTIndexFrequency()
	 */
	@Override
	public int getFTIndexFrequency();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getHttpURL()
	 */
	@Override
	public String getHttpURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFixup()
	 */
	@Override
	public DateTime getLastFixup();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFTIndexed()
	 */
	@Override
	public DateTime getLastFTIndexed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastModified()
	 */
	@Override
	public DateTime getLastModified();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitRevisions()
	 */
	@Override
	public double getLimitRevisions();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitUpdatedBy()
	 */
	@Override
	public double getLimitUpdatedBy();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getListInDbCatalog()
	 */
	@Override
	public boolean getListInDbCatalog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getManagers()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<String> getManagers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getMaxSize()
	 */
	@Override
	public long getMaxSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments()
	 */
	@Override
	public DocumentCollection getModifiedDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(final lotus.domino.DateTime since);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime,
	 * int)
	 */
	@Override
	@Deprecated
	public DocumentCollection getModifiedDocuments(final lotus.domino.DateTime since, final int noteClass);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getNotesURL()
	 */
	@Override
	public String getNotesURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOption(int)
	 */
	@Override
	@Deprecated
	public boolean getOption(final int optionName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOutline(java.lang.String)
	 */
	@Override
	public Outline getOutline(final String outlineName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getPercentUsed()
	 */
	@Override
	public double getPercentUsed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocCollection(java.lang.String)
	 */
	@Override
	public DocumentCollection getProfileDocCollection(final String profileName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocument(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Document getProfileDocument(final String profileName, final String profileKey);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicaID()
	 */
	@Override
	public String getReplicaID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicationInfo()
	 */
	@Override
	public Replication getReplicationInfo();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getServer()
	 */
	@Override
	public String getServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSize()
	 */
	@Override
	public double getSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeQuota()
	 */
	@Override
	public int getSizeQuota();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeWarning()
	 */
	@Override
	public long getSizeWarning();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTemplateName()
	 */
	@Override
	public String getTemplateName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTitle()
	 */
	@Override
	public String getTitle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getType()
	 * 
	 * @Deprecated, better use getTypeEx
	 */
	@Override
	@Deprecated
	public int getType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getUndeleteExpireTime()
	 */
	@Override
	public int getUndeleteExpireTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURL()
	 */
	@Override
	public String getURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURLHeaderInfo(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getURLHeaderInfo(final String url, final String header, final String webUser,
			final String webPassword, final String proxyUser, final String proxyPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getView(java.lang.String)
	 */
	@Override
	public View getView(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getViews()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<View> getViews();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#grantAccess(java.lang.String, int)
	 */
	@Override
	@Deprecated
	public void grantAccess(final String name, final int level);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isAllowOpenSoftDeleted()
	 */
	@Override
	public boolean isAllowOpenSoftDeleted();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isClusterReplication()
	 */
	@Override
	public boolean isClusterReplication();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isConfigurationDirectory()
	 */
	@Override
	public boolean isConfigurationDirectory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicReader()
	 */
	@Override
	public boolean isCurrentAccessPublicReader();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicWriter()
	 */
	@Override
	public boolean isCurrentAccessPublicWriter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDB2()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public boolean isDB2();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDelayUpdates()
	 */
	@Override
	public boolean isDelayUpdates();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDesignLockingEnabled()
	 */
	@Override
	public boolean isDesignLockingEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDirectoryCatalog()
	 */
	@Override
	public boolean isDirectoryCatalog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDocumentLockingEnabled()
	 */
	@Override
	public boolean isDocumentLockingEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isFTIndexed()
	 */
	@Override
	public boolean isFTIndexed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInMultiDbIndexing()
	 */
	@Override
	public boolean isInMultiDbIndexing();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInService()
	 */
	@Override
	public boolean isInService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isLink()
	 */
	@Override
	public boolean isLink();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isMultiDbSearch()
	 */
	@Override
	public boolean isMultiDbSearch();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isOpen()
	 */
	@Override
	public boolean isOpen();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPendingDelete()
	 */
	@Override
	public boolean isPendingDelete();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPrivateAddressBook()
	 */
	@Override
	public boolean isPrivateAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPublicAddressBook()
	 */
	@Override
	public boolean isPublicAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#markForDelete()
	 */
	@Override
	public void markForDelete();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#open()
	 */
	@Override
	public boolean open();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openByReplicaID(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean openByReplicaID(final String server, final String replicaId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openIfModified(java.lang.String,
	 * java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public boolean openIfModified(final String server, final String dbFile, final lotus.domino.DateTime modifiedSince);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openWithFailover(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean openWithFailover(final String server, final String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccess(java.lang.String)
	 */
	@Override
	public int queryAccess(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessPrivileges(java.lang.String)
	 */
	@Override
	public int queryAccessPrivileges(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessRoles(java.lang.String)
	 */
	@Override
	public Vector<String> queryAccessRoles(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#removeFTIndex()
	 */
	@Override
	public void removeFTIndex();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#replicate(java.lang.String)
	 */
	@Override
	public boolean replicate(final String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#revokeAccess(java.lang.String)
	 */
	@Override
	public void revokeAccess(final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String)
	 */
	@Override
	public DocumentCollection search(final String formula);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String,
	 * lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection search(final String formula, final lotus.domino.DateTime startDate);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String,
	 * lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection search(final String formula, final lotus.domino.DateTime startDate, final int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setAllowOpenSoftDeleted(boolean)
	 */
	@Override
	public void setAllowOpenSoftDeleted(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setCategories(java.lang.String)
	 */
	@Override
	public void setCategories(final String categories);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDelayUpdates(boolean)
	 */
	@Override
	public void setDelayUpdates(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDesignLockingEnabled(boolean)
	 */
	@Override
	public void setDesignLockingEnabled(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDocumentLockingEnabled(boolean)
	 */
	@Override
	public void setDocumentLockingEnabled(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFolderReferencesEnabled(boolean)
	 */
	@Override
	public void setFolderReferencesEnabled(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFTIndexFrequency(int)
	 */
	@Override
	@Deprecated
	public void setFTIndexFrequency(final int frequency);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInMultiDbIndexing(boolean)
	 */
	@Override
	public void setInMultiDbIndexing(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInService(boolean)
	 */
	@Override
	public void setInService(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitRevisions(double)
	 */
	@Override
	public void setLimitRevisions(final double revisions);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitUpdatedBy(double)
	 */
	@Override
	public void setLimitUpdatedBy(final double updatedBys);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setListInDbCatalog(boolean)
	 */
	@Override
	public void setListInDbCatalog(final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setOption(int, boolean)
	 */
	@Override
	@Deprecated
	public void setOption(final int optionName, final boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeQuota(int)
	 */
	@Override
	public void setSizeQuota(final int quota);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeWarning(int)
	 */
	@Override
	public void setSizeWarning(final int warning);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(final String title);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setUndeleteExpireTime(int)
	 */
	@Override
	public void setUndeleteExpireTime(final int hours);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign()
	 */
	@Override
	public void sign();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int)
	 */
	@Override
	public void sign(final int documentType);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean)
	 */
	@Override
	@Deprecated
	public void sign(final int documentType, final boolean existingSigsOnly);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String)
	 */
	@Override
	@Deprecated
	public void sign(final int documentType, final boolean existingSigsOnly, final String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String, boolean)
	 */
	@Override
	@Deprecated
	public void sign(final int documentType, final boolean existingSigsOnly, final String name,
			final boolean nameIsNoteid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#updateFTIndex(boolean)
	 */
	@Override
	public void updateFTIndex(final boolean create);

	/**
	 * @author Nathan T Freeman
	 * 
	 *         Enum for Database-level events, triggered by listeners.
	 * 
	 *         <p>
	 *         Options are:
	 *         <ul>
	 *         <li>BEFORE_CREATE_DOCUMENT / AFTER_CREATE_DOCUMENT: triggered at
	 *         the start / end of the Database.createDocument method, source and
	 *         target will be Database (newly-created Document has no properties
	 *         or Items set, so no point passing that</li>
	 *         <li>BEFORE_DELETE_DOCUMENT / AFTER_DELETE_DOCUMENT: triggered at
	 *         the start / end of the Document.remove or
	 *         Document.removePermanently methods, source will be Document and
	 *         target will be Database</li>
	 *         <li>BEFORE_UPDATE_DOCUMENT / AFTER_UPDATE_DOCUMENT: triggered at
	 *         the start / end of the Document.save methods (and its variants),
	 *         source will be Document and target will be Database</li>
	 *         <li>BEFORE_REPLICATION / AFTER_REPLICATION: triggered at the
	 *         start / end of the Database.replicate method, source will be
	 *         Database and target will be the server the replication is to be
	 *         performed with</li>
	 *         <li>BEFORE_RUN_AGENT / AFTER_RUN_AGENT: triggered at the start /
	 *         end of the Agent.run method and its variants, source will be
	 *         Agent, target will be Datatbase</li>
	 *         </ul>
	 *         </p>
	 * @since org.openntf.domino 3.0.0
	 * 
	 */
	public static enum Events implements EnumEvent {
		BEFORE_CREATE_DOCUMENT, AFTER_CREATE_DOCUMENT, BEFORE_DELETE_DOCUMENT, AFTER_DELETE_DOCUMENT, BEFORE_UPDATE_DOCUMENT, AFTER_UPDATE_DOCUMENT, BEFORE_REPLICATION, AFTER_REPLICATION, BEFORE_RUN_AGENT, AFTER_RUN_AGENT;
	}

	/**
	 * Gets the factory that manages processing of the IDominoEvents
	 * 
	 * @return IDominoEventFactory containing the IDominoEvents
	 * @since org.openntf.domino 3.0.0
	 */
	public IDominoEventFactory getEventFactory();

	/**
	 * Sets the factory for managing processing of the IDominoEvents
	 * 
	 * @param factory
	 *            IDominoEventFactory containing the IDominoEvents
	 * @since org.openntf.domino 3.0.0
	 */
	public void setEventFactory(IDominoEventFactory factory);

	/**
	 * Generates an IDominoEvent into the IDominoEventFactory. The IDominoEvent
	 * will be for a specific EnumEvent, e.g. BEFORE_CREATE_DOCUMENT. This
	 * method basically triggers the EnumEvent, passing the relevant Objects
	 * that are currently being acted upon. <br/>
	 * <br/>
	 * EnumEvent types and contents can be found in
	 * {@link org.openntf.domino.ext.Database.Events}<br/>
	 * <br/>
	 * The target should not be passed into this method, but the implementation
	 * should pass {@code this} to as the target to
	 * {@link org.openntf.domino.events.IDominoEventFactory.generate}
	 * 
	 * @param event
	 *            EnumEvent being triggered, e.g. BEFORE_CREATE_DOCUMENT.
	 * @param source
	 *            The source object for the event to be run on. The relevant
	 * @param payload
	 *            Object a payload that can be passed along with the Event
	 * @return An IDominoEvent which will be passed to
	 *         {@link org.openntf.domino.ext.Base.fireListener}
	 * @since org.openntf.domino 3.0.0
	 */
	public IDominoEvent generateEvent(EnumEvent event, org.openntf.red.Base source, Object payload);

	/**
	 * NOT YET FULLY IMPLEMENTED. If memory serves me correctly, there were
	 * problems creating a blank DocumentCollection and merging other documents
	 * into them. The core {@link lotus.domino.DocumentCollection.merge} does
	 * not work
	 * 
	 * @return DocumentCollection ready to have Documents merged into it
	 */
	public DocumentCollection createMergeableDocumentCollection();

	/**
	 * Some core XPages controls require a database path in format
	 * server!!filePath. This method will extract the relevant components and
	 * return that format.
	 * 
	 * @return String in format server!!filePath, useful for XPages components
	 * @since org.openntf.domino 4.5.0
	 */
	public String getApiPath();

	/**
	 * The core {@link lotus.domino.Database.compactWithOptions} method takes an
	 * int worked out by adding the integer value for all the relevant options
	 * the developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of {@link org.openntf.domino.CompactOption}
	 * objects.
	 * 
	 * @see org.openntf.domino.Database.CompactOption for options
	 * 
	 * @param options
	 *            Set<CompactOption> of compact options you wish to apply, e.g.
	 *            CompactOption.COPYSTYLE
	 * @return int the difference in bytes between the size of the database
	 *         before and after compacting
	 * @since org.openntf.domino 1.0.0
	 */
	public int compactWithOptions(final Set<CompactOption> options);

	/**
	 * @see org.openntf.domino.ext.Database#compactWithOptions(Set) for why
	 *      overloaded methods for
	 *      {@link lotus.domino.Database.compactWithOptions}
	 * @see org.openntf.domino.Database.CompactOption for options
	 * 
	 * @param options
	 *            Set<CompactOption> of compact options you wish to apply, e.g.
	 *            CompactOption.COPYSTYLE
	 * @param spaceThreshold
	 *            The value of the S option for a compact, but without the S.
	 *            "10" for 10 percent, 10K for 10 kilobytes, 10M for 10
	 *            megabytes
	 * @return int the difference in bytes between the size of the database
	 *         before and after compacting
	 * @since org.openntf.domino 1.0.0
	 */
	public int compactWithOptions(final Set<CompactOption> options, final String spaceThreshold);

	/**
	 * @param keyValuePairs
	 *            an object of key value pairs with which to initialize a
	 *            document or<br/>
	 *            Map of fields and values with which to initialize a document
	 * @return the newly created document
	 * @since org.openntf.domino 1.0.0
	 */
	public Document createDocument(final Object... keyValuePairs);

	/**
	 * The core {@link lotus.domino.Database.createFTIndex} method takes an int
	 * worked out by adding the integer value for all the relevant options the
	 * developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of
	 * {@link org.openntf.domino.Database.FTIndexOption} objects.
	 * 
	 * @see org.openntf.domino.Database.FTIndexOption
	 * @param options
	 *            Set&lt;FTIndexOption&gt; full text index options that can be
	 *            applied
	 * @param recreate
	 *            boolean whether or not the full text index should be recreated
	 * @since org.openntf.domino 2.5.0
	 */
	public void createFTIndex(final Set<FTIndexOption> options, final boolean recreate);

	/**
	 * The core {@link lotus.domino.Database#fixup(int)} method takes an int
	 * worked out by adding the integer value for all the relevant options the
	 * developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of
	 * {@link org.openntf.domino.Database.FixupOption} objects.
	 * 
	 * @see org.openntf.domino.Database.FixupOption
	 * 
	 * @param options
	 *            Set<FixupOption>
	 * @since org.openntf.domino 1.0.0
	 */
	public void fixup(final Set<FixupOption> options);

	/**
	 * The core {@link lotus.domino.Database.FTDomainSearch} method takes an int
	 * worked out by adding the integer value for all the relevant search and
	 * sort options the developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of
	 * {@link org.openntf.domino.Database.FTDomainSearchOption} objects and a
	 * Set of {@link org.openntf.domino.Database.FTDomainSortOption}. <br/>
	 * <br/>
	 * The current database must be a Domain Catalog
	 * 
	 * @see org.openntf.domino.Database.FTDomainSearchOption
	 * @see org.openntf.domino.Database.FTDomainSortOption
	 * @param query
	 *            String the search query to use. Wildcards, operators, and
	 *            other syntax are permitted. For the complete syntax rules, see
	 *            "Refining a search query using operators" in Notes Help.
	 *            Search for "query syntax" in the Domino Designer Eclipse help
	 * @param maxDocs
	 *            int the maximum number of documents to return. NOTE: the
	 *            maximum will also be restricted by the setting on the server
	 *            document, "Maximum search result limit" on the Internet
	 *            Protocols..., Domino Web Engine tab
	 * @param sortOpt
	 *            Set<FTDomainSortOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSortOption}
	 *            options, e.g. date descending. If nothing is specified,
	 *            relevance score will be the sorting option applied.
	 * @param otherOpt
	 *            Set<FTDomainSearchOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSearchOption}
	 *            options, e.g. fuzzy search
	 * @param start
	 *            int the page from which to start showing
	 * @param count
	 *            int the count of pages to show
	 * @param entryForm
	 *            String the name of the Domain Search entry form in the domain
	 *            catalog. This will be a traditional Domino web form, not an
	 *            XPage form.
	 * @return Document with a rich text field called "Body" that contains a
	 *         table of matching document titles
	 * @since org.openntf.domino 2.5.0
	 */
	public Document FTDomainSearch(final String query, final int maxDocs, final FTDomainSortOption sortOpt,
			final Set<FTDomainSearchOption> otherOpt, final int start, final int count, final String entryForm);

	/**
	 * FT domain search.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @param start
	 *            the start
	 * @param count
	 *            the count
	 * @param entryForm
	 *            the entry form
	 * @return the document
	 */
	public Document FTDomainSearch(final String query, final int maxDocs, final FTDomainSortOption sortOpt,
			final int otherOpt, final int start, final int count, final String entryForm);

	/**
	 * The core {@link lotus.domino.Database.FTSearch} method takes an int
	 * worked out by adding the integer value for all the relevant search and
	 * sort options the developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of
	 * {@link org.openntf.domino.Database.FTSearchOption} objects and a Set of
	 * {@link org.openntf.domino.Database.FTSortOption}.<br/>
	 * <br/>
	 * The current database must be a Domain Catalog
	 * 
	 * @see org.openntf.domino.Database.FTSearchOption
	 * @see org.openntf.domino.Database.FTSortOption
	 * @param query
	 *            String the search query to use. Wildcards, operators, and
	 *            other syntax are permitted. For the complete syntax rules, see
	 *            "Refining a search query using operators" in Notes Help.
	 *            Search for "query syntax" in the Domino Designer Eclipse help
	 * @param maxDocs
	 *            int the maximum number of documents to return. NOTE: the
	 *            maximum will also be restricted by the setting on the server
	 *            document, "Maximum search result limit" on the Internet
	 *            Protocols..., Domino Web Engine tab
	 * @param sortOpt
	 *            Set<FTDomainSortOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSortOption}
	 *            options, e.g. date descending. If nothing is specified,
	 *            relevance score will be the sorting option applied.
	 * @param otherOpt
	 *            Set<FTDomainSearchOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSearchOption}
	 *            options, e.g. fuzzy search
	 * @return a DocumentCollection containing the documents matching the search
	 *         criteria
	 * @since org.openntf.domino 2.5.0
	 */
	public DocumentCollection FTSearch(final String query, final int maxDocs, final FTSortOption sortOpt,
			final Set<FTSearchOption> otherOpt);

	/**
	 * The core {@link lotus.domino.Database.FTSearch} method takes an int
	 * worked out by adding the integer value for all the relevant search and
	 * sort options the developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a Set of
	 * {@link org.openntf.domino.Database.FTSearchOption} objects and a Set of
	 * {@link org.openntf.domino.Database.FTSortOption}.<br/>
	 * <br/>
	 * The current database must be a Domain Catalog
	 * 
	 * @see org.openntf.domino.Database.FTSearchOption
	 * @see org.openntf.domino.Database.FTSortOption
	 * @param query
	 *            String the search query to use. Wildcards, operators, and
	 *            other syntax are permitted. For the complete syntax rules, see
	 *            "Refining a search query using operators" in Notes Help.
	 *            Search for "query syntax" in the Domino Designer Eclipse help
	 * @param maxDocs
	 *            int the maximum number of documents to return. NOTE: the
	 *            maximum will also be restricted by the setting on the server
	 *            document, "Maximum search result limit" on the Internet
	 *            Protocols..., Domino Web Engine tab
	 * @param sortOpt
	 *            Set<FTDomainSortOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSortOption}
	 *            options, e.g. date descending. If nothing is specified,
	 *            relevance score will be the sorting option applied.
	 * @param otherOpt
	 *            Set<FTDomainSearchOption> a Set of possible
	 *            {@link org.openntf.domino.Database.FTDomainSearchOption}
	 *            options, e.g. fuzzy search
	 * @param start
	 *            the start number of the document in the collection from which
	 *            to show
	 * @return a DocumentCollection of matching documents, starting at the
	 *         number entered
	 * @since org.openntf.domino 2.5.0
	 */
	public DocumentCollection FTSearchRange(final String query, final int maxDocs, final FTSortOption sortOpt,
			final Set<FTSearchOption> otherOpt, final int start);

	/**
	 * Gets a {@link org.openntf.domino design.DatabaseDesign} object providing
	 * access to various design elements of this database. The class also has
	 * helper methods to create some design resources, e.g.
	 * {@link org.openntf.domino.design.DatabaseDesign#createView()}
	 * 
	 * @return DatabaseDesign object
	 * @since org.openntf.domino 1.0.0
	 */
	public DatabaseDesign getDesign();

	/**
	 * Returns the shared XPage Design Template (if this is a Single Copy XPage
	 * Database)
	 * 
	 * @return the shared XPage Design Template (or null, if this is no SCXD-DB)
	 * @throws FileNotFoundException
	 *             if the Template could not be found
	 * @since org.openntf.domino 5.0.0
	 */
	public org.openntf.red.Database getXPageSharedDesignTemplate() throws FileNotFoundException;

	/**
	 * Retrieves a document by a String key.
	 * <p>
	 * The key is hashed using MD5 and treated as a UNID.
	 * </p>
	 * 
	 * @param key
	 *            The arbitrary-length string key.
	 * 
	 * @return The Document corresponding to the key, or null if no matching
	 *         document exists.
	 * @since org.openntf.domino 1.0.0
	 */
	public Document getDocumentWithKey(final Serializable key);

	@Deprecated
	public Document getDocumentByKey(Serializable key);

	@Deprecated
	public Document getDocumentByKey(Serializable key, boolean createOnFail);

	/**
	 * Retrieves a document by a String key, allowing for creation of a new
	 * document if no match was found.
	 * <p>
	 * The key is hashed using MD5 and treated as a UNID.
	 * </p>
	 * 
	 * @param key
	 *            The arbitrary-length string key.
	 * @param createOnFail
	 *            Whether or not a new document should be created when the key
	 *            was not found. Defaults to false.
	 * 
	 * @return The Document corresponding to the key, or null if no matching
	 *         document exists and createOnFail is false.
	 * @since org.openntf.domino 1.0.0
	 */
	public Document getDocumentWithKey(final Serializable key, final boolean createOnFail);

	/**
	 * Gets any documents of a specific note type modified since a given date,
	 * using {@link org.openntf.domino.Database.ModifiedDocClass} enum
	 * 
	 * @param since
	 *            DateTime after which documents should have been modified
	 * @param noteClass
	 *            ModifiedDocClass of notes to include in collection
	 * @return DocumentCollection of notes modified since the given date
	 * @since org.openntf.domino 2.5.0
	 */
	public DocumentCollection getModifiedDocuments(final lotus.domino.DateTime since, final ModifiedDocClass noteClass);

	/**
	 * Gets any documents of a specific note type modified since a given date,
	 * using {@link org.openntf.domino.Database.ModifiedDocClass} enum
	 * 
	 * @param since
	 *            Date after which documents should have been modified
	 * @param noteClass
	 *            ModifiedDocClass of notes to include in collection
	 * @return DocumentCollection of notes modified since the given date
	 * @since org.openntf.domino 5.0.0
	 */
	public DocumentCollection getModifiedDocuments(final java.util.Date since, final ModifiedDocClass noteClass);

	/**
	 * Gets any notes (design or data) modified since a given date
	 * 
	 * @param since
	 *            Date after which documents should have been modified
	 * @return DocumentCollection of notes modified since the given date
	 * @since org.openntf.domino 5.0.0
	 */
	public DocumentCollection getModifiedDocuments(final java.util.Date since);

	/**
	 * Gets the number of modified notes of relevant note types, using
	 * {@link org.openntf.domino.NoteCollection.SelectOption}
	 * 
	 * @param since
	 *            Date since when to check for modified notes
	 * @param noteClass
	 *            Set<SelectOption> of note types to include
	 * @return int number of modified notes
	 * @since org.openntf.domino 4.5.0
	 */
	public int getModifiedNoteCount(final java.util.Date since, final Set<SelectOption> noteClass);

	/**
	 * Gets the number of modified notes of all note types, using
	 * {@link org.openntf.domino.NoteCollection.SelectOption}
	 * 
	 * @param since
	 *            Date since when to check for modified notes
	 * @return int number of modified notes
	 * @since org.openntf.domino 4.5.0
	 */
	public int getModifiedNoteCount(final java.util.Date since);

	/**
	 * Gets the date a Database was last modified, as a Java Date
	 * 
	 * @return Date
	 * @since org.openntf.domino 4.5.0
	 */
	public Date getLastModifiedDate();

	/**
	 * Gets the last date a Fixup was run on the database
	 * 
	 * @return Date
	 * @since org.openntf.domino 1.0.0
	 */
	public Date getLastFixupDate();

	/**
	 * Gets the date the Full Text Index was last updated
	 * 
	 * @return Date
	 * @since org.openntf.domino 1.0.0
	 */
	public Date getLastFTIndexedDate();

	/**
	 * The core {@link lotus.domino.Database#getOption(int)} method takes an int
	 * worked out by adding the integer value for all the relevant options the
	 * developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a {@link org.openntf.domino.Database.DbOption} object.
	 * 
	 * @see org.openntf.domino.Database.DBOption
	 * @param optionName
	 *            DbOption database option to be applied
	 * @since org.openntf.domino 1.0.0
	 */
	public boolean getOption(final DBOption optionName);

	/**
	 * @param name
	 *            name of a user to grant access to
	 * @param level
	 *            ACL.Level for access
	 * @since org.openntf.domino 2.5.0
	 */
	public void grantAccess(final String name, final ACL.Level level);

	/**
	 * The core {@link lotus.domino.Database#setFTIndexFrequency(int)} method
	 * takes an int worked out by adding the integer value for all the relevant
	 * options the developer wishes to apply.<br/>
	 * <br/>
	 * To make code clearer and easier to support, this overloaded method has
	 * been added taking a {@link org.openntf.domino.Database.FTIndexFrequency}
	 * object.
	 * 
	 * @see org.openntf.domino.Database.FTIndexFrequency
	 * @param frequency
	 *            FTIndexFrequency how frequently to perform the full text
	 *            indexing
	 * @since org.openntf.domino 2.5.0
	 */
	public void setFTIndexFrequency(final FTIndexFrequency frequency);

	/**
	 * Sets a database option to true or false, using
	 * {@link org.openntf.domino.Database.DBOption}
	 * 
	 * @param optionName
	 *            DBOption option name
	 * @param flag
	 *            the flag
	 * @since org.openntf.domino 1.0.0
	 */
	public void setOption(final DBOption optionName, final boolean flag);

	/**
	 * Signs all notes corresponding to the
	 * {@link org.openntf.domino.Database.SignDocType}
	 * 
	 * @param documentType
	 *            SignDocType note type to sign
	 * @since org.openntf.domino 1.0.0
	 */
	public void sign(final SignDocType documentType);

	/**
	 * Signs all notes corresponding to the
	 * {@link org.openntf.domino.Database.SignDocType}, choosing whether to only
	 * update existing valid signatures
	 * 
	 * @param documentType
	 *            SignDocType note type to sign
	 * @param existingSigsOnly
	 *            boolean whether to update only existing signatures
	 * @since org.openntf.domino 1.0.0
	 */
	public void sign(final SignDocType documentType, final boolean existingSigsOnly);

	/**
	 * Signs all notes corresponding to the
	 * {@link org.openntf.domino.Database.SignDocType}, choosing whether to only
	 * update existing valid signatures
	 * 
	 * @param documentType
	 *            SignDocType note type to sign
	 * @param existingSigsOnly
	 *            boolean whether to update only existing signatures
	 * @param name
	 *            String the programmatic name or note id of a signle design
	 *            element to update
	 * @since org.openntf.domino 1.0.0
	 */
	public void sign(final SignDocType documentType, final boolean existingSigsOnly, final String name);

	/**
	 * Signs all notes corresponding to the
	 * {@link org.openntf.domino.Database.SignDocType}, choosing whether to only
	 * update existing valid signatures
	 * 
	 * @param documentType
	 *            SignDocType note type to sign
	 * @param existingSigsOnly
	 *            boolean whether to update only existing signatures
	 * @param name
	 *            String the programmatic name or note id of a signle design
	 *            element to update
	 * @param nameIsNoteid
	 *            boolean whether or not the name is a note id
	 * @since org.openntf.domino 1.0.0
	 */
	public void sign(final SignDocType documentType, final boolean existingSigsOnly, final String name,
			final boolean nameIsNoteid);

	/**
	 * Creates and initiates a transaction on a given database
	 * 
	 * @return DatabaseTransaction initiated on the relevant Database object
	 * @since org.openntf.domino 2.5.0
	 */
	public IDatabaseTransaction startTransaction();

	/**
	 * Closes the transaction on a given database
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public void closeTransaction();

	/**
	 * Gets an already initiated transaction for a database
	 * 
	 * @return DatabaseTransaction or null
	 * @since org.openntf.domino 2.5.0
	 */
	public IDatabaseTransaction getTransaction();

	public String getUNID(String noteid);

	public String getUNID(int noteid);

	public Document getDocumentByID(int noteid);

	/**
	 * Passes a DatabaseTransaction to a Database object. This allows a single
	 * Transaction to be used to process activity across multiple databases
	 * 
	 * @param txn
	 *            DatabaseTransaction to be passed to a relevant database
	 * @since org.openntf.domino 4.5.0
	 * 
	 */
	public void setTransaction(IDatabaseTransaction txn);

	/**
	 * Creates a new {@link lotus.notes.addins.DominoServer} object for the
	 * server the database is on
	 * 
	 * @return DominoServer running on the current Domino server`
	 * @since org.openntf.domino 2.5.0
	 */
	public lotus.notes.addins.DominoServer getDominoServer();

	/**
	 * Refreshes the design of the relevant database
	 * 
	 * @since org.openntf.domino 2.5.0
	 */
	public void refreshDesign();

	/**
	 * Opens the mail database for the relevant user loading it into this
	 * Database object
	 * 
	 * @since org.openntf.domino 4.5.0
	 */
	public void openMail();

	/**
	 * Gets the Mail database for the relevant user
	 * 
	 * @return Database for the relevant user's mail database
	 * @since org.openntf.domino 4.5.0
	 */
	public org.openntf.red.Database getMail();

	/**
	 * Gets a Map view of the documents in the database, keyed according to
	 * getDocumentByKey
	 * 
	 * @return Map<Serializable, Document>
	 * @since org.openntf.domino 5.0.0
	 */
	public Map<Serializable, org.openntf.red.Document> getDocumentMap();

	/**
	 * Gets the schema for the database. Not yet complete
	 * 
	 * @return instance of IDatabaseSchema interface
	 * @since org.openntf.domino 2.5.0
	 */
	public IDatabaseSchema getSchema();

	/**
	 * Sets the schema for the database. Not yet complete
	 * 
	 * @param schema
	 *            instance of IDatabaseSchema interface
	 * @since org.openntf.domino 2.5.0
	 */
	public void setSchema(IDatabaseSchema schema);

	/**
	 * Checks whether replication is disabled for this database
	 * 
	 * @return boolean
	 * @since org.openntf.domino 4.5.0
	 */
	public boolean isReplicationDisabled();

	/**
	 * Gets the web URL for the relevant database, specifying whether or not to
	 * include the path
	 * 
	 * @param usePath
	 *            boolean
	 * @return String url for the database
	 * @since org.openntf.domino 5.0.0
	 */
	public String getHttpURL(final boolean usePath);

	/**
	 * Gets MIME behavior for the session, whether to wrap all mime, wrap if
	 * over 32k, or wrap none
	 * 
	 * @return AutoMime format for the session
	 * @since org.openntf.domino 5.0.0
	 */
	public AutoMime getAutoMime();

	/**
	 * Sets the MIME behavior for the session, using
	 * {@link org.openntf.red.util.domino.AutoMime}
	 * 
	 * @param autoMime
	 *            AutoMime format, WRAP_ALL, WRAP_32K, WRAP_NONE
	 * @since org.openntf.domino 5.0.0
	 */
	public void setAutoMime(AutoMime autoMime);

	/**
	 * Gets the $DefaultLanguage stored in the icon note and converts it to a
	 * locale
	 * 
	 * @return the Locale stored in the Notes database
	 * @since org.openntf.domino 5.0.0
	 */
	public Locale getLocale();

	/**
	 * 
	 * Gets the meta replica ID, an ID in the format serverName!!replicaId,
	 * first portion of metaversal ID
	 * 
	 * @return the meta replica id
	 * @since org.openntf.domino 5.0.0
	 */
	public String getMetaReplicaID();

	/**
	 * Returns the type of this database as Type object
	 * 
	 * @return a {@link Type} Object
	 */
	Type getTypeEx();

	public View getView(final Document viewDocument);

}
