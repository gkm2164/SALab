package kr.ac.kaist.salab.page;

import kr.ac.kaist.salab.servlets.PageServlet;
import kr.ac.kaist.salab.servlets.services.Page;

/**
 * @author Gyeongmin
 * 
 *         Navigation tree를 관리하는 녀석... 재미좀 보셈ㅋㅎ
 */
public class NavTree {
	private NavRoot nroot = null;
	private NavTreeConstructor ntc = null;
	private NavRoot badaccess;

	public NavTree(NavTreeConstructor ntc) {

		String absPath = PageServlet.thisConf.getAbsolutePath();
		// TODO Auto-generated constructor stub
		this.ntc = ntc;
		nroot = new NavRoot(absPath, null);
		badaccess = new NavRoot(absPath, new BadPage());

		initTree();

	}

	public void initTree() {
		nroot.setDefaultPage(ntc.initTree(nroot));

	}

	public NavNode[] getNavArrays() {
		return null;
	}

	public NavComponent[] getGlobalNavs() {
		// TODO Auto-generated method stub
		NavComponent[] narr = new NavComponent[nroot.childSize()];
		nroot.toArray(narr);
		return narr;
	}

	public NavComponent[] getLocalNavs(String path) {
		String[] tokens = path.split("/");

		NavComponent[] ret = null;
		NavComponent child = nroot.findChild(tokens[0]);

		if (child instanceof NavLeaf) {
			return null;
		}

		NavNode nChild = (NavNode) child;
		if (child == null || nChild.childSize() <= 0) {
			return null;
		}

		ret = new NavComponent[nChild.childSize()];
		nChild.toArray(ret);
		return ret;
	}

	public Page findService(String reqString) {
		// TODO Auto-generated method stub
		reqString = reqString.substring(reqString.indexOf('/') + 1);
		if (reqString.length() == 0) {
			return nroot;
		}
		return findService(nroot, reqString);
	}

	private Page findService(NavNode nav, String servlet) {
		int nextSplit = servlet.indexOf('/');
		if (nextSplit == -1) {
			nextSplit = servlet.length();
		}
		String name = servlet.substring(0, nextSplit);
		NavComponent ncChild = nav.findChild(name);

		if (ncChild == null) {
			return badaccess;
		} else if (ncChild instanceof NavLeaf || servlet.length() == nextSplit) {
			return ncChild;
		}

		return findService((NavNode) ncChild, servlet.substring(nextSplit + 1));
	}
}