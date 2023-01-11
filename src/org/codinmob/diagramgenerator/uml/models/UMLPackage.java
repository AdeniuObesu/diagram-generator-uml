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
		System.out.println(this.absolutePath + " is the absolute path");
		System.out.println(getRelativePath() + " is the relative path");
		this.models = new Vector<>();
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public String getRelativePath() {
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
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + getRelativePath());
		for(UMLModel model : models) {
			temp.append("\n------" + model);
		}
		return temp.toString();
	}
}
