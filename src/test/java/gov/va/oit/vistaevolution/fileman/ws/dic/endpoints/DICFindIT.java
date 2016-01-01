package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICFindEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Integration Test for FIND function of DIC Webservice
 */
public class DICFindIT extends EvolutionIT<DICFindEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DICFindIT.class);

	private DICFindRequest request;
	private DICFindResponse response;

	@Override
	protected Class<DICFindEndpoint> getType() {
		return DICFindEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DICFindRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DICFindIT() {
		super();
	}

	/**
	 * <em>Test Case #1   </em>
	 * 
	 * Retrieve all entries from File #.84beginning with "2". The RPC stores
	 * results in the global ^TMP("DILIST",$J), which is referenced in the
	 * return value DDRDATA. The RPC only shows the IENs in the output.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="2",DDR("MAX")="",DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA
	 * ^TMP("DILIST",544023840,.5)="[BEGIN_diDATA]"		(Note:  This subscript is the job number; it will be different for every session.)
	 * ^TMP("DILIST",544023840,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544023840,2,1)=200
	 * ^TMP("DILIST",544023840,2,2)=201
	 * ^TMP("DILIST",544023840,2,3)=202
	 * ^TMP("DILIST",544023840,2,4)=203
	 * ^TMP("DILIST",544023840,2,5)=204
	 * ^TMP("DILIST",544023840,2,6)=205
	 * ^TMP("DILIST",544023840,2,7)=206
	 * ^TMP("DILIST",544023840,2,8)=207
	 * ^TMP("DILIST",544023840,2,9)=208
	 * ^TMP("DILIST",544023840,2,10)=209
	 * ^TMP("DILIST",544023840,2,11)=299
	 * ^TMP("DILIST",544023840,2,12)=20001
	 * ^TMP("DILIST",544023840,2,13)=261101
	 * ^TMP("DILIST",544023840,2,14)=261102
	 * ^TMP("DILIST",544023840,2,15)=261103
	 * ^TMP("DILIST",544023840,2,16)=261104
	 * ^TMP("DILIST",544023840,2,17)=261105
	 * ^TMP("DILIST",544023840,2,18)=261106
	 * ^TMP("DILIST",544023840,2,19)=261107
	 * ^TMP("DILIST",544023840,2,20)=261108
	 * ^TMP("DILIST",544023840,2,21)=261109
	 * ^TMP("DILIST",544023840,2,22)=261110
	 * ^TMP("DILIST",544023840,2,23)=261111
	 * ^TMP("DILIST",544023840,2,24)=261112
	 * ^TMP("DILIST",544023840,2,25)=261113
	 * ^TMP("DILIST",544023840,2,26)=261114
	 * ^TMP("DILIST",544023840,2,27)=261115
	 * ^TMP("DILIST",544023840,2,28)=261116
	 * ^TMP("DILIST",544023840,2,29)=261117
	 * ^TMP("DILIST",544023840,2,30)=261118
	 * ^TMP("DILIST",544023840,2,31)=261119
	 * ^TMP("DILIST",544023840,2,32)=261120
	 * ^TMP("DILIST",544023840,2,33)=261121
	 * ^TMP("DILIST",544023840,2,34)=261122
	 * ^TMP("DILIST",544023840,2,35)=261123
	 * ^TMP("DILIST",544023840,2,36)=261124
	 * ^TMP("DILIST",544023840,2,37)=261125
	 * ^TMP("DILIST",544023840,2,38)=261126
	 * ^TMP("DILIST",544023840,2,39)=261127
	 * ^TMP("DILIST",544023840,2,40)=261128
	 * ^TMP("DILIST",544023840,2,41)=261129
	 * ^TMP("DILIST",544023840,2,42)=261130
	 * ^TMP("DILIST",544023840,2,43)=261131
	 * ^TMP("DILIST",544023840,2,44)=261132
	 * ^TMP("DILIST",544023840,2,45)=20050000.001
	 * ^TMP("DILIST",544023840,2,46)=20050000.002
	 * ^TMP("DILIST",544023840,2,47)=20050000.003
	 * ^TMP("DILIST",544023840,2,48)=20050000.004
	 * ^TMP("DILIST",544023840,2,49)=20050000.005
	 * ^TMP("DILIST",544023840,2,50)=20050000.006
	 * ^TMP("DILIST",544023840,2,51)=20050000.008
	 * ^TMP("DILIST",544023840,2,52)=20050000.009
	 * ^TMP("DILIST",544023840,2,53)=20050000.01
	 * ^TMP("DILIST",544023840,2,54)=20050000.011
	 * ^TMP("DILIST",544023840,2,55)=20050000.012
	 * ^TMP("DILIST",544023840,2,56)=20050000.013
	 * ^TMP("DILIST",544023840,2,57)=20050000.014
	 * ^TMP("DILIST",544023840,2,58)=20050000.015
	 * ^TMP("DILIST",544023840,2,59)=20050000.016
	 * ^TMP("DILIST",544023840,2,60)=20050000.017
	 * ^TMP("DILIST",544023840,2,61)=20050000.018
	 * ^TMP("DILIST",544023840,2,62)=20050000.019
	 * ^TMP("DILIST",544023840,2,63)=20050000.02
	 * ^TMP("DILIST",544023840,2,64)=20050000.021
	 * ^TMP("DILIST",544023840,2,65)=20050000.022
	 * ^TMP("DILIST",544023840,2,66)=20050000.023
	 * ^TMP("DILIST",544023840,2,67)=20050000.024
	 * ^TMP("DILIST",544023840,2,68)=20050000.025
	 * ^TMP("DILIST",544023840,2,69)=20050000.026
	 * ^TMP("DILIST",544023840,2,70)=20050000.027
	 * ^TMP("DILIST",544023840,2,71)=20050000.028
	 * ^TMP("DILIST",544023840,2,72)=20050000.029
	 * ^TMP("DILIST",544023840,2,73)=20050000.03
	 * ^TMP("DILIST",544023840,2,74)=20050000.031
	 * ^TMP("DILIST",544023840,2,75)=20050000.032
	 * ^TMP("DILIST",544023840,2,76)=20050000.033
	 * ^TMP("DILIST",544023840,2,77)=20050000.034
	 * ^TMP("DILIST",544023840,2,78)=20050000.035
	 * ^TMP("DILIST",544023840,2,79)=20050000.036
	 * ^TMP("DILIST",544023840,2,80)=20050000.037
	 * ^TMP("DILIST",544023840,2,81)=20050000.038
	 * ^TMP("DILIST",544023840,2,82)=20050000.039
	 * ^TMP("DILIST",544023840,2,83)=20050000.04
	 * ^TMP("DILIST",544023840,2,84)=20050000.041
	 * ^TMP("DILIST",544023840,2,85)=20050000.042
	 * ^TMP("DILIST",544023840,2,86)=20050000.043
	 * ^TMP("DILIST",544023840,2,87)=20050000.044
	 * ^TMP("DILIST",544023840,2,88)=20050000.045
	 * ^TMP("DILIST",544023840,2,89)=20050000.046
	 * ^TMP("DILIST",544023840,2,90)=20050000.047
	 * ^TMP("DILIST",544023840,2,91)=20050000.048
	 * ^TMP("DILIST",544023840,2,92)=20050000.049
	 * ^TMP("DILIST",544023840,2,93)=20050005.001
	 * ^TMP("DILIST",544023840,2,94)=20050005.002
	 * ^TMP("DILIST",544023840,2,95)=20050005.003
	 * ^TMP("DILIST",544023840,2,96)=20050005.004
	 * ^TMP("DILIST",544023840,2,97)=20050005.005
	 * ^TMP("DILIST",544023840,2,98)=20050005.006
	 * ^TMP("DILIST",544023840,2,99)=20050005.007
	 * ^TMP("DILIST",544023840,2,100)=20050005.008
	 * ^TMP("DILIST",544023840,2,101)=20050005.009
	 * ^TMP("DILIST",544023840,2,102)=20050005.01
	 * ^TMP("DILIST",544023840,2,103)=20050005.011
	 * ^TMP("DILIST",544023840,2,104)=20050005.012
	 * ^TMP("DILIST",544023840,2,105)=20050005.013
	 * ^TMP("DILIST",544023840,2,106)=20050005.014
	 * ^TMP("DILIST",544023840,2,107)="END_IENs"
	 * ^TMP("DILIST",544023840,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("200");
		results.add("201");
		results.add("202");
		results.add("203");
		results.add("204");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #2   </em>
	 * 
	 * Retrieve first five entries beginning with "2" by using the number
	 * parameter. The output will show the five IENs and indicate that more
	 * results exist.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="2",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA
	 * ^TMP("DILIST",544023840,.1)="[Misc]"
	 * ^TMP("DILIST",544023840,.2)="MORE"
	 * ^TMP("DILIST",544023840,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544023840,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544023840,2,1)=200
	 * ^TMP("DILIST",544023840,2,2)=201
	 * ^TMP("DILIST",544023840,2,3)=202
	 * ^TMP("DILIST",544023840,2,4)=203
	 * ^TMP("DILIST",544023840,2,5)=204
	 * ^TMP("DILIST",544023840,2,6)="END_IENs"
	 * ^TMP("DILIST",544023840,"IDZ")="[END_diDATA]"
	 * </pre>
	 */
	@Test
	public void testFind002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("200");
		results.add("201");
		results.add("202");
		results.add("203");
		results.add("204");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}

	/**
	 * <em>Test Case #3   </em>
	 * 
	 * Use a numeric search term with no flags. There are no entries in the
	 * DIALOG File (#.84) with a SHORT DESCRIPTION field (index "D") that begins
	 * with "42241".
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")=42241,DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,0)="0^5^0^"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("42241");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #4   </em>
	 * 
	 * Use a numeric search term with the "A" flag, allowing the entry with an
	 * IEN of 42241 to be found.
	 * 
	 * <pre>
	 * 
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="A",DDR("VALUE")=42241,DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544022402,2,1)=42241
	 * ^TMP("DILIST",544022402,2,2)="END_IENs"
	 * ^TMP("DILIST",544022402,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("42241");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("A");
		List<String> values = new ArrayList<String>();
		values.add("42241");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #5   </em>
	 * 
	 * Search starting with the "AC" (HELP FRAME) index. The HELP FRAME field
	 * points to the HELP FRAME file, which has a cross-reference "C" on the
	 * HEADER field. This search goes through all the indexes in the HELP FRAME
	 * file from "B" on in order to look for the value "THE", finding it in the
	 * HEADER field (not shown in output) of three different pointed-to records.
	 * 
	 * <pre>
	 * 
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=19,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="THE",DDR("MAX")=5,DDR("XREF")="AC",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543891114,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543891114,2,1)=9773
	 * ^TMP("DILIST",543891114,2,2)=3447
	 * ^TMP("DILIST",543891114,2,3)=3448
	 * ^TMP("DILIST",543891114,2,4)="END_IENs"
	 * ^TMP("DILIST",543891114,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("9773");
		results.add("3447");
		results.add("3448");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("THE");
		List<String> xref = new ArrayList<String>();
		xref.add("AC");
		request.setFile("19");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getOutputDataList().size());

	}

	/**
	 * <em>Test Case #6   </em>
	 * 
	 * The same search with the "B" flag added will go no deeper than the "B"
	 * index of the pointed-to HELP FRAME file, i.e., the index for the NAME
	 * field of the HELP FRAME file. No HELP FRAME records have a NAME beginning
	 * with "THE".
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=19,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="B",DDR("VALUE")="THE",DDR("MAX")=5,DDR("XREF")="AC",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,0)="0^5^0^"
	 * ^TMP("DILIST",543891114,0,"MAP")="FID(1)"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");
		results.add("FID(1)");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("B");
		List<String> values = new ArrayList<String>();
		values.add("THE");
		List<String> xref = new ArrayList<String>();
		xref.add("AC");
		request.setFile("19");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #7   </em>
	 * 
	 * Search on "TEST,P" without the "C" flag. There are no records in File 200
	 * with a first piece beginning with "TEST" and a second piece beginning
	 * with "P". Subsequent pieces are not checked.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=200,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="TEST,P",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,0)="0^5^0^"
	 * ^TMP("DILIST",543891114,0,"MAP")="FID(1)^FID(28)"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");
		results.add("FID(1)^FID(28)");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("TEST,P");
		List<String> xref = new ArrayList<String>();
		request.setFile("200");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #8   </em>
	 * 
	 * The same search with the "C" flag finds records with a first piece
	 * beginning with "TEST" and any subsequent piece beginning with "P",
	 * because Classic lookup mode checks all the subsequent pieces.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=200,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="C",DDR("VALUE")="TEST,P",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543891114,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543891114,2,1)=83288
	 * ^TMP("DILIST",543891114,2,2)="END_IENs"
	 * ^TMP("DILIST",543891114,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind008() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("83288");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("C");
		List<String> values = new ArrayList<String>();
		values.add("TEST,P");
		List<String> xref = new ArrayList<String>();
		request.setFile("200");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #9   </em>
	 * 
	 * Create an array of values to search a Primary Key in the NAME COMPONENTS
	 * file, but donâ€™t use the "K" flag. An error message appears.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=20,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE",1)="200",DDR("VALUE",2)=".01",DDR("VALUE",3)="2,",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543891114,"ZERR",2)="202^1^^^^1"
	 * ^TMP("DILIST",543891114,"ZERR",3)="1^Lookup values"
	 * ^TMP("DILIST",543891114,"ZERR",4)="The input parameter that identifies the Lookup values is missing or invalid."
	 * ^TMP("DILIST",543891114,"ZERR",5)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind009() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("202^1^^^^1");
		results.add("1^Lookup values");
		results.add("The input parameter that identifies the Lookup values is missing or invalid.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("200");
		values.add(".01");
		values.add("2,");
		List<String> xref = new ArrayList<String>();
		request.setFile("20");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #10   </em>
	 * 
	 * Now use the "K" flag to tell the search that we're looking up values by
	 * Primary Key. An error is still generated because the RPC only allows
	 * lookup by a single value. Use of an array of lookup values is not
	 * supported.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=20,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="K",DDR("VALUE",1)="200",DDR("VALUE",2)=".01",DDR("VALUE",3)="2,",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543891114,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543891114,"ZERR",2)="202^1^^^^1"
	 * ^TMP("DILIST",543891114,"ZERR",3)="1^Lookup values"
	 * ^TMP("DILIST",543891114,"ZERR",4)="The input parameter that identifies the Lookup values is missing or invalid."
	 * ^TMP("DILIST",543891114,"ZERR",5)="[END_diERRORS]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0010() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("202^1^^^^1");
		results.add("1^Lookup values");
		results.add("The input parameter that identifies the Lookup values is missing or invalid.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("K");
		List<String> values = new ArrayList<String>();
		values.add("200");
		values.add(".01");
		values.add("2,");
		List<String> xref = new ArrayList<String>();
		request.setFile("20");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #11   </em>
	 * 
	 * By default, only the DIALOG NUMBER (B) index is searched. Using that
	 * index, there are no entries in the DIALOGFile (#.84) beginning with
	 * "Illegal".
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,0)="0^5^0^"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0011() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #12   </em>
	 * 
	 * Now use the "M" flag to search subsequent indices, such as SHORT
	 * DESCRIPTION (D). This will find the record with a SHORT DESCRIPTION value
	 * beginning with"Illegal".
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="M",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544022402,2,1)=208
	 * ^TMP("DILIST",544022402,2,2)="END_IENs"
	 * ^TMP("DILIST",544022402,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0012() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("208");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #13   </em>
	 * 
	 * Results of "O" flag when an exact match exists: the exact match is shown,
	 * and partial matches are not returned.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="O",DDR("VALUE")=" message",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544022402,2,1)=34007
	 * ^TMP("DILIST",544022402,2,2)="END_IENs"
	 * ^TMP("DILIST",544022402,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0013() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("34007");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("O");
		List<String> values = new ArrayList<String>();
		values.add("message");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #14   </em>
	 * 
	 * Results of "O" flag when no exact match exists, but partial matches do:
	 * the partial matches are returned.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="O",DDR("VALUE")="(1 message",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544022402,2,1)=34026.1
	 * ^TMP("DILIST",544022402,2,2)=34027.1
	 * ^TMP("DILIST",544022402,2,3)="END_IENs"
	 * ^TMP("DILIST",544022402,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0014() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("34026.1");
		results.add("34027.1");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("O");
		List<String> values = new ArrayList<String>();
		values.add("(1 message");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #15   </em>
	 * 
	 * Packed output format.
	 * 
	 * (NOTE: If you are running a Packed format test from the CachÃ© prompt,
	 * you will need to define XWBAPVER in order to prevent an error. This
	 * simulates the setting of this variable by the RPC broker before the call
	 * is made.)
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="P",DDR("VALUE")="2",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,.1)="[Misc]"
	 * ^TMP("DILIST",544022402,.2)="MORE"
	 * ^TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,1,0)="200^200^          An input variable or parameter i
	 * s missing "
	 * ^TMP("DILIST",544022402,2,0)="201^201^          The input variable |1| is missin
	 * g or inval"
	 * ^TMP("DILIST",544022402,3,0)="202^202^          The input parameter that identif
	 * ies the |1"
	 * ^TMP("DILIST",544022402,4,0)="203^203^          The subscript that identifies th
	 * e |1| is m"
	 * ^TMP("DILIST",544022402,5,0)="204^204^          The input value contains control
	 *  character"
	 * ^TMP("DILIST",544022402,6)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0015() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("200^200^          An input variable or parameter is missing ");
		results.add("201^201^          The input variable |1| is missing or inval");
		results.add("202^202^          The input parameter that identifies the |1");
		results.add("203^203^          The subscript that identifies the |1| is m");
		results.add("204^204^          The input value contains control character");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #16   </em>
	 * 
	 * Use the "Q" flag for a quick lookup of a search value that is already in
	 * internal format. For example, the following search on a date field (not
	 * shown in output) uses the internal date format, so no special transforms
	 * are needed; the value is looked up directly.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="Q",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,.1)="[Misc]"
	 * ^TMP("DILIST",543875313,.2)="MORE"
	 * ^TMP("DILIST",543875313,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543875313,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543875313,2,1)=14
	 * ^TMP("DILIST",543875313,2,2)=50
	 * ^TMP("DILIST",543875313,2,3)=51
	 * ^TMP("DILIST",543875313,2,4)=54
	 * ^TMP("DILIST",543875313,2,5)=55
	 * ^TMP("DILIST",543875313,2,6)="END_IENs"
	 * ^TMP("DILIST",543875313,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0016() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("14");
		results.add("50");
		results.add("51");
		results.add("54");
		results.add("55");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("Q");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}

	/**
	 * <em>Test Case #17   </em>
	 * 
	 * The file BRANCH OF SERVICE (#23) has a whole-file screen that screens out
	 * a value of "B.E.C.". Without the "U" flag for an unscreened lookup, the
	 * entry for "B.E.C." will not be found.
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=23,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="B.E.C.",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,0)="0^5^0^"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0017() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("Q");
		List<String> values = new ArrayList<String>();
		values.add("B.E.C.");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("23");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #18   </em>
	 * 
	 * With the "U" flag, the whole-file screen is bypassed and the entry is
	 * found.
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=23,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="U",DDR("VALUE")="B.E.C.",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543875313,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543875313,2,1)=8
	 * ^TMP("DILIST",543875313,2,2)="END_IENs"
	 * ^TMP("DILIST",543875313,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0018() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("8");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("U");
		List<String> values = new ArrayList<String>();
		values.add("B.E.C.");
		List<String> xref = new ArrayList<String>();
		request.setFile("23");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #19   </em>
	 * 
	 * Results of "X" flag when an exact match exists: the exact match is
	 * returned, and partial matches are not.
	 * 
	 * <pre>
	 * Input Data:
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="X",DDR("VALUE")=" message",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544022402,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544022402,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544022402,2,1)=34007
	 * ^TMP("DILIST",544022402,2,2)="END_IENs"
	 * ^TMP("DILIST",544022402,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0019() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("34007");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("X");
		List<String> values = new ArrayList<String>();
		values.add(" message");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #20   </em>
	 * 
	 * Results of "X" flag when no exact match exists, but partial matches do:
	 * no results are returned.
	 * 
	 * <pre>
	 * Input Data: 
	 * 
	 * >K ^TMP("DILIST",$J),DDR >S
	 * DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="X",DDR("VALUE")="  (1 message",DDR("MAX")=5,
	 * DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA 
	 * ^TMP("DILIST",544022402,0)="0^5^0^"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0020() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("X");
		List<String> values = new ArrayList<String>();
		values.add("  (1 message");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #21   </em>
	 * 
	 * In TRANSLATION Subfile (#.847) of the DIALOG File (#.84), look for
	 * Languages beginning with "GER". (The subfield IEN in this case ultimately
	 * points to GERMAN.)
	 * 
	 * <pre>
	 * Input Data: 
	 * 
	 * >K ^TMP("DILIST",$J),DDR >S
	 * DDR("FILE")=.847,DDR("IENS")=",7003,",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="GER",DDR("MAX")=5,
	 * DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA 
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,2,.1)="BEGIN_IENs" 
	 * ^TMP("DILIST",544082968,2,1)=2
	 * ^TMP("DILIST",544082968,2,2)="END_IENs"
	 * ^TMP("DILIST",544082968,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0021() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("2");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("X");
		List<String> values = new ArrayList<String>();
		values.add("GER");
		List<String> xref = new ArrayList<String>();
		request.setFile(".847");
		request.setIens(",7003,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #22   </em>
	 * 
	 * Letâ€™s repeat jTestFindcDDR0021 (above), using the fields parameter
	 * to show the .01 field of the subfile.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.847,DDR("IENS")=",7003,",DDR("FIELDS")=".01",DDR("FLAGS")="",DDR("VALUE")="GER",
	 * DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544082968,2,1)=2
	 * ^TMP("DILIST",544082968,2,2)="END_IENs"
	 * ^TMP("DILIST",544082968,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",544082968,"ID",.1)=".01;^1"
	 * ^TMP("DILIST",544082968,"ID",1,.01)=2	ïƒŸIEN of the GERMAN entry in the LANGUAGE file
	 * ^TMP("DILIST",544082968,"ID",2)="END_IDVALUES"
	 * ^TMP("DILIST",544082968,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0022() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("2");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add(".01;^1");
		results.add("2");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add(".01");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("GER");
		List<String> xref = new ArrayList<String>();
		request.setFile(".847");
		request.setIens(",7003,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #23   </em>
	 * 
	 * Repeating jTestFindcDDR0011and adding two fields in the fields parameter,
	 * we can display both Field #.01 (DIALOG NUMBER) and Field #1.3 (SHORT
	 * DESCRIPTION). As before, no results are found using the default "B" index
	 * search.
	 * 
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR >S DDR("FILE")=.84,DDR("IENS")="",DDR
	 * ("FIELDS")=".01;1.3",DDR("FLAGS")="", DDR ("VALUE")="Illegal",
	 * DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID
	 * ")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA ^TMP("DILIST",544082968,0)="0^5^0^"
	 * ^TMP("DILIST",544082968,0,"MAP")=".01^1.3"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0023() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("0^5^0^");
		results.add(".01^1.3");

		List<String> fields = new ArrayList<String>();
		fields.add(".01");
		fields.add("1.3");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #24   </em>
	 * 
	 * Repeating jTestFindcDDR0012 with the fields parameter, we can clearly
	 * display both Field #.01 (DIALOG NUMBER) and Field #1.3 (SHORT
	 * DESCRIPTION), where the "Illegal" text was found.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")=".01;1.3",DDR("FLAGS")="M",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544082968,2,1)=208
	 * ^TMP("DILIST",544082968,2,2)="END_IENs"
	 * ^TMP("DILIST",544082968,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",544082968,"ID",.1)=".01;1.3;^2"
	 * ^TMP("DILIST",544082968,"ID",1,.01)=208
	 * ^TMP("DILIST",544082968,"ID",1,1.3)="Illegal number error"
	 * ^TMP("DILIST",544082968,"ID",2)="END_IDVALUES"
	 * ^TMP("DILIST",544082968,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0024() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("207");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add(".01;1.3;^2");
		results.add("208");
		results.add("Illegal number error");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add(".01");
		fields.add("1.3");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(7), response.getOutputDataList().get(7));

	}

	/**
	 * <em>Test Case #25   </em>
	 * 
	 * Repeat the above test using the "@" field indicator to suppress the
	 * default fields (except for the IEN, which is always present).This causes
	 * only the fields we requested to show in the results.
	 * 
	 * Note: The RPC does this anyway, so the results are the same as above.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;.01;1.3",DDR("FLAGS")="M",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544082968,2,1)=208
	 * ^TMP("DILIST",544082968,2,2)="END_IENs"
	 * ^TMP("DILIST",544082968,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",544082968,"ID",.1)=".01;1.3;^2"
	 * ^TMP("DILIST",544082968,"ID",1,.01)=208
	 * ^TMP("DILIST",544082968,"ID",1,1.3)="Illegal number error"
	 * ^TMP("DILIST",544082968,"ID",2)="END_IDVALUES"
	 * ^TMP("DILIST",544082968,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0025() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("207");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add(".01;1.3;^2");
		results.add("208");
		results.add("Illegal number error");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1.3");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.size(), response.getOutputDataList().size());

	}

	/**
	 * <em>Test Case #26   </em>
	 * 
	 * Use the "P" flag to display the above results in Packed output format.
	 * Remember to define XWBAPVER.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;.01;1.3",DDR("FLAGS")="MP",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,1,0)="208^208^Illegal number error"
	 * ^TMP("DILIST",544082968,2)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0026() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("208^208^Illegal number error");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1.3");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #27   </em>
	 * 
	 * Repeat jTestFindcDDR0016, this time with the fields parameter showing the
	 * DATE ENTERED Field (#4) that was searched.
	 * 
	 * By default, the results display the field in external (user-readable)
	 * format.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4",DDR("FLAGS")="QP",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,.1)="[Misc]"
	 * ^TMP("DILIST",543875313,.2)="MORE"
	 * ^TMP("DILIST",543875313,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543875313,1,0)="14^JAN 20, 1989"
	 * ^TMP("DILIST",543875313,2,0)="50^JAN 20, 1989"
	 * ^TMP("DILIST",543875313,3,0)="51^JAN 20, 1989"
	 * ^TMP("DILIST",543875313,4,0)="54^JAN 20, 1989"
	 * ^TMP("DILIST",543875313,5,0)="55^JAN 20, 1989"
	 * ^TMP("DILIST",543875313,6)="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0027() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("14^JAN 20, 1989");
		results.add("50^JAN 20, 1989");
		results.add("51^JAN 20, 1989");
		results.add("54^JAN 20, 1989");
		results.add("55^JAN 20, 1989");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4");
		List<String> flags = new ArrayList<String>();
		flags.add("Q");
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #28   </em>
	 * 
	 * Use the "IX" field indicator to display values found in the indexes
	 * searched (Packed format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;.01;1.3;IX",DDR("FLAGS")="MP",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,1,0)="208^208^Illegal number error^Illegal number error"
	 * ^TMP("DILIST",544082968,2)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0028() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("208^208^Illegal number error^Illegal number error");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1.3");
		fields.add("IX");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #29   </em>
	 * 
	 * Use the "IX" field indicator to display values found in the indexes
	 * searched (Unpacked format).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;.01;1.3;IX",DDR("FLAGS")="M",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544082968,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544082968,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544082968,2,1)=208
	 * ^TMP("DILIST",544082968,2,2)="END_IENs"
	 * ^TMP("DILIST",544082968,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",544082968,"ID",.1)=".01;1.3;^2"
	 * ^TMP("DILIST",544082968,"ID",1,0,1)="Illegal number error"
	 * ^TMP("DILIST",544082968,"ID",1,.01)=208
	 * ^TMP("DILIST",544082968,"ID",1,1.3)="Illegal number error"
	 * ^TMP("DILIST",544082968,"ID",2)="END_IDVALUES"
	 * ^TMP("DILIST",544082968,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0029() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("208");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add(".01;1.3;^2");
		results.add("Illegal number error");
		results.add("208");
		results.add("Illegal number error");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1.3");
		fields.add("IX");
		List<String> flags = new ArrayList<String>();
		flags.add("M");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #30   </em>
	 * 
	 * Use the "E" suffix to return values in External format only. This should
	 * return the same results as using neither suffix.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4E;IXE",DDR("FLAGS")="",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,.1)="[Misc]"
	 * ^TMP("DILIST",543875313,.2)="MORE"
	 * ^TMP("DILIST",543875313,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543875313,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543875313,2,1)=14
	 * ^TMP("DILIST",543875313,2,2)=50
	 * ^TMP("DILIST",543875313,2,3)=51
	 * ^TMP("DILIST",543875313,2,4)=54
	 * ^TMP("DILIST",543875313,2,5)=55
	 * ^TMP("DILIST",543875313,2,6)="END_IENs"
	 * ^TMP("DILIST",543875313,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",543875313,"ID",.1)="4;^1"
	 * ^TMP("DILIST",543875313,"ID",1,0,1)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",1,4)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",2,0,1)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",2,4)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",3,0,1)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",3,4)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",4,0,1)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",4,4)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",5,0,1)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",5,4)="JAN 20, 1989"
	 * ^TMP("DILIST",543875313,"ID",6)="END_IDVALUES"
	 * ^TMP("DILIST",543875313,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0030() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("14");
		results.add("50");
		results.add("51");
		results.add("54");
		results.add("55");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add("4;^1");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("JAN 20, 1989");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4E");
		fields.add("IXE");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}

	/**
	 * <em>Test Case #31   </em>
	 * 
	 * Use the "I" suffix to return values in Internal format only (Packed
	 * format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4I;IXI",DDR("FLAGS")="P",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543875313,.1)="[Misc]"
	 * ^TMP("DILIST",543875313,.2)="MORE"
	 * ^TMP("DILIST",543875313,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543875313,1,0)="14^2890120^2890120"
	 * ^TMP("DILIST",543875313,2,0)="50^2890120^2890120"
	 * ^TMP("DILIST",543875313,3,0)="51^2890120^2890120"
	 * ^TMP("DILIST",543875313,4,0)="54^2890120^2890120"
	 * ^TMP("DILIST",543875313,5,0)="55^2890120^2890120"
	 * ^TMP("DILIST",543875313,6)="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0031() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("14^2890120^2890120");
		results.add("50^2890120^2890120");
		results.add("51^2890120^2890120");
		results.add("54^2890120^2890120");
		results.add("55^2890120^2890120");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4I");
		fields.add("IXI");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #32   </em>
	 * 
	 * Use the "I" suffix to return values in Internal format only (Unpacked
	 * format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4I;IXI",DDR("FLAGS")="",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.1)="[Misc]"
	 * ^TMP("DILIST",543868023,.2)="MORE"
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543868023,2,1)=14
	 * ^TMP("DILIST",543868023,2,2)=50
	 * ^TMP("DILIST",543868023,2,3)=51
	 * ^TMP("DILIST",543868023,2,4)=54
	 * ^TMP("DILIST",543868023,2,5)=55
	 * ^TMP("DILIST",543868023,2,6)="END_IENs"
	 * ^TMP("DILIST",543868023,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",543868023,"ID",.1)="4;^1"
	 * ^TMP("DILIST",543868023,"ID",1,0,1)=2890120
	 * ^TMP("DILIST",543868023,"ID",1,4)=2890120
	 * ^TMP("DILIST",543868023,"ID",2,0,1)=2890120
	 * ^TMP("DILIST",543868023,"ID",2,4)=2890120
	 * ^TMP("DILIST",543868023,"ID",3,0,1)=2890120
	 * ^TMP("DILIST",543868023,"ID",3,4)=2890120
	 * ^TMP("DILIST",543868023,"ID",4,0,1)=2890120
	 * ^TMP("DILIST",543868023,"ID",4,4)=2890120
	 * ^TMP("DILIST",543868023,"ID",5,0,1)=2890120
	 * ^TMP("DILIST",543868023,"ID",5,4)=2890120
	 * ^TMP("DILIST",543868023,"ID",6)="END_IDVALUES"
	 * ^TMP("DILIST",543868023,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0032() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("14");
		results.add("50");
		results.add("51");
		results.add("54");
		results.add("55");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add("4;^1");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("2890120");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4I");
		fields.add("IXI");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(11), response.getOutputDataList().get(11));

	}

	/**
	 * <em>Test Case #33   </em>
	 * 
	 * Use both the "I" and the "E" suffixes to return values in both Internal
	 * and External format (Packed format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4IE;IXIE",DDR("FLAGS")="P",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.1)="[Misc]"
	 * ^TMP("DILIST",543868023,.2)="MORE"
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,1,0)="14^2890120^JAN 20, 1989^2890120^JAN 20, 1989"
	 * ^TMP("DILIST",543868023,2,0)="50^2890120^JAN 20, 1989^2890120^JAN 20, 1989"
	 * ^TMP("DILIST",543868023,3,0)="51^2890120^JAN 20, 1989^2890120^JAN 20, 1989"
	 * ^TMP("DILIST",543868023,4,0)="54^2890120^JAN 20, 1989^2890120^JAN 20, 1989"
	 * ^TMP("DILIST",543868023,5,0)="55^2890120^JAN 20, 1989^2890120^JAN 20, 1989"
	 * ^TMP("DILIST",543868023,6)="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0033() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("14^2890120^JAN 20, 1989^2890120^JAN 20, 1989");
		results.add("50^2890120^JAN 20, 1989^2890120^JAN 20, 1989");
		results.add("51^2890120^JAN 20, 1989^2890120^JAN 20, 1989");
		results.add("54^2890120^JAN 20, 1989^2890120^JAN 20, 1989");
		results.add("55^2890120^JAN 20, 1989^2890120^JAN 20, 1989");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4IE");
		fields.add("IXIE");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #34   </em>
	 * 
	 * Use both the "I" and the "E" suffixes to return values in both Internal
	 * and External format (Unpacked format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;4IE;IXIE",DDR("FLAGS")="",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.1)="[Misc]"
	 * ^TMP("DILIST",543868023,.2)="MORE"
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543868023,2,1)=14
	 * ^TMP("DILIST",543868023,2,2)=50
	 * ^TMP("DILIST",543868023,2,3)=51
	 * ^TMP("DILIST",543868023,2,4)=54
	 * ^TMP("DILIST",543868023,2,5)=55
	 * ^TMP("DILIST",543868023,2,6)="END_IENs"
	 * ^TMP("DILIST",543868023,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",543868023,"ID",.1)="4;^1"
	 * ^TMP("DILIST",543868023,"ID",1,0,1,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",1,0,1,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",1,4,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",1,4,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",2,0,1,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",2,0,1,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",2,4,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",2,4,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",3,0,1,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",3,0,1,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",3,4,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",3,4,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",4,0,1,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",4,0,1,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",4,4,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",4,4,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",5,0,1,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",5,0,1,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",5,4,"E")="JAN 20, 1989"
	 * ^TMP("DILIST",543868023,"ID",5,4,"I")=2890120
	 * ^TMP("DILIST",543868023,"ID",6)="END_IDVALUES"
	 * ^TMP("DILIST",543868023,"IDZ")="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0034() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("14");
		results.add("50");
		results.add("51");
		results.add("54");
		results.add("55");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add("4;^1");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("JAN 20, 1989");
		results.add("2890120");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("4IE");
		fields.add("IXIE");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}

	/**
	 * <em>Test Case #35   </em>
	 * 
	 * Use the FID indicator to show field identifiers (Packed format). In the
	 * case of the HELP FRAME File (#9.2), the Header field is one of the file's
	 * field identifiers.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;FID",DDR("FLAGS")="P",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.1)="[Misc]"
	 * ^TMP("DILIST",543868023,.2)="MORE"
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,1,0)="14^USING THE 'Help Processor' OPTION"
	 * ^TMP("DILIST",543868023,2,0)="50^USING THE 'Key Allocation' OPTIONS"
	 * ^TMP("DILIST",543868023,3,0)="51^USING THE 'Deactivate user' OPTION"
	 * ^TMP("DILIST",543868023,4,0)="54^HELP FRAME LIST FORMATS"
	 * ^TMP("DILIST",543868023,5,0)="55^USING THE 'Cross reference Help Frame' OPTION"
	 * ^TMP("DILIST",543868023,6)="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0035() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("14^USING THE 'Help Processor' OPTION");
		results.add("50^USING THE 'Key Allocation' OPTIONS");
		results.add("51^USING THE 'Deactivate user' OPTION");
		results.add("54^HELP FRAME LIST FORMATS");
		results.add("55^USING THE 'Cross reference Help Frame' OPTION");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("FID");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #36   </em>
	 * 
	 * Use the FID indicator to show field identifiers (Unpacked format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="@;FID",DDR("FLAGS")="",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.1)="[Misc]"
	 * ^TMP("DILIST",543868023,.2)="MORE"
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543868023,2,1)=14
	 * ^TMP("DILIST",543868023,2,2)=50
	 * ^TMP("DILIST",543868023,2,3)=51
	 * ^TMP("DILIST",543868023,2,4)=54
	 * ^TMP("DILIST",543868023,2,5)=55
	 * ^TMP("DILIST",543868023,2,6)="END_IENs"
	 * ^TMP("DILIST",543868023,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",543868023,"ID",.1)="1;^1"
	 * ^TMP("DILIST",543868023,"ID",1,1)="USING THE 'Help Processor' OPTION"
	 * ^TMP("DILIST",543868023,"ID",2,1)="USING THE 'Key Allocation' OPTIONS"
	 * ^TMP("DILIST",543868023,"ID",3,1)="USING THE 'Deactivate user' OPTION"
	 * ^TMP("DILIST",543868023,"ID",4,1)="HELP FRAME LIST FORMATS"
	 * ^TMP("DILIST",543868023,"ID",5,1)="USING THE 'Cross reference Help Frame' OPTION"
	 * ^TMP("DILIST",543868023,"ID",6)="END_IDVALUES"
	 * ^TMP("DILIST",543868023,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0036() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("14");
		results.add("50");
		results.add("51");
		results.add("54");
		results.add("55");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add("1;^1");
		results.add("USING THE 'Help Processor' OPTION");
		results.add("USING THE 'Key Allocation' OPTIONS");
		results.add("USING THE 'Deactivate user' OPTION");
		results.add("HELP FRAME LIST FORMATS");
		results.add("USING THE 'Cross reference Help Frame' OPTION");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("FID");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(5), response.getOutputDataList().get(5));

	}

	/**
	 * <em>Test Case #37   </em>
	 * 
	 * Use the WID indicator to show write identifiers (Packed format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;WID",DDR("FLAGS")="P",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544136957,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544136957,1,0)="208^          Illegal number error"
	 * ^TMP("DILIST",544136957,2)="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0037() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("208^          Illegal number error");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #38   </em>
	 * 
	 * Use the WID indicator to show write identifiers (Unpacked format). The
	 * RPC returns only the IENs.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;WID",DDR("FLAGS")="",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544136957,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544136957,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544136957,2,1)=208
	 * ^TMP("DILIST",544136957,2,2)="END_IENs"
	 * ^TMP("DILIST",544136957,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0038() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("208");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #39   </em>
	 * 
	 * In jTestFindcDDR007, we see that File 200 has two field identifiers,
	 * Field #1 and Field #28. Here, let's use the FID indicator to display
	 * field identifiers, but use the "-" prefix to suppress display of Field
	 * #1. Only Field #28 should display.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=200,DDR("IENS")="",DDR("FIELDS")="@;FID;-1",DDR("FLAGS")="C",DDR("VALUE")="TEST,P",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",543868023,2,1)=83288
	 * ^TMP("DILIST",543868023,2,2)="END_IENs"
	 * ^TMP("DILIST",543868023,"ID",0)="BEGIN_IDVALUES"
	 * ^TMP("DILIST",543868023,"ID",.1)="28;^1"
	 * ^TMP("DILIST",543868023,"ID",1,28)=""
	 * ^TMP("DILIST",543868023,"ID",2)="END_IDVALUES"
	 * ^TMP("DILIST",543868023,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0039() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("83288");
		results.add("END_IENs");
		results.add("BEGIN_IDVALUES");
		results.add("28;^1");
		results.add("");
		results.add("END_IDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("FID");
		fields.add("-1");
		List<String> flags = new ArrayList<String>();
		flags.add("C");
		List<String> values = new ArrayList<String>();
		values.add("TEST,P");
		List<String> xref = new ArrayList<String>();
		request.setFile("200");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #40   </em>
	 * 
	 * Run the above test in Packed format.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=200,DDR("IENS")="",DDR("FIELDS")="@;FID;-1",DDR("FLAGS")="CP",DDR("VALUE")="TEST,P",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543868023,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",543868023,1,0)="83288^"
	 * ^TMP("DILIST",543868023,2)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0040() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("83288^");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("FID");
		fields.add("-1");
		List<String> flags = new ArrayList<String>();
		flags.add("C");
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("TEST,P");
		List<String> xref = new ArrayList<String>();
		request.setFile("200");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList());

	}

	/**
	 * <em>Test Case #41   </em>
	 * 
	 * jTestFindcDDR0015 with a screen parameter added: Screen out results with
	 * an IEN of 203 or less.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="P",DDR("VALUE")="2",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="I Y>203",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * TMP("DILIST",544136957,.1)="[Misc]"
	 * ^TMP("DILIST",544136957,.2)="MORE"
	 * ^TMP("DILIST",544136957,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544136957,1,0)="204^204^          The input value contains control character"
	 * ^TMP("DILIST",544136957,2,0)="205^205^          File# |1| and IEN string |IENS| represent "
	 * ^TMP("DILIST",544136957,3,0)="206^206^          The data requested for record |1| is too l"
	 * ^TMP("DILIST",544136957,4,0)="207^207^          The value |1| is too long to encode into H"
	 * ^TMP("DILIST",544136957,5,0)="208^208^          Illegal number error"
	 * ^TMP("DILIST",544136957,6)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0041() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("204^204^          The input value contains control character");
		results.add("205^205^          File# |1| and IEN string |IENS| represent ");
		results.add("206^206^          The data requested for record |1| is too l");
		results.add("207^207^          The value |1| is too long to encode into H");
		results.add("208^208^          Illegal number error");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("I Y>203");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #42   </em>
	 * 
	 * Use the identifier parameter to associate text of your choice with each
	 * returned entry. Note that the associated text is not shown in the output
	 * (in Unpacked format).
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="2",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="D EN^DDIOL(""The IEN for this entry is ""_Y)",DDR("OPTIONS")=""
	 * 
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544099039,.1)="[Misc]"
	 * ^TMP("DILIST",544099039,.2)="MORE"
	 * ^TMP("DILIST",544099039,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544099039,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544099039,2,1)=200
	 * ^TMP("DILIST",544099039,2,2)=201
	 * ^TMP("DILIST",544099039,2,3)=202
	 * ^TMP("DILIST",544099039,2,4)=203
	 * ^TMP("DILIST",544099039,2,5)=204
	 * ^TMP("DILIST",544099039,2,6)="END_IENs"
	 * ^TMP("DILIST",544099039,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0042() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("200");
		results.add("201");
		results.add("202");
		results.add("203");
		results.add("204");
		results.add("END_IENs");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		String ID = "D EN^DDIOL(\"The IEN for this entry is \"_Y)";
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId(ID);
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #43   </em>
	 * 
	 * Repeat the above test with the DDR("OPTIONS") parameter set to "WID". Now
	 * the text you associated with each entry using the DDR("ID") parameter is
	 * shown in the output, following the fileâ€™s WID text, if any.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="2",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="D EN^DDIOL(""The IEN for this entry is ""_Y)",DDR("OPTIONS")="WID"
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR) 
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544099039,.1)="[Misc]"
	 * ^TMP("DILIST",544099039,.2)="MORE"
	 * ^TMP("DILIST",544099039,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544099039,2,.1)="BEGIN_IENs"
	 * ^TMP("DILIST",544099039,2,1)=200
	 * ^TMP("DILIST",544099039,2,2)=201
	 * ^TMP("DILIST",544099039,2,3)=202
	 * ^TMP("DILIST",544099039,2,4)=203
	 * ^TMP("DILIST",544099039,2,5)=204
	 * ^TMP("DILIST",544099039,2,6)="END_IENs"
	 * ^TMP("DILIST",544099039,"ID","WID",0)="BEGIN_WIDVALUES"
	 * ^TMP("DILIST",544099039,"ID","WID",1)="WID^200^2"
	 * ^TMP("DILIST",544099039,"ID","WID",2)="          An input variable or parameter is missing "
	 * ^TMP("DILIST",544099039,"ID","WID",3)="The IEN for this entry is 200"
	 * ^TMP("DILIST",544099039,"ID","WID",4)="WID^201^2"
	 * ^TMP("DILIST",544099039,"ID","WID",5)="          The input variable |1| is missing or inval"
	 * ^TMP("DILIST",544099039,"ID","WID",6)="The IEN for this entry is 201"
	 * ^TMP("DILIST",544099039,"ID","WID",7)="WID^202^2"
	 * ^TMP("DILIST",544099039,"ID","WID",8)="          The input parameter that identifies the |1"
	 * ^TMP("DILIST",544099039,"ID","WID",9)="The IEN for this entry is 202"
	 * ^TMP("DILIST",544099039,"ID","WID",10)="WID^203^2"
	 * ^TMP("DILIST",544099039,"ID","WID",11)="          The subscript that identifies the |1| is m"
	 * ^TMP("DILIST",544099039,"ID","WID",12)="The IEN for this entry is 203"
	 * ^TMP("DILIST",544099039,"ID","WID",13)="WID^204^2"
	 * ^TMP("DILIST",544099039,"ID","WID",14)="          The input value contains control character"
	 * ^TMP("DILIST",544099039,"ID","WID",15)="The IEN for this entry is 204"
	 * ^TMP("DILIST",544099039,"ID","WID",16)="END_WIDVALUES"
	 * ^TMP("DILIST",544099039,"IDZ")="[END_diDATA]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0043() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE");
		results.add("[BEGIN_diDATA]");
		results.add("BEGIN_IENs");
		results.add("200");
		results.add("201");
		results.add("202");
		results.add("203");
		results.add("204");
		results.add("END_IENs");
		results.add("BEGIN_WIDVALUES");
		results.add("WID^200^2");
		results.add("          An input variable or parameter is missing ");
		results.add("The IEN for this entry is 200");
		results.add("WID^201^2");
		results.add("          The input variable |1| is missing or inval");
		results.add("The IEN for this entry is 201");
		results.add("WID^202^2");
		results.add("          The input parameter that identifies the |1");
		results.add("The IEN for this entry is 202");
		results.add("WID^203^2");
		results.add("          The subscript that identifies the |1| is m");
		results.add("The IEN for this entry is 203");
		results.add("WID^204^2");
		results.add("          The input value contains control character");
		results.add("The IEN for this entry is 204");
		results.add("END_WIDVALUES");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("2");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		String ID = "D EN^DDIOL(\"The IEN for this entry is \"_Y)";
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId(ID);
		request.setOptions("WID");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertNotNull(response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #44   </em>
	 * 
	 * Used with the "WID" field indicator, the text given in the identifier
	 * parameter follows the file's WID text in the output (Packed format).
	 * (Compare with jTestFindcDDR0037.)
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S XWBAPVER="0.0"
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="@;WID",DDR("FLAGS")="P",DDR("VALUE")="Illegal",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="",DDR("ID")="D EN^DDIOL(""The IEN for this entry is ""_Y)",DDR("OPTIONS")=""
	 * 
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",544099039,.5)="[BEGIN_diDATA]"
	 * ^TMP("DILIST",544099039,1,0)="208^          Illegal number error^The IEN for this entry is 208"
	 * ^TMP("DILIST",544099039,2)="[END_diDATA]"
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0044() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diDATA]");
		results.add("208^          Illegal number error^The IEN for this entry is 208");
		results.add("[END_diDATA]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> values = new ArrayList<String>();
		values.add("Illegal");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		String ID = "D EN^DDIOL(\"The IEN for this entry is \"_Y)";
		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId(ID);
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #45   </em>
	 * 
	 * Generate Error Message 202.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=.11,DDR("IENS")="",DDR("FIELDS")="@;WID",DDR("FLAGS")="",DDR("VALUE")="",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="D EN^DDIOL(""The IEN for this entry is ""_Y)",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="202^1^^^^1"
	 * ^TMP("DILIST",543884945,"ZERR",3)="1^Lookup values"
	 * ^TMP("DILIST",543884945,"ZERR",4)="The input parameter that identifies the Lookup values is missing or invalid."
	 * ^TMP("DILIST",543884945,"ZERR",5)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0045() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("202^1^^^^1");
		results.add("1^Lookup values");
		results.add("The input parameter that identifies the Lookup values is missing or invalid.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		List<String> xref = new ArrayList<String>();
		String ID = "D EN^DDIOL(\"\"The IEN for this entry is \"\"_Y)";
		request.setFile(".11");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId(ID);
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #46   </em>
	 * 
	 * Generate Error Message 205.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")=",1,",DDR("FIELDS")="",DDR("FLAGS")="Q",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="I Y>5",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="205^1^^^^"
	 * ^TMP("DILIST",543884945,"ZERR",3)="File# 9.2 and IEN string ,1, represent different subfile levels."
	 * ^TMP("DILIST",543884945,"ZERR",4)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0046() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("205^1^^^^");
		results.add("File# 9.2 and IEN string ,1, represent different subfile levels.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("Q");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens(",1,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("I Y>5");
		request.setId("");
		request.setOptions("WID");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #47   </em>
	 * 
	 * Generate Error Message 301.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=9.2,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="Z",DDR("VALUE")="2890120",DDR("MAX")=5,DDR("XREF")="D",DDR("SCREEN")="I Y>5",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="301^1^^^^1"
	 * ^TMP("DILIST",543884945,"ZERR",3)="1^Z"
	 * ^TMP("DILIST",543884945,"ZERR",4)="The passed flag(s) 'Z' are unknown or inconsistent."
	 * ^TMP("DILIST",543884945,"ZERR",5)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0047() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("301^1^^^^1");
		results.add("1^Z");
		results.add("The passed flag(s) 'Z' are unknown or inconsistent.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		flags.add("Z");
		List<String> values = new ArrayList<String>();
		values.add("2890120");
		List<String> xref = new ArrayList<String>();
		xref.add("D");
		request.setFile("9.2");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("I Y>5");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #48   </em>
	 * 
	 * Generate Error Message 304.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=19.01,DDR("IENS")=",9",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="XUT",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="304^1^^,9^^1"
	 * ^TMP("DILIST",543884945,"ZERR",3)="IENS^,9"
	 * ^TMP("DILIST",543884945,"ZERR",4)="The IENS ',9' lacks a final comma."
	 * ^TMP("DILIST",543884945,"ZERR",5)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0048() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("304^1^^,9^^1");
		results.add("IENS^,9");
		results.add("The IENS ',9' lacks a final comma.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("XUT");
		List<String> xref = new ArrayList<String>();
		request.setFile("19.01");
		request.setIens(",9");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #49   </em>
	 * 
	 * Generate Error Message 306.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=19.01,DDR("IENS")="9,",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="XUT",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="306^1^^9,^^1"
	 * ^TMP("DILIST",543884945,"ZERR",3)="IENS^9,"
	 * ^TMP("DILIST",543884945,"ZERR",4)="The first comma-piece of IENS '9,' should be empty."
	 * ^TMP("DILIST",543884945,"ZERR",5)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0049() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("306^1^^9,^^1");
		results.add("IENS^9,");
		results.add("The first comma-piece of IENS '9,' should be empty.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("XUT");
		List<String> xref = new ArrayList<String>();
		request.setFile("19.01");
		request.setIens("9,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #50   </em>
	 * 
	 * Generate Error Message 401.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=55555,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="XUT",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="401^1^55555^^^1"
	 * ^TMP("DILIST",543884945,"ZERR",3)="FILE^55555"
	 * ^TMP("DILIST",543884945,"ZERR",4)="File #55555 does not exist."
	 * ^TMP("DILIST",543884945,"ZERR",5)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0050() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("401^1^55555^^^1");
		results.add("FILE^55555");
		results.add("File #55555 does not exist.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("XUT");
		List<String> xref = new ArrayList<String>();
		request.setFile("55555");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #51   </em>
	 * 
	 * Generate Error Message 501.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP("DILIST",$J),DDR
	 * >S DDR("FILE")=19,DDR("IENS")="",DDR("FIELDS")="9999",DDR("FLAGS")="",DDR("VALUE")="XUT",DDR("MAX")=5,DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR("OPTIONS")=""
	 * 
	 * Procedure Call:
	 * 
	 * >D FINDC^DDR0(.DDRDATA,.DDR)
	 * 
	 * Expected Output:
	 * 
	 * >ZW @DDRDATA                                                            
	 * ^TMP("DILIST",543884945,"ZERR",1)="[BEGIN_diERRORS]"
	 * ^TMP("DILIST",543884945,"ZERR",2)="501^1^19^^^2"
	 * ^TMP("DILIST",543884945,"ZERR",3)="1^9999"
	 * ^TMP("DILIST",543884945,"ZERR",4)="FILE^19"
	 * ^TMP("DILIST",543884945,"ZERR",5)="File #19 does not contain a field 9999."
	 * ^TMP("DILIST",543884945,"ZERR",6)="[END_diERRORS]"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testFind0051() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("501^1^19^^^2");
		results.add("1^9999");
		results.add("FILE^19");
		results.add("File #19 does not contain a field 9999.");
		results.add("[END_diERRORS]");

		List<String> fields = new ArrayList<String>();
		fields.add("9999");
		List<String> flags = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		values.add("XUT");
		List<String> xref = new ArrayList<String>();
		request.setFile("19");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setValue(values);
		request.setMax("5");
		request.setXref(xref);
		request.setScreen("");
		request.setId("");
		request.setOptions("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.find(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}

}