package ash.com.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectionMap {
	public static List<Connection> getConnectionMap() {
		List<Connection> connectionList = new ArrayList<>();
		connectionList.add(new Connection("A","B"));
		connectionList.add(new Connection("A","C"));
		connectionList.add(new Connection("A","D"));
		connectionList.add(new Connection("D","C"));
		connectionList.add(new Connection("B","A"));
		connectionList.add(new Connection("C","E"));
		connectionList.add(new Connection("D","B"));
		return connectionList;
	}
}
