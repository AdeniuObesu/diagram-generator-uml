/**
 * 
 */
package org.mql.uml.parsers;

import java.io.File;

/**
 * @author MOUKHAFI ANASS
 * @On Thursday, January 05, 2023
 */
public interface Parser {
	Object parse(File file);
}
