package net.tfobz.ausdrueckeerw;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public abstract class Operand implements MutableTreeNode, TreeNode {
	public abstract double getErgebnis();

	private TreeNode parent;

	@Override
	public void removeFromParent() {
		TreeNode parent = getParent();
		if (parent != null && parent instanceof Operation) {
			((Operation) parent).loescheOperand(parent.getIndex(this));
			this.setParent(null);
		}
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		this.parent = newParent;
	}

}
