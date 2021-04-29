package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;


/**
 * Node type representing a relational expression
 * with the "less than" operator.  If the left
 * operand evaluates to a smaller value than the 
 * right operand, this expression evaluates to 1; otherwise,
 * it evaluates to zero.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns a string consisting of the less-than symbol
 *   (&lt;).
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class RopLessThan implements Expression
{
	private Expression lhs;
	private Expression rhs;
	
	/**
   * Constructs an expression with the given left and right sides.
   * @param lhs
   *   expression for the left-hand-side operand
   * @param rhs
   *   expression for the left-hand-side operand
   */
  public RopLessThan(Expression lhs, Expression rhs)
  {
	  
	  this.lhs = lhs;
	  this.rhs = rhs;
	  
  }

@Override
public ProgramNode getChild(int i) {

	if (i == 0)
    {
      return lhs;
    }
    else if (i == 1)
    {
      return rhs;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
	
}

@Override
public String getLabel() {

	return "<";
	
}

@Override
public int getNumChildren() {

	return 2;
	
}

@Override
public String getText() {
	
	return "";

}

@Override
public int eval(Scope env) {
	int leftVal = lhs.eval(env);
	int rightVal = rhs.eval(env);
	
	if(leftVal < rightVal) {
		
		return 1;
		
	}
	
	else {
	
		return 0;
	
	}
	
}

}