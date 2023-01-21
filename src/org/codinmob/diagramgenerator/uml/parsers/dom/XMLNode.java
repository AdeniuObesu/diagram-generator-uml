/**
 * 
 */
package org.codinmob.diagramgenerator.uml.parsers.dom;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * @author MOUKHAFI ANASS
 * @On Saturday, January 21, 2023
 */

public class XMLNode {

	private Node node;
	private static Document document;

	private XMLNode(Node node) {
		this.node = node;
	}

	public XMLNode(String data, int flag) {
		try {
			if (document == null) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				document = builder.newDocument();
			}
			switch (flag) {
			case 1:
				this.node = document.createElement(data);
				break;
			case 4:
				this.node = document.createCDATASection(data);
			default:
				throw new Exception("FAILED TO CREATE XMLNode");
			}
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public File generate() {
		try {
			File file = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()
					+ "\\projectModel.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// initialize StreamResult with File object to save in file
			StreamResult result = new StreamResult(file);
			DOMSource source = new DOMSource(this.node);
			transformer.transform(source, result);
			return file;
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return null;
	}

	public XMLNode[] children() {
		Vector<XMLNode> nodes = new Vector<>();
		NodeList list = node.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE)
				nodes.add(new XMLNode(list.item(i)));
		}

		return nodes.toArray(new XMLNode[nodes.size()]);
	}

	public String getValue() {
		if (isAttribute()) {
			return node.getNodeValue();
		} else if (isElement()) {
			if (node.getFirstChild() == null)
				return "";
			return (node.getFirstChild().getNodeValue() == null) ? "" : node.getFirstChild().getNodeValue();
		}
		return "";
	}

	public boolean isAttribute() {
		return node.getNodeType() == Node.ATTRIBUTE_NODE;
	}

	public boolean isElement() {
		return (node.hasAttributes() || node.hasChildNodes());
	}

	public String getAttributeValue(String attributeName) {
		XMLNode attribute = getAttribute(attributeName);
		if (attribute == null)
			return null;
		return attribute.getValue();
	}

	public XMLNode getAttribute(String attributeName) {
		NamedNodeMap attributes = node.getAttributes();
		Node attribute = attributes.getNamedItem(attributeName);
		if (attribute != null)
			return new XMLNode(attribute);
		return null;
	}

	public XMLNode[] getAttributes() {
		List<XMLNode> list = new Vector<>();
		NamedNodeMap attributes = node.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			list.add(new XMLNode(attributes.item(i)));
		}
		return list.toArray(new XMLNode[list.size()]);
	}

	public void setAttribute(String attributeName, String newValue) {
		if (this.getAttribute(attributeName) != null) {
			node.getAttributes().getNamedItem(attributeName).setNodeValue(newValue);
		} else {
			Node newAttributeNode = document.createAttribute(attributeName);
			newAttributeNode.setNodeValue(newValue);
			node.getAttributes().setNamedItem(newAttributeNode);
		}
	}

	public String getName() {
		return node.getNodeName();
	}

	public XMLNode child(String childName) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			NodeList list = node.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getNodeName().equals(childName))
					return new XMLNode(list.item(i));
			}
		}
		return null;
	}

	public XMLNode child(String childName, String attributeName, String attributeValue) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			NodeList list = node.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i).getNodeName().equals(childName)
						&& list.item(i).getAttributes().getNamedItem(attributeName) != null && list.item(i)
								.getAttributes().getNamedItem(attributeName).getNodeValue().equals(attributeValue))
					return new XMLNode(list.item(i));
			}
		}
		return null;
	}

	public void appendChild(XMLNode newNode) {
		node.appendChild(newNode.node);
	}

	public void removeChild(XMLNode oldNode) {
		if (oldNode != null && oldNode.node != null)
			node.removeChild(oldNode.node);
		oldNode = null;
	}

	public XMLNode childHavingAttribute(String name, String value) {
		for (XMLNode child : children()) {
			if (child.hasAttributes()) {
				for (XMLNode attribute : child.getAttributes()) {
					if (name.equals(attribute.getName()) && value.equals(attribute.getValue()))
						return child;
				}
			}
		}
		return null;
	}

	public boolean hasAttributes() {
		return node.hasAttributes();
	}

	public static Document getDocument() {
		return document;
	}

	@Override
	public String toString() {
		String temp = getName() + " : " + getValue();
		if (node.hasAttributes()) {
			XMLNode[] attributes = getAttributes();
			for (int i = 0; i < attributes.length; i++) {
				if (i == 0)
					temp = temp + "(";
				temp = temp + attributes[i].getName() + ": " + attributes[i].getValue();
				if (i == attributes.length - 1) {
					temp = temp + ")";
					continue;
				}
				temp = temp + ", ";
			}
		}
		for (var child : children())
			temp = temp + "\n------" + child;
		return temp;
	}
}
