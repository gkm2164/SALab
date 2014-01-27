package kr.ac.kaist.salab.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.servlets.services.EmptyPageDesc;
import kr.ac.kaist.salab.servlets.services.PageDescription;

abstract public class NavNode extends NavComponent {
	private ArrayList<NavComponent> childNodes = null;
	private HashMap<String, NavComponent> childNodesHash = null;

	public NavNode(String servletName, String name, NavNode parent) {
		super(servletName, name, parent);
		childNodes = new ArrayList<NavComponent>();
		childNodesHash = new HashMap<String, NavComponent>();
	}

	public NavNode(String servletName, String name) {
		this(servletName, name, null);
	}

	public ArrayList<NavComponent> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(ArrayList<NavComponent> childNodes) {
		this.childNodes = childNodes;
	}

	@Override
	public int childSize() {
		// TODO Auto-generated method stub
		return childNodes.size();
	}

	public void toArray(NavComponent[] narr) {
		// TODO Auto-generated method stub
		childNodes.toArray(narr);
	}

	public void attachChild(NavComponent newNode) {
		// TODO Auto-generated method stub
		String servletName = newNode.getServletName();
		childNodes.add(newNode);
		childNodesHash.put(servletName, newNode);
	}

	public NavNode createChild(String servletName, String name) {
		return new NavNode(servletName, name, this) {
			@Override
			public PageDescription setPageEnv(HttpServletRequest request) {
				// TODO Auto-generated method stub
				return new EmptyPageDesc();
			}
		};
	}

	public NavLeaf createChildLeaf(String servletName, String name) {
		return new NavLeaf(servletName, name, this) {
			@Override
			public PageDescription setPageEnv(HttpServletRequest request) {
				// TODO Auto-generated method stub
				return new EmptyPageDesc();
			}
		};
	}

	public Iterator<NavComponent> childIterator() {
		return new NavNodeIterator(childNodes);
	}

	public NavComponent findChild(String servlet) {
		// TODO Auto-generated method stub
		return childNodesHash.get(servlet);
	}

	@Override
	public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		NavComponent[] ret = new NavComponent[childNodes.size()];
		childNodes.toArray(ret);
		return ret;
	}

	@Override
	abstract public PageDescription setPageEnv(HttpServletRequest request);

}
