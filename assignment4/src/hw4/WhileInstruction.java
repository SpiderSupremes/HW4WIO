package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type representing a while-loop.  A loop has an
 * expression and an instruction.  If the expression evaluates to a 
 * nonzero value (i.e., "true"), the instruction is executed
 * and the expression is re-evaluated, and this process continues 
 * until the expression evaluates to 0 ("false").
 * <ul>
 *   <li>There are two children; the first is the expression, the second 
 *   is the instruction
 *   <li>The getLabel() method returns the string "While".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class WhileInstruction implements Instruction 
{
	private Expression condition;
	private Instruction s;
	
  /**
   * Constructs a while statement from the given condition and body
   * @param condition
   *   expression for the loop condition
   * @param s
   *   instruction for the loop body
   */
  public WhileInstruction(Expression condition, Instruction s)
  {

	  this.condition = condition;
	  this.s = s;
	  
	  
  }

@Override
public ProgramNode getChild(int i) {

	if (i == 0)
    {
      return condition;
    }
    else if (i == 1)
    {
      return s;
    }
    else
    {
      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
    }
	
}

@Override
public String getLabel() {

	return "While";
	
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
public void execute(Scope env) {
	
}
}
