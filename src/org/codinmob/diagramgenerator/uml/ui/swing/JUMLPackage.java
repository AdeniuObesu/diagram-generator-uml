/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.util.List;
import java.util.Vector;

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
	
	private List<JUMLClass> jClasses;
	private List<JUMLInterface> jInterfaces;
	private List<JUMLEnum> jEnums;
	
	public JUMLPackage() {
		jClasses = new Vector<>();
		jInterfaces = new Vector<>();
		jEnums = new Vector<>();
	}
	
	public void setTitle(String title) {
		if(titlePane.getComponentCount() == 0) {
			titlePane.add(new JLabel(title));
		} else {
			JLabel titleLabel = (JLabel)titlePane.getComponent(0);
			titleLabel.setText(title);
		}
	}
	public void addJUMLClassifier(Drawable jClassifier) {
		if(jClassifier != null) {
			if(jClassifier instanceof JUMLClass) {
				jClasses.add((JUMLClass)jClassifier);
			}
			else if(jClassifier instanceof JUMLInterface) {
				jInterfaces.add((JUMLInterface)jClassifier);
			} else if(jClassifier instanceof JUMLEnum) {
				jEnums.add((JUMLEnum)jClassifier);
			}
		}
	}
	@Override
	public Object draw() {
		// TODO : Draw the JUMLPackage
		return null;
	}

	@Override
	public void move() {
		// TODO : move the element with the mouse when dragged
	}
}
