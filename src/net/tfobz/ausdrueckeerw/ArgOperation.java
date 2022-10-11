package net.tfobz.ausdrueckeerw;

import javax.swing.tree.TreeNode;

public abstract class ArgOperation extends Operand {
	private Argument argument;
	private Operand operand;

	public ArgOperation(Operand operand, Argument argument) {
		this.setOperand(operand);
		this.setArgument(argument);
	}

	public ArgOperation() {
		super();
	}

	public Argument getArgument() {
		return this.argument;
	}

	public void setArgument(Argument argument) {
		if (argument != null)
			this.argument = argument;
	}

	public void setOperand(Operand operand) {
		if (operand != null)
			this.operand = operand;
	}

	public Operand getOperand() {
		return this.operand;
	}

	public int getChildCount() {
		int ret = -1;
		if (operand != null && argument != null) {
			ret = 0;
		} else if (operand != null || argument != null) {
			ret = 1;
		} else {
			System.out.println("Fehler");
		}
		return ret;
	}

	public int getIndex(TreeNode node) {
		int ret = -1;
		if (node != null && node.equals(operand)) {
			ret = 0;
		} else if (node.equals(argument)) {
			ret = 1;
		} else {
			System.out.println("Fehler");
		}
		return ret;
	}

	public TreeNode getChildAt(int childIndex) {
		TreeNode ret = null;
		if (childIndex == 0) {
			return operand;
		} else if (childIndex == 1) {
			return argument;
		} else {
			System.out.println("Fehler");
		}
		return ret;
	}
	
	
}
