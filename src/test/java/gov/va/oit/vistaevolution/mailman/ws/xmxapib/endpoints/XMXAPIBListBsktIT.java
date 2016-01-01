package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBListBsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListBsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.junit.Before;
import org.junit.Test;

public class XMXAPIBListBsktIT extends EvolutionIT<XMXAPIBListBsktEndpoint> {
	
	private XMXAPIBListBsktRequest request;
	
	@Override
	protected Class<XMXAPIBListBsktEndpoint> getType() {
		return XMXAPIBListBsktEndpoint.class;
	}
	
	@Before
    public void setUp() {
		request = new XMXAPIBListBsktRequest();
		request.setDuz(".5");
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
		Expected Output:
		Item number 1 will be
		String expectedBasketIen = "1435";
    	String expectedBasketName = "DEV.DOMAIN.GOV";
    	String expectedNumMsgs = "248";
    	String expectedNumNewMsgs = "0";
		</pre>
     */
    @Test
    public void testGetBasketForMailbox() throws Exception {
    	String expectedBasketIen = "1435";
    	String expectedBasketName = "DEV.DOMAIN.GOV";
    	String expectedNumMsgs = "248";
    	String expectedNumNewMsgs = "0";

    	
    	XMXAPIBListBsktResponse response = service.ListBskt(request);
    	XMXAPIBListBsktEntry bsktEntry = response.getBasketList().get(1);
    	assertEquals(expectedBasketIen, bsktEntry.getBasketIen());
    	assertEquals(expectedBasketName, bsktEntry.getBasketName());
    	assertEquals(expectedNumMsgs, bsktEntry.getNumMessagesInBasket());
    	assertEquals(expectedNumNewMsgs, bsktEntry.getNumNewMessagesInBasket());
    }
    
    /**
     * <em>Get x amount of baskets for a mailbox</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART
		>S DUZ=.5,XMDUZ=.5,XMFLAGS=””,XMAMT=”5”,XMPART=””
		
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
    public void testGet5BasketsAtATime() throws Exception {
    	int expectedItemCountFirstRun = 5;
    	
    	request.setXmAmt("5");

    	
    	XMXAPIBListBsktResponse response = service.ListBskt(request);
    	
    	assertTrue("Item count correct", response.getBasketList().size() == expectedItemCountFirstRun);
    	
    	
    }
    
    /**
     * <em>Get all the baskets for a mailbox that begin with the string “DEV“.</em>
     * 
     * <pre>
			Input Data:
			>K RETURN,XMSTART
			>S DUZ=.5,XMDUZ=.5,XMFLAGS=””,XMAMT=”*”,XMPART=”DEV”
			
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
    public void testAllBasketsWithSpecificName() throws Exception {
    	String expectedBasketIen = "1435";
    	String expectedBasketName = "DEV.DOMAIN.GOV";
    	String expectedNumMsgs = "248";
    	String expectedNumNewMsgs = "0";
    	
    	request.setXmPart("DEV");

    	
    	XMXAPIBListBsktResponse response = service.ListBskt(request);
    	
    	XMXAPIBListBsktEntry bsktEntry = response.getBasketList().get(0);
    	assertEquals(expectedBasketIen, bsktEntry.getBasketIen());
    	assertEquals(expectedBasketName, bsktEntry.getBasketName());
    	assertEquals(expectedNumMsgs, bsktEntry.getNumMessagesInBasket());
    	assertEquals(expectedNumNewMsgs, bsktEntry.getNumNewMessagesInBasket());
    }
    
    /**
     * <em>Get the baskets for a mailbox, in reverse alphabetical order.  </em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART
		>S DUZ=.5,XMDUZ=.5,XMFLAGS=”B”,XMAMT=””,XMPART=””
		
		Procedure Call:
		>D LISTBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMFLAGS,XMAMT,.XMSTART,XMPART)
		
		Expected Output:
		Item number 7 will be
		String expectedBasketIen = "1435";
    	String expectedBasketName = "DEV.DOMAIN.GOV";
    	String expectedNumMsgs = "248";
    	String expectedNumNewMsgs = "0";
		</pre>
     */
    @Test
    public void testGetBasketForMailboxInReverseAlhpa() throws Exception {
    	String expectedBasketIen = "1435";
    	String expectedBasketName = "DEV.DOMAIN.GOV";
    	String expectedNumMsgs = "248";
    	String expectedNumNewMsgs = "0";
    	request.setXmFlags("B");

    	
    	XMXAPIBListBsktResponse response = service.ListBskt(request);
    	XMXAPIBListBsktEntry bsktEntry = response.getBasketList().get(7);
    	assertEquals(expectedBasketIen, bsktEntry.getBasketIen());
    	assertEquals(expectedBasketName, bsktEntry.getBasketName());
    	assertEquals(expectedNumMsgs, bsktEntry.getNumMessagesInBasket());
    	assertEquals(expectedNumNewMsgs, bsktEntry.getNumNewMessagesInBasket());
    }
    	
    /**
     * <em>Get the baskets for a mailbox that have new messages  </em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART
		>S DUZ=.5,XMDUZ=.5,XMFLAGS=”N”,XMAMT=””,XMPART=””
		
		Procedure Call:
		>D LISTBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMFLAGS,XMAMT,.XMSTART,XMPART)
		
		Expected Output:
		Item number 0 will be
		String expectedBasketIen = "1";
    	String expectedBasketName = "IN";
    	String expectedNumMsgs = "358";
    	String expectedNumNewMsgs = "266";
		</pre>
     */
    @Test
    public void testGetBasketForMailboxWhichHaveNewMessages() throws Exception {
    	String expectedBasketIen = "1";
    	String expectedBasketName = "IN";
    	String expectedNumMsgs = "358";
    	String expectedNumNewMsgs = "266";
    	request.setXmFlags("N");

    	
    	XMXAPIBListBsktResponse response = service.ListBskt(request);
    	XMXAPIBListBsktEntry bsktEntry = response.getBasketList().get(0);
    	assertEquals(expectedBasketIen, bsktEntry.getBasketIen());
    	assertEquals(expectedBasketName, bsktEntry.getBasketName());
    	assertEquals(expectedNumMsgs, bsktEntry.getNumMessagesInBasket());
    	assertEquals(expectedNumNewMsgs, bsktEntry.getNumNewMessagesInBasket());
    }
}
