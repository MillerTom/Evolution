package gov.va.oit.vistaevolution.utils.ws.model;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4NNTResponse;
import gov.va.oit.vistaevolution.util.XmlUtils;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XmlUtilsTest {
	@Test
	@Ignore
	public void testName() throws Exception {
		assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
						+ "<xuaf4nntResponse>\n"
						+ "    <institutionName>institutionName</institutionName>\n"
						+ "    <siteNumber>siteNumber</siteNumber>\n"
						+ "    <institutionType>institutionType</institutionType>\n"
						+ "</xuaf4nntResponse>\n",
				XmlUtils.toStringFromJAXBObject(new XUAF4NNTResponse(
						"institutionName", "siteNumber", "institutionType")));
		assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
						+ "<xuaf4nntRequest>\n"
						+ "    <ien>ien</ien>\n"
						+ "</xuaf4nntRequest>\n",
				XmlUtils.toStringFromJAXBObject(new XUAF4NNTRequest("ien")));
	}
}
