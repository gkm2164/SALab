package kr.ac.kaist.salab.page;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.servlets.services.EmptyPage;
import kr.ac.kaist.salab.servlets.services.Page;
import kr.ac.kaist.salab.servlets.services.PageDescription;

public class NavRoot extends NavNode {
	Page defaultPage = null;

	public NavRoot(String absolutePath, Page defaultPage) {
		super(absolutePath, "root");
		if (defaultPage != null) {
			this.defaultPage = defaultPage;
		} else {
			this.defaultPage = new EmptyPage();
		}
		// TODO Auto-generated constructor stub
	}

	public void setDefaultPage(Page page) {
		defaultPage = page;
	}

	public NavRoot(String servletName, String name, NavNode parent) {
		super(servletName, name, parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	final public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return defaultPage.setPageEnv(request);
	}
}
