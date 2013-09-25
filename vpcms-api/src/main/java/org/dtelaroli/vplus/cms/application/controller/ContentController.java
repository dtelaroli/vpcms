package org.dtelaroli.vplus.cms.application.controller;

import org.dtelaroli.vpcms.domain.model.content.Content;
import org.dtelaroli.vplus.core.controller.Crud;
import org.dtelaroli.vplus.core.controller.Scaffold;

import br.com.caelum.vraptor.Resource;

@Resource
public class ContentController extends Scaffold<Content> {

	public ContentController(Crud controller) {
		super(controller);
	}

}