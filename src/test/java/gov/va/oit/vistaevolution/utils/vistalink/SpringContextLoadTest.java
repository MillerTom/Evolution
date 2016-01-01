/**
 * 
 */
package gov.va.oit.vistaevolution.utils.vistalink;

import static org.junit.Assert.fail;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.J2SEVistaLinkStrategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This test will fail when trying to load the spring application context
 * 
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public class SpringContextLoadTest extends VistaLinkContextITParent {

	@Autowired
	J2SEVistaLinkStrategy j2seStrategy;
	@Autowired
	IVistaLinkContext vistaLinkContext;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		try {
			j2seStrategy.getAccessCode();
		} catch (RuntimeException e) {
			fail();
		}
	}

}
