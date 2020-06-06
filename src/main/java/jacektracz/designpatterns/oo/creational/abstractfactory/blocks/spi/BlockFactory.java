package jacektracz.designpatterns.oo.creational.abstractfactory.blocks.spi;

public interface BlockFactory {
	Board createBoard();
	Cube createCube();
}
