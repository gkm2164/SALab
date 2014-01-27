package kr.ac.kaist.salab.page.salabpage.page.activities;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class LabEventsPage extends NavLeaf {

	public class LabEventsPageDesc extends PageDescription {

		public LabEventsPageDesc() {
			super("Lab events", "/WEB-INF/JSPS/acts/acts.event.jsp");
			// TODO Auto-generated constructor stub
		}
		
	};
	
	public LabEventsPage(NavNode parent) {
		super("labevent", "Lab Events", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new LabEventsPageDesc ();
	}

}
