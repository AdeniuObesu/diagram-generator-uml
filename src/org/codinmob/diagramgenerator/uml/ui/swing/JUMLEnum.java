/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.codinmob.diagramgenerator.uml.ui.swing.utils.BorderPane;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class JUMLEnum extends JPanel implements Movable {
	private static final long serialVersionUID = 1l;
	private BorderPane titlePane;
	private BorderPane constantsPane;
	
	public JUMLEnum() {
		titlePane = new BorderPane(Color.BLACK, 5);
		titlePane.add(new JLabel("<<enumeration>>"));
		titlePane.makeVBox();
	}
	
	public void setTitle(String title) {
		titlePane.add(new JLabel(title));
	}

	public void addJUMLConstant(Drawable jConstant) {
		if(jConstant != null && jConstant instanceof JUMLField) {
			if(constantsPane == null) {
				constantsPane = new BorderPane(Color.BLACK, 5);
				constantsPane.makeVBox();
			}
			constantsPane.add((JLabel) jConstant);
		}
	}
	
	@Override
	public Object draw() {
		add(titlePane);
		if(constantsPane != null) add(constantsPane);
		return this;
	}

	@Override
	public void move() {
		// TODO : move the element with the mouse when dragged
	}

}
