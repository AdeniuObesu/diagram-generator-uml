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
public class JUMLInterface extends JPanel implements Movable {
	private static final long serialVersionUID = 1l;
	private BorderPane titlePane;
	private BorderPane fieldsPane;
	private BorderPane methodsPane;
	
	public JUMLInterface() {
		titlePane = new BorderPane(Color.BLACK, 5);
		titlePane.makeVBox();
		titlePane.add(new JLabel("<<interface>>"));
	}
	
	public void setTitle(String title) {
		titlePane.add(new JLabel(title));
	}

	public void addJUMLProperty(Drawable jProperty) {
		if(jProperty != null) {
			if(jProperty instanceof JUMLField) {
				if(fieldsPane == null) {
					fieldsPane = new BorderPane(Color.BLACK, 5);
					fieldsPane.makeVBox();
				}
				methodsPane.add((JLabel) jProperty);
			}
			else if(jProperty instanceof JUMLMethod) {
				if(methodsPane == null) {
					methodsPane = new BorderPane(Color.BLACK, 5);
					methodsPane.makeVBox();
				}
				methodsPane.add((JLabel) jProperty);
			}
		}
	}
	
	@Override
	public Object draw() {
		add(titlePane);
		if(fieldsPane != null) add(fieldsPane);
		if(methodsPane != null) add(methodsPane);
		return this;
	}

	@Override
	public void move() {
		// TODO : move the element with the mouse when dragged
	}

}
