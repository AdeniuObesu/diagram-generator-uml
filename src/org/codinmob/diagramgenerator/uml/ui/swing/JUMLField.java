/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 22, 2023
 */
@SuppressWarnings("all")
public class JUMLField extends JLabel implements Drawable {
	private static final long serialVersionUID = 1l;
	
	public void underline() {
		Font font = getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		setFont(font.deriveFont(attributes));
	}
	@Override
	public Object draw() {
		// TODO : Draw the JUMLField
		return null;
	}
}
