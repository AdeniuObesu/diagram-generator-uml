/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public class JUMLField extends JUMLCharacteristic {
	private static final long serialVersionUID = 1L;

	public JUMLField(UMLField field) {
		super();
		
		visibilityLabel = new JLabel( field.getVisibility().getSymbol() + " ");
		add(visibilityLabel);
		
		nameLabel = new JLabel(field.getName() + " : ");
		add(nameLabel);
	}
}
