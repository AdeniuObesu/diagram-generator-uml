/**
 * 
 */
package org.codinmob.diagramgenerator.uml.models;

/**
 * @author MOUKHAFI Anass
 * @On Tuesday, January 24, 2023
 */
public class Multiplicity {
	private char lowerBound;
	private char upperBound;
	
	public Multiplicity() {
		this.lowerBound = '1';
		this.upperBound = '1';
	}
	
	public Multiplicity(char lowerBound, char upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public void setUpperBound(char upperBound) {
		this.upperBound = upperBound;
	}

	public char getUpperBound() {
		return upperBound;
	}
	public boolean isMultiple() {
		return upperBound == 'n';
	}
	@Override
	public String toString() {
		StringBuffer temp = new StringBuffer("[");
		temp.append(lowerBound);
		if(upperBound != 'n')
			temp.append(".." + upperBound);
		return temp.append(']').toString();
	}

}
