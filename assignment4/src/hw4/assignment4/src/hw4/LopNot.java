package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Node type representing a logical expression 
 * with the "not" operator. If expr evaluates to zero, 
 * then this expression evaluates to 1; otherwise, this
 * expression evaluates to 0. 
 * <ul>
 *   <li>There is one child, the expression to be logically negated
 *   <li>The getLabel() method returns the string "!".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class LopNot implements Expression
{ 
	private Expression expr;
/**
   * Constructs a unary expression that represents the logical negation
   * of the given expression.  
   * @param expr
   *   the logical expression to be negated
   */
  public LopNot(Expression expr)
  {
    this.expr = expr;
  }

@Override
public ProgramNode getChild(int i) {

	if (i == 0)
    {
      return expr;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
}

@Override
public String getLabel() {
	
	return "!";
	
}

@Override
public int getNumChildren() {
	
	return 1;
	
}

@Override
public String getText() {
	
	return "";
	
}

@Override
public int eval(Scope env) {
	
	int expression = expr.eval(env); 
	
	if(expression != 0) {
		
		return 0;
		
	}
	
	else {
		
		return 1;
		
	}
	
	
}

}
