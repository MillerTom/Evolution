/**
 * 
 */
package gov.va.oit.vistaevolution.utils.vistalink;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resources/applicationContext.xml" })
public class VistaLinkContextITParent2 {

	protected TestContextManager testContextManager;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("java.security.auth.login.config",
				"file:src/test/resources/jaas.config");

	}

	/**
	 * 
	 */
	public VistaLinkContextITParent2() {
		super();
	}

}