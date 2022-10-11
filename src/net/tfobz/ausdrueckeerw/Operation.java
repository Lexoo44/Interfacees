package net.tfobz.ausdrueckeerw;

import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Achtung: Die Operanden werden immer der Reihe nach in die Operation gehängt.
 * Mit setOperand kann man beim ersten Aufruf den ersten Operanden füllen, ruft
 * man setOperand nochmals auf, so wird der zweite Operand gefüllt. Beim Löschen
 * werden die Operanden unter Umständen nach vorne verschoben.
 * 
 * @author Michael Wild
 */
public abstract class Operation extends Operand {
	private Operand[] operand = new Operand[2];

	public Operation(Operand operand0, Operand operand1) {
		this.setOperand(operand0);
		this.setOperand(operand1);
	}

	public Operation() {
		super();
	}

	public void setOperand(Operand operand) {
		if (this.operand[0] == null)
			this.operand[0] = operand;
		else if (this.operand[1] == null)
			this.operand[1] = operand;
	}

	public Operand getOperand(int position) {
		if (position >= 0 && position <= 1)
			return this.operand[position];
		else
			return null;
	}

	public void vertausche() {
		if (this.operand[0] != null && this.operand[1] != null) {
			Operand operand = this.operand[0];
			this.operand[0] = this.operand[1];
			this.operand[1] = operand;
		}
	}

	public void loescheOperand(int position) {
		if (position == 0) {
			this.operand[0] = this.operand[1];
			this.operand[1] = null;
		} else if (position == 1)
			this.operand[1] = null;
	}

	public TreeNode getChildAt(int childIndex) {
		return operand[childIndex];
	}

	public int getChildCount() {
		int ret = 0;
		if (operand[0] != null && operand[1] != null) {
			ret = 2;
		} else if (operand[0] == null || operand[1] == null) {
			ret = 1;
		} else {
			System.out.println("Fehler");
		}
		return ret;

	}

	@Override
	public int getIndex(TreeNode node) {
		int ret = -1;
		if (node != null && node.equals(operand[0])) {
			ret = 0;
		} else if (node != null && node.equals(operand[1])) {
			ret = 1;
		} else {
			System.out.println("Fehler");
		}
		return ret;
	}

	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		return null;
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		if (this.operand[0] == null && index == 0) {
			this.operand[0] = (Operand) child;
		} else if (this.operand[0] != null && this.operand[1] == null) {
			this.operand[1] = (Operand) child;
		} else {
			System.out.println("Fehler");
		}
	}

	@Override
	public void remove(int index) {
		loescheOperand(index);
	}

	@Override
	public void remove(MutableTreeNode node) {
		if (node != null)
			remove(getIndex(node));
	}
}
