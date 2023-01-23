/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing.utils;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class BorderPane extends JPanel{
	private static final long serialVersionUID = 1l;
	
	public BorderPane(Color color, int thickness) {
		setLayout(null); // flow layout is the default layout
		setBorder(new LineBorder(color, thickness, true));
	}

	public void makeHBox() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}
	
	public void makeVBox() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
