/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBNamebsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for NAMEBSKT method of XMXAPIB Webservice
 */
public class XMXAPIBNamebsktIT extends VistaLinkContextITParent {

	@Autowired
	private XMXAPIBNamebsktEndpointImpl service;

	private XMXAPIBNamebsktRequest request;
	private XMXAPIBNamebsktResponse response;

	/**
	 * No Arguments Constructor
	 */
	public XMXAPIBNamebsktIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Error. DUZ is null.
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=""
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^Error in required input"
	 * 
	 * </pre>
	 */
	@Test
	public void testNamebskt001() throws VistaWebServiceFault {

		request = new XMXAPIBNamebsktRequest("");

		response = service.namebskt(request);

		assertNotNull(response);
		if (response.getErrors() != null) {
			assertEquals("Error in required input\n", response.getErrors()
					.get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * User read the original message only
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=999999
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="ERROR,-1^DUZ 999999 is not an active user"
	 * 
	 * </pre>
	 */
	@Test
	public void testNamebskt002() throws VistaWebServiceFault {

		request = new XMXAPIBNamebsktRequest("999999");

		response = service.namebskt(request);

		assertNotNull(response);
		if (response.getErrors() != null) {
			assertEquals("DUZ 999999 is not an active user\n", response
					.getErrors().get(1));
		} else {
			fail("msgRoot is NULL !!");
		}
	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Set up User’s Vital Information. Use DUZ=.5
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.5
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="0^No errors or warnings"   
	 * RETURN(1)="WARNING,1^Priority Mail"     ***DBITPRO
	 * 
	 * >ZW XMDISPI
	 * XMDISPI="XIA^I"
	 * 
	 * >ZW XMDUN
	 * XMDUN="POSTMASTER"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMPRIV
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"   **DNITPRO  XMV("BANNER")="POSTMASTER"
	 * XMV("DUZ NAME")="POSTMASTER"
	 * XMV("LAST USE")="02/27/14@14:54:31"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="POSTMASTER"
	 * XMV("NETNAME")="POSTMASTER@DEVNCH.VACO.VA.GOV"
	 * XMV("NETNAME")="SHARED.MAIL@DBITTEST.DBITPRO.COM"   *** DBITPRO
	 * 
	 * XMV("NEW MSGS")=2191     **DBITPRO  XMV("NEW MSGS")=244
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("RDR ASK")="N"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * 
	 * </pre>
	 */
	@Test
	public void testNamebskt003() throws VistaWebServiceFault {

		request = new XMXAPIBNamebsktRequest(".5");

		response = service.namebskt(request);

		assertNotNull(response);
		if (response.getSettingsList() != null) {
			assertEquals("WARNING,1^Priority Mail", response.getSettingsList()
					.get(0));
		} else {
			fail("settingsList is NULL !!");
		}
	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Set up User’s Vital Information. Use DUZ=.6
	 * 
	 * <pre>
	 *  Input Data:
	 * >K XMDISPI,XMDUN,XMNOSEND,XMPRIV,XMV
	 * >S DUZ=.6
	 * 
	 * Procedure Call:
	 * >D SELF^XMWSOA03(.RETURN,DUZ)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="WARNING,1^Priority Mail"
	 * 
	 * >ZW XMDISPI
	 * XMDISPI="XIA^I"
	 * 
	 * >ZW XMDUN
	 * XMDUN="SHARED,MAIL"
	 * 
	 * >ZW XMNOSEND
	 * 
	 * >ZW XMPRIV
	 * 
	 * >ZW XMV
	 * XMV("ASK BSKT")=1
	 * XMV("BANNER")="MR. MAILMAN"    **DNITPRO  XMV("BANNER")="POSTMASTER"
	 * XMV("DUZ NAME")="POSTMASTER"
	 * XMV("LAST USE")="02/27/14@15:33:44"
	 * XMV("MSG DEF")="I"
	 * XMV("NAME")="SHARED,MAIL"
	 * XMV("NETNAME")=SHARED.MAIL@DEVNCH.VACO.VA.GOV  
	 * XMV("NETNAME")="SHARED.MAIL@DBITTEST.DBITPRO.COM"   *** DBITPRO
	 * 
	 * XMV("NEW MSGS")=6            ***DBITPRO   XMV("NEW MSGS")=43
	 * XMV("NEW OPT")="R"
	 * XMV("NEW ORDER")=1
	 * XMV("NOSEND")=0
	 * XMV("ORDER")=1
	 * XMV("PREVU")=0
	 * XMV("PRIV")="R"
	 * XMV("RDR ASK")="N"
	 * XMV("RDR DEF")="C"
	 * XMV("SHOW DUZ")=0
	 * XMV("SHOW INST")=1
	 * XMV("SHOW TITL")=0
	 * XMV("VERSION")="VA MailMan 8.0"
	 * 
	 * </pre>
	 */
	@Test
	public void testNamebskt004() throws VistaWebServiceFault {

		request = new XMXAPIBNamebsktRequest(".6");

		response = service.namebskt(request);

		assertNotNull(response);
		if (response.getSettingsList() != null) {
			assertEquals("WARNING,1^Priority Mail", response.getSettingsList()
					.get(0));
		} else {
			fail("settingsList is NULL !!");
		}
	}
}
