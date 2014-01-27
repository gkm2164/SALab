package kr.ac.kaist.salab.page;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.servlets.services.Page;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class BadPage implements Page {

	static public class BadPageDesc extends PageDescription {

		public BadPageDesc() {
			super("Bad access", "/WEB-INF/JSPS/badpage.jsp");
			// TODO Auto-generated constructor stub
			addCSS("bad.css");
		}

	};

	@Override
	public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new BadPageDesc();
	}

	@Override
	public void setArgument(String[] reqString) {
		// TODO Auto-generated method stub

	}

}
