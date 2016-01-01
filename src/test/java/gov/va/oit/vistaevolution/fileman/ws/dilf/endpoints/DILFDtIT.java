package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDtEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDtResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for DT method of DILF Webservice
 */
public class DILFDtIT extends EvolutionIT<DILFDtEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFDtIT.class);

	private DILFDtRequest request;
	private DILFDtResponse response;

	@Override
	protected Class<DILFDtEndpoint> getType() {
		return DILFDtEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DILFDtRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DILFDtIT() {
		super();
	}

	/**
	 * <em>Test Case 1</em>
	 * 
	 * Show Internal and External formats for current date.
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”NOW”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140130
	 * DDRDATA(0)="JAN 30, 2014"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140130");
		results.add("JAN 30, 2014");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("NOW");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 2</em>
	 * 
	 * Show Internal and External formats one week from current date.
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”T+7”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * 
	 * DDRDATA=3140206
	 * DDRDATA(0)="FEB 06, 2014"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140206");
		results.add("FEB 06, 2014");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("T+7");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 3</em>
	 * 
	 * Show Internal and External formats for current date and time.
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ET”
	 * >S DDR(“IN_DATE”)=”NOW”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140130.1206
	 * DDRDATA(0)="JAN 30, 2014@12:06"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140130.1206");
		results.add("JAN 30, 2014@12:06");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("T");
		request.setFlags(flags);
		request.setInDate("NOW");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 4</em>
	 * 
	 * Show Internal and External formats for current date and time, including
	 * seconds.
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ETS”
	 * >S DDR(“IN_DATE”)=”NOW”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140130.120713
	 * DDRDATA(0)="JAN 30, 2014@12:07:13"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140130.120713");
		results.add("JAN 30, 2014@12:07:13");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("T");
		flags.add("S");
		request.setFlags(flags);
		request.setInDate("NOW");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 5</em>
	 * 
	 * Show Internal format for current date and time, including seconds.
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ST”
	 * >S DDR(“IN_DATE”)=”NOW”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140130.121613
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140130.121613");

		List<String> flags = new ArrayList<String>();
		flags.add("S");
		flags.add("T");
		request.setFlags(flags);
		request.setInDate("NOW");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 6</em>
	 * 
	 * Show Internal format for current date and time; generate error msg 330
	 * for invalid input.
	 * 
	 * <pre>
	 * 	>K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ST”
	 * >S DDR(“IN_DATE”)=”$H”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="$H"
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value '$H' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("$H");
		results.add("date/time");
		results.add("The value '$H' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("S");
		flags.add("T");
		request.setFlags(flags);
		request.setInDate("$H");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case7</em>
	 * 
	 * ‘N’ flag with numeric input
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”EN”
	 * >S DDR(“IN_DATE”)=3131202
	 * >S DDR(“LIMIT”)=””
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)=3131202
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value '3131202' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("3131202");
		results.add("date/time");
		results.add("The value '3131202' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("N");
		request.setFlags(flags);
		request.setInDate("3131202");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 8</em>
	 * 
	 * ‘R’ flag without time input
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”ER”
	 * >S DDR(“IN_DATE”)=3131202
	 * >S DDR(“LIMIT”)=””
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)=3131202
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value '3131202' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt008() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("3131202");
		results.add("date/time");
		results.add("The value '3131202' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("R");
		request.setFlags(flags);
		request.setInDate("3131202");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 9</em>
	 * 
	 * ‘P’ flag to assume Past Date
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”EP”
	 * >S DDR(“IN_DATE”)=”FEB 02”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3130202
	 * DDRDATA(0)="FEB 02, 2013"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt009() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3130202");
		results.add("FEB 02, 2013");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("P");
		request.setFlags(flags);
		request.setInDate("FEB 02");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 10</em>
	 * 
	 * ‘F’ flag to assume Future Date
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”EF”
	 * >S DDR(“IN_DATE”)=”FEB 02”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=3140202
	 * DDRDATA(0)="FEB 02, 2014"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt0010() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3140202");
		results.add("FEB 02, 2014");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("F");
		request.setFlags(flags);
		request.setInDate("FEB 02");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 11</em>
	 * 
	 * Convert non-standard external format to standard date format
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”2-DEC-2013”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DRDATA=3131202
	 * DDRDATA(0)="DEC 02, 2013"
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDt0011() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("3131202");
		results.add("DEC 02, 2013");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("2-DEC-2013");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 12</em>
	 * 
	 * ‘X’ flag without exact date
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”EX”
	 * >S DDR(“IN_DATE”)=”FEB 2014”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="FEB 2014"
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value 'FEB 2014' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt0012() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("FEB 2014");
		results.add("date/time");
		results.add("The value 'FEB 2014' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		flags.add("X");
		request.setFlags(flags);
		request.setInDate("FEB 2014");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 13</em>
	 * 
	 * Request help text
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”?”
	 * >S DDR(“LIMIT”)=””
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIHELP")=7
	 * DDRDATA("ERROR","DIHELP",1)="Examples of Valid Dates:"
	 * DDRDATA("ERROR","DIHELP",2)="   JAN 20 1957 or 20 JAN 57 or 1/20/57 or 012057"
	 * DDRDATA("ERROR","DIHELP",3)="   T   (for TODAY),  T+1 (for TOMORROW),  T+2,  T+7, etc."
	 * DDRDATA("ERROR","DIHELP",4)="   T-1 (for YESTERDAY),  T-3W (for 3 WEEKS AGO), etc."
	 * DDRDATA("ERROR","DIHELP",5)="If the year is omitted, the computer uses CURRENT YEAR.  Two digit year"
	 * DDRDATA("ERROR","DIHELP",6)="  assumes no more than 20 years in the future, or 80 years in the past."
	 * DDRDATA("ERROR","DIHELP",7)="You may omit the precise day, as:  JAN, 1957."
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt0013() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("7");
		results.add("Examples of Valid Dates:");
		results.add("   JAN 20 1957 or 20 JAN 57 or 1/20/57 or 012057");
		results.add("   T   (for TODAY),  T+1 (for TOMORROW),  T+2,  T+7, etc.");
		results.add("   T-1 (for YESTERDAY),  T-3W (for 3 WEEKS AGO), etc.");
		results.add("If the year is omitted, the computer uses CURRENT YEAR.  Two digit year");
		results.add("  assumes no more than 20 years in the future, or 80 years in the past.");
		results.add("You may omit the precise day, as:  JAN, 1957.");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("?");
		request.setLimit("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 14</em>
	 * 
	 * Limit input to greater than or equal to a certain date
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”DEC 04, 2013”
	 * >S DDR(“LIMIT”)=3140101
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="DEC 04, 2013"
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value 'DEC 04,2013' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt0014() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("DEC 04, 2013");
		results.add("date/time");
		results.add("The value 'DEC 04,2013' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("DEC 04, 2013");
		request.setLimit("3140101");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case 15</em>
	 * 
	 * Limit input to less than or equal to a certain date
	 * 
	 * <pre>
	 * >K DDRDATA,DDR
	 * >S DDR(“FLAGS”)=”E”
	 * >S DDR(“IN_DATE”)=”JAN 04, 2014”
	 * >S DDR(“LIMIT”)=-3140101
	 * 
	 * >D DTR^DDR5(.DDRDATA,.DDR)
	 * 
	 * >ZW DDRDATA
	 * DDRDATA=-1
	 * DDRDATA("ERROR","DIERR")="1^1"
	 * DDRDATA("ERROR","DIERR",1)=330
	 * DDRDATA("ERROR","DIERR",1,"PARAM",0)=2
	 * DDRDATA("ERROR","DIERR",1,"PARAM",1)="JAN 04, 2014"
	 * DDRDATA("ERROR","DIERR",1,"PARAM",2)="date/time"
	 * DDRDATA("ERROR","DIERR",1,"TEXT",1)="The value 'JAN 04,2014' is not a valid date/time."
	 * DDRDATA("ERROR","DIERR","E",330,1)=""
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Ignore
	@Test
	public void testDt0015() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("-1");
		results.add("1^1");
		results.add("330");
		results.add("2");
		results.add("JAN 04, 2014");
		results.add("date/time");
		results.add("The value 'JAN 04,2014' is not a valid date/time.");
		results.add("");

		List<String> flags = new ArrayList<String>();
		flags.add("E");
		request.setFlags(flags);
		request.setInDate("JAN 04, 2014");
		request.setLimit("-3140101");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.dt(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}
}
