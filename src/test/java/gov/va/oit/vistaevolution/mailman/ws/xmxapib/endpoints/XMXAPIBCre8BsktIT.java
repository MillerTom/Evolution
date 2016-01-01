package gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.endpoints.interfaces.XMXAPIBCre8BsktEndpoint;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktRequest;
import gov.va.oit.vistaevolution.mailman.ws.xmxapib.model.XMXAPIBCre8BsktResponse;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class XMXAPIBCre8BsktIT extends EvolutionIT<XMXAPIBCre8BsktEndpoint> {

    private static final Logger LOGGER = Logger
	    .getLogger(XMXAPIBCre8BsktIT.class);

    // XMXAPIBCre8BsktEndpointImpl
    private XMXAPIBCre8BsktRequest request;

    @Override
    protected Class<XMXAPIBCre8BsktEndpoint> getType() {
	return XMXAPIBCre8BsktEndpoint.class;
    }

    @Before
    public void setUp() {
	request = new XMXAPIBCre8BsktRequest();
	request.setDuz("1");
	request.setXmDuz("1");
	request.setXmkn("ZZ_NEWBASKET");
    }

    /**
     * Submits and tests private member request against provided expected input
     * 
     * @param expected
     */
    public void submitAndTestRequest(String expected) {
	LOGGER.debug(request);
	XMXAPIBCre8BsktResponse response = service.cre8Bskt(request);
	LOGGER.debug(response);
	assertEquals(expected, response.getStatus());
    }

    /**
     * <em>Retrieve create a basket for a user</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=1,XMKN=”ZZ_NEWBASKET”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="0^6"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testCreateBasketForUser() throws Exception {
	String expected = "0";
	submitAndTestRequest(expected);
    }

    /**
     * <em>Attempt to create a basket for a user where the logged in user does not have surrogate abilities.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=.5,XMDUZ=1,XMKN=”ZZ_NEWBASKET_2”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^You are not authorized to be a surrogate of DUZ 1."
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testCreateBasketWithNoSurrogateAbilities() throws Exception {
	String expected = "-1";
	request.setDuz(".5");
	request.setXmkn(request.getXmkn() + "_2");
	submitAndTestRequest(expected);
    }

    /**
     * <em>Attempt to create a basket and the target user is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=””,XMKN=”ZZ_NEWBASKET_2”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA	String expected = "-1";
     * 	request.setDuz(".5");
     * 	request.setXmkn(request.getXmkn() + "_2");
     * 	submitAndTestRequest(expected);
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testCreatebasticWithNoXmDuz() throws Exception {
	String expected = "-1";
	request.setXmDuz("");
	request.setXmkn(request.getXmkn() + "_2");
	submitAndTestRequest(expected);
    }

    /**
     * <em>Attempt to create a basket and the basket is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=1,XMKN=””
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void testCreateBasketWithNoBasketName() throws Exception {
	String expected = "-1";
	request.setXmkn("");
	submitAndTestRequest(expected);
    }

    /**
     * <em> Attempt to create a basket and the basket variable is empty.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=1,XMKN=”ZZ_TestBAsket_3”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     */
    @Test
    @Ignore
    public void testCreateBasketWithNoBasketVariableName() throws Exception {
	String expected = "-1";
	request.setXmkn("ZZ_TestBAsket_3");
	submitAndTestRequest(expected);
    }

    /**
     * <em>Attempt to create a basket and the DUZ is for a non-existent user.</em>
     * 
     * <pre>
     * Input Data:
     * >Set U=”^”,DUZ=1,XMDUZ=1,XMKN=”ZZ_TestBasket_3”
     * 
     * Procedure Call:
     * 
     * >D CRE8BSKT^XMWSOA08(.DATA,DUZ,XMDUZ,XMKN)
     * 
     * Expected Output:
     * 
     * >ZW DATA
     * DATA="-1^Error in required input"
     * </pre>
     */
    @Test
    @Ignore
    public void testCreateBasketDuzNonExistent() throws Exception {
	String expected = "-1";
	request.setXmkn("ZZ_TestBasket_3");
	submitAndTestRequest(expected);
    }
}
