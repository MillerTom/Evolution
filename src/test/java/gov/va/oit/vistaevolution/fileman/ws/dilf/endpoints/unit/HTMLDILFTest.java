/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.unit;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.HTMLDILFImpl;
import gov.va.oit.vistaevolution.utils.vistalink.VistaLinkContextTestParent;

import org.junit.Test;

/**
 * @author Bill Blackmon <Bill.blackmon@medsphere.com>
 * 
 */
public class HTMLDILFTest extends VistaLinkContextTestParent {

	private HTMLDILFImpl endcodeDecodeEndpoints = new HTMLDILFImpl();

	@Test
	public void testEncodeHTML() {
		assertEquals(
				"&lt;sometext&gt;Here is some &quot;Text&quot; that I'd like to be &quot;escaped&quot; for HTML &amp; here is some Swedish: Tack. Vars?god.&lt;/sometext&gt;",
				this.endcodeDecodeEndpoints
						.encodeToHTML("<sometext>Here is some \"Text\" that I'd like to be \"escaped\" for HTML & here is some Swedish: Tack. Vars?god.</sometext>"));
	}

	@Test
	public void testDecodeHTML() {
		assertEquals(
				"<sometext>Here is some \"Text\" that I'd like to be \"escaped\" for HTML & here is some Swedish: Tack. Vars?god.</sometext>",
				this.endcodeDecodeEndpoints
						.decodeFromHTML("&lt;sometext&gt;Here is some &quot;Text&quot; that I'd like to be &quot;escaped&quot; for HTML &amp; here is some Swedish: Tack. Vars?god.&lt;/sometext&gt;"));
	}

}
