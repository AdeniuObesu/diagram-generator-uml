/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import javax.swing.JFrame;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
public class SwingUI extends JFrame {
	private static final long serialVersionUID = 1l;
	
	public SwingUI() {
		display();
	}
	private void display() {
		pack();
		setSize(500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SwingUI();
	}
}
