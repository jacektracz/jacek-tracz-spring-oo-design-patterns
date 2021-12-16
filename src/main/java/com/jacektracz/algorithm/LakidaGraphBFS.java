package com.jacektracz.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class LakidaGraphBFS {
	
    public static void mainExec() {
    
        // Constructing the graph
        LakidaNode n0 = new LakidaNode(0);
        LakidaNode n1 = new LakidaNode(1);
        LakidaNode n2 = new LakidaNode(2);
        LakidaNode n3 = new LakidaNode(3);
        LakidaNode n4 = new LakidaNode(4);
        LakidaNode n5 = new LakidaNode(5);

        n0.addEdge(n1);
        n1.addEdge(n0);
        n1.addEdge(n3);
        n1.addEdge(n2);
        n2.addEdge(n1);
        n2.addEdge(n4);
        n3.addEdge(n1);
        n3.addEdge(n4);
        n3.addEdge(n5);
        n4.addEdge(n2);
        n4.addEdge(n3);
        n5.addEdge(n3);


        // Traversal methods

        System.out.println("BFS Iterative:");

        System.out.println("DFS Iterative:");
        dfsIterative(n0);
        System.out.println();

        System.out.println("DFS Recursive:");
        dfsRecursive(n0, new HashSet<Integer>());
    
    }
    

    public static void dfsIterative(LakidaNode startNode) {
        Stack<LakidaNode> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            LakidaNode currentNode = stack.pop();
            
            if (!visited.contains(currentNode.value)) {
                System.out.println(currentNode.value);
                visited.add(currentNode.value);
            }
            
            for (LakidaNode n : currentNode.neighbors) {
                if (!visited.contains(n.value)) {
                    stack.push(n);
                }
            }
        }
    }

    public static void dfsRecursive(LakidaNode startNode, Set<Integer> visited) {
        System.out.println(startNode.value);
        visited.add(startNode.value);
        
        for (LakidaNode n : startNode.neighbors) {
            if (!visited.contains(n.value)) {
                dfsRecursive(n, visited);
            }
        }
    }
    
    
}