package kr.ac.kaist.salab.page.salabpage.page.members;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.database.tableop.EStatusOP;
import kr.ac.kaist.salab.database.tableop.EStatusOP.EStatus;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class MembersPage extends NavNode {
	static public class MembersPageDesc extends PageDescription {

		public MembersPageDesc(String title, String pageFileName) {
			super(title, pageFileName);
			// TODO Auto-generated constructor stub
			addCSS("members.css");
		}

		public MembersPageDesc() {
			this("members", "/WEB-INF/JSPS/members/members.home.jsp");
		}
	}

	public MembersPage(NavNode parent) {
		super("members", "Members", parent);

		new MemberStatusProf(this);

		EStatusOP esop = null;
		try {
			esop = new EStatusOP();
			List<EStatus> elist = esop.findAllOrdered();
			
			for (final EStatus elem : elist) {
				if (elem.getStatusID().equals("prof")
						|| elem.getStatusID().equals("alumni")
						|| elem.getStatusID().equals("other")) {
					continue;
				}
				new MemberStatusPage(elem.getStatusID(), elem.getStatusName(),
						this);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (esop != null) {
				esop.close();
			}
		}

		new MemberStatusAlumni(this);
		new MemberEachPage (this);
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new MembersPageDesc();
	}
}