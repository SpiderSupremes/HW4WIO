package hw4;

import java.util.ArrayList;
import java.util.Iterator;

import api.DefaultNode;
import api.Instruction;
import api.Scope;
import parser.ProgramNode;

/**
 * Compound instruction representing a sequence of instructions.  Execution
 * of a block iterates through the sequence, calling execute() on each
 * one. When initially constructed, the block contains no instructions.  
 * Instruction objects are added to the sequence using the method
 * <pre>
 *     public void addStatement(Instruction s)
 * </pre>
 * <ul>
 *   <li>The number of children is the number of statements in
 *       this block (possibly zero).
 *   <li>The getLabel() method returns the string "Block".
 *   <li>The getText() method returns an empty string
 * </ul>
 */

public class BlockInstruction implements Instruction
{
	private ArrayList<Instruction> statements;
  /**
   * Constructs an empty sequence of instructions.
   */
  public BlockInstruction()
  {
	  
	  statements = new ArrayList<Instruction>();
	  
  }

  /**
   * Adds an instruction to this block.  The instructions will be executed
   * in the order added.
   * @param s
   *   instruction to be added to this block
   */
  public void addStatement(Instruction s)
  {
	  
	  statements.add(s);
	  
  }

@Override
public ProgramNode getChild(int arg0) {
	
	return null;
	
}

@Override
public String getLabel() {

	return "Block";
	
}

@Override
public int getNumChildren() {

	return statements.size();
	
}

@Override
public String getText() {

	return "";
	
}

@Override
public void execute(Scope env) {
	
	for (Iterator<Instruction> i = statements.iterator(); i.hasNext(); )
	{
		
		i.next().execute(env);
		
	}
	
}
  

}
