/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class JProject extends JPanel implements Drawable {
	private static final long serialVersionUID = 1l;
	private List<JUMLPackage> jPackages;
	
	public JProject() {
		jPackages = new Vector<>();
	}

	public void addJUMLPackage(Drawable jPackage) {
		if(jPackage != null) {
			if(jPackage instanceof JUMLPackage) {
				jPackages.add((JUMLPackage)jPackage);
			}
		}
	}
	@Override
	public Object draw() {
		// TODO : Draw the JProject
		return null;
	}
}
