package hw4;

import api.DefaultNode;
import api.Expression;
import api.Scope;
import parser.ProgramNode;

/**
 * Arithmetic negation expression (unary minus).  
 * <ul>
 *   <li>There is one child, the expression to be negated
 *   <li>The getLabel() method returns the string "Negative".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
// TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Expression INTERFACE
// AND OVERRIDE THE toString METHOD
public class AopNegation implements Expression
{
	private Expression expr;
	
	/**
   * Constructs a new unary expression representing the negative
   * of the given expression.
   * @param expr
   *   arithmetic expression to be negated
   */
  public AopNegation(Expression expr)
  {
	  this.expr = expr;
	  
	  }

	  @Override
	  public String getLabel()
	  {
	    return "Negative";
	  }

	  @Override
	  public String getText()
	  {
	    return "";
	  }

	  @Override
	  public ProgramNode getChild(int i)
	  {
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
	  public int getNumChildren()
	  {
	    return 1;
	  }

	  @Override
	  public int eval(Scope env)
	  {
	    
		int expression = expr.eval(env);
	    return -(expression);
	    
	  }
	  
	  @Override
	  public String toString()
	  {
	    return makeString();
	  }
  }


