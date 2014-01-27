package kr.ac.kaist.salab.page.salabpage.page.members;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.database.tableop.EMemberOP;
import kr.ac.kaist.salab.database.tableop.EMemberOP.EMember;
import kr.ac.kaist.salab.database.tableop.VMemberInterestOP;
import kr.ac.kaist.salab.database.tableop.VMemberInterestOP.VMemberInterest;
import kr.ac.kaist.salab.page.BadPage.BadPageDesc;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.page.salabpage.page.members.MembersPage.MembersPageDesc;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubDataReader;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubItem;
import kr.ac.kaist.salab.servlets.services.PageDescription;

import org.jooq.exception.DataAccessException;

public class MemberStatusPage extends NavLeaf {
	private String statusID;
	private String statusName;

	public MemberStatusPage(String statusID, String statusName, NavNode parent) {
		super(statusID, statusName, parent);
		// TODO Auto-generated constructor stub
		this.statusID = statusID;
		this.statusName = statusName;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<MemberList> mllist = new ArrayList<MemberList>();
		EMemberOP emop = null;
		VMemberInterestOP vmiop = null;

		try {

			emop = new EMemberOP();
			vmiop = new VMemberInterestOP();

			List<EMember> mlist = emop.findByStatusID(statusID);

			for (EMember melem : mlist) {
				List<VMemberInterest> vmilist = vmiop
						.findByMemberID(melem.memberID);
				ArrayList<String> slist = new ArrayList<String>();

				for (VMemberInterest velem : vmilist) {
					slist.add(velem.areaName);
				}

				String name = melem.engFirstName + ", " + melem.engLastName;

				System.out.println (slist.toString ());
				String areaNames = slist.toString ()
										.replace("[", "")
										.replace("]", "");
				List<PubItem> piList = PubDataReader
						.getPubItems(melem.memberID);
				
				MemberList ml = new MemberList(melem.memberID, name,
						null, melem.enterDate, melem.email, melem.privateWeb,
						statusName, areaNames, piList);
				mllist.add(ml);
			}

		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			return new BadPageDesc();
		} catch (DataAccessException e) {

			e.printStackTrace();
		} finally {
			emop.close();
			vmiop.close();
		}

		request.setAttribute("STATUSNAME", statusName);
		request.setAttribute("MEMBERLIST", mllist);
		return new MembersPageDesc(statusName,
				"/WEB-INF/JSPS/members/member.general.jsp");
	}

}
