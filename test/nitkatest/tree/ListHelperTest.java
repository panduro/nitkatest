package nitkatest.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import nitkatest.list.ListHelper;

import org.junit.Test;

public class ListHelperTest {

	@Test
	public void removeThreeAndMoreSameInARow() {
		buildListAndAssertRemovalInARow(new Integer[]{}, new Integer[]{});
		buildListAndAssertRemovalInARow(new Integer[]{1,2}, new Integer[]{1,2});
		buildListAndAssertRemovalInARow(new Integer[]{1,1}, new Integer[]{1,1});
		buildListAndAssertRemovalInARow(new Integer[]{}, new Integer[]{1,1,1});
		buildListAndAssertRemovalInARow(new Integer[]{1,2,1,1}, new Integer[]{1,2,1,1});
		buildListAndAssertRemovalInARow(new Integer[]{1,1,1,1,4,1}, new Integer[]{1,1,2,2,2,2,1,3,3,3,1,4,1});
		buildListAndAssertRemovalInARow(new Integer[]{1,2,3,2,1,3,1,2,1}, new Integer[]{1,2,3,2,1,3,1,2,1});
	}
	
	private static void buildListAndAssertRemovalInARow(Integer[] result, Integer[] argument) {
		assertEquals(new ArrayList<Integer>(Arrays.asList(result)), 
				ListHelper.removeThreeAndMoreSameInARow(new ArrayList<Integer>(Arrays.asList(argument))));
	}	
	
	@Test
	public void removeThreeAndMoreSame() {
		buildListAndAssertRemoval(new Integer[]{}, new Integer[]{});
		buildListAndAssertRemoval(new Integer[]{1,2}, new Integer[]{1,2});
		buildListAndAssertRemoval(new Integer[]{1,1}, new Integer[]{1,1});
		buildListAndAssertRemoval(new Integer[]{}, new Integer[]{1,1,1});
		buildListAndAssertRemoval(new Integer[]{2}, new Integer[]{1,2,1,1});
		buildListAndAssertRemoval(new Integer[]{2,3,4}, new Integer[]{1,1,2,3,1,4,1});
		buildListAndAssertRemoval(new Integer[]{3,3}, new Integer[]{1,2,3,2,1,3,1,2,1});
	}
	
	private static void buildListAndAssertRemoval(Integer[] result, Integer[] argument) {
		assertEquals(new ArrayList<Integer>(Arrays.asList(result)), 
				ListHelper.removeThreeAndMoreSame(new ArrayList<Integer>(Arrays.asList(argument))));
	}

}
