package kr.ac.kaist.salab.page;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.servlets.services.PageDescription;

abstract public class NavLeaf extends NavComponent {
	public NavLeaf(String servletName, String name, NavNode parent) {
		// TODO Auto-generated constructor stub
		super(servletName, name, parent);
	}

	public NavLeaf(String servletName, String name) {
		this(servletName, name, null);
	}

	@Override
	final public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		return parent.getLocalNavs();
	}

	@Override
	abstract public PageDescription setPageEnv(HttpServletRequest request);
}
