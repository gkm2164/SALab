package kr.ac.kaist.salab.page.salabpage.page.pubs;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class PublicationsPage extends NavNode {

	class PubPageDesc extends PageDescription {

		public PubPageDesc() {
			super("Publications", "/WEB-INF/JSPS/pubs/pub.home.jsp");
			// TODO Auto-generated constructor stub
			addCSS("pubs.home.css");
		}

	};

	public PublicationsPage(NavNode parent) {
		super("pubs", "Publications", parent);
		// TODO Auto-generated constructor stub
		new PubSectionPage("books", "Books", this);
		new PubSectionPage("journal", "Journal", this);
		new PubSectionPage("conf", "Conference", this);
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub

		return new PubPageDesc();
	}
}
