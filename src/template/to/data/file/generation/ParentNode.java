package template.to.data.file.generation;

import java.util.List;

/**
 * Defines the parent node of a xml document
 * */

public class ParentNode {
	private String element;
	private String attribute;
	private String attributeValue;
	private List<ChildNode> childNodes;
	
	public ParentNode(String element, String attribute, String attributeValue, List<ChildNode> childNodes) {
		super();
		this.element = element;
		this.attribute = attribute;
		this.attributeValue = attributeValue;
		this.childNodes = childNodes;
	}

	public String getElement() {
		return element;
	}

	public String getAttribute() {
		return attribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public List<ChildNode> getChildNodes() {
		return childNodes;
	}

}
