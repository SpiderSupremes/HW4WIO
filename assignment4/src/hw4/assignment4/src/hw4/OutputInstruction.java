package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type whose execution causes the value of an expression to
 * be printed to the console.
 * <ul>
 *   <li>There is one child, the expression whose value is to be printed.
 *   <li>The getLabel() method returns the string "Output".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class OutputInstruction implements Instruction
{
  
	private Expression expr;
	
  /**
   * Constructs an output statement for the given expression.
   * @param expr
   *   given expression
   */
  public OutputInstruction(Expression expr)
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

	return "Output";
	
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
public void execute(Scope env) {

	System.out.print(expr);
	
}

}
