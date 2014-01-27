package kr.ac.kaist.salab.page.salabpage.page.courses;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class CoursesPastPage extends NavLeaf {

	public class PastCoursesPageDesc extends PageDescription {

		public PastCoursesPageDesc() {
			super("Past courses", "/WEB-INF/JSPS/courses/courses.show.jsp");
			// TODO Auto-generated constructor stub
		}
		
	};
	public CoursesPastPage(NavNode parent) {
		super("past", "Past", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("COURSESTITLE", "Past Courses");
		return new PastCoursesPageDesc ();
	}

}
