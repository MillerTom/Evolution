package gov.va.oit.vistaevolution.fileman.ws.die.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dilf.DILFResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFValue1EndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.DILFValue1IT;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Request;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Response;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.Fda;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Unit Test for Value1 method of DILF Webservice
 */
public class DILFValue1Test extends VistaLinkContextTestParent {
	// Log4J setup
	final Logger logger = Logger.getLogger(DILFValue1IT.class);
	
	@Test
	public void testGetValue1() throws VistaWebServiceFault {
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

		String expectedResult = "FREE TEXT DATA";
		
		// Use Mockito to set up vistaLinkContext from parent class to return
		// proper string.
		when(this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""), null)).thenReturn(
				expectedResult);

		// Setup the endpoint for testing.
		DILFValue1EndpointImpl dilfValue1Endpoint = new DILFValue1EndpointImpl(
				getVistaLinkContext(), new DILFResponseFactory());

		DILFValue1Request request = new DILFValue1Request();
		request.setField("4");
		request.setFile("16200");
		
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
		fda3.setFile("16200.04");
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		// Execute request against mocked object backend.
		DILFValue1Response response = dilfValue1Endpoint.value1(request);

		assertNotNull(response);
		assertEquals(expectedResult, response.getResult());

	}
}
