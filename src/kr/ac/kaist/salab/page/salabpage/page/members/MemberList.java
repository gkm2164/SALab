package kr.ac.kaist.salab.page.salabpage.page.members;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kaist.salab.page.salabpage.page.pubs.PubItem;

public class MemberList {
	String memberID;
	String memberName;
	String currentWork;
	Date enterDate;
	String email;
	String privateWeb;
	String statusName;
	String areaName;
	List<PubItem> pubItem;

	public MemberList (String memberID, String memberName, String currentWork,
			Date enterDate, String email, String privateWeb, String statusName,
			String areaName, List<PubItem> pubItem) {
		this.memberID = memberID;
		this.memberName = memberName;
		this.currentWork = currentWork;
		this.enterDate = enterDate;
		this.email = email;
		this.privateWeb = privateWeb;
		this.statusName = statusName;
		this.areaName = areaName;
		this.pubItem = pubItem;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCurrentWork() {
		return currentWork;
	}

	public void setCurrentWork(String currentWork) {
		this.currentWork = currentWork;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrivateWeb() {
		return privateWeb;
	}

	public void setPrivateWeb(String privateWeb) {
		this.privateWeb = privateWeb;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setAreaName(ArrayList<String> areas) {
		this.areaName = areas.toString().replace("[", "").replace("]", "");
	}

	public List<PubItem> getPubItem() {
		return pubItem;
	}

	public void addPubItem(PubItem pi) {
		pubItem.add(pi);
	}

	public void addPubItem(List<PubItem> piList) {
		for (PubItem elem : piList) {
			pubItem.add(elem);
		}
	}
	
	public String concat (String a, String b, String c) {
		return a + b + c;
	}
}