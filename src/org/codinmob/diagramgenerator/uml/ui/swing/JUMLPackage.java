/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.event.MouseEvent;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class JUMLPackage extends FolderPane implements Movable {
	private static final long serialVersionUID = 1l;
	
	public JUMLPackage(String name) {
		super(name);
	}

	public void addJUMLClassifier(Drawable jClassifier) {
		if(jClassifier != null) {
			if(jClassifier instanceof JUMLClass) {
				addContent((JUMLClass) jClassifier);
			}
			else if(jClassifier instanceof JUMLInterface) {
				addContent((JUMLInterface) jClassifier);
			} else if(jClassifier instanceof JUMLEnum) {
				addContent((JUMLEnum) jClassifier);
			}
			setSize(getPreferredSize());
		}
	}
	@Override
	public Object draw() {
		return this;
	}

	@Override
	public void move() {
		// TODO : move the element with the mouse when dragged
	}
}
