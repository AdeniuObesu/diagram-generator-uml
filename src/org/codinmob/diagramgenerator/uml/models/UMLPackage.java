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
	private List<UMLClassifier> classifiers;
	
	public UMLPackage(String absolutePath) {
		this.absolutePath = absolutePath;
		this.classifiers = new Vector<>();
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	/*
	 * Returns binary name or (default-package)
	 * name : a calculated attribute 
	 * */
	public String getName() {
		return (
				"".equals(PathResolver.retrievePackageRelativePath(absolutePath))
				? "(default-package)" : PathResolver.retrievePackageRelativePath(absolutePath)
			);
	}
	
	public void addClassifier(UMLClassifier anotherClassifier) {
		if(anotherClassifier != null) {
			classifiers.add(anotherClassifier);
		}
	}
	
	public List<UMLClassifier> getClassifiers(){
		return classifiers;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + getName());
		for(UMLClassifier model : classifiers) {
			temp.append("\n------" + model);
		}
		return temp.toString();
	}
}
