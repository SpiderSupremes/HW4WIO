package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Node type representing a logical expression 
 * with the "or" operator.  If both operands evaluate
 * to zero, then this expression evaluates to 0;
 * otherwise, this expression evaluates to 1.
 * <ul>
 *   <li>There are two children; the first is the left operand, and the second 
 *   is the right operand.
 *   <li>The getLabel() method returns the string "||".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class LopOr implements Expression
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
  public LopOr(Expression lhs, Expression rhs) {

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
		
		return "||";
		
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
			
		if(rightVal > 0 || leftVal > 0) {
		
			return 1;
		
		}
		else {
			
			return 0;
			
		}

  }

}