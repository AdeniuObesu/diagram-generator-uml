/**
 * 
 */
package org.mql.uml.models;

import java.util.List;
import java.util.Vector;

import org.mql.uml.utils.StringResolver;

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
	
	private List<UMLModel> umlModels;
	
	public UMLPackage(String absolutePath) {
		this.absolutePath = absolutePath;
		this.relativePath = StringResolver.convertPathToRelative(absolutePath);
		this.umlModels = new Vector<>();
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setRelativePath(String path) {
		if(path!=null)
			this.relativePath = path;
	}
	
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("Package : " + relativePath);
		for(UMLModel model : umlModels) {
			temp.append("\n\t" + model);
		}
		return temp.toString();
	}
}
