package com.jacektracz.letcode.mergeklists;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.Ignore;
import org.junit.jupiter.api.Test;

public class SolutionData {
	
	
    
	public ListNode getList_OneNodes() {
		ListNode ll = new ListNode(1);
		return ll;
	}
	
	public ListNode getList_TwoNodes() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		return l1;
	}
	
	public ListNode getList_ThreeNodes() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		ListNode l3 = new ListNode(2);
		l2.next = l3;		
		return l1;
	}
	
	public ListNode getList_Nodes(int max,int val_step,int start_value) {
		
		int val_current = start_value;
		if(val_current > val_step) {
			val_current = 1;	
		}						
		
		ListNode ll_current = new ListNode(val_current);
		ListNode ll_root = ll_current;
		
		val_current ++;
		
		for (int ii = 1 ; ii < max; ii++) {
			if(val_current > val_step) {
				val_current = 1;	
			}						
			ListNode ll_next = new ListNode(val_current);
			ll_current.next = ll_next;
			ll_current = ll_next;
			val_current ++;
		}		
		return ll_root;
	}

	
	public ListNode[] getLists_WithOneNodes(int max,int val_step,int start_value) {
		
		int val_current = start_value;
		
		ListNode[] ll_out = new ListNode[max];
				
		for (int ii = 0 ; ii < max; ii++) {
			if(val_current > val_step) {
				val_current = 1;	
			}						
			ListNode ll_next = new ListNode(val_current);
			ll_out[ii] = ll_next;
			val_current++;
		}
		
		return ll_out;
		
	}
	
	public static  ListNode getList_OneNodesS() {
		ListNode ll = new ListNode(1);
		return ll;
	}
	
	public static ListNode getList_TwoNodesS() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		return l1;
	}
	
	public static ListNode getList_ThreeNodesS() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		l1.next = l2;
		ListNode l3 = new ListNode(2);
		l2.next = l3;		
		return l1;
	}
	
	public static ListNode getList_ZeroValueNode() {
		ListNode l1 = new ListNode();
		return l1;
	}
	
	public static ListNode getList_NullModeS() {
		ListNode l1 = null;
		return l1;
	}	
	
	//[[1,1,3,3,3],[2,2,2]]
}
