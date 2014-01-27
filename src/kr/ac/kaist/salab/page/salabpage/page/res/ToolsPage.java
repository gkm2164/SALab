package kr.ac.kaist.salab.page.salabpage.page.res;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class ToolsPage extends NavLeaf {
	public class ToolsPageDesc extends PageDescription {

		public ToolsPageDesc() {
			super("Tools", "/WEB-INF/JSPS/resources/res.tools.jsp");
			// TODO Auto-generated constructor stub
		}
		
	};
	public ToolsPage(NavNode parent) {
		super("tools", "Tools", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new ToolsPageDesc ();
	}

}
