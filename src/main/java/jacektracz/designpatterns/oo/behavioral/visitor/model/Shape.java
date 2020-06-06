package jacektracz.designpatterns.oo.behavioral.visitor.model;

import jacektracz.designpatterns.oo.behavioral.visitor.ShapeVisitor;

public interface Shape {
	void accept(ShapeVisitor visitor);
}
