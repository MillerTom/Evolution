package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBListMsgsEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBListMsgsResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.model.VistaM1KeyArrayEntry;
import gov.va.oit.vistaevolution.ws.model.VistaM2KeyArrayEntry;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class XMXABPIBListMsgsIT extends EvolutionIT<XMXAPIBListMsgsEndpoint> {

	private XMXAPIBListMsgsRequest request;
	
	@Override
	protected Class<XMXAPIBListMsgsEndpoint> getType() {
		return XMXAPIBListMsgsEndpoint.class;
	}
	
	@Before
    public void setUp() {
		request = new XMXAPIBListMsgsRequest();
		request.setDuz(".5");
		request.setXmDuz(".5");
		request.setXmk("*");
    }

	/**
     * <em> Get all the messages for a mailbox</em>
     * 
     * <pre>
			Input Data:
			>K RETURN,XMSTART,XMCRIT
			>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=””,XMAMT=””,XMCRIT=””
			
			Procedure Call:
			>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
			
			Expected Output:
			>ZW RETURN
			RETURN="^TMP(""XMLIST"",544362355)"
			
			>ZW XMSTART
			XMSTART=""
			XMSTART("XMK")="B"
			XMSTART("XMZ")=""


		</pre>
     */
    @Test 
    public void testGetAllMessageForAMailBox() throws Exception {
    	
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
	
	
	
	/**
     * <em> Get all the messages for a mailbox that have the string “API” in the text.  
     * 		Make the search non-case-sensitive.  Search only the responses.</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=””,XMAMT=””,XMCRIT=””,XMCRIT(“TEXT”)=”API“,XMCRIT(“TEXT”,”C”)=0,XMCRIT(“TEXT”,”L”)=3
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544362355)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART("XMK")="B"
		XMSTART("XMZ")=""

		</pre>
     */
    @Test 
    public void testSearchResponsesForSpecifiedString() throws Exception {
    	request.setXmFlds("BSKT;SUBJ;DATE");
    	request.setXmCrit(new LinkedList<Object>());
    	request.getXmCrit().add("");
    	request.getXmCrit().add(new VistaM1KeyArrayEntry("TEXT","API"));
    	request.getXmCrit().add(new VistaM2KeyArrayEntry("TEXT","C","0"));
    	request.getXmCrit().add(new VistaM2KeyArrayEntry("TEXT","L","3"));
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
	
    /**
     * <em> GGet the first five messages for a mailbox, then the next five messages</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=””,XMAMT=””,XMCRIT=””,XMCRIT(“TEXT”)=”API“,XMCRIT(“TEXT”,”C”)=0,XMCRIT(“TEXT”,”L”)=3
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544362355)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART("XMK")="B"
		XMSTART("XMZ")=""

		</pre>
     */
    @Test 
    public void testGetFirst5MessagesForAMailBox() throws Exception {
    	request.setXmAmt("5");
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
	
    
    
    
    /**
     * <em> Get all the messages for a mailbox whose Subjects begin with the string “MAIL GROUP“.</em>
     * 
     * <pre>
		Input Data:
			>K RETURN,XMSTART,XMCRIT
			>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=””,XMAMT=”*”,XMCRIT(“SUBJ”)=”MAIL GROUP”
			
			Procedure Call:
			>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
			
			Expected Output:
			>ZW RETURN
			RETURN="^TMP(""XMLIST"",544362355)"
			
			>ZW XMSTART
			XMSTART=""
			XMSTART("XMK")="B"
			XMSTART("XMZ")=""


		</pre>
     */
    @Test 
    public void testGetAllMsgsForMailBoxWithSpecifiedSubject() throws Exception {
    	request.setXmCrit(new LinkedList<Object>());
    	request.getXmCrit().add(new VistaM1KeyArrayEntry("SUBJ","MAIL GROUP"));
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
    
    
    /**
     * <em>Get the first 5 new messages for a mailbox.</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=”N”,XMAMT=5,XMCRIT=””
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544362355)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART("XMK")=1
		XMSTART("XMZ")=138218



		</pre>
     */
    @Test 
    public void testGetFirst5NewMessagesForAMailbox() throws Exception {
    	request.setXmFlags("N");
    	request.setXmAmt("5");
    	request.setXmCrit(new LinkedList<Object>());
    	request.getXmCrit().add("");
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
    
    
    /**
     * <em>Get the first 5 priority messages for a mailbox.</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=”P”,XMAMT=5,XMCRIT=””
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544362355)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART("XMK")=1
		XMSTART("XMZ")=138218



		</pre>
     */
    @Test 
    public void testGetFirst5PriorityMessagesForAMailbox() throws Exception {
    	
    	request.setXmFlags("P");
    	request.setXmAmt("5");
    	request.setXmCrit(new LinkedList<Object>());
    	request.getXmCrit().add("");
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
    
    
    /**
     * <em>Ensure that using all four flags does not cause an error</em>
     * 
     * <pre>
		Input Data:
		>K RETURN,XMSTART,XMCRIT
		>S DUZ=.5,XMDUZ=.5,XMK=”*”,XMFLDS=””,XMFLAGS=”BCNP”,XMAMT=5,XMCRIT=””
		
		Procedure Call:
		>D LISTMSGS^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK,XMFLDS,XMFLAGS,XMAMT,.XMSTART,.XMCRIT)
		
		Expected Output:
		>ZW RETURN
		RETURN="^TMP(""XMLIST"",544362355)"
		
		>ZW XMSTART
		XMSTART=""
		XMSTART("XMK")=""
		XMSTART("XMZ")=""




		</pre>
     */
    @Test 
    public void testUseAll4FlagsAtSameTimeWithNoError() throws Exception {
    	
    	request.setXmFlags("BCNP");
    	request.setXmAmt("5");
    	request.setXmCrit(new LinkedList<Object>());
    	request.getXmCrit().add("");
    	
    	XMXAPIBListMsgsResponse response = service.ListMsgs(request);
    	assertNotNull(response);
    	assertNotNull(response.getRawResponse());
    }
    
}
