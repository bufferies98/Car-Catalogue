package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
	private static CarService instance;

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	private List<Car> carList = new ArrayList<>();

	public CarService() {
		for (int i = 0; i < 50; i++) {
			carList.add(new Car("BMW", 300, 200, 2015));
			carList.add(new Car("Porshe", 320, 220, 2012));
			carList.add(new Car("Mercedes", 250, 180, 2010));
			carList.add(new Car("Lotus", 420, 250, 2014));
			carList.add(new Car("Trabant", 450, 280, 2000));
			carList.add(new Car("Lada", 150, 80, 1963));
		}
	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}

	public void addCar(Car car) {
		carList.add(car);
	}

	public PagedResponse getUsersInPagesFiltered(int page, int perPage, String withModel) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getModel().equals(withModel) || withModel == null || "".equals(withModel))
				.skip(previousEntries).limit(perPage).collect(Collectors.toList());

		int totalPages = (int) Math.ceil(((double) carList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);

		return response;
	}

	public List<String> getAllDistinctCarModels() {
		return carList.stream()
				.map((u) -> u.getModel())
				.distinct()
				.collect(Collectors.toList());
	}
}
