package com.jacektracz.letcode.mergeklists;


import org.junit.jupiter.api.Test;

public class JacekTraczLetcodeMergeKListsSolutionTest {

	
	private int EXEC_HANDLER_VERSION = 3;
	private boolean TEST_CHOOSEN_TEST_CASE_ONLY = true;
	
	public final static int HNDL_JacekTraczLetCodeMergeSortedKListsDebugOnSolution = 5;
	public final static int HNDL_JacekTraczLetCodeMergeSortedKListsDebugOffSolution = 3;
	
	private int TEST_CHOOSEN_TEST_FOR_ONE_EXEC = 1000000;
	private String TEST_EXEC_NAME = "EXEC_NULL_ONE_NODE_REMOVED"; 
	//EXEC_ONE_NODE";
	
	private boolean TEST_DEBUG_MODE = false;
	private boolean EXEC_DEBUG_MODE_LVL3 = false;	
	private boolean  EXEC_DEBUG_MODE_LVL0 = false;
	private boolean  EXEC_DEBUG_MODE_LVL1 = false;	
	private int  EXEC_DEBUG_LEVEL = 4;
	
	private boolean MERGE_IN_PLACE = true;
    private boolean MERGE_IMMUTABLE = false;	
    @Test	
	public void test2() throws Exception {
		//assertEquals(5,5);
	}	
    
	@Test		
	public void test1() throws Exception {
		int[] params = {1,3,6,4,1,2};
		com.jacektracz.letcode.smallestinteger.JacekTraczLetcodeSmallestIntSolution handler = new com.jacektracz.letcode.smallestinteger.JacekTraczLetcodeSmallestIntSolution();
		int outcome = handler.solution(params);
		//assertEquals(outcome,5);
	}	
	
	@Test	
	//@Ignore
	public void testListsWithOneNode_4() throws Exception {		
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 4)) {	
			return;
		}
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(4,100,0,"testListsWithOneNode_4",testDebug,handlerDebug);		
	}
	
	@Test
	//@Ignore
	public void testListsWithOneNode_10() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 10)) {			
			return;			
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(10,3,2,"testListsWithOneNode_10",testDebug,handlerDebug);				
	}
	
	@Test
	//@Ignore
	public void testListsWithOneNode_20() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 20)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(20,100,2,"testListsWithOneNode_2000",testDebug,handlerDebug);		
	}
	
	@Test
	//@Ignore
	public void testListsWithOneNode_100() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 100)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(100,100,2,"testListsWithOneNode_500",testDebug,handlerDebug);				
	}	
		
	@Test
	//@Ignore
	public void testListsWithOneNode_500() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 500)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(500,100,2,"testListsWithOneNode_500",testDebug,handlerDebug);				
	}
	
	@Test	
	//@Ignore
	public void testListsWithOneNode_1000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 1000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(1000,100,0,"testListsWithOneNode_1000",testDebug,handlerDebug);		
	}	
		
	@Test
	//@Ignore
	public void testListsWithOneNode_2000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(2000,100,2,"testListsWithOneNode_2000",testDebug,handlerDebug);		
	}	
	
	@Test
	//@Ignore
	public void testListsWithOneNode_5000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 5000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(5000,100,2,"testListsWithOneNode_5000",testDebug,handlerDebug);				
	}
	
	@Test
	//@Ignore
	public void testListsWithOneNode_8000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 8000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(8000,100,2,"testListsWithOneNode_8000",testDebug,handlerDebug);				
	}	
	
	@Test
	//@Ignore
	public void testListsWithOneNode_10000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 10000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(10000,100,2,"testListsWithOneNode_10000",testDebug,handlerDebug);				
	}
	
	@Test
	//@Ignore
	public void testListsWithOneNode_100000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 100000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(100000,100,2,"testListsWithOneNode_100000",testDebug,handlerDebug);				
	}

	@Test
	//@Ignore
	public void testListsWithOneNode_1000000() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY && (TEST_CHOOSEN_TEST_FOR_ONE_EXEC != 1000000)) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(1000000,100,2,"testListsWithOneNode_1000000",testDebug,handlerDebug);				
	}
	
	@Test
	//@Ignore
	public void testWitManyListsWithOneNode() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		boolean testDebug = TEST_DEBUG_MODE;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		execTestmanyListsOneNode(2,2,2,"testListsWithOneNode_500",testDebug,handlerDebug);				
	}	
	
	@Test
	//@Ignore
	public void testWithNotSortedLists() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testWithOndNode";
		dbgInfo(sFun + "-start");
		int items =2;
		SolutionData dataProvider = new SolutionData();
		ListNode ll = dataProvider.getList_Nodes(items,2,2);
		dbgList(ll, sFun+ "-IN-LIST");
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;
		
		
		ListNode lout = execHandler(0,true,inputArray);
		validateList( inputArray, lout,sFun,items);

		
	}	
	
	
	@Test	
	//@Ignore
	public void testWithOneNode() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testWithOndNode";
		dbgInfo(sFun + "-start");
		
		ListNode ll = SolutionData.getList_OneNodesS();
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;
		
		ListNode lout = execHandler(0,true,inputArray);
		validateList( inputArray, lout,sFun,1);

		
	}	
	
	@Test
	//@Ignore
	public void testOneListWithTwoNode() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testOneListWithTwoNode";
		dbgInfo(sFun + "-start");
		ListNode ll = SolutionData.getList_TwoNodesS();
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;
		ListNode lout = execHandler(0,true,inputArray);
		
		validateList( inputArray, lout,sFun,2);

	}
	
	@Test
	//@Ignore
	public void testTwoListWithTwoNode() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testTwoListWithTwoNode";
		dbgInfo(sFun + "-start");
		ListNode ll = SolutionData.getList_TwoNodesS();
		ListNode l2 = SolutionData.getList_TwoNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = ll;
		inputArray[1] = l2;
		
		ListNode lout = execHandler(0,true,inputArray);
		
		validateList( inputArray, lout,sFun,4);
		
	}
	
	@Test
	//@Ignore
	public void testTwoListWithThreeNodes() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testTwoListWithThreeNodes";
		dbgInfo(sFun + "-start");
		ListNode ll =  SolutionData.getList_ThreeNodesS();
		ListNode l2 =  SolutionData.getList_ThreeNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = ll;
		inputArray[1] = l2;
		
		ListNode lout = execHandler(0,true,inputArray);
		
		validateList( inputArray, lout,sFun,6);
	}
	
	@Test	
	//@Ignore
	public void testWithOneNode_solution() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testWithOndNode";
		dbgInfo(sFun + "-start");
		
		ListNode ll = SolutionData.getList_OneNodesS();
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		
		validateList( inputArray, lout,sFun,1);
		
	}	
	
	@Test	
	//@Ignore
	public void testOneListWithTwoNode_solution() throws Exception {
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testOneListWithTwoNode";
		dbgInfo(sFun + "-start");
		ListNode ll = SolutionData.getList_TwoNodesS();
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		
		validateList( inputArray, lout,sFun,2);
	}
	
	@Test
	//@Ignore
	public void testTwoListWithTwoNode_solution() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testTwoListWithTwoNode";
		dbgInfo(sFun + "-start");
		ListNode ll = SolutionData.getList_TwoNodesS();
		ListNode l2 = SolutionData.getList_TwoNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = ll;
		inputArray[1] = l2;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		
		validateList( inputArray, lout,sFun,4);
	}
	
	@Test
	//@Ignore
	public void testTwoListWithThreeNodes_solution() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY&& ! TEST_EXEC_NAME.equals("BASIC_TEST_CAES")) {
			return;
		}
		
		String sFun = "testTwoListWithThreeNodes";
		dbgInfo(sFun + "-start");
		ListNode ll =  SolutionData.getList_ThreeNodesS();
		ListNode l2 =  SolutionData.getList_ThreeNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = ll;
		inputArray[1] = l2;
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);	
		validateList( inputArray, lout,sFun,6);
	}

	@Test
	//@Ignore
	public void testEmptyList() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY && ! TEST_EXEC_NAME.equals("testEmptyList")) {
			return;
		}
		
		String sFun = "testTwoListWithThreeNodes";
		dbgInfo(sFun + "-start");
		ListNode ll =  SolutionData.getList_ZeroValueNode();		
		ListNode[] inputArray =  new  ListNode[1];
		inputArray[0] = ll;		
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		validateList( inputArray, lout,sFun,1);
	}
	
	@Test
	//@Ignore
	public void testZeroOneNodeList() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY && ! TEST_EXEC_NAME.equals("EXEC_ZERO_ONE_NODE")) {
			return;
		}
		
		String sFun = "testEmptyOneList";
		dbgInfo(sFun + "-start");
		ListNode l0 =  SolutionData.getList_ZeroValueNode();
		ListNode l1 =  SolutionData.getList_OneNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = l0;
		inputArray[1] = l1;
		
		dbgLists(inputArray,sFun);
		
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		validateList( inputArray, lout,sFun,2);
	}
	
	@Test
	//@Ignore
	public void testNullOneNodeList() throws Exception {
		
		if(TEST_CHOOSEN_TEST_CASE_ONLY && ! TEST_EXEC_NAME.equals("EXEC_NULL_ONE_NODE")) {
			return;
		}
		
		String sFun = "testEmptyOneList";
		dbgInfo(sFun + "-start");
		ListNode l0 =  SolutionData.getList_NullModeS();
		ListNode l1 =  SolutionData.getList_OneNodesS();
		ListNode[] inputArray =  new  ListNode[2];
		inputArray[0] = l0;
		inputArray[1] = l1;
		
		dbgLists(inputArray,sFun);
		
		boolean handlerDebug = EXEC_DEBUG_MODE_LVL3;
		ListNode lout = execHandler(0,handlerDebug,inputArray);
		validateList( inputArray, lout, sFun,1);
		
	}	
	
    private void validateList (ListNode[] inputArray, ListNode lout,String sFun,int expected_length){
    	
    	if(TEST_DEBUG_MODE) {
    		
    		String sFunV =  "::validateList::";
    		
    		dbgLists(inputArray,sFun);
    		
			dbgNode(lout,sFun);
			
			dbgList(lout,  sFun + sFunV );
			int listLength = dbgList(lout, sFun + sFunV);
			if(expected_length >= 0) {
				//assertEquals(expected_length,listLength);
			}
			checkList(lout, sFun);
			//assertEquals(true,sErr.isEmpty());
			dbgInfo(sFun + "-end");
		}
	}
    
	public ListNode execHandler(int ptype, boolean deb_mode, ListNode [] inputArray) {
		
		int type = EXEC_HANDLER_VERSION;
		if(type == 1){
			JacekTraczLetcCodeMergeSortedKlistsOptimizedSolution handler = new JacekTraczLetcCodeMergeSortedKlistsOptimizedSolution();
			ListNode lout = handler.mergeKLists( inputArray );
			return lout;
		}
		
		if(type == 2) {
			JacekTraczLetCodeMergeSortedKListsVersion2Solution handler = new JacekTraczLetCodeMergeSortedKListsVersion2Solution();
			handler.setDebugModeLvl3(  EXEC_DEBUG_MODE_LVL3 );
			handler.setDebugModeLvl0( EXEC_DEBUG_MODE_LVL0  );
			handler.setDebugModeLvl1( EXEC_DEBUG_MODE_LVL1  );
			ListNode lout = handler.mergeKLists( inputArray );
			return lout;
		}
		if(type == HNDL_JacekTraczLetCodeMergeSortedKListsDebugOffSolution) {
			JacekTraczLetCodeMergeSortedKListsDebugOffSolution handler = new JacekTraczLetCodeMergeSortedKListsDebugOffSolution();
			handler.setMergeInPlace( MERGE_IN_PLACE);
			handler.setMergeImmutable( MERGE_IMMUTABLE);
			handler.setDebugLevel5( EXEC_DEBUG_LEVEL);
			ListNode lout = handler.mergeKLists( inputArray );
			return lout;
		}
		if(type == HNDL_JacekTraczLetCodeMergeSortedKListsDebugOnSolution) {
			JacekTraczLetCodeMergeSortedKListsDebugOnSolution handler = new JacekTraczLetCodeMergeSortedKListsDebugOnSolution();
			handler.setMergeInPlace( MERGE_IN_PLACE);
			handler.setMergeImmutable( MERGE_IMMUTABLE);
			handler.setDebugLevel5( EXEC_DEBUG_LEVEL);
			ListNode lout = handler.mergeKLists( inputArray );
			return lout;
		}
		
		return null;	
	}	
		
	public void execTestmanyListsOneNode(int items,int val_step,int start_value,String tt,boolean p_test_debug,boolean p_handler_debug) throws Exception {
		String sFun = "execTestmanyListsOneNode";
		if(p_test_debug) dbgInfo(sFun + "-start");
		if(p_test_debug) dbgInfo(sFun + tt + "-start");
		
		SolutionData dataProvider = new SolutionData();
		ListNode[] inputArray = dataProvider.getLists_WithOneNodes(items,val_step,start_value);		
		//assertEquals(items,inputArray.length);
		
		ListNode lout = execHandler(EXEC_HANDLER_VERSION,p_handler_debug,inputArray);
		
		validateList( inputArray, lout, sFun, items);
	
	}

    private void dbgInfo ( String tt){
    	if(!TEST_DEBUG_MODE) {
    		return;
    	}
    	
        dbgInfoSubmitted(tt);
    }
    
    private void dbgInfoSubmitted ( String tt){

        System.out.println( tt );
    }
	
    private void dbgNode ( 
            ListNode p_nl
            , String tt){
    	
    	if(!TEST_DEBUG_MODE) {
    		return;
    	}
    	JacekTraczKlistsValidations handler = new JacekTraczKlistsValidations();
    	handler.setDebugMode(TEST_DEBUG_MODE);
    	handler.dbgNode(p_nl, tt);
    	
    }
    
    private void dbgLists ( 
            ListNode[] p_nl
            , String tt){
    	
    	if(!TEST_DEBUG_MODE) {
    		return;
    	}
    	
    	JacekTraczKlistsValidations handler = new JacekTraczKlistsValidations();
    	handler.setDebugMode(TEST_DEBUG_MODE);
    	handler.dbgLists(p_nl, tt);    	
    }

    private int dbgList ( 
            ListNode p_nl
            , String tt){
    	
    	if(!TEST_DEBUG_MODE) {
    		return 0;
    	}
    	
    	JacekTraczKlistsValidations handler = new JacekTraczKlistsValidations();
    	handler.setDebugMode(TEST_DEBUG_MODE);
    	return handler.dbgList(p_nl, tt);
    	
    }         
    
    private  String checkList ( 
            ListNode p_nl
            , String tt
            ){
            
    	if(!TEST_DEBUG_MODE) {
    		return "";
    	}
    	
    	JacekTraczKlistsValidations handler = new JacekTraczKlistsValidations();
    	handler.setDebugMode(TEST_DEBUG_MODE);
    	return handler.checkList(p_nl, tt);    	
    }    
	
	
}
