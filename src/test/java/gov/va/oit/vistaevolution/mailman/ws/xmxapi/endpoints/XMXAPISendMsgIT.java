package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendMsgResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPISendMsgIT extends EvolutionIT<XMXAPISendMsgEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPISendMsgIT.class);

    private XMXAPISendMsgRequest request;

    @Override
    protected Class<XMXAPISendMsgEndpoint> getType() {
	return XMXAPISendMsgEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPISendMsgRequest();

	List<String> msg = new LinkedList<String>();
	msg.add("TEST 1");
	msg.add("TEST 2");

	List<XMXAPIArrayEntry> xmTo = new LinkedList<XMXAPIArrayEntry>();
	xmTo.add(new XMXAPIArrayEntry(".6", ""));

	List<XMXAPIArrayEntry> xmInstr = new LinkedList<XMXAPIArrayEntry>();

	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmSubj("TEST");
	request.setMsg(msg);
	request.setXmTo(xmTo);
	request.setXmInstr(xmInstr);
    }

    /**
     * Used to submit local request and validate response is error.
     */
    private void submitRequestWithErrors() {
	LOGGER.debug(request);

	XMXAPISendMsgResponse response = service.sendMsg(request);

	LOGGER.debug(response);

	assertEquals("-1", response.getStatus());
	assertNotNull(response.getErrors().get(0));
    }

    /**
     * <em>Normal successful message</em>
     * 
     * <pre>
     * Input Data:
     * > S DUZ=.5
     * > S XMDUZ=.5
     * > S XMSUBJ="TEST"
     * > S MSG(1)="TEST 1"
     * > S MSG(2)="TEST 2"
     * > S XMTO(.6)=""
     * > S XMINSTR=""
     * > S U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN=55758
     * </pre>
     */
    @Test
    public void testSendMessageSuccessfully() throws VistaWebServiceFault {
	LOGGER.debug(request);

	XMXAPISendMsgResponse response = service.sendMsg(request);

	LOGGER.debug(response);

	assertNotNull(response.getXmz());

    }

    /**
     * <em> DUZ not found</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=9999999,XMDUZ=.5,XMSUBJ="TEST",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^DUZ not found"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithBadDUZ() throws Exception {
	request.setDuz("9999999");

	submitRequestWithErrors();
    }

    /**
     * <em>Error in one of the required input fields</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=””,XMDUZ=.5,XMSUBJ="TEST",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithEmptyDUZ() throws Exception {
	request.setDuz("");

	submitRequestWithErrors();
    }

    /**
     * <em>Send a NULL subject.</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=.5,XMSUBJ="",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN=55759
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithEmptySubject() throws Exception {
	request.setXmSubj("");

	LOGGER.debug(request);

	XMXAPISendMsgResponse response = service.sendMsg(request);

	LOGGER.debug(response);

	assertNotNull(response.getXmz());
    }

    /**
     * <em>Send a Subject with <3 characters</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=.5,XMSUBJ="K",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Subject must be from 3 to 65 characters long."
     * </pre>
     */
    @Test
    public void testSendMessageWithShortSubject() throws Exception {
	request.setXmSubj("K");

	submitRequestWithErrors();
    }

    /**
     * <em>Send a reserved subject message</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=.5,XMSUBJ="R12322",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^Subject 'Rnnn' reserved."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithReservedSubject() throws Exception {
	request.setXmSubj("R12322");

	submitRequestWithErrors();
    }

    /**
     * <em>Send a not an authorized surrogate error message</em>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=923,XMSUBJ="TEST",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^You are not authorized to be a surrogate of DUZ 923."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageAsUnauthorizedSurrogate() throws Exception {
	request.setXmDuz("923");

	submitRequestWithErrors();
    }

    /**
     * <e>Multiple error messages returned</e>
     * 
     * <pre>
     * Input Data:
     * >S DUZ=.5,XMDUZ=343,XMSUBJ="TEST",MSG(1)="TEST 1",MSG(2)="TEST 2",XMTO(.6)="",XMINSTR="",U="^"
     * 
     * Procedure Call:
     * >D SENDMSG^XMWSOA03(.RETURN,DUZ,XMDUZ,XMSUBJ,.MSG,.XMTO,XMINSTR)
     * 
     * Expected Output:
     * >ZW RETURN
     * RETURN="-1^User '343' not found.^You are not authorized to be a surrogate of DUZ
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    public void testSendMessageWithMultipleErrors() throws Exception {
	request.setXmDuz("343");

	submitRequestWithErrors();
    }

}
