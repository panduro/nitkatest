package nitkatest.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
	
	@Test
	public void testDepthEmpty() {
		Tree root = new Tree(1);
		
		assertEquals(new Integer(1), root.getDepth());		
	}
	
	@Test
	public void testDepthSimple() {
		Tree root = new Tree(1);
		Tree second1 = root.addChild(2);
		
		Tree third1 = second1.addChild(3);
		
		Tree fourth1 = third1.addChild(4);
		
		assertEquals(new Integer(4), root.getDepth());
		
	}

	@Test
	public void testDepth() {
		Tree root = new Tree(1);
		Tree second1 = root.addChild(2);
		Tree second2 = root.addChild(2);
		Tree second3 = root.addChild(2);
		
		Tree third1 = second1.addChild(3);
		Tree third2 = second1.addChild(3);
		Tree third3 = second2.addChild(3);
		
		Tree fourth1 = third1.addChild(4);
		Tree fourth2 = third1.addChild(4);
		Tree fourth3 = third3.addChild(4);
		Tree fourth4 = third3.addChild(4);
		
		Tree fifth1 = fourth4.addChild(5);
		Tree fifth2 = fourth4.addChild(5);
		
		assertEquals(new Integer(5), root.getDepth());
		
	}

}