package kr.ac.kaist.salab.page.salabpage.page.members;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.database.tableop.EMemberOP;
import kr.ac.kaist.salab.database.tableop.EMemberOP.EMember;
import kr.ac.kaist.salab.database.tableop.EStatusOP;
import kr.ac.kaist.salab.database.tableop.EStatusOP.EStatus;
import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubDataReader;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubItem;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class MemberEachPage extends NavNode {
	public class EachMemberPage extends NavLeaf {

		public class EachMemberPageDesc extends PageDescription {

			public EachMemberPageDesc() {
				super(getServletName (), "/WEB-INF/JSPS/members/member.individual.jsp");
				// TODO Auto-generated constructor stub
			}
		};
		
		public EachMemberPage(String servletName, String name, NavNode parent) {
			super(servletName, name, parent);
			// TODO Auto-generated constructor stub
		}

		@Override
		public PageDescription setPageEnv(HttpServletRequest request) {
			// TODO Auto-generated method stub
			EMemberOP emop = null;
			EStatusOP esop = null;
			try {
				emop = new EMemberOP ();
				esop = new EStatusOP ();
				
				EMember em = emop.findByMemberID(getServletName());
				EStatus es = esop.findByStatusID(em.statusID);
				
				String memberID = em.memberID;
				String memberName = em.engFirstName + ", " + em.engLastName;
				String currentWork = null;
				Date enterDate = em.enterDate;
				String email = em.email;
				String privateWeb = em.privateWeb;
				String statusName = es.StatusName;
				String areaName = null;
				List<PubItem> pi = PubDataReader.getPubItems(em.memberID);
				
				MemberList ml = new MemberList (memberID, memberName, currentWork, enterDate, email, privateWeb, statusName, areaName, pi);
				request.setAttribute("MEMBERITEM", ml);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (emop != null) emop.close();
				if (esop != null) esop.close();
			}
			return new EachMemberPageDesc ();
		}
		
	};
	public MemberEachPage(NavNode parent) {
		super("each", "Member each", parent);
		// TODO Auto-generated constructor stub
		
		EMemberOP emop = null;
		try {
			emop = new EMemberOP ();
			List<EMember> emList = emop.findAll();
			for (EMember em: emList) {
				String name = String.format ("%s, %s", em.engFirstName, em.engLastName);
				new EachMemberPage (em.memberID, name, this);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			emop.close ();
		}
		
		this.setExposeOnGlobalNav(false);
		this.setExposeOnLocalNav(false);
	}
	
	@Override
	public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
