package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.XMXAPIBResponseFactory;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.XMXAPIBListBsktEndpointImpl;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBListBsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBListBsktTest extends VistaLinkContextTestParent {

	public XMXAPIBListBsktTest() {	}
	
	private XMXAPIBListBsktRequest request; 
	
	@Before
    public void setUp() {
		request = new XMXAPIBListBsktRequest();
		request.setXmDuz(".5");
    }
	
	/**
     * <em>Get the baskets for a mailbox</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART
		>S DUZ=.5,XMDUZ=.5,XMFLAGS=””,XMAMT=””,XMPART=””
		
		Procedure Call:
		>D LISTBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMFLAGS,XMAMT,.XMSTART,XMPART)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544357339)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART(1)=""
		XMSTART(2)=""
		XMSTART("IEN")=""
		</pre>
     */
    @Test
    public void testGetBasketForMailbox() throws Exception {
    	String expectedOutput = "1435^DEV.DOMAIN.GOV^244^0";

    	request.setDuz(".5");

    	when(
    		this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
    			null)).thenReturn(expectedOutput);

    	XMXAPIBListBsktEndpoint service = new XMXAPIBListBsktEndpointImpl(
    		getVistaLinkContext(), new XMXAPIBResponseFactory());

    	XMXAPIBListBsktResponse response = service.ListBskt(request);

    	assertEquals(expectedOutput,response.getRawResponse());
    }

}
