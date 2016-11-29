package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api(value = "Api for querying cars")
public class CarResource {

	@GET
	@ApiOperation(value = "get  all cars")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getCars(@QueryParam("page") int page,
			@QueryParam("perPage") int perPage, @QueryParam("withModel") String withModel) {

		CarService carService = CarService.getInstance();
		PagedResponse carsInPage = carService.getUsersInPagesFiltered(page, perPage, withModel);

		return carsInPage;
	}

	@POST
	@ApiOperation(value = "create new car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(Car car) {
		CarService.getInstance().addCar(car);
		return Response.ok(car).status(Status.CREATED).build();
	}
}
