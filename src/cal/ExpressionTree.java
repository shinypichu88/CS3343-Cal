package cal;

/**
 * This class is the initialize a expression tree by
 * creating the head of TreeNode object.
 * 
 * Then, the whole tree can be built via the head TreeNode object
 * by setting the left and right TreeNode of head TreeNode
 * 
 * @author derek
 *
 */
public class ExpressionTree{

	/** The head node. */
	private TreeNode headNode;
	
	/**
	 * Set the head TreeNode to initialize the whole expression tree
	 * @param headNode, top of TreeNode object
	 */
	public void setHeadNode(TreeNode headNode)
	{
		this.headNode = headNode;
	}
	
	/**
	 * Head TreeNode Getter
	 * @return, headNode, top of TreeNode object
	 */
	public TreeNode getHeadNode()
	{
		return headNode;
	}

}
