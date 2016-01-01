/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.endpoints.interfaces.XMXUTILBpmsgctEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil.model.XMXUTILBpmsgctResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rcollins
 *
 */
public class XMXUTILBpmsgctIT extends VistaLinkContextITParent {
    
    @Autowired
    private XMXUTILBpmsgctEndpoint endpoint;
    
    
    @Test
    public void bpmsgctTest001() throws VistaWebServiceFault {
        
        XMXUTILBpmsgctRequest request = new XMXUTILBpmsgctRequest();
        
        request.setXmduz(".5");
        request.setXmk("1");
        
        XMXUTILBpmsgctResponse response = this.endpoint.bpmsgct(request);
        
        assertNotNull(response);
        assertEquals("6", response.getReturns());
        System.out.println(response);
        
    }
    
}
