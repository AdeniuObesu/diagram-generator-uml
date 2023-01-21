/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing.utils;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */
public class BoxPanel extends JPanel{
	private static final long serialVersionUID = 1l;
	
	public BoxPanel(int axis) {
		setLayout(new BoxLayout(this, axis));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	}
}
