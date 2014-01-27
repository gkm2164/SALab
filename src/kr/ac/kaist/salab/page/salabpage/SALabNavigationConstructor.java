package kr.ac.kaist.salab.page.salabpage;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.page.NavTreeConstructor;
import kr.ac.kaist.salab.page.salabpage.page.HomePage;
import kr.ac.kaist.salab.page.salabpage.page.activities.ActivitiesPage;
import kr.ac.kaist.salab.page.salabpage.page.courses.CoursesPage;
import kr.ac.kaist.salab.page.salabpage.page.members.MembersPage;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PublicationsPage;
import kr.ac.kaist.salab.page.salabpage.page.res.ResourcesPage;
import kr.ac.kaist.salab.page.salabpage.page.research.ResearchPage;

public class SALabNavigationConstructor implements NavTreeConstructor {
	List<NavComponent> navList = null;
	public SALabNavigationConstructor() {
		// TODO Auto-generated constructor stub
		
		navList = new ArrayList<NavComponent> ();
	}

	@Override
	public NavComponent initTree(NavNode nroot) {
		// TODO Auto-generated method stub
		NavLeaf ret = null;
		navList.add(ret = new HomePage(nroot));
		navList.add(new MembersPage(nroot));
		navList.add(new ResearchPage(nroot));
		navList.add(new PublicationsPage(nroot));
		navList.add(new ActivitiesPage(nroot));
		navList.add(new CoursesPage(nroot));
		navList.add(new ResourcesPage(nroot));
		
		return ret;
	}
}
