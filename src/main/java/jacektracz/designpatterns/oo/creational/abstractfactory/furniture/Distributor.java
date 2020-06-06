package jacektracz.designpatterns.oo.creational.abstractfactory.furniture;

import java.util.ArrayList;
import java.util.List;

import jacektracz.designpatterns.oo.creational.abstractfactory.furniture.spi.FurnitureFactory;

public class Distributor {

	private final FurnitureFactory factory;

	public Distributor(FurnitureFactory factory) {
		this.factory = factory;
	}

	public List<Object> getKitchenFurniture() {
		List<Object> objects = new ArrayList<>();
		objects.add(factory.createTable());
		for (int i = 0; i < 4; i++) {
			objects.add(factory.createChair());
		}
		// TODO add Stand product to the kitchen furniture
		return objects;
	}
}
