/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * @author MOUKHAFI ANASS
 * @On Tuesday, January 24, 2023
 */
public class JUMLClassifier extends VBox implements Movable {
	private static final long serialVersionUID = 1L;
	private VBox titleBox;
	private VBox fieldsBox;
	
	public JUMLClassifier(String name) {
		titleBox = new VBox();
		if(this instanceof JUMLEnum) {
			titleBox.add(new JLabel("<<enumeration>>"));
		} else if(this instanceof JUMLInterface) {
			titleBox.add(new JLabel("<<interface>>"));
		}
		titleBox.add(new JLabel(name));
		titleBox.createMatteBorder(1, Color.black);
		add(titleBox);
		
		fieldsBox = new VBox();
		fieldsBox.add(new JLabel("- model : String"));
		fieldsBox.add(new JLabel("- brand : String"));
		fieldsBox.add(new JLabel("- plateNumber : String"));
		fieldsBox.add(new JLabel("- price : double"));
		fieldsBox.createMatteBorder(1, Color.black);
		add(fieldsBox);
	}

	@Override
	public Object draw() {
		// TODO draw the JUMLClassifier instance on screen
		return null;
	}

	@Override
	public void move() {
	}
}
