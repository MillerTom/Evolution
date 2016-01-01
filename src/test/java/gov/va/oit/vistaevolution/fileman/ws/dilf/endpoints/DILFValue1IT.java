/**
 * 
 */
package gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints;

import static org.junit.Assert.assertEquals;
import gov.va.oit.vistaevolution.fileman.ws.dilf.endpoints.interfaces.DILFValue1Endpoint;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Request;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.DILFValue1Response;
import gov.va.oit.vistaevolution.fileman.ws.dilf.model.Fda;
import gov.va.oit.vistaevolution.utils.vistalink.EvolutionIT;
import gov.va.oit.vistaevolution.ws.faults.VistaWebServiceFault;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author Leisa Martella
 *
 */
public class DILFValue1IT extends EvolutionIT<DILFValue1Endpoint> {

	@Override
	protected Class<DILFValue1Endpoint> getType() {
		return DILFValue1Endpoint.class;
	}

	@Test
	public void DILFValue1Test001() throws VistaWebServiceFault {
//		>S DDR("FILE")=16200,DDR("FIELD")=4
//		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
//		>S DDR("FDA",16200.04,"1,33,",1)=16
//		>S DDR("FDA",16200.04,"2,33,",2)=45
//		>D VALUE1R^DDR5(.RESULT,.DDR)
//
//		>ZW RESULT
//		RESULT="FREE TEXT DATA"
		
		// Log4J setup
		@SuppressWarnings("unused")
		final Logger logger = Logger.getLogger(DILFValue1IT.class);
		
		DILFValue1Request request = new DILFValue1Request();
		
		request.setField("4");
		request.setFile("16200");
		
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
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		DILFValue1Response response = service.value1(request);
		assertEquals("FREE TEXT DATA", response.getResult());

	}
	
	@Test
	public void DILFValue1Test002() throws VistaWebServiceFault {
//		>S DDR("FILE")=16200,DDR("FIELD")=1
//		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
//		>S DDR("FDA",16200.04,"1,33,",1)=16
//		>S DDR("FDA",16200.04,"2,33,",2)=45
//		>D VALUE1R^DDR5(.RESULT,.DDR)
//		>ZW RESULT
//		RESULT="^"
		
		
		DILFValue1Request request = new DILFValue1Request();
		
		request.setField("1");
		request.setFile("16200");
		
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
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		DILFValue1Response response = service.value1(request);
		assertEquals("^", response.getResult());

	}

	@Test
	public void DILFValue1Test003() throws VistaWebServiceFault {
//		>S DDR("FILE")=16200.04,DDR("FIELD")=2
//		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
//		>S DDR("FDA",16200.04,"1,33,",1)=16
//		>S DDR("FDA",16200.04,"2,33,",2)=45
//		>D VALUE1R^DDR5(.RESULT,.DDR)
//		>ZW RESULT
//		RESULT="45"
		
		DILFValue1Request request = new DILFValue1Request();
		
		request.setField("2");
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
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);
		
		DILFValue1Response response = service.value1(request);

		assertEquals("45", response.getResult());

	}

	@Test
	public void DILFValue1Test004() throws VistaWebServiceFault {
//		>S DDR("FILE")=16200.04,DDR("FIELD")=1
//		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
//		>S DDR("FDA",16200.04,"1,33,",1)=16
//		>S DDR("FDA",16200.04,"2,33,",2)=45
//		>D VALUE1R^DDR5(.RESULT,.DDR)
//		>ZW RESULT
//		RESULT="16"
		
		DILFValue1Request request = new DILFValue1Request();
		
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
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);

		DILFValue1Response response = service.value1(request);

		assertEquals("16", response.getResult());

	}

	@Test
	public void DILFValue1Test005() throws VistaWebServiceFault {
//		>S DDR("FILE")=16200,DDR("FIELD")=1
//		>S DDR("FDA",16200,"33,",4)="FREE TEXT DATA"
//		>S DDR("FDA",16200.04,"1,33,",1)=16
//		>S DDR("FDA",16200.04,"2,33,",2)=45
//		>D VALUE1R^DDR5(.RESULT,.DDR)
//		>ZW RESULT
//		RESULT="^"
		
		DILFValue1Request request = new DILFValue1Request();
		
		request.setField("1");
		request.setFile("16200");
		
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
		fda3.setField("2");
		fda3.setPosition("2,33,");
		fda3.setValue("45");
		fdaList.add(fda3);

		request.setFdas(fdaList);
	
		DILFValue1Response response = service.value1(request);

		assertEquals("^", response.getResult());

	}

}
       