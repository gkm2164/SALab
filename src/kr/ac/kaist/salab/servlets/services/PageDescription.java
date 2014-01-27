package kr.ac.kaist.salab.servlets.services;

import java.util.ArrayList;
import java.util.List;

public class PageDescription {
	private String title;
	private ArrayList<String> pageCSS;
	private ArrayList<String> pageJS;
	private String pageFileName;

	public PageDescription(String title, String pageFileName) {
		this.title = title;
		this.pageFileName = pageFileName;
		pageCSS = new ArrayList<String>();
		pageJS = new ArrayList<String>();
	}

	/* Decorator pattern */
	public PageDescription addCSS(String cssURL) {
		pageCSS.add(cssURL);

		return this;
	}

	public PageDescription addJS(String jsURL) {
		pageJS.add(jsURL);

		return this;
	}

	public PageDescription setPageFileName(String pageFileName) {
		this.pageFileName = pageFileName;

		return this;
	}

	public PageDescription setTitle(String title) {
		this.title = title;

		return this;
	}

	public List<String> getPageCSS() {
		return pageCSS;
	}

	public List<String> getPageJS() {
		return pageJS;
	}

	public String getPageFileName() {
		return pageFileName;
	}

	public String getTitle() {
		return title;
	}

}
