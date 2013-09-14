package org.dtelaroli.vplus.cms.infraestructure.route;

import br.com.caelum.vraptor.http.route.PathAnnotationRoutesParser;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CustomPathAnnotationRoutesParser extends PathAnnotationRoutesParser {

	private static final String API_V1 = "/v1";

	public CustomPathAnnotationRoutesParser(Router router) {
		super(router);
	}

	@Override
	protected String extractPrefix(Class<?> type) {
		return API_V1 + super.extractPrefix(type);
	}
	
}