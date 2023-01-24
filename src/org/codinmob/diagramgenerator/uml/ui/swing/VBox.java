/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Tuesday, January 24, 2023
 */
public class VBox extends JPanel {
	private static final long serialVersionUID = 1l;
	
	public VBox() {
		super(null);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setMinimumSize(getPreferredSize());
	}
	public void createMatteBorder(int size, Color color) {
		setBorder(BorderFactory.createMatteBorder(size, size, size, size, color));
	}
}
