/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class JProject extends JPanel implements Drawable {
	private static final long serialVersionUID = 1l;
	private JPanel contentPane;
	
	public JProject() {
		contentPane = new JPanel(null);
		contentPane.setLayout(new BorderLayout());
		
		JUMLPackage umlPackage = new JUMLPackage("org.codinmob.diagramgenerator.uml.ui.swing");
		umlPackage.setLocation(1, 1);
		add(umlPackage);
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
