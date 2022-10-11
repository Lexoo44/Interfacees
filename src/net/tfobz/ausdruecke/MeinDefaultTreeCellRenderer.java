package net.tfobz.ausdruecke;

import javax.swing.*;
import java.awt.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import net.tfobz.ausdrueckeerw.*;

public class MeinDefaultTreeCellRenderer extends DefaultTreeCellRenderer {

	private ImageIcon division = new ImageIcon(this.getClass().getResource("division.gif"));
	private ImageIcon multiplikation = new ImageIcon(this.getClass().getResource("multiplikation.gif"));
	private ImageIcon addition = new ImageIcon(this.getClass().getResource("addition.gif"));
	private ImageIcon subtraktion = new ImageIcon(this.getClass().getResource("subtraktion.gif"));
	private ImageIcon konstante = new ImageIcon(this.getClass().getResource("konstante.gif"));

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		Component ret = null;

		ret = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
		if (value instanceof Division) {
			setIcon(division);
			setToolTipText("Division");
		} else if (value instanceof Multiplikation) {
			setIcon(multiplikation);
			setToolTipText("Multiplikation");
		} else if (value instanceof Addition) {
			setIcon(addition);
			setToolTipText("Addition");
		} else if (value instanceof Subtraktion) {
			setIcon(subtraktion);
			setToolTipText("Subtraktion");
		} else if (leaf && value instanceof Konstante) {
			setIcon(konstante);
			setToolTipText("konstante");
		}
		return ret;
	}

}
