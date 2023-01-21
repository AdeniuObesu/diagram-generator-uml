/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import javax.swing.JFrame;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public class Main extends JFrame {
	private static final long serialVersionUID = 1l;
	
	public Main() {
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main();
	}
}
