/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import javax.swing.JFrame;

import org.codinmob.diagramgenerator.uml.models.UMLField;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public class Examples extends JFrame {
	private static final long serialVersionUID = 1l;
	
	public Examples() {
		testJUMLField();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Examples();
	}

	private void testJUMLMethod() {
		JUMLCharacteristic method = new JUMLMethod(new UMLMethod(Examples.class.getDeclaredMethods()[1]));
		getContentPane().add(method);
	}
	
	private void testJUMLField() {
		JUMLCharacteristic field = new JUMLField(new UMLField(Examples.class.getDeclaredFields()[0]));
		getContentPane().add(field);
	}
}
