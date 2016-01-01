/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.endpoints.interfaces.DDR2Find1CEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CRequest;
import gov.va.oit.vistaevolution.fileman.ws.ddr2.model.DDR2Find1CResponse;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4LKUPEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4LKUPResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPINpiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.endpoints.interfaces.XUSNPIQiEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPINpiResponse;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiRequest;
import gov.va.oit.vistaevolution.kernel.ws.xusnpi.model.XUSNPIQiResponse;
import gov.va.oit.vistaevolution.util.StrUtils;
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
public class XUSNPIQiIT extends EvolutionIT<XUSNPIQiEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XUSNPIQiIT.class);

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Valid lookup for an individual
	 * </pre>
	 */
	@Test
	public void testQi001() throws VistaWebServiceFault, Exception {
		DDR2Find1CEndpoint service2 = this.getEndpointImpl(DDR2Find1CEndpoint.class);
		
		DDR2Find1CRequest request2 = new DDR2Find1CRequest();
		
		request2.setFile("200");
		request2.setIens("");
		request2.setValue("ZZEVO,PROXY USER");
		request2.setScreen("");
		request2.setXref("");
		List<String> flags = new ArrayList<String>();
		// flags.add("M");
		// flags.add("X");
		request2.setFlags(flags);

		DDR2Find1CResponse response2 = service2.find1C(request2);
		
		LOGGER.debug("response 2: " + response2.getDataList().get(0));
		
		XUSNPINpiRequest request3 = new XUSNPINpiRequest("Individual_ID", response2.getDataList().get(0));
		
		XUSNPINpiEndpoint service3 = this.getEndpointImpl(XUSNPINpiEndpoint.class);
		
		XUSNPINpiResponse response3 = service3.npi(request3);
		
		LOGGER.debug("response 3: " + response3.getResponse());
		
		List<String> resp3Lines = StrUtils.stringtoList(response3.getResponse(), "\\^");
		
		XUSNPIQiRequest request = new XUSNPIQiRequest(resp3Lines.get(0));
		
		XUSNPIQiResponse response = service.qi(request);
		
		LOGGER.debug("response: " + response.getResponse());
		
		assertNotNull(response);        
        assertEquals("Individual_ID^10000000223^3140218^Active;", response.getResponse());
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Valid lookup for an organization
	 * </pre>
	 */
	@Test
	public void testQi002() throws VistaWebServiceFault, Exception {
		XUAF4LKUPEndpoint service2 = this.getEndpointImpl(XUAF4LKUPEndpoint.class);
		
		XUAF4LKUPRequest request2 = new XUAF4LKUPRequest("776");
		
		XUAF4LKUPResponse response2 = service2.LKUP(request2);
		
		LOGGER.debug("response2: " + response2.getIen());

		XUSNPINpiRequest request3 = new XUSNPINpiRequest("Organization_ID", response2.getIen());
		
		XUSNPINpiEndpoint service3 = this.getEndpointImpl(XUSNPINpiEndpoint.class);
		
		XUSNPINpiResponse response3 = service3.npi(request3);
		
		LOGGER.debug("response 3: " + response3.getResponse());
	
		List<String> resp3Lines = StrUtils.stringtoList(response3.getResponse(), "\\^");
		
		XUSNPIQiRequest request = new XUSNPIQiRequest(resp3Lines.get(0));
		
		XUSNPIQiResponse response = service.qi(request);
		
		LOGGER.debug("response: " + response.getResponse());

		assertNotNull(response);        
        assertEquals("Organization_ID^17048^3140320^Active;", response.getResponse());
	}

	@Override
	protected Class<XUSNPIQiEndpoint> getType() {
		return XUSNPIQiEndpoint.class;
	}
}
