/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.endpoints.interfaces.XMXUTIL1ZonediffEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model.XMXUTIL1ZonediffResponse;
import gov.va.oit.vistaevolution.util.VistaConstants;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for ZONEDIFF method of XMXUTIL1 Webservice
 */
public class XMXUTIL1ZonediffIT extends EvolutionIT<XMXUTIL1ZonediffEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XMXUTIL1ZonediffIT.class);

	private XMXUTIL1ZonediffRequest request;
	private XMXUTIL1ZonediffResponse response;

	@Override
	protected Class<XMXUTIL1ZonediffEndpoint> getType() {
		return XMXUTIL1ZonediffEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XMXUTIL1ZonediffRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Get the difference between local time and a three-character time zone.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”EST”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=1"
	 * RETURN(2)="XMMM=0"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=1");
		results.add("XMMM=0");

		request.setXmyt("EST");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Get the difference between local time and a different three-character
	 * time zone.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”PDT”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=3"
	 * RETURN(2)="XMMM=0"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=3");
		results.add("XMMM=0");

		request.setXmyt("PDT");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Get the difference between local time and a positive numeric time zone
	 * (GMT+3).
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”0300”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=-7"
	 * RETURN(2)="XMMM=0"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=-7");
		results.add("XMMM=0");

		request.setXmyt("0300");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Get the difference between local time and a numeric time zone with
	 * minutes (GMT-2.5).
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”-0230”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=-2"
	 * RETURN(2)="XMMM=30"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=-2");
		results.add("XMMM=30");

		request.setXmyt("-0230");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Get the difference between local time and a negative numeric time zone
	 * (GMT-5).
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”-0500”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=1"
	 * RETURN(2)="XMMM=0"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=1");
		results.add("XMMM=0");

		request.setXmyt("-0500");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Get the difference between local time and a three-character time zone
	 * that involves minutes.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”NDT”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="XMHH=-2"
	 * RETURN(2)="XMMM=30"
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("XMHH=-2");
		results.add("XMMM=30");

		request.setXmyt("NDT");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getHmList().size());

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Try to call the API with a null time zone.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=””
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(0)="-1^Error in required input"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testZonediff007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("Error in required input");

		request.setXmyt("");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.zonediff(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getErrors().get(0));

	}

	/**
	 * <em>Test Case #8  </em>
	 * 
	 * Try to call the API with a non-existent time zone. An error occurs. This
	 * is because the routine should be checking if the variable’s defined
	 * status is 0, not null.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S XMYT=”ZZZ”
	 * 
	 * Procedure Call:
	 * >D ZONEDIFF^XMWSOA05(.RETURN,XMYT)
	 * 
	 * Expected Output:
	 * 
	 *  I $D(XMHH)’=”” S RETURN(1)=”XMHH=”_XMHH
	 * 
	 * <UNDEFINED>ZONEDIFF+5^XMWSOA05 *XMHH
	 * 2d1>
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testZonediff008() throws VistaWebServiceFault {
		try {

			request.setXmyt("ZZZ");
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("request= " + request);
			}
			service.zonediff(request);
		} catch (Exception e) {
			LOGGER.debug(VistaConstants.ERR_MSG_ABNORMAL);
		}

	}

}
