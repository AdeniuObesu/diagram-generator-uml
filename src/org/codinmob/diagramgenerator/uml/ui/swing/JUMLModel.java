/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 13, 2023
 */
public abstract class JUMLModel extends JPanel {
	private static final long serialVersionUID = 1l;
	
	private JLabel stereotypeLabel;
	protected JLabel nameLabel;
	protected List<JUMLCharacteristic> characteristics;
	
	private BoxLayout boxLayout;
	private Color backgroundColor;
	
	public JUMLModel() {
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		if(this instanceof JUMLClass) {
			backgroundColor = new Color(243, 243, 243);
		} else if (this instanceof JUMLInterface) {
			backgroundColor = new Color(209, 166, 253);
			stereotypeLabel = new JLabel("<<Interface>>");
			add(stereotypeLabel);
		} else {
			backgroundColor = new Color(184, 294, 168);
			stereotypeLabel = new JLabel("<<Enumeration>>");
			add(stereotypeLabel);
		}
		setBackground(backgroundColor);
	}
}
