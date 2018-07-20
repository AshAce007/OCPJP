package template.to.data.file.generation;

public class ElementReader {
	private String element;
	private String attribute;
	private String attributeValue;
	
	public ElementReader(String element, String attribute, String attributeValue) {
		super();
		this.element = element;
		this.attribute = attribute;
		this.attributeValue = attributeValue;
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

}
