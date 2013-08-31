package org.vplus.cms.application.controller;

import org.vplus.cms.domain.model.content.Content;
import org.vplus.core.controller.Crud;
import org.vplus.core.controller.Scaffold;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Path("/content")
@Resource
public class ContentController extends Scaffold<Content> {

	public ContentController(Crud controller) {
		super(controller);
	}

}