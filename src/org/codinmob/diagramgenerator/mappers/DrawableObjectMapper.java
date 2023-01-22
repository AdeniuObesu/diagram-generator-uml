/**
 * 
 */
package org.codinmob.diagramgenerator.mappers;

import org.codinmob.diagramgenerator.uml.ui.swing.Drawable;

/** Responsible of mapping a uml member object instance into a drawable instance
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public interface DrawableObjectMapper {
	Drawable objectToDrawable(Object obj);
}
