/**
 * 
 */
package org.codinmob.diagramgenerator.uml.ui.swing;

import java.lang.reflect.Parameter;

import javax.swing.JLabel;

import org.codinmob.diagramgenerator.uml.models.UMLMethod;
import org.codinmob.diagramgenerator.uml.utils.PathResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 12, 2023
 */
public class JUMLMethod extends JUMLCharacteristic {
	private static final long serialVersionUID = 1l;
	
	public JUMLMethod(UMLMethod method) {
		visibilityLabel = new JLabel(method.getVisibility().getSymbol());
		add(visibilityLabel);
		
		StringBuffer methodName = new StringBuffer(method.getName());
		methodName.append("(");
		for(Parameter param : method.getParameters()) {
			methodName.append(
					param.getName() + " : "
					+ PathResolver.getShortFormOfType(param.getType().toString())
				);
		}
		methodName.append(")");
		if(!method.isConstructor())
			methodName.append(" : " + method.getType().toString());
		nameLabel = new JLabel(methodName.toString());
		add(nameLabel);
	}
}
