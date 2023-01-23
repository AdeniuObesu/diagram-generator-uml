/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.JPanel;

import org.codinmob.diagramgenerator.uml.ui.swing.utils.BorderPane;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class JProject extends JPanel implements Drawable {
	private static final long serialVersionUID = 1l;
	private BorderPane contentPane;
	
	public JProject() {
		contentPane = new BorderPane(Color.black, 5);
		
	}

	public void addJUMLPackage(Drawable jPackage) {
		if(jPackage != null) {
			if(jPackage instanceof JUMLPackage) {
				contentPane.add((JUMLPackage)jPackage);
			}
		}
	}
	@Override
	public Object draw() {
		add(contentPane);
		return this;
	}
}
