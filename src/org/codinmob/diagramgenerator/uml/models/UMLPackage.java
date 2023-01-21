/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;
import java.util.Vector;

import org.codinmob.diagramgenerator.uml.utils.PathResolver;
/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLPackage {
	private String absolutePath;
	private List<UMLModel> models;
	
	public UMLPackage(String absolutePath) {
		this.absolutePath = absolutePath;
		this.models = new Vector<>();
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public String getName() {
		return (
				"".equals(PathResolver.retrievePackageRelativePath(absolutePath))
				? "(default-package)" : PathResolver.retrievePackageRelativePath(absolutePath)
			);
	}
	
	public void addModel(UMLModel anotherModel) {
		if(anotherModel != null) {
			models.add(anotherModel);
		}
	}
	
	public List<UMLModel> getModels(){
		return models;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + getName());
		for(UMLModel model : models) {
			temp.append("\n------" + model);
		}
		return temp.toString();
	}
}
