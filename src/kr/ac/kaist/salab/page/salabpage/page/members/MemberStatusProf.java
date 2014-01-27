package kr.ac.kaist.salab.page.salabpage.page.members;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class MemberStatusProf extends NavLeaf {

	public MemberStatusProf(NavNode parent) {
		super("prof", "Professor", parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String title = "Professor";
		String fileURL = "/WEB-INF/JSPS/members/members.prof.jsp";
		PageDescription pd = new PageDescription(title, fileURL)
				.addCSS("members.prof.css");
		return pd;
	}

}
