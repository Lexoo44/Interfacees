package net.tfobz.ausdrueckeerw;

import javax.swing.tree.TreeNode;

public class Subtraktion extends Operation {
	public Subtraktion(Operand operand0, Operand operand1) {
		super(operand0, operand1);
	}

	public Subtraktion() {
		super();
	}

	public double getErgebnis() {
		double ret = 0.0;
		if (this.getOperand(0) != null)
			ret = this.getOperand(0).getErgebnis();
		if (this.getOperand(1) != null)
			ret = ret - this.getOperand(1).getErgebnis();
		return ret;
	}

	public String toString() {
		String ret = null;
		Operand operand0 = this.getOperand(0);
		Operand operand1 = this.getOperand(1);
		Operand checkedOperand0 = operand0 == null ? new Konstante(0) : operand0;
		Operand checkedOperand1 = operand1 == null ? new Konstante(1) : operand1;

		ret = ("(" + checkedOperand0.toString() + "-" + checkedOperand1.toString() + ")="
				+ String.valueOf(this.getErgebnis()) + ")");
		return ret;
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public void setUserObject(Object object) {
		// TODO Auto-generated method stub
		
	}
}
