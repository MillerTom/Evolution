/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMDIT extends EvolutionIT<XMDEndpoint> {

    /**
	 * 
	 */
    private static final String SUBJECT = "Test subject";
    private static final String DUZ = ".5";
    private static final String XMDUZ = ".5";
    private static final Logger LOGGER = Logger.getLogger(XMDIT.class);

    private ArrayList<String> message;
    private ArrayList<XMYEntry> XMY;
    private XMDRequest request;

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
     */
    @Override
    protected Class<XMDEndpoint> getType() {
	return XMDEndpoint.class;
    }

    @Before
    public void setUp() {
	XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry(".6", ""));

	message = new ArrayList<String>();
	message.add("THIS IS A 2 LINE TEST MESSAGE");
	message.add("THIS IS THE SECOND LINE ~&% with some text to be stripped.");

	request = new XMDRequest();
    }

    /**
     * <em>Send a standard Message to a single recipient</em>
     * 
     * <pre>
     *  Input Data:
     *  >S DUZ=.5
     *  >S XMDUZ=.5
     *  >S XMSUB="Test subject",
     *  >S MSG(1,0)="THIS IS A 2 LINE TEST MESSAGE"
     *  >S MSG(1,1)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     *  >S XMY(.6)=""
     *  >S U=^
     *  >S RETURN=””
     *  
     *  Procedure Call:
     *  >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     *  
     *  Expected Output:
     *  >ZW RETURN
     *  RETURN=55763
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSendMessageToSingleRecipient() throws VistaWebServiceFault {

	request.setDuz(DUZ);
	request.setXmDuz(XMDUZ);
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	testRequest();
    }

    /**
     * <em>Send a standard Message with no User ID (DUZ) set.  </em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=””
     * >S XMDUZ=.5
     * >S XMSUB="Test subject"
     * >S MSG(1,0)="THIS IS A 2 LINE TEST MESSAGE"
     * >S MSG(1,1)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     * >S XMY(.6)=""
     * >S U=^
     * >S RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSendMessageWithNoDUZ() throws VistaWebServiceFault {

	request.setDuz("");
	request.setXmDuz(XMDUZ);
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	testForError();
    }

    /**
     * <em>Send a standard Message with no User ID (XMDUZ) set.</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=””
     * >S XMSUB="Test subject"
     * >S MSG(1,0)="THIS IS A 2 LINE TEST MESSAGE"
     * >S MSG(1,1)="THIS IS THE SECOND LINE ~&% with some text to be stripped."\
     * >S XMY(.6)=""
     * >S U=^
     * >S RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN=55764
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithNoXMDUZ() throws Exception {
	request.setDuz(DUZ);
	request.setXmDuz("");
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	testRequest();
    }

    /**
     * <em> Send a standard Message with an unknown User ID (XMDUZ) set. </em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5
     * >S XMDUZ=939
     * >S XMSUB="Test subject"
     * >S MSG(1,0)="THIS IS A 2 LINE TEST MESSAGE"
     * >S MSG(1,1)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     * >S XMY(.6)=""
     * >S U=^
     * >S RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Error = User '939' not found."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testSendMessageWithInvalidXMDUZ() throws Exception {

	request.setDuz(".5");
	request.setXmDuz("939");
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	LOGGER.debug(request);

	XMDResponse response = service.xmd(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * <em>Send a standard Message with name passed in as the XMDUZ instead of the number.</em>
     * 
     * <pre>
     * Input Data:
     * >S XMDUZ=”POSTMASTER”
     * >S DUZ=””
     * >S XMSUB="Test subject"
     * >S MSG(1)="THIS IS A 2 LINE TEST MESSAGE"
     * >S MSG(2)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     * >S XMY(.6)=""
     * >S U=^
     * >S RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN=55766
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithNameForXMDUZ() throws Exception {
	request.setDuz(".5");
	request.setXmDuz("POSTMASTER");
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	testRequest();
    }

    /**
     * <em>Missing subject</em>
     * 
     * <pre>
     * Input Data:
     * >S XMDUZ=.5 
     * >S DUZ=.5
     * >S XMSUB="”
     * >S MSG(1)="THIS IS A 2 LINE TEST MESSAGE"
     * >S MSG(2)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     * >S XMY(.6)=""
     * >S U=^
     * >S RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithNoSubject() throws Exception {
	request.setDuz(DUZ);
	request.setXmDuz(XMDUZ);
	request.setXmSub("");
	request.setMessage(message);
	request.setxMY(XMY);

	testForError();
    }

    /**
     * <em>Missing text body</em>
     * 
     * <pre>
     * Input Data:
     * >S XMDUZ=.5 DUZ=.5,XMSUB="Test Subject”,MSG="”,XMY(.6)="",U=^,RETURN=””
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURNs
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWtihNoBody() throws Exception {

	request.setDuz(DUZ);
	request.setXmDuz(XMDUZ);
	request.setXmSub(SUBJECT);
	request.setMessage(null);
	request.setxMY(XMY);

	testForError();
    }

    /**
     * <em>Testing receipt of error message generated within API</em>
     * 
     * <pre>
     * Input Data:
     * > S XMDUZ=53467
     * > S DUZ=.5
     * > S XMSUB="Test subject"
     * > S MSG(1)="THIS IS A 2 LINE TEST MESSAGE"
     * > S MSG(2)="THIS IS THE SECOND LINE ~&% with some text to be stripped."
     * > S XMY(.6)=""
     * > S U="^"
     * > S RETURN=""
     * 
     * Procedure Call:
     * >D XMD^XMWSOA02(.RETURN,DUZ,XMDUZ,XMSUB,.MSG,.XMY)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Error = You are not authorized to be a surrogate of DUZ 53467."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testSendMessageWithInternalAPIError() throws Exception {

	request.setDuz(".5");
	request.setXmDuz("53467");
	request.setXmSub(SUBJECT);
	request.setMessage(message);
	request.setxMY(XMY);

	LOGGER.debug(request);

	XMDResponse response = service.xmd(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
     * @param expectedResult
     */
    private void testForError() {
	LOGGER.debug(request);

	XMDResponse response = service.xmd(request);

	LOGGER.debug(response);

	assertNotNull(response.getErrors());
    }

    /**
	 * 
	 */
    private void testRequest() {
	LOGGER.debug(request);

	XMDResponse response = service.xmd(request);

	LOGGER.debug(response);

	assertNotNull(response.getResponse());
    }

}
