package jacektracz.designpatterns.oo.creational.abstractfactory.furniture.spi;


public interface FurnitureFactory {
	Chair createChair();

	Table createTable();
}
