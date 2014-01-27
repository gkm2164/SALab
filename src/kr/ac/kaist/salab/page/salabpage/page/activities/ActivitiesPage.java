package kr.ac.kaist.salab.page.salabpage.page.activities;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class ActivitiesPage extends NavNode {
	NavLeaf labevents = null;
	
	public class ActivitiesPageDesc extends PageDescription {

		public ActivitiesPageDesc() {
			super("Activities", "/WEB-INF/JSPS/acts/acts.home.jsp");
			// TODO Auto-generated constructor stub
		}
		
	};
	
	public ActivitiesPage(NavNode parent) {
		super("activities", "Activities", parent);
		// TODO Auto-generated constructor stub
		
		labevents = new LabEventsPage (this);
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new ActivitiesPageDesc ();
	}

}
