package net.codestory;

import javax.ws.rs.*;
import java.io.*;
import java.util.*;

@Path("/")
public class CodeStoryResource {
	@GET
	public File index() {
		return new File("index.html");
	}

	@GET
	@Path("commits")
	@Produces("application/json;charset=UTF-8")
	public List<Commit> commits() {
		return new AllCommits().list();
	}

	@GET
	@Path("{path: .* }")
	@Produces("application/javascript;charset=UTF-8")
	public File script(@PathParam("path") String path) {
		return new File(path);
	}
}
