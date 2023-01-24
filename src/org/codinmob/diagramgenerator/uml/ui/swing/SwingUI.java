/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.BorderLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class SwingUI extends JFrame {
	private static final long serialVersionUID = 1l;
	private static final Logger logger = Logger.getLogger(SwingUI.class.getName());
	
	public SwingUI() {
//		DrawableObjectMapper mapper = new DrawableObjectMapperImpl();
//		Drawable project = mapper.objectToDrawable(Project.getInstance(null));
//		add((JPanel)project.draw());
		setLayout(new BorderLayout());
		add(new JUMLEnum("Vehicle"));
		display();
	}
	private void display() {
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
//		if(Project.getInstance(null) != null) {
			new SwingUI();
//		} else {
			logger.info("Oups ! cannot generate Swing UI -> Project instance is not yet created !");
//		}
	}
}
