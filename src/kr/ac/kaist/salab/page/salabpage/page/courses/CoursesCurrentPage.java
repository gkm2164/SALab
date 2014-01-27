package kr.ac.kaist.salab.page.salabpage.page.courses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.database.tableop.ECourseOP;
import kr.ac.kaist.salab.database.tableop.ECourseOP.ECourse;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class CoursesCurrentPage extends NavLeaf {

	public class CurrentCoursePageDesc extends PageDescription {

		public CurrentCoursePageDesc() {
			super("Current courses", "/WEB-INF/JSPS/courses/courses.show.jsp");
			// TODO Auto-generated constructor stub
		}
		
	};
	public CoursesCurrentPage(NavNode parent) {
		super("current", "Current", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ECourseOP ecop = null;
		try {
			ecop = new ECourseOP ();
			List<ECourse> ecList = ecop.findAllOrderedByTime();
			
			request.setAttribute("COURSELIST", ecList);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ecop != null) ecop.close();
		}
		request.setAttribute("COURSESTITLE", "Current Courses");
		return new CurrentCoursePageDesc ();
	}

}
