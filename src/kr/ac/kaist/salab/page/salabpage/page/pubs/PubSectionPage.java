package kr.ac.kaist.salab.page.salabpage.page.pubs;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class PubSectionPage extends NavNode {
	private String dbValue;

	private class PubPageDesc extends PageDescription {

		public PubPageDesc(String title) {
			super(title, "/WEB-INF/JSPS/pubs/pub.show.jsp");
			addCSS ("pubs.show.css");
			// TODO Auto-generated constructor stub
		}
	};

	public class PublicationNation extends NavLeaf {
		private String nation;

		public PublicationNation(String servletName, String nation,
				NavNode parent) {
			super(servletName, nation, parent);
			// TODO Auto-generated constructor stub
			this.nation = nation;
		}

		@Override
		public PageDescription setPageEnv(HttpServletRequest request) {
			// TODO Auto-generated method stub
			List<PubItem> pubItem = PubDataReader.getPubItems(dbValue, nation);
			request.setAttribute("PUB_TITLE", dbValue + ":" + nation);
			request.setAttribute("PUBCONTENTS", pubItem);
			return new PubPageDesc(dbValue + ":" + nation);
		}

	};

	public PubSectionPage(String servletName, String DBValue, NavNode parent) {
		super(servletName, DBValue, parent);
		// TODO Auto-generated constructor stub
		dbValue = DBValue;
		setGlobalExposeChild(false);
		setLocalExposeChild(true);
		if (DBValue.equals("Books")) {
			return;
		}

		new PublicationNation("int", "International", this);
		new PublicationNation("dom", "Domestic", this);
	}

	@Override
	public NavComponent[] getLocalNavs() {
		return parent.getLocalNavs();
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		List<PubItem> pubItem = PubDataReader.getPubItems(dbValue, "*");
		request.setAttribute("PUB_TITLE", dbValue);
		request.setAttribute("PUBCONTENTS", pubItem);
		return new PubPageDesc(dbValue);
	}
}
