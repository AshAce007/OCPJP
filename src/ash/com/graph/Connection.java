package ash.com.graph;

public class Connection {
	private String connectedFrom;
	private String connectedTo;
	public Connection(String connectedFrom, String connectedTo) {
		this.connectedFrom = connectedFrom;
		this.connectedTo = connectedTo;
	}
	public String getConnectedFrom() {
		return connectedFrom;
	}
	public void setConnectedFrom(String connectedFrom) {
		this.connectedFrom = connectedFrom;
	}
	public String getConnectedTo() {
		return connectedTo;
	}
	public void setConnectedTo(String connectedTo) {
		this.connectedTo = connectedTo;
	}
	
	public String toString() {
		return this.connectedFrom;
	}
}
