/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLField;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public class JUMLField extends JUMLCharacteristic {
	private static final long serialVersionUID = 1L;

	public JUMLField(UMLField field) {
		super(field);
		
		visibilityLabel = new JLabel( field.getVisibility().getSymbol());
		add(visibilityLabel);
		
		add(Box.createRigidArea(new Dimension(5, 0)));
		signatureLabel.setText(field.getName() + " : " + field.getSimpleType());;
		
		add(signatureLabel);
	}
}
