package org.dtelaroli.vplus.cms.infraestructure.route;

import br.com.caelum.vraptor.http.route.PathAnnotationRoutesParser;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.google.common.base.Strings;

@Component
@ApplicationScoped
public class CustomPathAnnotationRoutesParser extends PathAnnotationRoutesParser {

	private static final String API_V1 = "/v1";

	public CustomPathAnnotationRoutesParser(Router router) {
		super(router);
	}

	@Override
	protected String extractPrefix(Class<?> type) {
		String extractPrefix = super.extractPrefix(type);
		if(Strings.isNullOrEmpty(extractPrefix)) {
			return API_V1 + controllerName(type);
		}
		return API_V1 + extractPrefix;
	}

	private String controllerName(Class<?> type) {
		String baseName = lowerFirstCharacter(type.getSimpleName());
		if (baseName.endsWith("Controller")) {
			return "/" + baseName.substring(0, baseName.lastIndexOf("Controller"));
		}
		return "/" + baseName;
	}
	
}