package jacektracz.designpatterns.oo.creational.abstractfactory.blocks.spi;

public interface Cube {
	void stackOnto(Cube anotherCube);
	void putOn(Board board);
}
