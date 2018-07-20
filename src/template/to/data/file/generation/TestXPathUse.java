package template.to.data.file.generation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXPathUse {
	private File file;
	private List<String> nodes = null;
	
	public TestXPathUse(File file) {
		super();
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}

	private NodeList testTemplateParse() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		FileInputStream fileIS = new FileInputStream(getFile());
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document xmlDocument = builder.parse(fileIS);
		XPath xPath = XPathFactory.newInstance().newXPath();
		String expression = "/schema";
		NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
		return nodeList;
	}
	
	
	private static void getNodes(NodeList nodeList) throws XPathExpressionException {
		//nodes = new ArrayList<>();
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = (Node) nodeList.item(i);
			System.out.println("node : "+node.getNodeName());
			System.out.println("value : "+node.getTextContent());
			System.out.println("local name : " + node.getLocalName());

			if(node.hasChildNodes()) {
				getNodes(node.getChildNodes());
			}
		}
		//return nodes;
	}
	
	
	public static void main(String[] args) {
		try {
			NodeList nodes = new TestXPathUse(new File("E:\\_Aton\\2018\\ATON_ITEM.xsd")).testTemplateParse();
			TestXPathUse.getNodes(nodes);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
