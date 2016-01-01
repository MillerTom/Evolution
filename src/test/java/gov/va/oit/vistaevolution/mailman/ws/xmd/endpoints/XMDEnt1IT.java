package gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.endpoints.interfaces.XMDEnt1Endpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDEnt1Request;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMDResponse;
import gov.va.oit.vistaevolution.mailman.ws.xmd.model.XMYEntry;
import gov.va.oit.vistaevolution.utils.MailUtils;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

public class XMDEnt1IT extends EvolutionIT<XMDEnt1Endpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMDEnt1IT.class);

    private XMDEndpoint service2;

    /*
     * (non-Javadoc)
     * 
     * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
     */
    @Override
    protected Class<XMDEnt1Endpoint> getType() {
	return XMDEnt1Endpoint.class;
    }

    public String sendMessage() {
	try {
	    if (service2 == null)
		service2 = getEndpointImpl(XMDEndpoint.class);

	    return MailUtils.createMailMessage(service2, null, null, null);

	} catch (Exception e) {
	    LOGGER.error(e);
	    return null;
	}

    }

    /**
     * <em>Test case no DUZ defined, returns error</em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S DUZ=””,XMDUZ=52,XMY(53392)=””,XMZ=3
     *  
     * Function call 
     * > D ENT1^XMWSOA02(.OUTPUT,DUZ,XMDUZ,.XMY,XMZ)
     *  
     * Output 
     * >ZW OUTPUT
     * OUTPUT="-1^Error in required input"
     * </pre>
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testNoDUZError() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry("53467", ""));
	XMDEnt1Request request = new XMDEnt1Request("", "52", XMY, "3");

	XMDResponse response = service.ent1(request);

	assertEquals("Error in required input", response.getErrors().get(0));

    }

    /**
     * <em>Test case forward a message to a user, successful return code. </em>
     * 
     * <pre>
     * >S U="^"
     * Input  
     * >S DUZ=53467,XMDUZ=52,XMY(53392)=””,XMZ=3
     *  
     * Function call 
     * > D ENT1^XMWSOA02(.OUTPUT,DUZ,XMDUZ,.XMY,XMZ)
     *  
     * Output 
     * >ZW OUTPUT
     * OUTPUT="0^Successful"
     * </pre>
     */
    @Test
    public void testSuccessfulSend() throws VistaWebServiceFault {
	ArrayList<XMYEntry> XMY = new ArrayList<XMYEntry>();
	XMY.add(new XMYEntry(".6", ""));
	XMDEnt1Request request = new XMDEnt1Request(".5", ".5", XMY,
		sendMessage());

	XMDResponse response = service.ent1(request);

	assertEquals("Successful", response.getResponse());

    }

}
