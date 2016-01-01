/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.endpoints.interfaces.XMA1CSetsbEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma1c.model.XMA1CSetsbResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Christopher Schuck
 *
 */
public class XMA1CSetsbIT extends EvolutionIT<XMA1CSetsbEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMA1CSetsbIT.class);
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Put a message in a server basket.
	 * </pre>
	 */
	@Test
	public void testSetsb001() throws VistaWebServiceFault {
		XMA1CSetsbRequest request = new XMA1CSetsbRequest();
		request.setXmxx("S.XU FINDUSER");
		request.setXmz("73884");
		XMA1CSetsbResponse response = service.setsb(request);
		LOGGER.info("testSetsb001 response: " + response.getReturnCode() + " " + response.getReturnMsg());
		assertEquals("0", response.getReturnCode());
		assertEquals("Successful", response.getReturnMsg());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Invalid input
	 * </pre>
	 */
	@Test
	public void testSetsb002() throws VistaWebServiceFault {
		XMA1CSetsbRequest request = new XMA1CSetsbRequest();
		request.setXmxx("S.XU FINDUSER");
		request.setXmz(""); // this isn't an optional input, so should produce an error
		XMA1CSetsbResponse response = service.setsb(request);
		LOGGER.info("testSetsb002 response: " + response.getReturnCode() + " " + response.getReturnMsg());
		assertEquals("-1", response.getReturnCode());
		assertEquals("Error in required input", response.getReturnMsg());
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Invalid server basket
	 * </pre>
	 */
	@Test
	public void testSetsb003() throws VistaWebServiceFault {
		XMA1CSetsbRequest request = new XMA1CSetsbRequest();
		request.setXmxx("S.XU FINDUSER X");
		request.setXmz("999");
		
		XMA1CSetsbResponse response = service.setsb(request);
		LOGGER.info("testSetsb003 response: " + response.getReturnCode() + " " + response.getReturnMsg());
		assertEquals("-1", response.getReturnCode());
		assertEquals("Server basket not found", response.getReturnMsg());
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Message not found
	 * </pre>
	 */
	@Test
	public void testSetsb004() throws VistaWebServiceFault {
		XMA1CSetsbRequest request = new XMA1CSetsbRequest();
		request.setXmxx("S.XU FINDUSER");
		request.setXmz("999");
		
		XMA1CSetsbResponse response = service.setsb(request);
		LOGGER.info("testSetsb004 response: " + response.getReturnCode() + " " + response.getReturnMsg());
		assertEquals("-1", response.getReturnCode());
		assertEquals("Message not found", response.getReturnMsg());
	}

	@Override
	protected Class<XMA1CSetsbEndpoint> getType() {
		return XMA1CSetsbEndpoint.class;
	}
}