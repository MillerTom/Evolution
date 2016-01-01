package gov.va.oit.vistaevolution.fileman.ws.die.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.die.endpoints.interfaces.DIEKeyValEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValRequest;
import gov.va.oit.vistaevolution.fileman.ws.die.model.DIEKeyValResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 *	DDR KEY VALIDATOR
 *
 *	Validates that values passed in do not violate key integrity.  Underlying
 *	DBS call is KEYVAL^DIE.
 *	
 *	Input Parameters:
 *		VALUES 	A list containing the values to validate
 *
 *		Array of data used to create FDA for KEYVAL^DIE call.  Alternating lines
 *		contain file#^IENS^field# and value associated with preceding file, record,
 *		and field.
 *
 *	Results:
 *		If values pass validation, 1 is returned in first node of array.  If
 *		validation fails, 0 is returned in first node followed by error
 *		information.
 * 
 */
public class DIEKeyValIT extends EvolutionIT<DIEKeyValEndpoint> {

	@Override
	protected Class<DIEKeyValEndpoint> getType() {
		// TODO Auto-generated method stub
		return DIEKeyValEndpoint.class;
	}

	public DIEKeyValIT() {
		super();
	}

	private DIEKeyValRequest dieKeyValRequest;
	private DIEKeyValResponse dieKeyValResponse;

	@Before
	public void setUp() {
		dieKeyValRequest = new DIEKeyValRequest();
	}

	@After
	public void tearDown() {
		dieKeyValRequest = null;
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * <pre>
	 *
	 * RPC Results:
	 *		>S DATA(1)="20^+1^.01"
	 *		>S DATA(2)=200
	 *		>S DATA(3)="20^+1^.02"
	 *		>S DATA(4)=.01
	 *		>S DATA(5)="20^+1^.03"
	 *		>S DATA(6)=.5
	 *		>S DATA(7)="20^2^.01"
	 *		>S DATA(8)=200
	 *		>S DATA(9)="20^2^.02"
	 *		>S DATA(10)=.01
	 *		>S DATA(11)="20^2^.03"
	 *		>S DATA(12)=.5
	 *
	 *		>D KEYVAL^DDR4(.RESULT,.DATA)
	 *		>ZW RESULT
	 *		RESULT(1)=0
	 *
	 *			 
	 * </pre>
	 */
	@Test
	public void testKeyVal001() throws VistaWebServiceFault {

		String result ="0";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^+1^.01");
		values.add("200");
		values.add("20^+1^.02");
		values.add(".01");
		values.add("20^+1^.03");
		values.add(".5");
		values.add("20^2^.01");
		values.add("200");
		values.add("20^2^.02");
		values.add(".01");
		values.add("20^2^.03");
		values.add(".5");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * <pre>
	 * RPC Results:
	 * 
	 * 		>S DATA(1)="20^+1^.01"
	 * 		>S DATA(2)=200
	 * 		>S DATA(3)="20^+1^.02"
	 * 		>S DATA(4)=.01
	 * 		>S DATA(5)="20^+1^.03"
	 * 		>S DATA(6)="@"
	 * 
	 * 		>D KEYVAL^DDR4(.RESULT,.DATA)
	 * 		>ZW RESULT
	 * 		RESULT(1)=0
	 *				 
	 * </pre>
	 */
	@Test
	public void testKeyVal002() throws VistaWebServiceFault {
		String result ="0";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^+1^.01");
		values.add("200");
		values.add("20^+1^.02");
		values.add(".01");
		values.add("20^+1^.03");
		values.add("@");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * <pre>
	 * 
	 * RPC Results:
	 *
	 * 		>S DATA(1)="20^+1^.01"
	 * 		>S DATA(2)=200
	 * 		>S DATA(3)="20^+1^.02"
	 * 		>S DATA(4)=.01
	 * 
	 * 		>D KEYVAL^DDR4(.RESULT,.DATA)
	 * 
	 * 		>ZW RESULT
	 * 		RESULT(1)=0
	 *				 
	 * </pre>
	 */
	@Test
	public void testKeyVal003() throws VistaWebServiceFault {
		String result ="0";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^+1^.01");
		values.add("200");
		values.add("20^+1^.02");
		values.add(".01");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * <pre>
	 * 
	 * RPC Results:
	 *
	 * 		>S DATA(1)="20^2^.01"
	 * 		>S DATA(2)=200
	 * 		>S DATA(3)="20^2^.02"
	 *		>S DATA(4)=.01
	 *		>S DATA(5)="20^2^.03"
	 *		>S DATA(6)=.5
	 *		>D KEYVAL^DDR4(.RESULT,.DATA)
	 *		
	 *		>ZW RESULT
	 *		RESULT(1)=1
	 *	
	 * </pre>
	 */
	@Test
	public void testKeyVal004() throws VistaWebServiceFault {
		String result ="1";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^2^.01");
		values.add("200");
		values.add("20^2^.02");
		values.add(".01");
		values.add("20^2^.03");
		values.add(".5");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * <pre>
	 * 
	 * RPC Results:
	 *
	 * 		>S DATA(1)="20^2,^.01"
	 * 		>S DATA(2)=200
	 * 		>S DATA(3)="20^2,^.02"
	 * 		>S DATA(4)=.01
	 * 		>S DATA(5)="20^2,^.03"
	 * 		>S DATA(6)=.5
	 * 		>D KEYVAL^DDR4(.RESULT,.DATA)
	 * 
	 * 		>ZW RESULT
	 * 		RESULT(1)=1
	 *	
	 * </pre>
	 */
	@Test
	public void testKeyVal005() throws VistaWebServiceFault {
		String result ="1";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^2,^.01");
		values.add("200");
		values.add("20^2,^.02");
		values.add(".01");
		values.add("20^2,^.03");
		values.add(".5");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * <pre>
	 * 
	 * RPC Results:
	 *
	 * 		>S DATA(1)="20^+1^.01"
	 * 		>S DATA(2)=200
	 * 		>S DATA(3)="20^+1^.02"
	 * 		>S DATA(4)=.01
	 * 		>S DATA(5)="20^+1^.03"
	 * 		>S DATA(6)=.5
	 * 
	 * 		>D KEYVAL^DDR4(.RESULT,.DATA)
	 * 
	 * 		>ZW RESULT
	 * 		RESULT(1)=1
	 *	
	 * </pre>
	 */
	@Test
	public void testKeyVal006() throws VistaWebServiceFault {
		String result ="1";

		ArrayList<String> values = new ArrayList<String>();

		values.add("20^+1^.01");
		values.add("200");
		values.add("20^+1^.02");
		values.add(".01");
		values.add("20^+1^.03");
		values.add(".5");
		
		dieKeyValRequest.setValues(values);
		 
		// Execute request against mocked object backend.
		dieKeyValResponse = service.keyVal(dieKeyValRequest);

		assertNotNull(dieKeyValResponse);
		assertEquals(result, dieKeyValResponse.getDataList().get(0));
	}

}
