/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.utils.MailmanUtils;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.endpoints.interfaces.XMA2REntaEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma2r.model.XMA2REntaResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InrespEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 * 
 */
public class XMXUTIL2InrespIT extends EvolutionIT<XMXUTIL2InrespEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL2InrespIT.class);

	/**
	 * Test method for
	 * {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InrespEndpointImpl#inresp(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InrespRequest)}
	 * .
	 * 
	 * @throws VistaWebServiceFault
	 *             Exception
	 */
	@Test
	public void testInresp001() throws VistaWebServiceFault, Exception {

		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMA2REntaEndpoint service3 = this
				.getEndpointImpl(XMA2REntaEndpoint.class);

		List<String> msgTxt = new ArrayList<String>();
		msgTxt.add("LINE 1");
		msgTxt.add("LINE 2");

		XMA2REntaResponse response3 = MailmanUtils.respondToMsg(service3,
				newMailMessageIEN, "INRESP TESTING", msgTxt, "", "1");

		XMXUTIL2InrespRequest request = new XMXUTIL2InrespRequest("1",
				response3.getResult(), "1");

		XMXUTIL2InrespResponse response = service.inresp(request);

		assertNotNull(response);

		LOGGER.debug("response: ");
		for (String xmirLine : response.getXmir()) {
			LOGGER.debug(xmirLine);
		}

	}

	@Test
	public void testInresp002() throws VistaWebServiceFault, Exception {

		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMA2REntaEndpoint service3 = this
				.getEndpointImpl(XMA2REntaEndpoint.class);

		List<String> msgTxt = new ArrayList<String>();
		msgTxt.add("LINE 1");
		msgTxt.add("LINE 2");

		XMA2REntaResponse response3 = MailmanUtils.respondToMsg(service3,
				newMailMessageIEN, "INRESP TESTING", msgTxt, "", "1");

		XMXUTIL2InrespRequest request = new XMXUTIL2InrespRequest("1",
				response3.getResult(), "1", "I");

		XMXUTIL2InrespResponse response = service.inresp(request);

		assertNotNull(response);

		LOGGER.debug("response: ");
		for (String xmirLine : response.getXmir()) {
			LOGGER.debug(xmirLine);
		}

	}

	@Test
	public void testInresp003() throws VistaWebServiceFault, Exception {

		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMA2REntaEndpoint service3 = this
				.getEndpointImpl(XMA2REntaEndpoint.class);

		List<String> msgTxt = new ArrayList<String>();
		msgTxt.add("LINE 1");
		msgTxt.add("LINE 2");

		XMA2REntaResponse response3 = MailmanUtils.respondToMsg(service3,
				newMailMessageIEN, "INRESP TESTING", msgTxt, "", "1");

		XMXUTIL2InrespRequest request = new XMXUTIL2InrespRequest("1",
				response3.getResult(), "1", "F");

		XMXUTIL2InrespResponse response = service.inresp(request);

		assertNotNull(response);

		LOGGER.debug("response: ");
		for (String xmirLine : response.getXmir()) {
			LOGGER.debug(xmirLine);
		}

	}

	@Override
	protected Class<XMXUTIL2InrespEndpoint> getType() {
		return XMXUTIL2InrespEndpoint.class;
	}

}
