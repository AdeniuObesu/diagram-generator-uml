package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public BoxPanel() {
		this(BoxLayout.Y_AXIS);
	}
	
	public BoxPanel(int axis) {
		setLayout(new BoxLayout(this, axis));
	}
	
	public void setBorder(int size) {
		setBorder(BorderFactory.createMatteBorder(size, size, size, size, Color.black));
	}
	
	public void setBorderTop(int size) {
		setBorder(BorderFactory.createMatteBorder(
				size,
				getBorder() != null ? getBorder().getBorderInsets(this).left : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).bottom : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).right : 0,
				Color.black
		));
	}
	
	public void setBorderBottom(int size) {		
		setBorder(BorderFactory.createMatteBorder(
				getBorder() != null ? getBorder().getBorderInsets(this).top : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).left : 0,
				size,
				getBorder() != null ? getBorder().getBorderInsets(this).right : 0,
				Color.black
		));
	}
	
	public void setBorderLeft(int size) {		
		setBorder(BorderFactory.createMatteBorder(
				getBorder() != null ? getBorder().getBorderInsets(this).top : 0,
				size,
				getBorder() != null ? getBorder().getBorderInsets(this).bottom : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).right : 0,
				Color.black
		));
	}
	
	public void setBorderRight(int size) {		
		setBorder(BorderFactory.createMatteBorder(
				getBorder() != null ? getBorder().getBorderInsets(this).top : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).left : 0,
				getBorder() != null ? getBorder().getBorderInsets(this).bottom : 0,
				size,
				Color.black
		));
	}
	
	public void setBackground(Color color, int opacity) {
		setBackground(new Color(120, 130, 150));
	}
}
