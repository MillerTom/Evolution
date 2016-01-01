package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBQBsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBQBsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class XMXAPIBQBsktIT extends EvolutionIT<XMXAPIBQBsktEndpoint> {

    private static final Logger LOGGER = Logger.getLogger(XMXAPIBQBsktIT.class);

    private XMXAPIBQBsktRequest request;

    @Override
    protected Class<XMXAPIBQBsktEndpoint> getType() {
	return XMXAPIBQBsktEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPIBQBsktRequest();
	request.setDuz(".5");
	request.setXmDuz(".5");
	request.setXmk(".5");
    }

    /**
     * Successful call
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=.5,XMK=.5
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN=".5^WASTE^0^0"
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfo() throws Exception {

	String expectedOutput = ".5^WASTE^0^0";

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getIen());
	assertEquals(expectedOutput.split("\\^")[1], response.getName());
	assertEquals(expectedOutput.split("\\^")[2], response.getNumOfMsgs());
	assertEquals(expectedOutput.split("\\^")[3], response.getNumOfNewMsgs());
    }

    /**
     * <em>Missing DUZ</em>
     * 
     * Input Data: >S U="^",RETURN="",DUZ=””,XMDUZ=.5,XMK=.5
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     * 
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfoWithEmptyDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setDuz("");

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Missing XMDUZ
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=””,XMK=.5
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfoWithEmptyXMDUZ() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setXmDuz("");

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Missing Message Basket IEN
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=.5,XMK=””
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Error in required input"
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfoWithEmptyXMK() throws Exception {
	String expectedOutput = "-1^Error in required input";

	request.setXmk("");

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

    /**
     * Success using Basket Name
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=.5,XMK=”WASTE”
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN=".5^WASTE^0^0"
     * 
     * @throws Exception
     */
    @Test
    public void testGetBasketInfoByBasketName() throws Exception {

	request.setXmk("WASTE");

	String expectedOutput = ".5^WASTE^0^0";

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getIen());
	assertEquals(expectedOutput.split("\\^")[1], response.getName());
	assertEquals(expectedOutput.split("\\^")[2], response.getNumOfMsgs());
	assertEquals(expectedOutput.split("\\^")[3], response.getNumOfNewMsgs());
    }

    /**
     * Error generated within the API
     * 
     * Input Data: >S U="^",RETURN="",DUZ=.5,XMDUZ=.5,XMK=”WASTEr”
     * 
     * Procedure Call: >D QBSKT^XMWSOA08(.RETURN,DUZ,XMDUZ,XMK)
     * 
     * Expected Output: >ZW RETURN RETURN="-1^Basket 'WASTEr' not found."
     */
    @Test
    public void testGetBasketInfoWithBadName() throws Exception {
	String expectedOutput = "-1^Basket 'WASTEr' not found.";

	request.setXmk("WASTEr");

	LOGGER.debug(request);
	XMXAPIBQBsktResponse response = service.qBskt(request);
	LOGGER.debug(response);

	assertEquals(expectedOutput.split("\\^")[0], response.getStatus());
	assertEquals(expectedOutput.split("\\^")[1], response.getErrors()
		.get(0));
    }

}
