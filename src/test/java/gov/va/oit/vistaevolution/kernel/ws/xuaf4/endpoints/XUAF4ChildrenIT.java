/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4ChildrenEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenResponse;
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
 *         Integration Test for CHILDREN method of XUAF4 Webservice
 * 
 */
public class XUAF4ChildrenIT extends EvolutionIT<XUAF4ChildrenEndpoint> {

	private static final Logger LOGGER = Logger
			.getLogger(XUAF4ChildrenIT.class);

	private XUAF4ChildrenRequest request;
	private XUAF4ChildrenResponse response;

	@Override
	protected Class<XUAF4ChildrenEndpoint> getType() {
		return XUAF4ChildrenEndpoint.class;
	}

	@Before
	public void setup() {
		request = new XUAF4ChildrenRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public XUAF4ChildrenIT() {
		super();
	}

	/**
	 * <em>Test Case #1  </em>
	 * 
	 * Return the Children of the LOCAL Parent (VISN) IEN value of 588 from our
	 * test record. Use the "`" concatenated to the IEN value ("`588"). For the
	 * RPC, the Associated IEN defaults to null (“VISN”) and the Flag defaults
	 * to null (“Do not check for Inactive Status”). Return the Children
	 * Institution data. Note the IEN values of the testing output that we
	 * listed in Example 1 above will be the same IEN values as the following
	 * output data.
	 * 
	 * <pre>
	 * Input Data:
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="`588"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN("C",392)="ZZ673p^"
	 * RETURN("C",468)="WEST PALM BEACH VAMC^548"
	 * RETURN("C",486)="SAN JUAN VAMC^672"
	 * RETURN("C",516)="BAY PINES VA HCS^516"
	 * RETURN("C",546)="MIAMI VAMC^546"
	 * RETURN("C",573)="N. FLORIDA/S. GEORGIA VHS^573"
	 * RETURN("C",673)="TAMPA VAMC^673"
	 * RETURN("C",6469)="BAY PINES DOMICILIARY^516BU"
	 * RETURN("C",6471)="FT MYERS VA OUTPATIENT CLINIC^516BZ"
	 * RETURN("C",6476)="SARASOTA COUNTY CBOC^516GA"
	 * RETURN("C",6477)="SOUTH ST. PETERSBURG CBOC^516GB"
	 * RETURN("C",6478)="N PINELLAS COUNTY CBOC^516GC"
	 * RETURN("C",6479)="MANATEE COUNTY CBOC^516GD"
	 * RETURN("C",6481)="COLLIER COUNTY CBOC^516GF"
	 * RETURN("C",6482)="BAY PINES-PRRTP^516PA"
	 * RETURN("C",6713)="MIAMI (NHCU)^5469AA"
	 * RETURN("C",6714)="MIAMI (OCS)^546B0"
	 * RETURN("C",6716)="BROWARD COUNTY VA OPC^546BZ"
	 * RETURN("C",6718)="MIAMI (ALCOHOL/DRUG)^546GA"
	 * RETURN("C",6719)="KEY WEST CBOC^546GB"
	 * RETURN("C",6720)="HOMESTEAD CBOC^546GC"
	 * RETURN("C",6721)="PEMBROKE PINES CBOC^546GD"
	 * RETURN("C",6722)="KEY LARGO CBOC^546GE"
	 * RETURN("C",6723)="HOLLYWOOD CBOC^546GF"
	 * RETURN("C",6724)="CORAL SPRINGS CBOC^546GG"
	 * RETURN("C",6725)="DEERFIELD BEACH CBOC^546GH"
	 * RETURN("C",6726)="MIA-PRRTP^546PA"
	 * RETURN("C",6727)="FT. PIERCE CBOC^548GA"
	 * RETURN("C",6728)="DELRAY BEACH CBOC^548GB"
	 * RETURN("C",6729)="STUART CBOC^548GC"
	 * RETURN("C",6730)="BOCA RATON CBOC^548GD"
	 * RETURN("C",6879)="GAINESVILLE (NHCU)^5739AA"
	 * RETURN("C",6880)="LAKE CITY NHC^5739B"
	 * RETURN("C",6881)="LAKE CITY^573A4"
	 * RETURN("C",6882)="JACKSONVILLE, FL OPC^573BY"
	 * RETURN("C",6883)="DAYTONA BEACH OPC^573BZ"
	 * RETURN("C",6884)="DAYTONA VETERANS NURSING HOME^573DT"
	 * RETURN("C",6885)="LAKE CITY STATE HOME^573DU"
	 * RETURN("C",6886)="VALDOSTA^573GA"
	 * RETURN("C",6887)="JACKSONVILLE, FL CBOC^573GB"
	 * RETURN("C",6889)="OCALA^573GD"
	 * RETURN("C",6890)="ST. AUGUSTINE^573GE"
	 * RETURN("C",6891)="TALLAHASSEE^573GF"
	 * RETURN("C",6892)="LECANTO CBOC^573GG"
	 * RETURN("C",6893)="LEESBURG CBOC^573GH"
	 * RETURN("C",6894)="GAINESVILLE (PRRTP)^573PA"
	 * RETURN("C",7588)="PONCE^672B0"
	 * RETURN("C",7589)="MAYAGUEZ^672BZ"
	 * RETURN("C",7590)="SAN JUAN^672CT"
	 * RETURN("C",7591)="ST. CROIX^672GA"
	 * RETURN("C",7592)="ST. THOMAS^672GB"
	 * RETURN("C",7593)="ARECIBO^672GC"
	 * RETURN("C",7594)="TAMPA NHCU^6739AA"
	 * RETURN("C",7595)="ORLANDO OPC^673BY"
	 * RETURN("C",7596)="PASCO OPC^673BZ"
	 * RETURN("C",7597)="VIERA OPC^673GA"
	 * RETURN("C",7598)="LAKELAND CBOC^673GB"
	 * RETURN("C",7599)="BROOKSVILLE CBOC^673GC"
	 * RETURN("C",7600)="SANFORD CBOC^673GD"
	 * RETURN("C",7601)="KISSIMMEE CBOC^673GE"
	 * RETURN("C",7602)="ZEPHYRHILLS CBOC^673GF"
	 * RETURN("C",7804)="VERO BEACH CBOC^548GE"
	 * RETURN("C",7805)="OKEECHOBEE CBOC^548GF"
	 * RETURN("C",7829)="ORLANDO NHCU^6739AB"
	 * RETURN("C",7830)="ORLANDO DOMICILIARY^673BU"
	 * RETURN("C",7855)="HIGHLANDS COUNTY CBOC^516GH"
	 * RETURN("C",7921)="GUAYAMA CBOC^672GE"
	 * RETURN("C",10879)="VILLAGES CBOC^573GI"
	 * RETURN("C",10886)="DOUGLAS JACOBSON SVH^516DT"
	 * RETURN("C",10909)="JUANA DIAZ SVH^672DT"
	 * RETURN("C",10923)="ORLANDO VAMC (EFF. 10/1/06)^675"
	 * RETURN("C",10925)="ORLANDO VA DOM (EFF. 10/1/06)^675BU"
	 * RETURN("C",10926)="DAYTONA BEACH OPC (10/1/06)^675GB"
	 * RETURN("C",10927)="KISSIMMEE CBOC (EFF. 10/1/06)^675GC"
	 * RETURN("C",10928)="SANFORD CBOC (EFF. 10/1/06)^675GD"
	 * RETURN("C",10941)="MIAMI SPINAL CORD OUTCOMES^546SCI"
	 * RETURN("C",10947)="SAN JUAN SPINAL CORD OUTCOMES^672SCI"
	 * RETURN("C",10950)="TAMPA SPINAL CORD OUTCOMES^673SCI"
	 * RETURN("C",11209)="LEESBURG CBOC (EFF. 10/1/06)^675GE"
	 * RETURN("C",11544)="ST MARYS CBOC^573GJ"
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ZZ673p^");
		results.add("WEST PALM BEACH VAMC^548");
		results.add("SAN JUAN VAMC^672");
		results.add("BAY PINES VA HCS^516");
		results.add("MIAMI VAMC^546");

		request.setParent("`588");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #2  </em>
	 * 
	 * Set the LOCAL Parent (VISN) IEN to a value of “588” from our test example
	 * 1 above. Do Not use the tick mark "`". Nothing returned.
	 * 
	 * <pre>
	 * 			Input Data:
	 * >K RETURN        Clear result array of leftover data 
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="588"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setParent("588");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #3  </em>
	 * 
	 * Set the LOCAL Parent (VISN) IEN to a bogus value of 999999. Use the "`"
	 * concatenated to the IEN value ("`999999"). Set the Associated IEN value
	 * to 1. Nothing returned.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN 
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="`999999"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setParent("`999999");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #4  </em>
	 * 
	 * Set the LOCAL Parent (VISN) IEN to a bogus value of “ABCDEF”. Nothing
	 * returned.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN 
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="ABCDEF"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setParent("ABCDEF");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #5  </em>
	 * 
	 * Return the Children of the National Parent (VISN) IEN value of 638 from
	 * our test record used in Example 2 above. Use the "`" concatenated to the
	 * IEN value ("`638"). Return the Children Institution data. Note the IEN
	 * values of the testing output that we listed in Example 2 above will be
	 * the same IEN values as the following output data.
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN 
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="`638"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN("C",358)="MANILA-RO^358"
	 * RETURN("C",359)="VA PACIFIC ISLANDS HCS^459"
	 * RETURN("C",430)="GUAM CLINIC^459GE"
	 * RETURN("C",473)="NORTHERN CALIFORNIA HCS^612"
	 * RETURN("C",570)="CENTRAL CALIFORNIA HCS^570"
	 * RETURN("C",640)="PALO ALTO HCS^640"
	 * RETURN("C",654)="SIERRA NEVADA HCS^654"
	 * RETURN("C",662)="SAN FRANCISCO VAMC^662"
	 * RETURN("C",6325)="HONOLULU PRRP^459A4"
	 * RETURN("C",6326)="TRIPLER ARMY MEDICAL CENTER^459CN"
	 * RETURN("C",6327)="MAUI CLINIC^459GA"
	 * RETURN("C",6328)="HILO CLINIC^459GB"
	 * RETURN("C",6329)="KONA CLINIC^459GC"
	 * RETURN("C",6330)="KAUAI CLINIC^459GD"
	 * RETURN("C",6334)="HILO, HI (PRRTP)^459PA"
	 * RETURN("C",6874)="FRESNO NHC^5709AA"
	 * RETURN("C",6875)="ATWATER CBOC^570GA"
	 * RETURN("C",6876)="TULARE CBOC^570GB"
	 * RETURN("C",7120)="SACRAMENTO VAMC^612A4"
	 * RETURN("C",7121)="MARTINEZ SOC^"
	 * RETURN("C",7122)="REDDING^612B4"
	 * RETURN("C",7123)="OAKLAND^612BY"
	 * RETURN("C",7129)="FAIRFIELD^612GD"
	 * RETURN("C",7130)="MARE ISLAND^612GE"
	 * RETURN("C",7131)="MARTINEZ OPC/CREC^612GF"
	 * RETURN("C",7132)="CHICO^612GG"
	 * RETURN("C",7133)="MCCLELLAN^612GH"
	 * RETURN("C",7335)="PALO ALTO NHC^6409AA"
	 * RETURN("C",7336)="LIVERMORE NHC^6409AB"
	 * RETURN("C",7337)="MENLO PARK^640A0"
	 * RETURN("C",7338)="LIVERMORE VAMC^640A4"
	 * RETURN("C",7339)="PALO ALTO DOM^640BU"
	 * RETURN("C",7340)="SAN JOSE^640BY"
	 * RETURN("C",7341)="CAPITOLA^640GA"
	 * RETURN("C",7342)="SONORA^640GB"
	 * RETURN("C",7343)="STOCKTON^640HA"
	 * RETURN("C",7344)="MODESTO^640HB"
	 * RETURN("C",7345)="MONTEREY^640HC"
	 * RETURN("C",7414)="AUBURN CBOC^654GA"
	 * RETURN("C",7415)="MINDEN OPC^654GB"
	 * RETURN("C",7498)="SAN FRAN NHC^6629AA"
	 * RETURN("C",7499)="SAN FRAN STNB^6629AF"
	 * RETURN("C",7501)="SAN FRAN PHS^662C5"
	 * RETURN("C",7502)="SAN FRAN USAH^662CN"
	 * RETURN("C",7503)="SAN FRAN USNH^662CT"
	 * RETURN("C",7504)="SAN FRAN USAF^662CZ"
	 * RETURN("C",7505)="YOUNTVILLE STNB^662DT"
	 * RETURN("C",7506)="SANTA ROSA, CA CBOC ^662GA"
	 * RETURN("C",7507)="VALLEJO CBOC^662GB"
	 * RETURN("C",7508)="EUREKA CBOC^662GC"
	 * RETURN("C",7509)="UKIAH CBOC^662GD"
	 * RETURN("C",7510)="YOUNTVILLE ORC^662HA"
	 * RETURN("C",7511)="SAN FRAN PRRTP^662PA"
	 * RETURN("C",7854)="US NAVAL HOSPITAL GUAM^459CT"
	 * RETURN("C",7881)="MPD-PRRTP^640PB"
	 * RETURN("C",7884)="PAD-PRRTP^640PA"
	 * RETURN("C",7918)="MENLO PARK VA NHC^6409AC"
	 * RETURN("C",10890)="SAN BRUNO CBOC^662GE"
	 * RETURN("C",10943)="PALO ALTO SPINAL CORD OUTCOMES^640SCI"
	 * RETURN("C",11198)="VA LAHONTAN VALLEY CBOC^654GC"
	 * RETURN("C",11278)="MENLO PARK PHARMACY^"
	 * RETURN("C",11396)="LIVERMORE PHARMACY^"
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("MANILA-RO^358");
		results.add("VA PACIFIC ISLANDS HCS^459");
		results.add("GUAM CLINIC^459GE");
		results.add("NORTHERN CALIFORNIA HCS^612");
		results.add("CENTRAL CALIFORNIA HCS^570");

		request.setParent("`638");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #6  </em>
	 * 
	 * Return the Children of the National Parent (VISN) Name (“VISN 21”) from
	 * our test record used in Example 2 above. Return the Children Institution
	 * data. Note the IEN values of the testing output that we listed in Example
	 * 2 above will be the same IEN values as the following output data.
	 * 
	 * <pre>
	 * 		Input Data:
	 * >K RETURN
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="VISN 21"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN("C",358)="MANILA-RO^358"
	 * RETURN("C",359)="VA PACIFIC ISLANDS HCS^459"
	 * RETURN("C",430)="GUAM CLINIC^459GE"
	 * RETURN("C",473)="NORTHERN CALIFORNIA HCS^612"
	 * RETURN("C",570)="CENTRAL CALIFORNIA HCS^570"
	 * RETURN("C",640)="PALO ALTO HCS^640"
	 * RETURN("C",654)="SIERRA NEVADA HCS^654"
	 * RETURN("C",662)="SAN FRANCISCO VAMC^662"
	 * RETURN("C",6325)="HONOLULU PRRP^459A4"
	 * RETURN("C",6326)="TRIPLER ARMY MEDICAL CENTER^459CN"
	 * RETURN("C",6327)="MAUI CLINIC^459GA"
	 * RETURN("C",6328)="HILO CLINIC^459GB"
	 * RETURN("C",6329)="KONA CLINIC^459GC"
	 * RETURN("C",6330)="KAUAI CLINIC^459GD"
	 * RETURN("C",6334)="HILO, HI (PRRTP)^459PA"
	 * RETURN("C",6874)="FRESNO NHC^5709AA"
	 * RETURN("C",6875)="ATWATER CBOC^570GA"
	 * RETURN("C",6876)="TULARE CBOC^570GB"
	 * RETURN("C",7120)="SACRAMENTO VAMC^612A4"
	 * RETURN("C",7121)="MARTINEZ SOC^"
	 * RETURN("C",7122)="REDDING^612B4"
	 * RETURN("C",7123)="OAKLAND^612BY"
	 * RETURN("C",7129)="FAIRFIELD^612GD"
	 * RETURN("C",7130)="MARE ISLAND^612GE"
	 * RETURN("C",7131)="MARTINEZ OPC/CREC^612GF"
	 * RETURN("C",7132)="CHICO^612GG"
	 * RETURN("C",7133)="MCCLELLAN^612GH"
	 * RETURN("C",7335)="PALO ALTO NHC^6409AA"
	 * RETURN("C",7336)="LIVERMORE NHC^6409AB"
	 * RETURN("C",7337)="MENLO PARK^640A0"
	 * RETURN("C",7338)="LIVERMORE VAMC^640A4"
	 * RETURN("C",7339)="PALO ALTO DOM^640BU"
	 * RETURN("C",7340)="SAN JOSE^640BY"
	 * RETURN("C",7341)="CAPITOLA^640GA"
	 * RETURN("C",7342)="SONORA^640GB"
	 * RETURN("C",7343)="STOCKTON^640HA"
	 * RETURN("C",7344)="MODESTO^640HB"
	 * RETURN("C",7345)="MONTEREY^640HC"
	 * RETURN("C",7414)="AUBURN CBOC^654GA"
	 * RETURN("C",7415)="MINDEN OPC^654GB"
	 * RETURN("C",7498)="SAN FRAN NHC^6629AA"
	 * RETURN("C",7499)="SAN FRAN STNB^6629AF"
	 * RETURN("C",7501)="SAN FRAN PHS^662C5"
	 * RETURN("C",7502)="SAN FRAN USAH^662CN"
	 * RETURN("C",7503)="SAN FRAN USNH^662CT"
	 * RETURN("C",7504)="SAN FRAN USAF^662CZ"
	 * RETURN("C",7505)="YOUNTVILLE STNB^662DT"
	 * RETURN("C",7506)="SANTA ROSA, CA CBOC ^662GA"
	 * RETURN("C",7507)="VALLEJO CBOC^662GB"
	 * RETURN("C",7508)="EUREKA CBOC^662GC"
	 * RETURN("C",7509)="UKIAH CBOC^662GD"
	 * RETURN("C",7510)="YOUNTVILLE ORC^662HA"
	 * RETURN("C",7511)="SAN FRAN PRRTP^662PA"
	 * RETURN("C",7854)="US NAVAL HOSPITAL GUAM^459CT"
	 * RETURN("C",7881)="MPD-PRRTP^640PB"
	 * RETURN("C",7884)="PAD-PRRTP^640PA"
	 * RETURN("C",7918)="MENLO PARK VA NHC^6409AC"
	 * RETURN("C",10890)="SAN BRUNO CBOC^662GE"
	 * RETURN("C",10943)="PALO ALTO SPINAL CORD OUTCOMES^640SCI"
	 * RETURN("C",11198)="VA LAHONTAN VALLEY CBOC^654GC"
	 * RETURN("C",11278)="MENLO PARK PHARMACY^"
	 * RETURN("C",11396)="LIVERMORE PHARMACY^"
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("MANILA-RO^358");
		results.add("VA PACIFIC ISLANDS HCS^459");
		results.add("GUAM CLINIC^459GE");
		results.add("NORTHERN CALIFORNIA HCS^612");
		results.add("CENTRAL CALIFORNIA HCS^570");

		request.setParent("VISN 21");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #7  </em>
	 * 
	 * Set the National Parent (VISN) IEN to a value of “638” from our test
	 * example 2 above. Do Not use the tick mark "`". Nothing returned.
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN
	 * >S ROOT=$NA(RETURN)
	 * >S PAR="638"
	 * 
	 * Procedure Call:
	 * >D CHILDR^XUSOAR(ROOT,PAR)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * 
	 * </pre>
	 */
	@Ignore
	@Test
	public void testChildren007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		request.setParent("638");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.children(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());
	}
}
