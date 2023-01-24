/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Tuesday, January 24, 2023
 */
public class LabelPane extends JPanel {
	private static final long serialVersionUID = 1l;
	private JLabel label;
	
	public LabelPane(String text) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		label = new JLabel(text);
		setBackground(Color.red);
		add(label);
	}
	
	public void alignToLeft(){
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
	
	public void setLabelBackground(Color color){
		if(color != null) {
			label.setBackground(color);
		}
	}
	
	@SuppressWarnings("all")
	public void setUnderline() {
		Font font = label.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		label.setFont(font.deriveFont(attributes));
	}
	
	public void setData(String text) {
		label.setText(text);
	}
}
