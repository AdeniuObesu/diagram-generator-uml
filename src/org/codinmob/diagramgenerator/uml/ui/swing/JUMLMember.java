package org.codinmob.diagramgenerator.uml.ui.swing;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.codinmob.diagramgenerator.uml.models.UMLCharacteristic;
import org.codinmob.diagramgenerator.uml.models.UMLConstant;
import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.models.UMLProperty;

public class JUMLMember extends JPanel {
	private static final long serialVersionUID = 1L;

	protected UMLCharacteristic umlMember;
	
	protected Label signatureLabel;
	
	public JUMLMember(UMLCharacteristic umlCharacteristic) {
		this.umlMember = umlCharacteristic;
		
		setOpaque(false);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		signatureLabel = new Label();
		
		if (umlCharacteristic instanceof UMLConstant) {
			signatureLabel.addText(umlCharacteristic.getName());
		}
		else {
			UMLProperty property = (UMLProperty) umlCharacteristic;
			
			if (property.isStatic()) {
				signatureLabel.setUnderline();
			}
			
			signatureLabel.addText(property.getVisibility().getSymbol());
			signatureLabel.addText(property.getName());
			
			if (property instanceof UMLMethod) {
				UMLMethod method = (UMLMethod) property;
				signatureLabel.addText("(");
				
				for (int i = 0; i < method.getParameters().size(); i++) {
					signatureLabel.addText(method.getParameters().get(i).getSimpleType());
					if (i < method.getParameters().size()-1) {
						signatureLabel.addText(", ");
					}
				}

				signatureLabel.addText(")");
			}
			
			if (property.getSimpleType() != null) {
				signatureLabel.addText(": " + property.getSimpleType());				
			}
		}

		add(signatureLabel);
	}
}
