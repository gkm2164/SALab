package kr.ac.kaist.salab.page.salabpage.page.res;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class LinksPage extends NavLeaf {

	public class LinksPageDesc extends PageDescription {

		public LinksPageDesc() {
			super("Links", "/WEB-INF/JSPS/resources/res.links.jsp");
			// TODO Auto-generated constructor stub
			addCSS("resources.links.css");
		}
	};
	public LinksPage(NavNode parent) {
		super("links", "Links", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new LinksPageDesc ();
	}

}
