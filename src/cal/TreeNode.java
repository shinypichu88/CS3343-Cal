package cal;

/**
 * A class represents a single Tree Node with left and right node.
 * It will be extended.
 */
public abstract class TreeNode {
	
	/** The left node. */
	private TreeNode left;
	
	/** The right node. */
	private TreeNode right;
	
	public void addLeft(TreeNode node)
	{
		left = node;
	}
	
	public void addRight(TreeNode node)
	{
		right = node;
	}
	
	public TreeNode getLeft()
	{
		//TODO: check null
		return left;
	}
	
	public TreeNode getRight()
	{
		//TODO: check null
		return right;
	}
	
}