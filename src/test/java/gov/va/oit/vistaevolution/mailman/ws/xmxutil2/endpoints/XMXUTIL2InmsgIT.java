/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2InmsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgResponse;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2InmsgIT extends EvolutionIT<XMXUTIL2InmsgEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXUTIL2InmsgIT.class);

	/**
	 * Test method for {@link gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.XMXUTIL2InmsgEndpointImpl#inmsg(gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2InmsgRequest)}.
	 */
	@Test
	public void testInmsg001() throws VistaWebServiceFault, Exception {
		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMXUTIL2InmsgRequest request = new XMXUTIL2InmsgRequest("", "0", newMailMessageIEN);
		
		XMXUTIL2InmsgResponse response = service.inmsg(request);
		
		assertNotNull(response.getError());
		assertTrue(response.getError().equals("-1^Error in required input"));
	}

	@Test
	public void testInmsg002() throws VistaWebServiceFault, Exception {
		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMXUTIL2InmsgRequest request = new XMXUTIL2InmsgRequest(".6", "1", newMailMessageIEN);
		
		XMXUTIL2InmsgResponse response = service.inmsg(request);
		
		assertNotNull(response.getXmim());
		assertNotNull(response.getXminstr());
		assertNotNull(response.getXmiu());
		
		if (LOGGER.isDebugEnabled()) {
			for (String xmimLine : response.getXmim()) {
				LOGGER.debug(xmimLine);
			}
			for (String xminstrLine : response.getXminstr()) {
				LOGGER.debug(xminstrLine);
			}
			for (String xmiuLine : response.getXmiu()) {
				LOGGER.debug(xmiuLine);
			}
		}
	}

	@Test
	public void testInmsg003() throws VistaWebServiceFault, Exception {
		XMDEndpoint service2 = getEndpointImpl(XMDEndpoint.class);

		String newMailMessageIEN = MailUtils.createMailMessage(service2,
				null, null, null);

		XMXUTIL2InmsgRequest request = new XMXUTIL2InmsgRequest(".6", "1", newMailMessageIEN, "^XMB(3.9,XMZ,0)", "");
		
		XMXUTIL2InmsgResponse response = service.inmsg(request);
		
		assertNotNull(response.getXmim());
		assertNotNull(response.getXminstr());
		assertNotNull(response.getXmiu());
		
		if (LOGGER.isDebugEnabled()) {
			for (String xmimLine : response.getXmim()) {
				LOGGER.debug(xmimLine);
			}
			for (String xminstrLine : response.getXminstr()) {
				LOGGER.debug(xminstrLine);
			}
			for (String xmiuLine : response.getXmiu()) {
				LOGGER.debug(xmiuLine);
			}
		}
	}

	@Override
	protected Class<XMXUTIL2InmsgEndpoint> getType() {
		return XMXUTIL2InmsgEndpoint.class;
	}

}
