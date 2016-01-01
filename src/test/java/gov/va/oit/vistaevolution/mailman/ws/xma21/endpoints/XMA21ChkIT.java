/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xma21.endpoints.interfaces.XMA21ChkEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkRequest;
import gov.va.oit.vistaevolution.mailman.ws.xma21.model.XMA21ChkResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Christopher Schuck
 *
 */
public class XMA21ChkIT extends EvolutionIT<XMA21ChkEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(XMA21ChkIT.class);

	/**
	 * <em>Use Case #1</em>
	 * 
	 * <pre>
	 * Check DUZ of a user who IS in the Mail Group
	 * 
	 * step 1:  (Optional) Create new mail group for testing
     * 
     * >S xmgroup="TestMailGroup",xmtype=0,xmorg=DUZ,xmself=1,xmy(DUZ)="",xmdesc(1)="For API Testing Only",xmquiet=0
     *
     * >S IEN=$$MG^XMBGRP(xmgroup,xmtype,xmorg,xmself,.xmy,.xmdesc,xmquiet)          
     * >W IEN
     * 2212
     *
     * Step 2: Call CHK^XMWSOA01 to confirm that user DUZ is a member of Mail Group created in Step 1
     * >S XMDUZ=DUZ 
     * >D CHK^XMWSOA01(.RETURN,XMDUZ,IEN)
     *
     * Check value of RETURN to verify successful result of the call:
     * >W RETURN
     * 1^User is a member
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testChk001() throws VistaWebServiceFault {
		XMA21ChkRequest request = new XMA21ChkRequest();
		request.setXmduz("1");
        request.setIen("317");
        XMA21ChkResponse response = this.service.chk(request);
        
        LOGGER.debug("response: " + response.getReturnCode() + " " + response.getReturnMsg());
        
        assertNotNull(response);
        assertTrue(response.getReturnCode().equals("1"));
        assertTrue(response.getReturnMsg().equalsIgnoreCase("User is a member"));
	}

	/**
	 * <em>Use Case #2</em>
	 * 
	 * <pre>
	 * Check DUZ of a user who is NOT a member of the Mail Group
	 * 
	 * >S XMDUZ=.5,IEN=2212 ;using IEN of MAIL GROUP from Test Case #1 above. Your IEN will be different.
     * >D CHK^XMWSOA01(.RETURN,XMDUZ,IEN)
     * >W RETURN
     * 0^User is not a member
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testChk002() throws VistaWebServiceFault {
	    	    
		XMA21ChkRequest request = new XMA21ChkRequest();
		request.setXmduz(".5");
	    request.setIen("399");
	    
        XMA21ChkResponse response = this.service.chk(request);

        LOGGER.debug("response: " + response.getReturnCode() + " " + response.getReturnMsg());
        
        assertNotNull(response);
        assertTrue(response.getReturnCode().equals("0"));
        assertTrue(response.getReturnMsg().equalsIgnoreCase("User is not a member"));
	}

	/**
	 * <em>Use Case #3</em>
	 * 
	 * <pre>
	 * Check DUZ of a user for a non-existent Mail Group
	 * 
	 * >S XMDUZ=DUZ,IEN=99999 
     * > D CHK^XMWSOA01(.RETURN,XMDUZ,IEN)
     * >W RETURN
     * -1^Mail group not found
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testChk003() throws VistaWebServiceFault {

		XMA21ChkRequest request = new XMA21ChkRequest();
		request.setXmduz("1");
	    request.setIen("99999");
	        
        XMA21ChkResponse response = this.service.chk(request);

        LOGGER.debug("response: " + response.getReturnCode() + " " + response.getReturnMsg());
        
        assertNotNull(response);
        assertTrue(response.getReturnCode().equals("-1"));
        assertTrue(response.getReturnMsg().equalsIgnoreCase("Mail group not found"));
	}

	/**
	 * <em>Use Case #4</em>
	 * 
	 * <pre>
	 * Call API with incorrect value for IEN
	 * 
	 * >S XMDUZ=DUZ,IEN="ZZZ"
     * >D CHK^XMWSOA01(.RETURN,XMDUZ,IEN) 
     * >W RETURN
     * -1^Error in required input
	 * </pre>
	 * @throws VistaWebServiceFault 
	 */
	@Test
	public void testChk004() throws VistaWebServiceFault {

		XMA21ChkRequest request = new XMA21ChkRequest();
		request.setXmduz("1");
	    request.setIen("ZZZ");
        
        XMA21ChkResponse response = this.service.chk(request);

        LOGGER.debug("response: " + response.getReturnCode() + " " + response.getReturnMsg());
        
        assertNotNull(response);
        assertTrue(response.getReturnCode().equals("-1"));
        assertTrue(response.getReturnMsg().equalsIgnoreCase("Error in required input"));
	}

	@Override
	protected Class<XMA21ChkEndpoint> getType() {
		return XMA21ChkEndpoint.class;
	}
}