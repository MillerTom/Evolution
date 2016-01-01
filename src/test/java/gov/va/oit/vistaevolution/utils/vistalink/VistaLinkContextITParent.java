/**
 * 
 */
package gov.va.oit.vistaevolution.utils.vistalink;

import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/applicationContext.xml" })
public class VistaLinkContextITParent {

	@BeforeClass
	public static void beforeClass() {
		if (System.getProperty("java.security.auth.login.config") == null) {
			System.setProperty("java.security.auth.login.config",
					"file:src/test/resources/jaas.config");
		}
	}

	/**
	 * @param url
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected static QName getQname(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String serviceName = getServiceNameFromWsdlUrl(url);
		String nameSpace = getServiceNamespaceFromWsdlUrl(url);
		QName qname = new QName(nameSpace, serviceName);
		return qname;
	}

	/**
	 * @param url
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected static String getServiceNameFromWsdlUrl(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String attributeName = "name";
		String tagName = "service";
		return getAttributeValueForTagNameFromWsdlURL(url, attributeName,
				tagName);
	}

	/**
	 * @param url
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected static String getServiceNamespaceFromWsdlUrl(URL url)
			throws ParserConfigurationException, SAXException, IOException {
		String attributeName = "xmlns:tns";
		String tagName = "definitions";
		return getAttributeValueForTagNameFromWsdlURL(url, attributeName,
				tagName);
	}

	/**
	 * @param url
	 * @param attributeName
	 * @param tagName
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	protected static String getAttributeValueForTagNameFromWsdlURL(URL url,
			String attributeName, String tagName)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(url.openStream());
		NodeList serviceTags = doc.getElementsByTagName(tagName);
		NamedNodeMap attributes = serviceTags.item(0).getAttributes();
		Node attribute = attributes.getNamedItem(attributeName);
		return attribute.getTextContent();

	}

	/**
	 * 
	 */
	public VistaLinkContextITParent() {
		super();
	}

}