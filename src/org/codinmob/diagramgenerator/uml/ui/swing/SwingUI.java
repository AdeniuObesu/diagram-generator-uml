/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.codinmob.diagramgenerator.mappers.DrawableObjectMapper;
import org.codinmob.diagramgenerator.mappers.impl.DrawableObjectMapperImpl;
import org.codinmob.diagramgenerator.uml.models.Project;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class SwingUI extends JFrame {
	private static final long serialVersionUID = 1l;
	private static final Logger logger = Logger.getLogger(SwingUI.class.getName());
	
	public SwingUI() {
		DrawableObjectMapper mapper = new DrawableObjectMapperImpl();
		Drawable project = mapper.objectToDrawable(Project.getInstance(null));
		add((JPanel)project.draw());
		display();
	}
	private void display() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		if(Project.getInstance(null) != null) {
			new SwingUI();
		} else {
			logger.info("Oups ! cannot generate Swing UI -> Project instance is not yet created !");
		}
	}
}
