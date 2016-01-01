/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.DILFDResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.DILFDFldnumEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.endpoints.interfaces.DILFDFldnumEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilfd.model.DILFDFldnumResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class DILFDFldnumTest  extends VistaLinkContextTestParent {

    private static final String RPCCALL = "";

    @Test
    public void fldnumTest() throws VistaWebServiceFault {
        
        String expectedOutput = "3";
        
        DILFDFldnumRequest request = new DILFDFldnumRequest();
        
        request.setFile("200");
        request.setFieldName("DUZ(0)");
        
        
        //  Use Mockito to set up vistaLinkContext from parent class to return
        //  proper string.
        when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(RPCCALL), null)).thenReturn(
                expectedOutput);
        
        DILFDFldnumEndpoint endpoint = new DILFDFldnumEndpointImpl(this.getVistaLinkContext(),
                new DILFDResponseFactory());
        
        DILFDFldnumResponse response = endpoint.fldnum(request);
        
        assertNotNull(response);
    }
}
