package gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import gov.va.oit.vistaevolution.fileman.ws.dic.DICResponseFactory;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.DICFindEndpointImpl;
import gov.va.oit.vistaevolution.fileman.ws.dic.endpoints.interfaces.DICFindEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindRequest;
import gov.va.oit.vistaevolution.fileman.ws.dic.model.DICFindResponse;
import gov.va.oit.vistaevolution.util.vistalink.RPCIdentifier;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 *         Unit Test for FIND function of DIC Webservice
 */
public class DICFindTest extends VistaLinkContextTestParent {

	/**
	 * No Arguments Constructor
	 */
	public DICFindTest() {
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
	 * >K ^TMP(“DILIST”,$J),DDR
	 * >S DDR("FILE")=.84,DDR("IENS")="",DDR("FIELDS")="",DDR("FLAGS")="",DDR("VALUE")="2",DDR("MAX")="",DDR("XREF")="",DDR("SCREEN")="",DDR("ID")="",DDR(“OPTIONS”)=""
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

		String expectedOutput = "[BEGIN_diDATA]\n" + "BEGIN_IENs\n" + "200\n"
				+ "201\n";

		DICFindRequest request = new DICFindRequest();
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

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DICFindEndpoint service = new DICFindEndpointImpl(
				new DICResponseFactory(), getVistaLinkContext());

		DICFindResponse response = service.find(request);

		assertNotNull(response);
		assertEquals(results.get(2), response.getOutputDataList().get(2));

	}

	/**
	 * <em>Test Case #2   </em>
	 * 
	 * Generate Error Message 501.
	 * 
	 * <pre>
	 * Input Data:
	 * 
	 * >K ^TMP(â€œDILISTâ€�,$J),DDR
	 * >S DDR(â€œFILEâ€�)=19,DDR(â€œIENSâ€�)="",DDR(â€œFIELDSâ€�)="9999",DDR(â€œFLAGSâ€�)="",DDR(â€œVALUEâ€�)="XUT",DDR(â€œMAXâ€�)=5,DDR(â€œXREFâ€�)="",DDR(â€œSCREENâ€�)="",DDR(â€œIDâ€�)="",DDR(â€œOPTIONSâ€�)=â€œâ€œ
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
	public void testFind002() throws VistaWebServiceFault {
		ArrayList<String> results = new ArrayList<String>();
		results.add("[BEGIN_diERRORS]");
		results.add("501^1^19^^^2");
		results.add("1^9999");
		results.add("FILE^19");
		results.add("File #19 does not contain a field 9999.");
		results.add("[END_diERRORS]");

		String expectedOutput = "[BEGIN_diERRORS]\n" + "501^1^19^^^2\n"
				+ "1^9999\n" + "FILE^19\n"
				+ "File #19 does not contain a field 9999.\n"
				+ "[END_diERRORS]";

		DICFindRequest request = new DICFindRequest();
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

		when(
				this.getVistaLinkContext().makeRPCCall(new RPCIdentifier(""),
						null)).thenReturn(expectedOutput);

		DICFindEndpoint service = new DICFindEndpointImpl(
				new DICResponseFactory(), getVistaLinkContext());

		DICFindResponse response = service.find(request);

		assertNotNull(response);
		assertEquals(results.get(4), response.getOutputDataList().get(4));

	}
}
