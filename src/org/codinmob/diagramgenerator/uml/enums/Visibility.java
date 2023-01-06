/**
 * 
 */
package org.codinmob.diagramgenerator.uml.enums;

/**
 * @author MOUKHAFI ANASS
 * @On Friday, January 06, 2023
 */
public enum Visibility {
	PUBLIC("+"),
	PACKAGE("~"),
	PROTECTED("#"),
	PRIVATE("-");
	
	private String symbol;
	
	private Visibility(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
