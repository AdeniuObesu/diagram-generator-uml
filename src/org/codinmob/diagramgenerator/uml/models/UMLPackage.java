/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

import java.util.List;
import java.util.Vector;

import org.codinmob.diagramgenerator.uml.utils.StringResolver;

/**
 * @author MOUKHAFI ANASS
 * @On Sunday, January 01, 2023
 */
public class UMLPackage {
	private String absolutePath;
	/*
	 * relativePath is the relative path to the actual CLASSPATH
	 * */
	private String relativePath;
	
	private List<UMLModel> models;
	
	public UMLPackage(String absolutePath) {
		this.absolutePath = absolutePath;
		this.relativePath = StringResolver.convertPackagePathToRelative(absolutePath);
		this.models = new Vector<>();
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setRelativePath(String path) {
		if(path!=null)
			this.relativePath = path;
	}
	public void addModel(UMLModel anotherModel) {
		if(anotherModel != null) {
			models.add(anotherModel);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + relativePath);
		for(UMLModel model : models) {
			temp.append("\n------" + model);
		}
		return temp.toString();
	}
}
