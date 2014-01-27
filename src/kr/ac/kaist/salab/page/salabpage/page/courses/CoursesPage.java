package kr.ac.kaist.salab.page.salabpage.page.courses;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class CoursesPage extends NavNode {
	public class CoursesHomePageDesc extends PageDescription {

		public CoursesHomePageDesc() {
			super("Courses", "/WEB-INF/JSPS/courses/courses.home.jsp");
			// TODO Auto-generated constructor stub
		}

	};

	public CoursesPage(NavNode parent) {
		super("courses", "Courses", parent);
		// TODO Auto-generated constructor stub
		
		new CoursesCurrentPage (this);
		new CoursesPastPage (this);
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new CoursesHomePageDesc();
	}

}
