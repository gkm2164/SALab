package kr.ac.kaist.salab.taglib;

import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import kr.ac.kaist.salab.database.tableop.EPubMetaFormatOP;
import kr.ac.kaist.salab.database.tableop.EPubMetaFormatOP.EPubMetaFormat;
import kr.ac.kaist.salab.pubs.util.pubparser.Parser;

public class PublicationTag extends SimpleTagSupport {
	private String var;
	private String format;
	private String desc;

	public void setVar(String var) {
		this.var = var;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private String readFormatString() {
		String formatString = "";
		try {
			EPubMetaFormatOP epmfop = new EPubMetaFormatOP();
			EPubMetaFormat epmf = epmfop.findByFormatID(format);
			formatString = epmf.formatString;
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formatString;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = this.getJspContext();

		String formatString = readFormatString();
		String ret = makeString(formatString, desc);
		System.out.println (desc);
		context.setAttribute(var, ret);
		JspFragment body = getJspBody();
		body.invoke(null);
	}

	private String makeString(String formatString, String pubDesc) {
		// TODO Auto-generated method stub
		Parser p = new Parser();
		StringReader sr = new StringReader (pubDesc);
		return p.parseToFormat(formatString, sr);
	}
}
