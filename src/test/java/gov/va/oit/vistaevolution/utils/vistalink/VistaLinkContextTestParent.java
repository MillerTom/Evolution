/**
 * 
 */
package gov.va.oit.vistaevolution.utils.vistalink;

import static org.mockito.Mockito.mock;
import gov.va.oit.vistaevolution.util.vistalink.DefaultVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkContext;
import gov.va.oit.vistaevolution.util.vistalink.IVistaLinkStrategy;

import org.junit.After;
import org.junit.Before;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
public abstract class VistaLinkContextTestParent {

	private IVistaLinkContext vistaLinkContext;
	private IVistaLinkStrategy vistaLinkStrategy;

	/**
	 * 
	 */
	public VistaLinkContextTestParent() {
		super();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpSuper() throws Exception {
		setVistaLinkStrategy(mock(IVistaLinkStrategy.class));
		setVistaLinkContext(new DefaultVistaLinkContext(getVistaLinkStrategy()));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		setVistaLinkContext(null);
	}

	protected IVistaLinkContext getVistaLinkContext() {
		return vistaLinkContext;
	}

	protected void setVistaLinkContext(IVistaLinkContext vistaLinkContext) {
		this.vistaLinkContext = vistaLinkContext;
	}

	private IVistaLinkStrategy getVistaLinkStrategy() {
		return vistaLinkStrategy;
	}

	private void setVistaLinkStrategy(IVistaLinkStrategy vistaLinkStrategy) {
		this.vistaLinkStrategy = vistaLinkStrategy;
	}

}