/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public abstract class JUMLCharacteristic extends JPanel {
	private static final long serialVersionUID = 1l;

	protected JLabel visibilityLabel;
	protected JLabel nameLabel;
	protected JLabel typeLabel;
	
	// Places its components in a row
	protected BoxLayout boxLayout;
	// Field and method has a background color
	private Color backgroundColor;
	
	public JUMLCharacteristic() {
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
		
		setLayout(boxLayout);
		if(this instanceof JUMLField) {
			backgroundColor = Color.RED;
		} else {
			backgroundColor = Color.YELLOW;
		}
		setBackground(backgroundColor);
	}
}
