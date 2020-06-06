package jacektracz.designpatterns.oo.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

import jacektracz.designpatterns.oo.behavioral.visitor.model.Circle;
import jacektracz.designpatterns.oo.behavioral.visitor.model.Shape;
import jacektracz.designpatterns.oo.behavioral.visitor.model.Square;

public class VisitorPlay {

	public static void main(String[] args) {
		List<Shape> shapes = Arrays.asList(
				new Square(10), 
				new Circle(5), 
				new Square(5));

		PerimeterCalculatorVisitor perimeterCalculator = new PerimeterCalculatorVisitor();
		for (Shape shape : shapes) {
			shape.accept(perimeterCalculator);
		}
		System.out.println("Total perimeter: " + perimeterCalculator.getTotal());


		System.out.println("Total area: " + 0); // TODO

	}

}
