
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xma21.XMA21ResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.XMA21InstEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21InstEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21InstResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XMA21InstTest extends VistaLinkContextTestParent {
    
    private static final String RPCCALL = "XMWSOA INST";
        
    @Autowired
    private XMA21ResponseFactory responseFactory;
    

    @Test
    public void testAddressLookup() throws VistaWebServiceFault {
        
        String expectedOutput = "REMOTE^ via FORUM.VA.GOV\nREMOTE^48^FORUM.VA.GOV\nADDRESS^john.merritt2@VA.GOV";
        
        XMA21InstRequest request = new XMA21InstRequest();
        
        request.setXmadd("john.merritt2@va.gov");
        request.setXmdf(""); // Optional
        request.setXmduz("1");
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        //  Set up Endpoint
        XMA21InstEndpoint endpoint = new XMA21InstEndpointImpl(this.getVistaLinkContext(),
                new XMA21ResponseFactory());
        
        //  Execute request
        XMA21InstResponse response = endpoint.inst(request);        
        assertNotNull(response);      
      //  assertTrue(response.getResponse().size() == 3);
    }
    
}
