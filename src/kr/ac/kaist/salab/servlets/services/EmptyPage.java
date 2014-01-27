package kr.ac.kaist.salab.servlets.services;

import javax.servlet.http.HttpServletRequest;

import kr.ac.kaist.salab.page.NavComponent;

public class EmptyPage implements Page {

	public EmptyPage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public NavComponent[] getLocalNavs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageDescription setPageEnv(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new EmptyPageDesc();
	}

	@Override
	public void setArgument(String[] reqString) {
		// TODO Auto-generated method stub

	}
}