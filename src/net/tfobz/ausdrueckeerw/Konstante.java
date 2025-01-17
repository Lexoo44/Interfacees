package net.tfobz.ausdrueckeerw;

import java.util.Enumeration;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class Konstante extends Operand {
	private double ergebnis = 0.0;

	public Konstante(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public Konstante() {
		super();
	}

	public void setErgebnis(double ergebnis) {
		this.ergebnis = ergebnis;
	}

	public double getErgebnis() {
		return this.ergebnis;
	}

	public String toString() {
		return String.valueOf(this.ergebnis);
	}

	@Override
	public void setUserObject(Object userObject) {
		setErgebnis(Double.parseDouble(String.valueOf(userObject.toString())));
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(MutableTreeNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public Enumeration<? extends TreeNode> children() {
		// TODO Auto-generated method stub
		return null;
	}

}
