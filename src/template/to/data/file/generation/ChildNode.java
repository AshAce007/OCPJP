package template.to.data.file.generation;

/**
 * child node of a parent 
 * */

public class ChildNode {
	private String element;
	private String attribute;
	private String attributeValue;
	private String textContext;
	private ParentNode parent;
	public ChildNode(String element, String attribute, String attributeValue, String textContext, ParentNode parent) {
		super();
		this.element = element;
		this.attribute = attribute;
		this.attributeValue = attributeValue;
		this.textContext = textContext;
		this.parent = parent;
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

	public String getTextContext() {
		return textContext;
	}
	
	public ParentNode getParent() {
		return parent;
	}
}
