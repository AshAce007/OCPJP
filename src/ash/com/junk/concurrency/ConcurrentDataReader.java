package ash.com.junk.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentDataReader {
	
	private final String url;
	private final ExecutorService executorService;
	
	
	public ConcurrentDataReader(String url, ExecutorService executorService) {
		super();
		this.url = url;
		this.executorService = executorService;
	}
	
	private BufferedReader establishConnection() throws IOException {
		URL remote = new URL(url);
		return new BufferedReader(new InputStreamReader(remote.openStream()));
	}
	
	private Future<String> readALine(BufferedReader buffReader) {
		return executorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return buffReader.readLine();
			}
		});
	}
	
	private void executeReadFromRemote() throws IOException, InterruptedException, ExecutionException {
		ConcurrentDataReader dataReader = new ConcurrentDataReader(url, executorService);
		BufferedReader buffReader = dataReader.establishConnection();
		int line = 0;
		while(line++ < 20) {
			System.out.println(dataReader.readALine(buffReader).get());
			Thread.sleep(500);
		}
		System.out.println("going to shutdown executor service....");
		executorService.shutdown();
		if(!executorService.isShutdown()) {
			System.out.println("executor service didn't shutdown.");
			executorService.shutdownNow();
		}
		System.out.println("shutdown properly.");
	}
	
	public static void main(String... args) {
		try {
			new ConcurrentDataReader("http://norvig.com/big.txt", Executors.newSingleThreadExecutor()).executeReadFromRemote();
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
