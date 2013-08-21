package org.vplus.cms.infraestructure;

import java.io.File;

import br.com.caelum.vraptor.test.RealVRaptor;

public interface Server {
	
	static final RealVRaptor VRAPTOR = new RealVRaptor(new File("src/main/webapp"));
	
}
