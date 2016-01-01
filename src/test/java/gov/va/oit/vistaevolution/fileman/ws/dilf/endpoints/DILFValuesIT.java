/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValuesEndpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesRequest;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValuesResponse;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.Fda;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leisa Martella
 *
 */
public class DILFValuesIT extends EvolutionIT <DILFValuesEndpoint> {

	@Override
	protected Class<DILFValuesEndpoint> getType() {
		return DILFValuesEndpoint.class;
	}
	/*		>S DDR("FILE")=16200.04,DDR("FIELD")=1
	>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
	>S DDR("FDA",16200.04,"1,33,",1)=16
	>S DDR("FDA",16200.04,"2,33,",1)=45
	>D VALUESR^DDR5(.RESULT,.DDR)

	>ZW RESULT
	RESULT=2
	RESULT(1)=16
	RESULT(1,"IENS")="1,33,"
	RESULT(2)=45
	RESULT(2,"IENS")="2,33,"
*/

	@Test
	public void DILFValuesTest001() throws VistaWebServiceFault {
		//TODO: Setup Test Case when reported RPC issues are resolved (Leisa)

		// Log4J setup
		@SuppressWarnings("unused")
		final Logger logger = Logger.getLogger(DILFValuesIT.class);
		
		DILFValuesRequest request = new DILFValuesRequest();

		request.setField("1");
		request.setFile("16200.04");
		
		ArrayList<Fda> fdaList = new ArrayList<Fda>();
		Fda fda1 = new Fda();
		fda1.setFile("16200");
		fda1.setField("4");
		fda1.setPosition("33,");
		fda1.setValue("FREE TEXT DATA");
		fdaList.add(fda1);
		
		
		Fda fda2 = new Fda();
		fda2.setFile("16200.04");
		fda2.setField("1");
		fda2.setPosition("1,33,");
		fda2.setValue("16");
		fdaList.add(fda2);

		Fda fda3 = new Fda();
		fda3.setFile("16200.04");
		fda3.setField("1");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		DILFValuesResponse response = service.values(request);
//TODO: This should return an array with given input
		assertEquals("16", response.getDataArray().get(0));
		//assertEquals("45", response.getDataArray().get(1));

	}

}
       