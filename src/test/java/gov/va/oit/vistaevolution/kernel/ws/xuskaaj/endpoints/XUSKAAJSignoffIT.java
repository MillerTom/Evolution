package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.endpoints.interfaces.XUSKAAJSignoffEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model.XUSKAAJSignoffResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XUSKAAJSignoffIT extends VistaLinkContextITParent {

	@Autowired
	private XUSKAAJSignoffEndpoint endpoint;
	
	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Remove entry in sign-on log for current user
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testSignoff001() throws VistaWebServiceFault {
	    
	    XUSKAAJSignoffRequest request = new XUSKAAJSignoffRequest(); 
	    
	    request.setDa(".5");
	    
	    XUSKAAJSignoffResponse response = this.endpoint.signoff(request);
	    assertNotNull(response);
	    assertEquals("1", response.getRet());
		
	}

}
