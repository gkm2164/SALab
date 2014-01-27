package kr.ac.kaist.salab.pubs.util.pubparser;

import java.io.StringWriter;

public interface StringProcess {
	public StringWriter dest = null;
	public StringGather src = null;
	public void setSource (StringGather src);
}
