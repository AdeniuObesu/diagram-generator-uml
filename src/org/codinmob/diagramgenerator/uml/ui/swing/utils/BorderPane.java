/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing.utils;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class BorderPane extends JPanel{
	private static final long serialVersionUID = 1l;
	
	public BorderPane(Color color) {
		setLayout(null);
		setBorder(new LineBorder(color, 4, true));
	}
}
