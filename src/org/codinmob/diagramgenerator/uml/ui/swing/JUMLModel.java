/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.ui.swing.utils.BoxPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 13, 2023
 */
public abstract class JUMLModel extends BoxPanel {
	private static final long serialVersionUID = 1l;
	
	private JLabel stereotypeLabel;
	protected JLabel nameLabel;
	protected List<JUMLCharacteristic> characteristics;
	private Color backgroundColor;
	
	public JUMLModel() {
		super(BoxLayout.Y_AXIS);
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
