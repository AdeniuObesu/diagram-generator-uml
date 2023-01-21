/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.ui.swing.utils.BoxPanel;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public abstract class JUMLCharacteristic extends BoxPanel {
	private static final long serialVersionUID = 1l;

	protected JLabel visibilityLabel;
	protected JLabel signatureLabel;
	
	// Places its components in a row
	protected BoxLayout boxLayout;
	// Field and method has a background color
//	private Color backgroundColor;
	
	public JUMLCharacteristic(UMLCharacteristic characteristic) {
		super(BoxLayout.X_AXIS);
		signatureLabel = new JLabel("Some signature");
		if(characteristic.isStatic()) {
			Font font = signatureLabel.getFont();
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			signatureLabel.setFont(font.deriveFont(attributes));
		}
		// TODO : fields and method with different colors
	}
}
