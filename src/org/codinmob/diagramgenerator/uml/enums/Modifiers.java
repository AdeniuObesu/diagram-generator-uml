package org.codinmob.diagramgenerator.uml.enums;
/** Defines all possible modifiers and their symbols to be used in the grammar
 * @author MOUKHAFI ANASS
 * @On Friday, December 30, 2022
 */
public enum Modifiers {
	
	PUBLIC(1, "+"),
	PUBLIC_STATIC(9, "+ {static}"),
	PUBLIC_ABSTRACT(1025, "+ {abstract}"),
	PUBLIC_FINAL_STATIC(25, ""),
	
	PACKAGE(0, "~"),
	PACKAGE_STATIC(8, "~ {static}"),
	PACKAGE_ABSTRACT(1024, "~ {abstract}"),
	PACKAGE_FINAL_STATIC(24, ""),
	
	PROTECTED(4, "#"),
	PROTECTED_STATIC(12, "{static}"),
	PROTECTED_ABSTRACT(1028, "# {abstract}"),
	PROTECTED_FINAL_STATIC(28, ""),
	

	PRIVATE(2, "-"),
	PRIVATE_STATIC(10, "- {static}"),
	PRIVATE_FINAL_STATIC(26, "");
	
	public int modifier;
	public String symbol;
	
	/**
	 * Initializes the modifiers each with a number and a symbol
	 * @param modifier
	 * @param symbol
	 */
	private Modifiers(int modifier, String symbol) {
		this.modifier = modifier;
		this.symbol = symbol;
	}
	
	/**
	 * Giving a modifier's number this method returns its associated symbol
	 * @param modifier
	 * @return symbol
	 */
	public static String valueOf(int modifier){
		for(Modifiers element : Modifiers.values()){
			if(element.modifier == modifier){
				return element.symbol;
			}
		}
		return "";
	}
}