/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Tuesday, January 24, 2023
 */
public class FolderPane extends JPanel {
	private static final long serialVersionUID = 1l;
	private JPanel northPane;
	private JPanel contentPane;
	
	public FolderPane(String folderName) {
		super(null);
		setLayout(new BorderLayout());
		
		northPane = new JPanel(null);
		northPane.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		LabelPane titleLabelPane;
		titleLabelPane = new LabelPane(folderName);
		titleLabelPane.setBackground(new Color(248, 215, 117));
		northPane.add(titleLabelPane);
		
		contentPane = new JPanel(null);
		contentPane.setLayout(new BorderLayout());
		contentPane.setMinimumSize(contentPane.getMinimumSize());
		contentPane.setBackground(new Color(255, 233, 168));
		
		add(northPane, BorderLayout.NORTH);
		add(contentPane);
	}
	
	public void addContent(Component obj) {
		contentPane.add(obj);
	}
}
