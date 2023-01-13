/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLClass;
import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 13, 2023
 */
public class JUMLClass extends JUMLModel {
	private static final long serialVersionUID = 1l;
	
	public JUMLClass(UMLClass umlClass) {
		super();
		nameLabel = new JLabel(umlClass.getName());
		add(nameLabel);
		for(UMLCharacteristic element : umlClass.getCharacteristics()) {
			this.addJUMLCharacteristic(element);
		}
	}
	
	private void addJUMLCharacteristic(UMLCharacteristic anotherOne) {
		if(anotherOne instanceof UMLMethod) {
			characteristics.add(new JUMLMethod((UMLMethod) anotherOne));
		} else {
			characteristics.add(new JUMLField((UMLField) anotherOne));
		}
	}
}
