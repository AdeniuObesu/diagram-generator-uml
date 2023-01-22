/**
 * 
 */
package org.codinmob.diagramgenerator.mappers;

import org.codinmob.diagramgenerator.uml.ui.swing.Drawable;

/** Responsible of mapping a drawable into an object
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public interface DrawableObjectMapper {
	Object drawableToUIComponent(Drawable obj);
}
