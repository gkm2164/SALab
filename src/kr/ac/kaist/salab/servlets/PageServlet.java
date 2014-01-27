package kr.ac.kaist.salab.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kaist.salab.database.DBMSConnector;
import kr.ac.kaist.salab.page.NavComponent;
import kr.ac.kaist.salab.page.NavTree;
import kr.ac.kaist.salab.page.NavTreeConstructor;
import kr.ac.kaist.salab.servlets.confs.Configurations;
import kr.ac.kaist.salab.servlets.services.Page;
import kr.pe.imarch.utils.XMLDocument;
import kr.pe.imarch.utils.XMLParser;

public class PageServlet extends HttpServlet {

	static public Configurations thisConf = null;
	
	private String absolutePath = "";
	private NavTree nTree = null;
	private NavComponent[] globalNavs = null;
	private Boolean initialized = false;

	private static final long serialVersionUID = -3078384614801544999L;

	public PageServlet() {
		super();
	}
	
	private synchronized Boolean setInit (Boolean initialized) {
		Boolean ret = this.initialized;
		this.initialized = initialized;
		return ret;
	}

	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println ("Init!");
		XMLParser parser = new XMLParser();
		ServletContext sc = conf.getServletContext();
		
		String realPath = sc.getRealPath("/WEB-INF/conf/page-info.xml");
		DBMSConnector.PROP_PATH = sc.getRealPath("/WEB-INF/conf/jdbc.properties");
		
		XMLDocument xmldoc = null;
		Class<?> cls = null;
		NavTreeConstructor ntc = null;
		
		try {
			xmldoc = parser.parseXML(realPath);
			thisConf = new Configurations(xmldoc, sc.getRealPath ("/"));
			cls = thisConf.getInstantiator ();
			ntc = (NavTreeConstructor)cls.newInstance();
			
			setInit (true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			setInit (false);
		} finally {
			System.out.println ("Configuration info: " + thisConf);
		}
		
		nTree = new NavTree (ntc);
		absolutePath = thisConf.getAbsolutePath();
		globalNavs = nTree.getGlobalNavs();
	}

	private void setEnvironment(HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* menus */
		if (initialized == false) {
			PrintWriter out = response.getWriter();
			out.println ("Site is currently not being initialized.");
			return;
		}
		
		String reqString = request.getServletPath();
		reqString = request.getServletPath();

		Page page = nTree.findService(reqString);
		NavComponent[] localNavs = page.getLocalNavs();

		setEnvironment(request, response);

		page.setArgument(reqString.split("/"));

		request.setAttribute("ABSPATH", absolutePath);
		request.setAttribute("NAVS", globalNavs);
		request.setAttribute("LNAVS", localNavs);
		request.setAttribute("PDESC", page.setPageEnv(request));

		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/JSPS/main.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
