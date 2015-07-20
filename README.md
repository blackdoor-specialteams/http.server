#blackdoor http server
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/blackdoor/http.server?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)  
####master: [![Build Status](https://travis-ci.org/blackdoor/http.server.svg?branch=master)](https://travis-ci.org/blackdoor/http.server) 
####dev: [![Build Status](https://travis-ci.org/blackdoor/http.server.svg?branch=dev)](https://travis-ci.org/blackdoor/http.server)  

----
##### blackdoor http is... some kinda' thing.  
* lightweight
* quick
* reactive
* simple

## Quick Start  
### New Project from Maven Archetype
### Creating an Endpoint
There are several ways to define behavior for a certain HTTP method and path. See them all [here](https://github.com/blackdoor/http.server/wiki/Creating-Controllers).  
The quickest way to get an endpoint working is with a functional controller and is actually very similar to Go.
##### Create a Server
		HttpServer server = new HttpServer();
##### Add a Behavior
The addBehavior(HttpVerb, String, HttpFunction) method takes, obviously a HTTP method, as well as a regex used to match the paths you want the controller to run on and a lambda describing what to do when it does run.

		server.addBehavior(HttpVerb.GET, "^/hello/?$", (request, params)->{
			HttpResponse response = StandardResponses.OK.getResponse();
			response.setBody("Hello world".getBytes());
			return response;
		});
##### Start the Server
		server.run(); 
<!--- The creation and explicit start of the server should not be needed after creation of the Archetype -->
That's it! The server runs on port 80 by default and pointing your browser to localhost/hello should greet you with a "Hello world" message.
## Full Tutorial
A complete tutorial can be found on the [github wiki](https://github.com/blackdoor/http.server/wiki/Tutorial).