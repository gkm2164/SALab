package kr.ac.kaist.salab.page.salabpage.page;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class HomePage extends NavLeaf {
	class HomePageDesc extends PageDescription {

		public HomePageDesc() {
			super("Home", "/WEB-INF/JSPS/home/home.jsp");
			// TODO Auto-generated constructor stub

			this.addCSS("home.css")
				.addJS("salab.home.js");
		}

	}

	public HomePage(NavNode parent) {
		super("home", "Home", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		PageDescription ret = new HomePageDesc();
		return ret;
	}
}
