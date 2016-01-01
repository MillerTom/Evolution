/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21WhoEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21WhoResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA21WhoIT extends EvolutionIT<XMA21WhoEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMA21WhoIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Look up user in remote domain
	 * </pre>
	 */
	@Test
	public void testWho001() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		// request.setX("PROGRAMMER.ONE@VA.GOV");
		request.setX("abcd.efgh@va.gov");
		request.setXmdf("");
		request.setXmduz(".6");
		// request.setXmloc("1");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho001 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("REMOTE", response.getResponse().get(0));
		assertEquals(" via FORUM.VA.GOV", response.getResponse().get(1));
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Look up user in remote domain with XMDF flag set
	 * </pre>
	 */
	@Test
	public void testWho002() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		request.setX("abcd.efgh@va.gov");
		request.setXmdf("");
		request.setXmduz(".6");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho002 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("REMOTE", response.getResponse().get(0));
		assertEquals(" via FORUM.VA.GOV", response.getResponse().get(1));
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Look up local user by partial name
	 * </pre>
	 */
	@Test
	public void testWho003() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		request.setX("SHARED,MAIL");
		request.setXmdf("");
		request.setXmduz(".6");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho003 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("ADDRESS", response.getResponse().get(0));
		assertEquals(".6", response.getResponse().get(1));
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Look up local user by partial name with XMBF flag set
	 * </pre>
	 */
	@Test
	public void testWho004() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		request.setX("SHARED,MAIL");
		request.setXmdf("");
		request.setXmduz(".6");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho004 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("ADDRESS", response.getResponse().get(0));
		assertEquals(".6", response.getResponse().get(1));
	}

	/**
	 * <em>Use Case #5</em>
	 * 
	 * <pre>
	 * Look up remote user by partial name
	 * </pre>
	 */
	@Ignore
	@Test
	public void testWho005() throws VistaWebServiceFault {
		
	}

	/**
	 * <em>Use Case #6</em>
	 * 
	 * <pre>
	 * Look up an invalid address; error returned in XMMG (XMLOC not set)
	 * </pre>
	 */
	@Test
	public void testWho006() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		request.setX("XQZD");
		request.setXmdf("");
		request.setXmduz(".5");
		// request.setXmloc("");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho006 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("-1", response.getResponse().get(0));
		assertEquals("Addressee not found.", response.getResponse().get(1));
	}

	/**
	 * <em>Use Case #7</em>
	 * 
	 * <pre>
	 * Look up local address for non-existent user with XMDF flag set; error returned in XMMG
	 * </pre>
	 */
	@Test
	public void testWho007() throws VistaWebServiceFault {
		XMA21WhoRequest request = new XMA21WhoRequest();
		request.setX("XQZD");
		request.setXmdf("");
		request.setXmduz(".5");
		// request.setXmloc("");
		XMA21WhoResponse response = service.who(request);
		LOGGER.info("testWho007 response: " + response.getResponse().get(0) + " " + response.getResponse().get(1));
		assertEquals("-1", response.getResponse().get(0));
		assertEquals("Addressee not found.", response.getResponse().get(1));
	}

	@Override
	protected Class<XMA21WhoEndpoint> getType() {
		return XMA21WhoEndpoint.class;
	}
}
