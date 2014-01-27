package kr.ac.kaist.salab.page.salabpage.page.pubs;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kaist.salab.database.tableop.EPublicationOP;
import kr.ac.kaist.salab.database.tableop.VPubMemberOP;
import kr.ac.kaist.salab.database.tableop.EPublicationOP.EPublication;
import kr.ac.kaist.salab.database.tableop.VPubMemberOP.VPubMember;

public class PubDataReader {

	static private PubItem fillPubItem(EPublication elem,
			List<VPubMember> member) {
		String pubID = elem.pubID;
		String title = elem.title;
		String pubType = elem.pubType;
		String pubNation = elem.pubNation;
		String pubDesc = elem.pubDesc;
		Date pubDate = elem.pubDate;
		String formatID = "";

		if (elem.pubType.equals("Conference")
				&& elem.pubNation.equals("International")) {
			formatID = "salab-conf-int";
		} else if (elem.pubType.equals("Conference")
				&& elem.pubNation.equals("Domestic")) {
			formatID = "salab-conf-dom";
		} else if (elem.pubType.equals("Journal")
				&& elem.pubNation.equals("International")) {
			formatID = "salab-jour-int";
		} else {
			formatID = "salab-default";
		}

		PubItem pi = new PubItem(pubID, title, pubType, pubNation, pubDesc,
				pubDate, formatID);

		for (VPubMember vElem : member) {
			String memberID = vElem.memberID;
			String name = "";
			if (elem.pubNation.equals("Domestic")) {
				name = vElem.korFirstName + vElem.korLastName;
			} else {
				name = vElem.engFirstName + " " + vElem.engLastName;
			}

			pi.addName(memberID, name);
		}

		return pi;
	}

	static public List<PubItem> getPubItems(String type, String nation) {
		List<EPublication> epList = null;
		List<PubItem> pubItem = new ArrayList<PubItem>();
		
		EPublicationOP epop = null;
		VPubMemberOP vpmop = null;
		try {
			epop = new EPublicationOP();
			vpmop = new VPubMemberOP();
			epList = epop.findByPubQuery(type, nation);
			for (EPublication eElem : epList) {
				List<VPubMember> vpmList = vpmop.findByPubID(eElem.pubID);
				pubItem.add(fillPubItem(eElem, vpmList));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			epop.close ();
			vpmop.close ();
		}

		return pubItem;
	}

	static public List<PubItem> getPubItems(String memberID) {
		List<VPubMember> vpList = null;
		List<PubItem> pubItem = new ArrayList<PubItem>();
		
		EPublicationOP epop = null;
		VPubMemberOP vpmop = null;
		try {
			epop = new EPublicationOP();
			vpmop = new VPubMemberOP();
			vpList = vpmop.findByMemberID(memberID);
			for (VPubMember vpElem : vpList) {
				EPublication ep = epop.findByPubID(vpElem.pubID);
				List<VPubMember> vpmList = vpmop.findByPubID(ep.pubID);

				pubItem.add(fillPubItem(ep, vpmList));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			epop.close ();
			vpmop.close ();
		}
		return pubItem;
	}

	public static PubItem getPubItem(String pubID) {
		// TODO Auto-generated method stub
		PubItem ret = null;

		EPublicationOP epop = null;
		VPubMemberOP vpmop = null;
		try {
			epop = new EPublicationOP();
			vpmop = new VPubMemberOP();
			EPublication ep = epop.findByPubID(pubID);
			List<VPubMember> vpmList = vpmop.findByPubID(pubID);

			ret = fillPubItem(ep, vpmList);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			epop.close ();
			vpmop.close ();
		}
		return ret;
	}
}
