package org.openntf.red.design;

import java.awt.image.BufferedImage;

/**
 * <i>Initial code borrowed from OpenNTF Domino API.</i><br>
 * @author jgallagher
 * 
 */
public interface ImageResource extends AnyFileResource {

	public BufferedImage getImage();
}
