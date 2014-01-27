package kr.ac.kaist.salab.servlets.services;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavComponent;

public interface Page {
	public NavComponent[] getLocalNavs();

	public PageDescription setPageEnv(HttpServletRequest request);

	public void setArgument(String[] reqString);
}
