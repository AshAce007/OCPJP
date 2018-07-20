package ash.com.graph;

import java.util.List;
import java.util.stream.Collectors;

public class Executable {
	public static void main(String[] args) {
		List<Connection> connections = ConnectionMap.getConnectionMap();
		connections.stream().collect(Collectors.groupingBy(Connection::getConnectedFrom)).values().forEach(System.out::println);
	}
}
