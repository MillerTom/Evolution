/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.endpoints.interfaces.XMXUTIL2BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model.XMXUTIL2BsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMXUTIL2BsktIT extends EvolutionIT<XMXUTIL2BsktEndpoint> {
	
	private static final Logger LOGGER = Logger.getLogger(XMXUTIL2BsktIT.class);
	
    /**
     * Test Case #1: Get basket information with option input
     * 
     */
    @Test
    public void testBsktname001() throws VistaWebServiceFault {
		//XMXAPIAddrNSndResponse msgResponse = msgService.AddrNSnd(msgRequest);
		
		XMXUTIL2BsktRequest request = new XMXUTIL2BsktRequest(); 

		request.setXmduz(".6");
		//LOGGER.debug("msg ien: " + msgResponse.getMsgIen());
		//request.setXmz(msgResponse.getMsgIen());
		request.setXmz("FAKE NUMBER");  //  TODO: Need to remove once Josh is done
        request.setXmname("1");
        
        XMXUTIL2BsktResponse response = service.bskt(request);
        
        assertNotNull(response);
        LOGGER.debug("response: " + response.getResponse());
        
        // assertTrue(response.getBsktIEN().equals("0"));
    }

    /**
     * Test Case #2: Get basket information with required input only
     * 
     */
    @Test
    public void testBsktname002() throws VistaWebServiceFault {
        
		//XMXAPIAddrNSndResponse msgResponse = msgService.AddrNSnd(msgRequest);
    	
    	XMXUTIL2BsktRequest request = new XMXUTIL2BsktRequest();

		request.setXmduz(".6");
       // request.setXmz(msgResponse.getMsgIen());
		request.setXmz("FAKE MESSAGE"); //  TODO: Need to remove once Josh is done
        request.setXmname("");
        
        XMXUTIL2BsktResponse response = service.bskt(request);
        
        assertNotNull(response);
        LOGGER.debug("response: " + response.getResponse());
        
       //  assertTrue(response.getBsktIEN().equals("0"));
    }
/*
    private static void createMsgRequest() {
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("ZZ BASE MSG FOR VISTA API EXPOSURE Test Case Scenarios.");
		msg.add("ZZ BASE Test case for API XMXAPI-ADDRNSND");
		
		ArrayList<String> xmto = new ArrayList<String>();
		xmto.add("POSTMASTER");
		
		String duz = ".5";
		String xmDuz = ".5";
		String xmSubj = "ZZ VISTA API EXPOSURE XMXAPI-ADDRNSND";
		String xmStrip = "";
		String xmInstr = "I";
		msgRequest  = new XMXAPIAddrNSndRequest();
		msgRequest.setDuz(duz);
		msgRequest.setXmDuz(xmDuz);
		msgRequest.setXmSubj(xmSubj);
		msgRequest.setXmz(msg);
		msgRequest.setXmStrip(xmStrip);
		msgRequest.setXmto(xmto);
		msgRequest.setXmInstr(xmInstr);
	}
	*/

	@Override
	protected Class<XMXUTIL2BsktEndpoint> getType() {
		return XMXUTIL2BsktEndpoint.class;
	}
}
