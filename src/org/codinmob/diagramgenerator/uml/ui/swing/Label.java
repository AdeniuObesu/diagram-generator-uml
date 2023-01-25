package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Label extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel label;
	
	public Label() {
		this("");
	}
	
	public Label(String title) {
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		label = new JLabel(title);
		add(label);
	}
	
	@SuppressWarnings("unchecked")
	public void setUnderline() {
		Font font = label.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		label.setFont(font.deriveFont(attributes));
	}

	public void addText(String text) {
		label.setText(label.getText() + text);
	}
	
	public String getText() {
		return label.getText();
	}
}
