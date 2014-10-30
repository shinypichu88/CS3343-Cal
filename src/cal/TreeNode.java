package cal;

/**
 * A class represents a single Tree Node with left and right node. It will be
 * extended.
 */
public abstract class TreeNode {

    /** The left node. */
    private TreeNode left;

    /** The right node. */
    private TreeNode right;

    /**
     * To link to left node
     * 
     * @param node
     *            , TreeNode object being placed at left
     */
    public void addLeft(TreeNode node) {
	left = node;
    }

    /**
     * To link to left node
     * 
     * @param node
     *            , TreeNode object being placed at right
     */
    public void addRight(TreeNode node) {
	right = node;
    }

    /**
     * left TreeNode getter
     * 
     * @return, left TreeNode object
     */
    public TreeNode getLeft() {
	// TODO: check null
	return left;
    }

    /**
     * right TreeNode getter
     * 
     * @return, right TreeNode object
     */
    public TreeNode getRight() {
	// TODO: check null
	return right;
    }

}