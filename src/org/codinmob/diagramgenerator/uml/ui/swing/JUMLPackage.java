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
public class JUMLPackage extends JPanel implements Movable {
	private static final long serialVersionUID = 1l;
	private BorderPane titlePane;
	private BorderPane contentPane;
	
	public JUMLPackage() {
		titlePane = new BorderPane(Color.BLACK, 5);
	}
	
	public void setTitle(String title) {
		titlePane.add(new JLabel(title));
	}
	public void addJUMLClassifier(Drawable jClassifier) {
		if(jClassifier != null) {
			if(contentPane != null) {
				contentPane = new BorderPane(Color.BLACK, 5);
			}
			if(jClassifier instanceof JUMLClass) {
				contentPane.add((JUMLClass)jClassifier);
			}
			else if(jClassifier instanceof JUMLInterface) {
				contentPane.add((JUMLInterface)jClassifier);
			} else if(jClassifier instanceof JUMLEnum) {
				contentPane.add((JUMLEnum)jClassifier);
			}
		}
	}
	@Override
	public Object draw() {
		add(titlePane);
		if(contentPane != null) add(contentPane);
		return this;
	}

	@Override
	public void move() {
		// TODO : move the element with the mouse when dragged
	}
}
