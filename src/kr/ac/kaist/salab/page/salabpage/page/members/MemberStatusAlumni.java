package kr.ac.kaist.salab.page.salabpage.page.members;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.database.tableop.VAlumniOP;
import kr.ac.kaist.salab.database.tableop.VMemberInterestOP;
import kr.ac.kaist.salab.database.tableop.VAlumniOP.VAlumni;
import kr.ac.kaist.salab.database.tableop.VAlumniYearOP;
import kr.ac.kaist.salab.database.tableop.VAlumniYearOP.VAlumniYear;
import kr.ac.kaist.salab.database.tableop.VMemberInterestOP.VMemberInterest;
import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavLeaf;
import kr.ac.kaist.salab.page.NavNode;
import kr.ac.kaist.salab.page.salabpage.page.members.MembersPage.MembersPageDesc;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubDataReader;
import kr.ac.kaist.salab.page.salabpage.page.pubs.PubItem;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class MemberStatusAlumni extends NavNode {
	List<VAlumniYear> lists = null;

	private class MemberArchivePage extends NavLeaf {

		public MemberArchivePage (String year, NavNode parent) {
			super (year, year, parent);
		}
		
		@Override
		public PageDescription setPageEnv(HttpServletRequest request) {
			// TODO Auto-generated method stub
			MemberStatusAlumni msa = MemberStatusAlumni.this;
			/* need to regist attribute MEMBERLIST */
			List<MemberList> memlist = new ArrayList<MemberList>();
			String sYear = getServletName();
			int iYear = Integer.valueOf(sYear);

			VAlumniOP vaop = null;
			VMemberInterestOP vmiop = null;
			
			try {
				vaop = new VAlumniOP();

				List<VAlumni> valist = vaop.findByGradYear(iYear);
				vmiop = new VMemberInterestOP ();
				for (VAlumni elem : valist) {
					String name = elem.engFirstName + ", "
							+ elem.engLastName;
					List<VMemberInterest> vmi = vmiop
							.findByMemberID(elem.memberID);
					List<String> slist = new ArrayList<String>();
					for (VMemberInterest e : vmi) {
						slist.add(e.areaName);
					}
					
					String areaNames = slist.toString()
											.replace("[", "")
											.replace("]", "");

					List<PubItem> piList = PubDataReader.getPubItems(elem.memberID);
					MemberList ml = new MemberList(elem.memberID,
							name, elem.currentWork, null,
							elem.email, elem.privateWeb,
							elem.statusID, areaNames, piList);
					memlist.add(ml);
				}
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				vaop.close ();
				vmiop.close();
			}

			request.setAttribute("ALUMNIPATH", msa.getServletPath());
			request.setAttribute("ALUMNIYEARS", lists);
			request.setAttribute("MEMBERLIST", memlist);

			PageDescription mpd = new AlumniPageDesc(
					this.getServletName());
			return mpd;
		}
		
	};
	public class AlumniPageDesc extends MembersPageDesc {
		public AlumniPageDesc(String year) {
			this.setTitle((year.equals("") ? "Alumni" : year + "- Alumni"))
					.setPageFileName("/WEB-INF/JSPS/members/member.alumni.jsp")
					.addCSS("members.alumni.css");
		}
	};

	public MemberStatusAlumni(NavNode parent) {
		super("alumni", "Alumni", parent);
		// TODO Auto-generated constructor stub

		setGlobalExposeChild(false);
		VAlumniYearOP vayop = null;
		try {
			vayop = new VAlumniYearOP();
			lists = vayop.findAll();
			for (VAlumniYear vay : lists) {
				String year = Integer.toString(vay.getGradyear());
				System.out.println(vay.getGradyear());
				new MemberArchivePage (year, this);
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			vayop.close();
		}
	}

	@Override
	public NavComponent[] getLocalNavs() {
		return parent.getLocalNavs();
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("ALUMNIPATH", this.getServletPath());
		request.setAttribute("ALUMNIYEARS", lists);

		PageDescription mpd = new AlumniPageDesc("");
		return mpd;
	}
}
