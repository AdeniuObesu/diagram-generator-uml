/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.lang.reflect.Parameter;

import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLMethod;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public class JUMLMethod extends JUMLCharacteristic {
	private static final long serialVersionUID = 1l;
	
	public JUMLMethod(UMLMethod method) {
		super(method);
		visibilityLabel = new JLabel(method.getVisibility().getSymbol());
		add(visibilityLabel);
		
		StringBuffer methodName = new StringBuffer(method.getName());
		methodName.append("(");
		for(Parameter param : method.getParameters()) {
			methodName.append(
					param.getName() + " : "
					+ param.getType().getSimpleName()
				);
		}
		methodName.append(")");
		signatureLabel.setText(methodName.toString());
		
		if( ! method.isConstructor() ) {
			signatureLabel.setText(
					signatureLabel.getText()
					+ " : " + method.getType().getSimpleName()
				);
		}
		add(signatureLabel);
	}
}
