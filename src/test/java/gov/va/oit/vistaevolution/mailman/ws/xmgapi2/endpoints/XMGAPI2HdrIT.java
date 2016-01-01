package gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.endpoints.interfaces.XMGAPI2HdrEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmgapi2.model.XMGAPI2HdrResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class XMGAPI2HdrIT extends EvolutionIT<XMGAPI2HdrEndpoint> {
	private XMGAPI2HdrRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT#getType()
	 */
	@Override
	protected Class<XMGAPI2HdrEndpoint> getType() {
		return XMGAPI2HdrEndpoint.class;
	}

	@Before
	public void setUp() {
		request = new XMGAPI2HdrRequest();
		request.setDuz("1");
		request.setXmduz("");
		request.setMsg("58880");
		request.setFlag("0");

	}

	@After
	public void tearDown() {
		request = null;
	}

	/**
	 * <em>Test 1</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=1
	 * >SET XMDUZ=””
	 * >SET FLAG=0
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BROADCAST^0"
	 * DATA(2)="BSKT^LEX PATCH INFO"
	 * DATA(3)="BSKT IEN^5"
	 * DATA(4)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(5)="DATE FM^3100504.205902"
	 * DATA(6)="LINES^19"
	 * DATA(7)="NEW^0"
	 * DATA(8)="PXMZ"
	 * DATA(9)="SENDER^POSTMASTER"
	 * DATA(10)="SENDER DUZ^.5"
	 * DATA(11)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(12)="SURROG"
	 * DATA(13)="TYPE"
	 * DATA(14)="XMZ^58880"
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test001() throws VistaWebServiceFault {

		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull(response.getData());

	}
	
	/**
	 * <em>Test 2</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=""
	 * >SET XMDUZ=””
	 * >SET FLAG=0
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BROADCAST^0"
	 * DATA(2)="BSKT^LEX PATCH INFO"
	 * DATA(3)="BSKT IEN^5"
	 * DATA(4)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(5)="DATE FM^3100504.205902"
	 * DATA(6)="LINES^19"
	 * DATA(7)="NEW^0"
	 * DATA(8)="PXMZ"
	 * DATA(9)="SENDER^POSTMASTER"
	 * DATA(10)="SENDER DUZ^.5"
	 * DATA(11)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(12)="SURROG"
	 * DATA(13)="TYPE"
	 * DATA(14)="XMZ^58880"
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test002() throws VistaWebServiceFault {

		
		request.setDuz("");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getErrors() );
		assertNotNull( response.getStatus() );
		assertEquals( "ERROR", response.getStatus());
		assertEquals("Error in required input\n", response.getErrors().get(0));

	}

	/**
	 * <em>Test 3</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=1
	 * >SET XMDUZ=””
	 * >SET FLAG=1
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BLOBCNT^0"
	 * DATA(2)="BROADCAST^0"
	 * DATA(3)="BSKT^LEX PATCH INFO"
	 * DATA(4)="BSKT IEN^5"
	 * DATA(5)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(6)="DATE FM^3100504.205902"
	 * DATA(7)="LINES^19"
	 * DATA(8)="NEW^0"
	 * DATA(9)="PXMZ"
	 * DATA(10)="RRCV"
	 * DATA(11)="RRED^0"
	 * DATA(12)="SENDER^POSTMASTER"
	 * DATA(13)="SENDER DUZ^.5"
	 * DATA(14)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(15)="SURROG"
	 * DATA(16)="TYPE"
	 * DATA(17)="XMZ^58880"
	 * 
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test003() throws VistaWebServiceFault {

		
		request.setFlag("1");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getData() );


	}
	
	/**
	 * <em>Test 4</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=1
	 * >SET XMDUZ=””
	 * >SET FLAG=91
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BLOBCNT^0"
	 * DATA(2)="BROADCAST^0"
	 * DATA(3)="BSKT^LEX PATCH INFO"
	 * DATA(4)="BSKT IEN^5"
	 * DATA(5)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(6)="DATE FM^3100504.205902"
	 * DATA(7)="LINES^19"
	 * DATA(8)="NEW^0"
	 * DATA(9)="PXMZ"
	 * DATA(10)="RRCV"
	 * DATA(11)="RRED^0"
	 * DATA(12)="SENDER^POSTMASTER"
	 * DATA(13)="SENDER DUZ^.5"
	 * DATA(14)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(15)="SURROG"
	 * DATA(16)="TYPE"
	 * DATA(17)="XMZ^58880"
	 * 
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test004() throws VistaWebServiceFault {

		
		request.setFlag("91");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getData() );


	}
	/**
	 * <em>Test 5</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=1
	 * >SET XMDUZ=””
	 * >SET FLAG=92
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BLOBCNT^0"
	 * DATA(2)="BROADCAST^0"
	 * DATA(3)="BSKT^LEX PATCH INFO"
	 * DATA(4)="BSKT IEN^5"
	 * DATA(5)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(6)="DATE FM^3100504.205902"
	 * DATA(7)="LINES^19"
	 * DATA(8)="NEW^0"
	 * DATA(9)="PXMZ"
	 * DATA(10)="RRCV"
	 * DATA(11)="RRED^0"
	 * DATA(12)="SENDER^POSTMASTER"
	 * DATA(13)="SENDER DUZ^.5"
	 * DATA(14)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(15)="SURROG"
	 * DATA(16)="TYPE"
	 * DATA(17)="XMZ^58880"
	 * 
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test005() throws VistaWebServiceFault {

		
		request.setFlag("92");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getData() );


	}

	/**
	 * <em>Test 6</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=1
	 * >SET XMDUZ=””
	 * >SET FLAG=93
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BLOBCNT^0"
	 * DATA(2)="BROADCAST^0"
	 * DATA(3)="BSKT^LEX PATCH INFO"
	 * DATA(4)="BSKT IEN^5"
	 * DATA(5)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(6)="DATE FM^3100504.205902"
	 * DATA(7)="LINES^19"
	 * DATA(8)="NEW^0"
	 * DATA(9)="PXMZ"
	 * DATA(10)="RRCV"
	 * DATA(11)="RRED^0"
	 * DATA(12)="SENDER^POSTMASTER"
	 * DATA(13)="SENDER DUZ^.5"
	 * DATA(14)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(15)="SURROG"
	 * DATA(16)="TYPE"
	 * DATA(17)="XMZ^58880"
	 * 
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test006() throws VistaWebServiceFault {

		
		request.setFlag("93");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getData() );


	}
	/**
	 * <em>Test 7</em>
	 * 
	 * <pre>
	 * Input Data:
	 * >SET MSG=58880
	 * >SET MDUZ=""
	 * >SET XMDUZ=””
	 * >SET FLAG=99
	 * 
	 * Procedure Call:
	 * 
	 * >D HDR^XMWSOA03(.DATA,MYDUZ,XMDUZ,MSG,FLAG)
	 * 
	 * Expected Output:
	 * 
	 * >ZW DATA
	 * DATA(1)="BROADCAST^0"
	 * DATA(2)="BSKT^LEX PATCH INFO"
	 * DATA(3)="BSKT IEN^5"
	 * DATA(4)="DATE^MAY 04, 2010@20:59:02"
	 * DATA(5)="DATE FM^3100504.205902"
	 * DATA(6)="LINES^19"
	 * DATA(7)="NEW^0"
	 * DATA(8)="PXMZ"
	 * DATA(9)="SENDER^POSTMASTER"
	 * DATA(10)="SENDER DUZ^.5"
	 * DATA(11)="SUBJ^LEX*2.0*69 Installation"
	 * DATA(12)="SURROG"
	 * DATA(13)="TYPE"
	 * DATA(14)="XMZ^58880"
	 * 
	 * </pre>
	 * 
	 */
	@Test
	public void test007() throws VistaWebServiceFault {

		
		request.setDuz("");
		request.setFlag("99");
		XMGAPI2HdrResponse response = service.hdr(request);

		assertNotNull(response);
		assertNotNull( response.getErrors() );
		assertNotNull( response.getStatus() );
		assertEquals( "ERROR", response.getStatus());
		assertEquals("Error in required input\n", response.getErrors().get(0));

	}



}
