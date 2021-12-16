package com.jacektracz.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LakidaNode {
	
	int value;
	List<LakidaNode> neighbors;

	public LakidaNode(int value) {
		this.value = value;
		neighbors = new ArrayList<>();
	}
	
	public void addEdge(LakidaNode to) {
		neighbors.add(to);
	}
}
