package jacektracz.designpatterns.oo.behavioral.visitor;

import jacektracz.designpatterns.oo.behavioral.visitor.model.Circle;
import jacektracz.designpatterns.oo.behavioral.visitor.model.Square;

public interface ShapeVisitor {
	void visit(Square square);
	void visit(Circle circle);
}
