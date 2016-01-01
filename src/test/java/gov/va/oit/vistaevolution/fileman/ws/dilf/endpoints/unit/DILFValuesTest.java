package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFValuesEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFValuesIT;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.Fda;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit Test for Values method of DILF Webservice
 */
public class DILFValuesTest extends VistaLinkContextTestParent {
	@Test
	public void testGetValues() throws VistaWebServiceFault {
		/*		>S DDR("FILE")=16200.04,DDR("FIELD")=1
		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
		>S DDR("FDA",16200.04,"1,33,",1)=16
		>S DDR("FDA",16200.04,"2,33,",1)=45
		>D VALUESR^DDR5(.RESULT,.DDR)

		>ZW RESULT
		RESULT=2
		RESULT(1)=16
		RESULT(1,"IENS")="1,33,"
		RESULT(2)=45
		RESULT(2,"IENS")="2,33,"
		 */

		// Log4J setup
		final Logger logger = Logger.getLogger(DILFValuesIT.class);
		
		ArrayList <String> expectedResults = new ArrayList <String>();
		//TODO: VistaLink is not returning the sub fields that should be returned. The RPC call is not working
		expectedResults.add("16");
		expectedResults.add("45");
		
		String testResponse = "16\n" 
				+ "45\n";
		
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				testResponse);

		// Setup the endpoint for testing.
		DILFValuesEndpointImpl dilfValuesEndpoint = new DILFValuesEndpointImpl(
				getVistaLinkContext(), new DILFResponseFactory());

		DILFValuesRequest request = new DILFValuesRequest();
		
		request.setField("1");
		request.setFile("16200.04");
		
		ArrayList<Fda> fdaList = new ArrayList<Fda>();
		Fda fda1 = new Fda();
		fda1.setFile("16200");
		fda1.setField("4");
		fda1.setPosition("33,");
		fda1.setValue("FREE TEXT DATA");
		fdaList.add(fda1);
		
		
		Fda fda2 = new Fda();
		fda2.setFile("16200.04");
		fda2.setField("1");
		fda2.setPosition("1,33,");
		fda2.setValue("16");
		fdaList.add(fda2);

		Fda fda3 = new Fda();
		fda3.setFile("16200.4");
		fda3.setField("1");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		// Execute request against mocked object backend.
		DILFValuesResponse response = dilfValuesEndpoint.values(request);

		assertNotNull(response);
		assertEquals(expectedResults.get(0), response.getDataArray().get(0));
		assertEquals(expectedResults.get(1), response.getDataArray().get(1));

	}
}
