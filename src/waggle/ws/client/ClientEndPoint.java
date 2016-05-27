package waggle.ws.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ClientEndPoint{
	private Session session;
	
	public ClientEndPoint() throws URISyntaxException, DeploymentException, IOException {
		URI uri = new URI("ws://localhost:8080/trial");
		ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client: Session opened with WS Server: " + session.getId());
		this.session = session;
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		System.out.println("Client received: Msg: " + message + " on session: " + session.getId());
	}
	
	public void sendMessage(String message) throws IOException {
		session.getBasicRemote().sendText(message);
	}
}