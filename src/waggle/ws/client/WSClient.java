package waggle.ws.client;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.websocket.DeploymentException;

public class WSClient {

	public static void main(String[] args) throws URISyntaxException, DeploymentException, IOException, InterruptedException {
		System.out.println("Started WSClient main.");
		
		ClientEndPoint clientEndPoint = new ClientEndPoint();
		clientEndPoint.sendMessage("hello from java client.");
		
		Thread.sleep(100000);
	}
}
