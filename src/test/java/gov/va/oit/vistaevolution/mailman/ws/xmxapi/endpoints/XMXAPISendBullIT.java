package gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.endpoints.interfaces.XMXAPISendBullEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPIArrayEntry;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapi.model.XMXAPISendBullResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPISendBullIT extends EvolutionIT<XMXAPISendBullEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPISendBullIT.class);

    private XMXAPISendBullRequest request;

    @Override
    protected Class<XMXAPISendBullEndpoint> getType() {
	return XMXAPISendBullEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPISendBullRequest();
	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmbn("XUSSPKI SAN");
	request.setXmParm(Arrays.asList(new XMXAPIArrayEntry("1",
		"TEST SUBJECT"), new XMXAPIArrayEntry("2", "SHARED,MAIL")));
	request.setXmTo(Arrays.asList(new XMXAPIArrayEntry(".6", "")));
	request.setMsg(Arrays
		.asList("TEST INFORMATIONAL ADDITION TO BROADCAST"));
    }

    /**
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(1)="TEST SUBJECT"
     * ,XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST",XMINSTR=""
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output: >ZW RESULT RESULT=286774
     * 
     * @throws VistaWebServiceFault
     */
    @Test
    public void testSendBulletin() throws VistaWebServiceFault {
	LOGGER.debug(request);

	XMXAPISendBullResponse response = service.sendBull(request);
	LOGGER.debug(response);

	assertTrue(Long.parseLong(response.getXmz()) > 1);
    }

    /**
     * successful call with special instructions
     * 
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(1)="TEST SUBJECT"
     * ,XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST"
     * ,XMINSTR("ADDR FLAGS")="IR",XINSTR("VAPOR")=3140324.1522 Procedure Call:
     * >D SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output: >ZW RESULT RESULT=286782
     */
    @Test
    public void testSendBulletinWithSpecialInstructions() throws Exception {
	String futureVistaDate = getVistaDate();
	request.setXmInstr(Arrays.asList(new XMXAPIArrayEntry("VAPOR",
		futureVistaDate)));
	LOGGER.debug(request);

	XMXAPISendBullResponse response = service.sendBull(request);
	LOGGER.debug(response);

	assertTrue(Long.parseLong(response.getXmz()) > 1);
    }

    /**
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="VISTA EVO1",XMPARM(1)="TEST SUBJECT",
     * XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST"
     * ,XMINSTR("ADDR FLAGS")="IR",XINSTR("VAPOR")=3140324.1522
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output: >ZW RESULT RESULT="-1^Bulletin 'VISTA EVO1' not found."
     */
    @Test
    public void testSendBulletinWithBadName() {
	String expectedOutput = "-1^Bulletin 'VISTA EVO1' not found.";

	request.setXmbn("VISTA EVO1");
	LOGGER.debug(request);

	XMXAPISendBullResponse response = service.sendBull(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * call without message parameter
     * 
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(16)="TEST SUBJECT"
     * ,XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST"
     * ,XMINSTR("ADDR FLAGS")="IR",XINSTR("VAPOR")=3140324.1522
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,XMBN,.XMPARM,,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RESULT RESULT=286785
     */
    @Test
    public void testSendBulletinWithEmptyMessage() throws Exception {
	request.setMsg(null);
	LOGGER.debug(request);

	XMXAPISendBullResponse response = service.sendBull(request);
	LOGGER.debug(response);

	assertTrue(Integer.parseInt(response.getXmz()) > 1);
    }

    /**
     * call without bulletin parameter
     * 
     * Input Data: >S
     * DUZ=.5,XMDUZ=.5,XMBN="XUSSPKI SAN",XMPARM(16)="TEST SUBJECT"
     * ,XMPARM(2)="SHARED,MAIL"
     * ,XMTO(.6)="",MSG(1)="TEST INFORMATIONAL ADDITION TO BROADCAST"
     * ,XMINSTR("ADDR FLAGS")="IR",XINSTR("VAPOR")=3140324.1522
     * 
     * Procedure Call: >D
     * SENDBULL^XMWSOA03(.RESULT,DUZ,XMDUZ,,.XMPARM,.MSG,.XMTO,.XMINSTR)
     * 
     * Expected Output:
     * 
     * >ZW RESULT RESULT="-1^Error in required input"
     */
    @Test
    public void testSendBulletinWithEmptyName() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setXmbn("");
	LOGGER.debug(request);

	XMXAPISendBullResponse response = service.sendBull(request);
	LOGGER.debug(response);

	assertNotNull(response);
	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }
    
    

    private String getVistaDate() {
	StringWriter stringWriter = new StringWriter();
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);

	stringWriter.append(Integer.toString(cal.get(Calendar.YEAR) - 1699));

	DateFormat inputDF = new SimpleDateFormat("MM");

	stringWriter.append(inputDF.format(date));

	inputDF = new SimpleDateFormat("dd");
	stringWriter.append(inputDF.format(date));

	stringWriter.append('.');

	inputDF = new SimpleDateFormat("HH");
	stringWriter.append(inputDF.format(date));

	inputDF = new SimpleDateFormat("mm");
	stringWriter.append(inputDF.format(date));

	return stringWriter.toString();
    }

}
