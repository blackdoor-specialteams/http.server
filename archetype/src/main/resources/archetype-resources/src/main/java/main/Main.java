package ${packageName}.main;

import black.door.net.http.server.HttpServer;
import black.door.net.http.server.responses.StandardResponses;
import black.door.net.http.tools.HttpResponse;
import black.door.net.http.tools.HttpVerb;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.setUp();
		main.defineRoutes();
		main.start();
	}

	private HttpServer server;

	public Main(){
		server = new HttpServer();
	}

	private void setUp(){

	}

	private void defineRoutes(){

		server.addBehavior(HttpVerb.GET, "/hello", (request, params)->{
			HttpResponse response = StandardResponses.OK.getResponse();
			response.setBody("Hello world".getBytes());
			return response;
		});

	}

	private void start(){
		server.run();
	}
}