package cal;

public class ExpressionTree {

  private TreeNode headTreeNode;
  
  public ExpressionTree() {
    // TODO Auto-generated constructor stub
  }

  public class TreeNode {
    TreeNode left, right;
  }

  public class Operator extends TreeNode {
    char val;
  }
  
  public class Operand extends TreeNode {
    int val;
  }

  public String parseToPostfix(String inputExpression) {
    // TODO Auto-generated method stub
    return null;
  }

  public int parseResult(String inputExpression) {
    // TODO Auto-generated method stub
    return 0;
  }

}
