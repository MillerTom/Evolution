package gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.endpoints.interfaces.XQALBUTLUserlistEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistRequest;
import gov.va.oit.vistaevolution.kernel.ws.xqalbutl.model.XQALBUTLUserlistResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XQALBUTLUserlistEndpointIT extends EvolutionIT<XQALBUTLUserlistEndpoint> {
	

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Create and send test alert, then request list of recipients
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Ignore
	@Test
	public void testUserlist001() throws VistaWebServiceFault {
	    
		XQALBUTLUserlistRequest request = new XQALBUTLUserlistRequest();
		
	    request.setXqaid("1;1;3140321.161043");
	    
	    XQALBUTLUserlistResponse response = this.service.userlist(request);
	    assertNotNull(response);
		
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Request list of recipients for invalid alert
	 * </pre>
	 */
	@Ignore
	@Test
	public void testUserlist002() {

		XQALBUTLUserlistRequest request = new XQALBUTLUserlistRequest();
		
	    request.setXqaid("1");
	    
	    XQALBUTLUserlistResponse response = this.service.userlist(request);
	    assertNotNull(response);
		
	}

	@Override
	protected Class<XQALBUTLUserlistEndpoint> getType() {
		return XQALBUTLUserlistEndpoint.class;
	}
}
