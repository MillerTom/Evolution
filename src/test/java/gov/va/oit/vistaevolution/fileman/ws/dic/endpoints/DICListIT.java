package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICListEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICListResponse;
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
 *         Integration Test for LIST function of DIC Webservice
 */
public class DICListIT extends EvolutionIT<DICListEndpoint> {

	private static final Logger LOGGER = Logger.getLogger(DICListIT.class);

	private DICListRequest request;
	private DICListResponse response;

	@Override
	protected Class<DICListEndpoint> getType() {
		return DICListEndpoint.class;
	}

	@Before
	public void setup() {
		request = new DICListRequest();
	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * No Arguments Constructor
	 */
	public DICListIT() {
		super();
	}

	/**
	 * <em>Test Case #1</em>
	 * 
	 * Return a list of 5 Dialog entries.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")=""
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)=101
	 * RETURN(5)=110
	 * RETURN(6)=111
	 * RETURN(7)=112
	 * RETURN(8)=120
	 * 
	 * </pre>
	 */
	@Test
	public void testList001() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101");
		results.add("110");
		results.add("111");
		results.add("112");
		results.add("120");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #2</em>
	 * 
	 * Return a list of 5 Dialog entries beginning from index “1” with a partial
	 * match restriction of “2”.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")=""
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")="1"
	 * >S PARMS("PART")="2"
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^204^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)=200
	 * RETURN(5)=201
	 * RETURN(6)=202
	 * RETURN(7)=203
	 * RETURN(8)=204
	 * 
	 * </pre>
	 */
	@Test
	public void testList002() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^204^");
		results.add("[Data]");
		results.add("200");
		results.add("201");
		results.add("202");
		results.add("203");
		results.add("204");

		List<String> fields = new ArrayList<String>();
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		from.add("1");
		List<String> parts = new ArrayList<String>();
		parts.add("2");

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #3</em>
	 * 
	 * Return a list of 5 Dialog entries. Suppress the default values, use the
	 * values from its index, and returndata from fields .01, 1, 1.2 and 3.
	 * (“@;IX;FID;.01;1;1.2;3”).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^"
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES"
	 * 
	 * </pre>
	 */
	@Test
	public void testList003() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^");
		results.add("110^110^ERROR^VA FILEMAN^");
		results.add("111^111^ERROR^VA FILEMAN^YES");
		results.add("112^112^ERROR^VA FILEMAN^YES");
		results.add("120^120^ERROR^VA FILEMAN^YES");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #4</em>
	 * 
	 * Return a list of 5 Dialog entries. Suppress the default values, use the
	 * values from its index, and return data from fields .01, 1, 1.2 and
	 * External and Internal data from field 3. (“@;IX;FID;.01;1;1.2;3EI”).
	 * 
	 * 
	 * <pre>
	 *  	 Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^^" 
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^^"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES"
	 * 
	 * </pre>
	 */
	@Test
	public void testList004() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^^");
		results.add("110^110^ERROR^VA FILEMAN^^");
		results.add("111^111^ERROR^VA FILEMAN^YES");
		results.add("112^112^ERROR^VA FILEMAN^YES");
		results.add("120^120^ERROR^VA FILEMAN^YES");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #5</em>
	 * 
	 * Return a list of 5 Dialog entries Return the fields WRITE identifiers
	 * (Display only). (“@;WID”).
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;WID"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^          Only those with programmer's access can pe"
	 * RETURN(5)="110^          The record is currently locked."
	 * RETURN(6)="111^          The File Header Node is currently locked."
	 * RETURN(7)="112^          The file is currently locked."
	 * RETURN(8)="120^          The previous error occurred when performin"
	 * 
	 * </pre>
	 */
	@Test
	public void testList005() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^          Only those with programmer's access can pe");
		results.add("110^          The record is currently locked.");
		results.add("111^          The File Header Node is currently locked.");
		results.add("112^          The file is currently locked.");
		results.add("120^          The previous error occurred when performin");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #6</em>
	 * 
	 * Error. Return data from field #9. The file does not contain a field
	 * number 9.
	 * 
	 * 
	 * <pre>
	 * 	Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;9"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Errors]"
	 * 
	 * </pre>
	 */
	@Test
	public void testList006() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Errors]");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("9");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(0), response.getOutputDataList().get(0));

	}

	/**
	 * <em>Test Case #7</em>
	 * 
	 * Return data using the “C” x-ref.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")="C"
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * 
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^AUTOMATED INFO COLLECTION SYS^3570005"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="3570001^3570001^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y"
	 * RETURN(5)="3570002^3570002^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y"
	 * RETURN(6)="3570003^3570003^ERROR^AUTOMATED INFO COLLECTION SYS^^"
	 * RETURN(7)="3570004^3570004^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y"
	 * RETURN(8)="3570005^3570005^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y"
	 * 
	 * </pre>
	 */
	@Test
	public void testList007() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^AUTOMATED INFO COLLECTION SYS^3570005");
		results.add("[Data]");
		results.add("3570001^3570001^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y");
		results.add("3570002^3570002^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y");
		results.add("3570003^3570003^ERROR^AUTOMATED INFO COLLECTION SYS^^");
		results.add("3570004^3570004^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y");
		results.add("3570005^3570005^ERROR^AUTOMATED INFO COLLECTION SYS^YES^y");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("C");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #8</em>
	 * 
	 * Return data using the flags parameter “B” flag so as to return the data
	 * traversed backwards.
	 * 
	 * 
	 * <pre>
	 *  Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")="B"
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^89895011^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="89895011^89895011^ERROR^^^"
	 * RETURN(5)="89895012^89895012^ERROR^^^"
	 * RETURN(6)="89895013^89895013^ERROR^^^"
	 * RETURN(7)="89895014^89895014^ERROR^^^"
	 * RETURN(8)="89895140^89895140^GENERAL MESSAGE^KERNEL^^"
	 * 
	 * </pre>
	 */
	@Test
	public void testList008() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^89895011^");
		results.add("[Data]");
		results.add("89895011^89895011^ERROR^^^");
		results.add("89895012^89895012^ERROR^^^");
		results.add("89895013^89895013^ERROR^^^");
		results.add("89895014^89895014^ERROR^^^");
		results.add("89895140^89895140^GENERAL MESSAGE^KERNEL^^");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		flags.add("B");
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #9</em>
	 * 
	 * Return data. Do Not return any data from the .01 field using the “-“value
	 * (-.01).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;-.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")="B"
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^89895011^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="89895011^ERROR^^^"
	 * RETURN(5)="89895012^ERROR^^^"
	 * RETURN(6)="89895013^ERROR^^^"
	 * RETURN(7)="89895014^ERROR^^^"
	 * RETURN(8)="89895140^GENERAL MESSAGE^KERNEL^^"
	 * 
	 * </pre>
	 */
	@Test
	public void testList009() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^89895011^");
		results.add("[Data]");
		results.add("89895011^ERROR^^^");
		results.add("89895012^ERROR^^^");
		results.add("89895013^ERROR^^^");
		results.add("89895014^ERROR^^^");
		results.add("89895140^GENERAL MESSAGE^KERNEL^^");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("-.01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		flags.add("B");
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #10</em>
	 * 
	 * Return data. Use the “P” so as to return the data in a packed format.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")="P"
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^^"
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^^"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES^y"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES^y"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES^y"
	 * 
	 * 
	 * </pre>
	 */
	@Test
	public void testList0010() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^^");
		results.add("110^110^ERROR^VA FILEMAN^^");
		results.add("111^111^ERROR^VA FILEMAN^YES^y");
		results.add("112^112^ERROR^VA FILEMAN^YES^y");
		results.add("120^120^ERROR^VA FILEMAN^YES^y");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		flags.add("P");
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #11</em>
	 * 
	 * Return data using screen logic.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")="I Y]"""""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^^"
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^^"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES^y"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES^y"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES^y"
	 * 
	 * </pre>
	 */
	@Test
	public void testList0011() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^^");
		results.add("110^110^ERROR^VA FILEMAN^^");
		results.add("111^111^ERROR^VA FILEMAN^YES^y");
		results.add("112^112^ERROR^VA FILEMAN^YES^y");
		results.add("120^120^ERROR^VA FILEMAN^YES^y");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("I Y]\"\"\"\"");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #12</em>
	 * 
	 * Return data using the “ID” parameter to display a text message.
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.84
	 * >S PARMS("IENS")=""
	 * >S PARMS("FIELDS")="@;.01;1;1.2;3EI"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")="D EN^DDIOL(""TEST VRPC LISTC-DDR"")"
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Misc]"
	 * RETURN(2)="MORE^120^"
	 * RETURN(3)="[Data]"
	 * RETURN(4)="101^101^ERROR^VA FILEMAN^^^TEST VRPC LISTC-DDR"
	 * RETURN(5)="110^110^ERROR^VA FILEMAN^^^TEST VRPC LISTC-DDR"
	 * RETURN(6)="111^111^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR"
	 * RETURN(7)="112^112^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR"
	 * RETURN(8)="120^120^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR"
	 * 
	 * </pre>
	 */
	@Test
	public void testList0012() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Misc]");
		results.add("MORE^120^");
		results.add("[Data]");
		results.add("101^101^ERROR^VA FILEMAN^^^TEST VRPC LISTC-DDR");
		results.add("110^110^ERROR^VA FILEMAN^^^TEST VRPC LISTC-DDR");
		results.add("111^111^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR");
		results.add("112^112^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR");
		results.add("120^120^ERROR^VA FILEMAN^YES^y^TEST VRPC LISTC-DDR");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add("1");
		fields.add("1.2");
		fields.add("3EI");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();
		String ID = "D EN^DDIOL(\"TEST VRPC LISTC-DDR\")";

		request.setFile(".84");
		request.setIens("");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId(ID);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(3), response.getOutputDataList().get(3));

	}

	/**
	 * <em>Test Case #13</em>
	 * 
	 * Use sub-file .841 (CALLED FROM ENTRY POINTS). Return a maximum of 5
	 * entries. Suppress the default values, use the values from its index, and
	 * return data from fields .01 and .05. (“@;IX;FID;.01;.05”).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.841
	 * >S PARMS("IENS")=",110,"
	 * >S PARMS("FIELDS")="@;.01;.05"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Data]"
	 * RETURN(2)="1^DIE^FILE"
	 * 
	 * </pre>
	 */
	@Test
	public void testList0013() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Data]");
		results.add("1^DIE^FILE");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add(".01");
		fields.add(".05");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".841");
		request.setIens(",110,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

	/**
	 * <em>Test Case #14</em>
	 * 
	 * Use sub-file .841 (CALLED FROM ENTRY POINTS). Return a maximum of 5
	 * entries. Suppress the default values, use the values from its index, and
	 * return its Write Identifiers. (“@;WID”).
	 * 
	 * 
	 * <pre>
	 * Input Data:
	 * >K RETURN,PARMS
	 * >S XWBAPVER=0
	 * >S PARMS("FILE")=.841
	 * >S PARMS("IENS")=",110,"
	 * >S PARMS("FIELDS")="@;WID"
	 * >S PARMS("FLAGS")=""
	 * >S PARMS("MAX")=5
	 * >S PARMS("FROM")=""
	 * >S PARMS("PART")=""
	 * >S PARMS("XREF")=""
	 * >S PARMS("SCREEN")=""
	 * >S PARMS("ID")=""
	 * 
	 * 
	 * Procedure Call:
	 * >D LISTC^DDR(.RETURN,.PARMS)
	 * 
	 * Expected Output:
	 * >ZW RETURN
	 * RETURN(1)="[Data]"
	 * RETURN(2)=1
	 * 
	 * </pre>
	 */
	@Test
	public void testList0014() throws VistaWebServiceFault {

		ArrayList<String> results = new ArrayList<String>();
		results.add("[Data]");
		results.add("1");

		List<String> fields = new ArrayList<String>();
		fields.add("@");
		fields.add("WID");
		List<String> flags = new ArrayList<String>();
		List<String> from = new ArrayList<String>();
		List<String> parts = new ArrayList<String>();

		request.setFile(".841");
		request.setIens(",110,");
		request.setFields(fields);
		request.setFlags(flags);
		request.setMax("5");
		request.setFrom(from);
		request.setPart(parts);
		request.setXref("");
		request.setScreen("");
		request.setId("");

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("request= " + request);
		}

		response = service.list(request);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("response= " + response);
		}

		assertNotNull(response);
		assertEquals(results.get(1), response.getOutputDataList().get(1));

	}

}