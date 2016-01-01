/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.XUAF4ResponseFactory;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.XUAF4ChildrenEndpointImpl;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.endpoints.interfaces.XUAF4ChildrenEndpoint;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenRequest;
import gov.va.oit.vistaevolution.kernel.ws.xuaf4.model.XUAF4ChildrenResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 * 
 *         Unit Test for CHILDREN method of XUAF4 Webservice
 */
public class XUAF4ChildrenTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public XUAF4ChildrenTest() {
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
	@Test
	public void testChildren001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("ZZ673p^");
		results.add("WEST PALM BEACH VAMC^548");
		results.add("SAN JUAN VAMC^672");
		results.add("BAY PINES VA HCS^516");
		results.add("MIAMI VAMC^546");

		String expectedOutput = "ZZ673p^\n" + "WEST PALM BEACH VAMC^548\n"
				+ "SAN JUAN VAMC^672\n" + "BAY PINES VA HCS^516\n"
				+ "MIAMI VAMC^546\n";

		XUAF4ChildrenRequest request = new XUAF4ChildrenRequest();
		request.setParent("`588");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4ChildrenEndpoint service = new XUAF4ChildrenEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4ChildrenResponse response = service.children(request);

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
	@Test
	public void testChildren002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();

		String expectedOutput = "";

		XUAF4ChildrenRequest request = new XUAF4ChildrenRequest();
		request.setParent("588");

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		XUAF4ChildrenEndpoint service = new XUAF4ChildrenEndpointImpl(
				new XUAF4ResponseFactory(), getVistaLinkContext());

		XUAF4ChildrenResponse response = service.children(request);

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

}
