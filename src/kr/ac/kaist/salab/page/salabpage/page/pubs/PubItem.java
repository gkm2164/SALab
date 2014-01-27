package kr.ac.kaist.salab.page.salabpage.page.pubs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PubItem {
	public class PubMember {
		public String memberID;
		public String memberName;

		/**
		 * @param memberID
		 * @param memberName
		 */
		public PubMember(String memberID, String memberName) {
			this.memberID = memberID;
			this.memberName = memberName;
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
	};

	public class PubArea {
		public String areaID;
		public String areaName;

		/**
		 * @param areaID
		 * @param areaName
		 */
		public PubArea(String areaID, String areaName) {
			this.areaID = areaID;
			this.areaName = areaName;
		}

		public String getAreaID() {
			return areaID;
		}

		public void setAreaID(String areaID) {
			this.areaID = areaID;
		}

		public String getAreaName() {
			return areaName;
		}

		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
	};

	private String pubID;
	private String title;
	private List<PubMember> nameList;
	private List<PubArea> pubArea;
	private String pubType;
	private String pubNation;
	private String pubDesc;
	private Date pubDate;
	private String formatID;

	public String getPubID() {
		return pubID;
	}

	public String getTitle() {
		return title;
	}

	public List<PubMember> getNameList() {
		return nameList;
	}

	public List<PubArea> getPubArea() {
		return pubArea;
	}

	public String getPubType() {
		return pubType;
	}

	public String getPubNation() {
		return pubNation;
	}

	public String getPubDesc() {
		return pubDesc;
	}

	public Date getPubDate() {
		return pubDate;
	}

	/**
	 * @param pubID
	 * @param pubType
	 * @param pubNation
	 * @param pubDesc
	 * @param pubDate
	 */
	public PubItem(String pubID, String title, String pubType,
			String pubNation, String pubDesc, Date pubDate, String formatID) {
		this.pubID = pubID;
		this.title = title;
		this.nameList = new ArrayList<PubMember>();
		this.pubArea = new ArrayList<PubArea>();
		this.pubType = pubType;
		this.pubNation = pubNation;
		this.pubDesc = pubDesc;
		this.pubDate = pubDate;
		this.formatID = formatID;
	}

	public PubItem addName(String id, String name) {
		nameList.add(new PubMember(id, name));
		return this;
	}

	public PubItem addArea(String id, String area) {
		pubArea.add(new PubArea(id, area));
		return this;
	}

	public String getFormatID() {
		return formatID;
	}

	public void setFormatID(String formatID) {
		this.formatID = formatID;
	}
}
