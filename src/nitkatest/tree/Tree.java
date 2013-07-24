package nitkatest.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple tree implementation.
 */
public class Tree {
	private final Object value;
	/*
	 * this implementation doesn't give direct access to the children, because 
	 * otherwise user could use some node (Tree object), which already belongs 
	 * to this 'Tree', as a child thus making it not a tree, but a generic graph.
	 */
	private List<Tree> children = new ArrayList<Tree>();

	public Tree(Object value){
		this.value = value;
	}

	/**
	 * adds a child with given value
	 */
	public Tree addChild(Object value) {
		if (children.add(new Tree(value)))
			return children.get(children.size() - 1);
		else 
			return null;
	}

	public Object getValue() {
		return value;
	}

	/*
	 * returns unmodifiable collection of the children
	 */
	public List<Tree> getChildren() {
		return Collections.unmodifiableList(children);
	}
	/*
	 * removes all children for which value equals an argument provided
	 */
	public Integer removeChildrenByValue(Object value) {
		List<Tree> slatedForRemoval = new ArrayList<Tree>();

		for (Tree child : children) {
			if (child.value.equals(value)) slatedForRemoval.add(child);					
		}

		Integer removedCount = 0;
		for (Tree forRemoval : slatedForRemoval) {
			if (children.remove(forRemoval)) removedCount++;
		}
		return removedCount;
	}

	/*
	 * removes a child at given index
	 */
	public boolean removeChildAtIndex(Integer i){
		return children.remove(i);
	}

	/*
	 * returns maximum depth of the tree
	 */
	public Integer getDepth() {
		if (children.size() == 0) {
			return 1;
		} else {
			Integer maxChildDepth = 1;
			for (Tree child : children) {
				Integer depth = child.getDepth();
				if (depth > maxChildDepth) maxChildDepth = depth;					
			}
			return 1 + maxChildDepth;
		}

	}
}
