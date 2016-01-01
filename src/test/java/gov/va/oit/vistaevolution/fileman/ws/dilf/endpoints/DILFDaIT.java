package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFDaEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFDaResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for DA method of DILF Webservice
 */
public class DILFDaIT extends EvolutionIT<DILFDaEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DILFDaIT.class);

	private DILFDaRequest request;
	private DILFDaResponse response;

	@Override
	protected Class<DILFDaEndpoint> getType() {
		return DILFDaEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DILFDaRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DILFDaIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Pass in IENS, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="5,51,1," 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=5
	 * MYDA(1)=51
	 * MYDA(2)=1
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("5");
		results.add("51");
		results.add("1");

		request.setIens("5,51,1,");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Pass in null, display no output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="" 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setIens("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Pass in IENS without an ending comma, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="5,51,1" 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=5
	 * MYDA(1)=51
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("5");
		results.add("51");

		request.setIens("5,51,1");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());
	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Pass in IENS with a leading comma, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS=",51,1," 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=””
	 * MYDA(1)=51
	 * MYDA(2)=1
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("51");
		results.add("1");

		request.setIens(",51,1,");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Pass in a letter with no commas, display null in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="A" 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setIens("A");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Pass in a letter with a comma, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="A," 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=”A”
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("A");

		request.setIens("A,");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Pass in IENS with no commas, display null in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS="9999" 
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setIens("9999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Pass in all commas, display output in MYDA array
	 * 
	 * <pre>
	 * >K MYDA
	 * >S IENS=",,,"
	 * >D DAR^DDR5(.MYDA,IENS) 
	 * >ZW MYDA
	 * MYDA=””
	 * MYDA(1)=””
	 * MYDA(2)=””
	 * 
	 * </pre>
	 * 
	 * @throws VistaWebServiceFault
	 */
	@Test
	public void testDa008() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("");
		results.add("");
		results.add("");

		request.setIens(",,,");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.da(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getDa());

	}

}
