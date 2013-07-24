package nitkatest.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ListHelper {
	public static List<Integer> removeThreeAndMoreSameInARow(List<Integer> list) {
		int count = 0;
		Integer currentNumber = null;
		
		for (int i = 0; i < list.size(); i++) {
			Integer number = list.get(i);
			if (currentNumber == null || ! currentNumber.equals(number)) {
				if(count >= 3) {
					for (int n = 0; n < count; n++) list.remove(i-(n+1));
					i -= count;
				}				
				count = 1;
				currentNumber = number;
			} else {
				count++;
			}
		}
		if(count >= 3) {
			for (int n = 0; n < count; n++) list.remove(list.size()-1);
		}
		return list;
	}
	
	public static List<Integer> removeThreeAndMoreSame(List<Integer> list) {
		Map<Integer, Integer> numberOccurences = new HashMap<Integer, Integer>();
		
		for (Integer number : list) {
			Integer occurences = numberOccurences.get(number);
			if (occurences == null)
				numberOccurences.put(number, 1);
			else
				numberOccurences.put(number, ++occurences);
		}
		
		Set<Integer> forRemoval = new HashSet<Integer>();
		for (Entry<Integer, Integer> entry : numberOccurences.entrySet()) {
			if (entry.getValue() >= 3)
				forRemoval.add(entry.getKey());
		}
		
		list.removeAll(forRemoval);
		return list;
	}
}
