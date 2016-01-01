package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPIAnsrMsgEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIAnsrMsgResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIAnsrMsgIT extends EvolutionIT<XMXAPIAnsrMsgEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIAnsrMsgIT.class);

    @Override
    protected Class<XMXAPIAnsrMsgEndpoint> getType() {
	return XMXAPIAnsrMsgEndpoint.class;
    }

    XMXAPIAnsrMsgRequest request;

    @Before
    public void setUp() {
	request = new XMXAPIAnsrMsgRequest();
	List<String> msg = new ArrayList<String>();
	msg.add("Line one of the message");
	msg.add("Line one of the message");

	List<XMXAPIArrayEntry> xmto = new ArrayList<XMXAPIArrayEntry>();
	xmto.add(new XMXAPIArrayEntry("53467", ""));

	request.setDuz("123");
	request.setXmDuz(".5");
	request.setXmkz("58880");
	request.setXmSubj("Test Subject 1");
	request.setMsg(msg);
	request.setXmTo(xmto);
    }

    /**
     * Retrieve site address for specified IEN
     * 
     * Input Data: >Set U=”^” >Set DUZ=123 >Set XMDUZ=.5 >Set XMK=”” >Set
     * XMKZ=58880 >Set XMSUBJ=”Test Subject 1” >Set MSG(1)=”Line one of the
     * message” >Set MSG(2)=”Line one of the message” >Set XMTO=53467 >Set
     * XMINSTR=””
     * 
     * Procedure Call:
     * 
     * >D ANSRMSGM^XMWSOA03(.DATA,DUZ,XMDUZ,XMK,XMKZ,XMSUBJ,MSG,XMTO,XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA=33744
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSitesForSpecifiedIenWithoutXMK()
	    throws VistaWebServiceFault {

	LOGGER.debug(request);

	XMXAPIAnsrMsgResponse response = service.ansrMsg(request);

	LOGGER.debug(response);

	assertNotNull(response.getXmz());

    }

    /**
     * <em> Retrieve site address for specified IEN</em>
     * 
     * Input Data:
     * 
     * <pre>
     * >Set U=”^”
     * >Set DUZ=123
     * >Set XMDUZ=.5
     * >Set XMK=”IN”
     * >Set XMKZ=2
     * >Set XMSUBJ=”Test Subject 1”
     * >Set MSG(1)=”Line one of the message”
     * >Set MSG(2)=”Line two of the message”
     * >Set XMTO=53467
     * >Set XMINSTR=””
     * </pre>
     * 
     * Procedure Call:
     * 
     * >D ANSRMSGS^XMWSOA03(.DATA,DUZ,XMDUZ,XMKZ,XMSUBJ,MSG,XMTO,XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW DATA DATA=33745
     * 
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testRetrieveSitesForSpecifiedIenWithXMK()
	    throws VistaWebServiceFault {

	request.setXmk("IN");

	LOGGER.debug(request);

	XMXAPIAnsrMsgResponse response = service.ansrMsg(request);

	LOGGER.debug(response);

	assertNotNull(response.getXmz());

    }

    @Test
    public void testErrorCase() throws VistaWebServiceFault {

	request.setDuz("");
	request.setXmDuz("");

	LOGGER.debug(request);

	XMXAPIAnsrMsgResponse response = service.ansrMsg(request);

	LOGGER.debug(response);

	assertNotNull(response.getXmz());

    }

}
