package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import org.codinmob.diagramgenerator.uml.models.Project;
import org.codinmob.diagramgenerator.uml.models.UMLClassifier;
import org.codinmob.diagramgenerator.uml.models.UMLPackage;
public class JProject extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Project project;
	private List<JUMLPackage> jumlPackages;
		
	public JProject(Project project) {
		this.project = project;
		jumlPackages = new Vector<>();
		
		setLayout(null);
		
		drawPackages();
	}
	
	private void drawPackages() {
		JUMLPackage jumlPackage;
		for (UMLPackage umlPackage : project.getPackages()) {
			int x = 1, y = 1;
			
			jumlPackage = new JUMLPackage(umlPackage);
			jumlPackage.setLocation(x, y);
			add(jumlPackage);
			
			jumlPackages.add(jumlPackage);
		}
	}
	
	public JUMLClassifier getJumlClassifier(UMLClassifier umlClassifier) {
		for (JUMLPackage jumlPackage : jumlPackages) {
			for (JUMLClassifier jumlClassifier : jumlPackage.getJumlClassifiers()) {
				if (jumlClassifier.getClassifier().getName().equals(umlClassifier.getSimpleName())) {
					return jumlClassifier;
				}
			}
		}
		
		return null;
	}
}
