/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFIENSResponse;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextITParent2;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@ContextConfiguration(locations = { "file:src/test/resources/WSTestContexts/fileman/dilf/iens/testContext.xml" })
@RunWith(Parameterized.class)
public class DILFIENSIT extends VistaLinkContextITParent2 {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private DILFIENSEndpointImpl service;

	private String requestBeanName;
	private String responseBeanName;

	@Before
	public void setUpContext() throws Exception {
		// this is where the magic happens, we actually do "by hand" what the
		// spring runner would do for us,
		// read the JavaDoc for the class bellow to know exactly what it does,
		// the method names are quite accurate though
		testContextManager = new TestContextManager(getClass());
		testContextManager.prepareTestInstance(this);
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { "request1", "response1" },
				{ "request2", "response2" } });
	}

	/**
	 * Constructor for {@link Parameterized} testing. Accepts the bean names in
	 * the spring context
	 * 
	 * @Test @Ignore *
	 * @param requestBeanName
	 * @param responseBeanName
	 */
	public DILFIENSIT(String requestBeanName, String responseBeanName) {
		this.requestBeanName = requestBeanName;
		this.responseBeanName = responseBeanName;

	}

	@Test
	public void testDILFIEN() throws VistaWebServiceFault {

		DILFIENSResponse expectedResponse = (DILFIENSResponse) context
				.getBean(responseBeanName);
		DILFIENSResponse response = service
				.createIENS((DILFIENSRequest) context.getBean(requestBeanName));
		assertEquals(expectedResponse.getIENSString(), response.getIENSString());
	}

}
