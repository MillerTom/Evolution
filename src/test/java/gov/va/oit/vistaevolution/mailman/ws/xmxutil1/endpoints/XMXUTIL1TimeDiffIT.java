/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1TimeDiffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1TimeDiffResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.junit.Test;

/**
 * @author rcollins
 *
 */
public class XMXUTIL1TimeDiffIT extends EvolutionIT<XMXUTIL1TimeDiffEndpoint> {
    

     @Override
     protected Class<XMXUTIL1TimeDiffEndpoint> getType() {
         return XMXUTIL1TimeDiffEndpoint.class;
     }
     
     @Test
     public void timeDiffTest001() {
         
         XMXUTIL1TimeDiffRequest request = new XMXUTIL1TimeDiffRequest();
         
         request.setXmdiff("-2.5");
         
         XMXUTIL1TimeDiffResponse response = this.service.timediff(request);
         assertNotNull(response);
         assertEquals("-0230", response.getResponse());
     }  
     
}
