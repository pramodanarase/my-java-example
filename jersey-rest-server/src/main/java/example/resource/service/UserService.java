package example.resource.service;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import example.webapp.resource.User;

@Path("user")
public class UserService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(){
		return new User("pramod", "pramod@ml.com");
	}
}
