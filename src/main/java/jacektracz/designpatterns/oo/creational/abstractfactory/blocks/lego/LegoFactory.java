package jacektracz.designpatterns.oo.creational.abstractfactory.blocks.lego;

import jacektracz.designpatterns.oo.creational.abstractfactory.blocks.spi.BlockFactory;
import jacektracz.designpatterns.oo.creational.abstractfactory.blocks.spi.Board;
import jacektracz.designpatterns.oo.creational.abstractfactory.blocks.spi.Cube;

public class LegoFactory implements BlockFactory {

	@Override
	public Board createBoard() {
		return new LegoBoard();
	}

	@Override
	public Cube createCube() {
		return new LegoCube();
	}

}
