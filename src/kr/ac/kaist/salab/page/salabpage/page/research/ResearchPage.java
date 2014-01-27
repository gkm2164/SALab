package kr.ac.kaist.salab.page.salabpage.page.research;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class ResearchPage extends NavNode {

	public class ResearchPageDesc extends PageDescription {

		public ResearchPageDesc() {
			super("Research", "/WEB-INF/JSPS/research/home.jsp");
			// TODO Auto-generated constructor stub
			addCSS ("research.list.css");
		}

	}

	public ResearchPage(NavNode parent) {
		super("research", "Research", parent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public NavComponent[] getLocalNavs () {
		return null;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new ResearchPageDesc();
	}

}
