package jacektracz.designpatterns.oo.creational.abstractfactory.furniture;

import javax.xml.parsers.DocumentBuilderFactory;

import jacektracz.designpatterns.oo.creational.abstractfactory.furniture.spi.FurnitureFactory;
import jacektracz.designpatterns.oo.creational.abstractfactory.furniture.valeni.ValeniFurnitureFactory;

import java.util.List;

public class FactoryPlay {

	public static void main(String[] args) {
		FurnitureFactory factory = new ValeniFurnitureFactory();

		Distributor distributor = new Distributor(factory);

		List<Object> kitchen = distributor.getKitchenFurniture();

		System.out.println("Delivered objects: " + kitchen);

		// 2
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
	}
}
