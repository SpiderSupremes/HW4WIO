package hw4;

import api.DefaultNode;
import api.Expression;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Instruction type representing a conditional.  A conditional has an
 * expression and two instructions.  If the expression evaluates to a 
 * nonzero value (i.e., "true"), the first instruction is executed; otherwise, the 
 * second instruction is executed.
 * <ul>
 *   <li>There are three children; the first is the expression, the second 
 *   is the instruction for the "true", the third is the instruction for
 *   the "false" branch
 *   <li>The getLabel() method returns the string "If".
 *   <li>The getText() method returns an empty string.
 * </ul>
 */
//TODO: THIS CLASS MUST DIRECTLY OR INDIRECTLY IMPLEMENT THE Instruction INTERFACE
// AND OVERRIDE THE toString METHOD
public class IfInstruction implements Instruction 
{
  
	private Expression condition;
	private Instruction statements[];
  /**
   * Constructs a conditional statement from the given condition
   * and alternative actions.
   * @param condition
   *    an expression to use as the condition
   * @param s0
   *    statement to be executed if the condition is true (nonzero)
   * @param s1
   *    statement to be executed if the condition is false (zero)
   */
  public IfInstruction(Expression condition, Instruction s0, Instruction s1)
  {
	  	
	  	this.condition = condition;
	  	
	  	statements[0] = s0;
	  	statements[1] = s1;
	  
  }

@Override
public ProgramNode getChild(int i) {
	if (i == 0) {
		
		return this.condition;
	
	} 
	
	else if (i < 3) {
		
		return statements[i-1];
	
	} 
	
	else {
		
	      return new DefaultNode("Invalid index " + i + " for type " + this.getClass().getName());
	
	}

	
}

@Override
public String getLabel() {

	return "If";
	
}

@Override
public int getNumChildren() {

	return statements.length;
	
}

@Override
public String getText() {

	return "";
	
}

@Override
public void execute(Scope env) {

	if (condition.eval(env) == 0) {
		
		statements[1].execute(env);
	
	}
	
	else {
		
		statements[0].execute(env);
	
	}
}
  

}
