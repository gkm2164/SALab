package kr.ac.kaist.salab.servlets.confs;

import org.w3c.dom.Element;

import kr.pe.imarch.utils.XMLDocument;

public class Configurations {

	private String instantiator;
	private String protocolType;
	private String domainName;
	private String port;
	private String absolutePath;

	private String dbPort;
	private String dbID;
	private String dbPassword;
	private String dbDomainName;
	private String dbSID;
	private String servletPath;
	
	public Configurations(XMLDocument xmldoc, String servletPath) {
		/* Divide by step. */
		/* Address Information initialization */
		
		initInstantiator (xmldoc);
		initAddrInfo (xmldoc);
		initDBConnInfo (xmldoc);
		
		this.servletPath = servletPath; 
	}
	
	private void initInstantiator (XMLDocument xmldoc) {
		Element inst = xmldoc.readTagOne("Instantiator");
		instantiator = inst.getTextContent();
	}
	
	private void initAddrInfo (XMLDocument xmldoc) {
		Element addrInfo = xmldoc.readTagOne("AddressInformation");
		Element eProtocolType = xmldoc.readTagOne(addrInfo, "ProtocolType"),
				eDomainName = xmldoc.readTagOne(addrInfo, "DomainName"),
				ePort = xmldoc.readTagOne(addrInfo, "Port"),
				eAbsolutePath = xmldoc.readTagOne(addrInfo, "AbsolutePath");

		protocolType = eProtocolType.getTextContent();
		domainName = eDomainName.getTextContent();
		port = ePort.getTextContent();
		absolutePath = eAbsolutePath.getTextContent();
	}
	
	private void initDBConnInfo (XMLDocument xmldoc) {
		Element dbInfo = xmldoc.readTagOne("DatabaseInformation");
		Element eDbDomainName = xmldoc.readTagOne(dbInfo, "DomainName"),
				eDbPort = xmldoc.readTagOne(dbInfo, "Port"),
				eDbSID = xmldoc.readTagOne(dbInfo, "SID"),
				eDbID = xmldoc.readTagOne(dbInfo, "ID"),
				eDbPassword = xmldoc.readTagOne(dbInfo, "Password");
		dbDomainName = eDbDomainName.getTextContent();
		dbPort = eDbPort.getTextContent();
		dbSID = eDbSID.getTextContent ();
		dbID = eDbID.getTextContent();
		dbPassword = eDbPassword.getTextContent();
	}

	public String getAbsolutePath() {
		
		String fmt = "%s://%s:%s/%s";
		String ret = String.format(fmt, protocolType, domainName, port,
				absolutePath);
		return ret;
	}

	public String getDBConnectionURL() {
		String fmt = "jdbc:oracle:thin:@%s:%s:%s";
		String ret = String.format(fmt, dbDomainName, dbPort, dbSID);
		return ret;
	}
	
	@Override
	public String toString () {
		return getAbsolutePath () + " || " + getDBConnectionURL ();
	}
	
	public String getDBID () { return dbID; }
	
	public String getDBPassword () { return dbPassword; }

	public Class<?> getInstantiator() throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return Class.forName (instantiator);
	}

	public String getServletPath() {
		// TODO Auto-generated method stub
		return servletPath;
	}
}
