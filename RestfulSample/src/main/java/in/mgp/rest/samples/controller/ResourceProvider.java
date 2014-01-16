/**
 * 
 */
package in.mgp.rest.samples.controller;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

/**
 * @author GPS
 * 
 */
@Component
@Path("/")
public class ResourceProvider {

	public Response getProcessedInfo(@Context UriInfo info ){
		
		return new ResponseBuilderImpl().build();
	}
	
}
