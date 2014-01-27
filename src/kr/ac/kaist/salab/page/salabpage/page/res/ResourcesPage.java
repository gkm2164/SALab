package kr.ac.kaist.salab.page.salabpage.page.res;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class ResourcesPage extends NavNode {

	public class ResourcesPageDesc extends PageDescription {

		public ResourcesPageDesc() {
			super("Resources", "/WEB-INF/JSPS/resources/res.home.jsp");
			// TODO Auto-generated constructor stub
		}

	}

	public ResourcesPage(NavNode parent) {
		super("res", "Resources", parent);
		// TODO Auto-generated constructor stub
		new LinksPage (this);
		new ToolsPage (this);
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new ResourcesPageDesc();
	}

}
