package kr.ac.kaist.salab.page;

import kr.ac.kaist.salab.servlets.services.Page;

abstract public class NavComponent implements NavOperator, Page {
	private String servletName = "";
	private String name = "";
	protected NavNode parent = null;
	private boolean globalExposeChild = true;
	private boolean localExposeChild = true;
	private boolean exposeOnGlobalNav = true;
	public boolean isExposeOnGlobalNav() {
		return exposeOnGlobalNav;
	}

	public void setExposeOnGlobalNav(boolean exposeOnGlobalNav) {
		this.exposeOnGlobalNav = exposeOnGlobalNav;
	}

	public boolean isExposeOnLocalNav() {
		return exposeOnLocalNav;
	}

	public void setExposeOnLocalNav(boolean exposeOnLocalNav) {
		this.exposeOnLocalNav = exposeOnLocalNav;
	}

	private boolean exposeOnLocalNav = true;

	public NavComponent(String servletName, String name) {
		this.servletName = servletName;
		this.name = name;
		this.parent = null;
		this.globalExposeChild = true;
		this.localExposeChild = true;
	}

	public NavComponent(String servletName, String name, NavNode parent) {

		// TODO Auto-generated constructor stub
		this.servletName = servletName;
		this.name = name;

		if (parent != null) {
			this.parent = parent;
			parent.attachChild(this);
		}
		this.globalExposeChild = true;
		this.localExposeChild = true;
	}

	@Override
	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	@Override
	public String getServletPath() {
		if (parent == null) {
			return String.format("%s", servletName);
		}
		return String.format("%s/%s", parent.getServletPath(), servletName);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NavNode getParent() {
		return parent;
	}

	public void setParent(NavNode parent) {
		this.parent = parent;
	}

	@Override
	public int childSize() {
		return 0;
	}

	public boolean isGlobalExposeChild() {
		return globalExposeChild;
	}

	public void setGlobalExposeChild(boolean globalExposeChild) {
		this.globalExposeChild = globalExposeChild;
	}

	public boolean isLocalExposeChild() {
		return localExposeChild;
	}

	public void setLocalExposeChild(boolean localExposeChild) {
		this.localExposeChild = localExposeChild;
	}

	@Override
	public void setArgument(String[] args) { /* Ignore */
	}
}
