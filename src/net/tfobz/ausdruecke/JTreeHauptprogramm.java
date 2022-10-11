package net.tfobz.ausdruecke;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import net.tfobz.ausdrueckeerw.Addition;
import net.tfobz.ausdrueckeerw.Division;
import net.tfobz.ausdrueckeerw.Konstante;
import net.tfobz.ausdrueckeerw.Multiplikation;
import net.tfobz.ausdrueckeerw.Operation;
import net.tfobz.ausdrueckeerw.Subtraktion;


public class JTreeHauptprogramm extends JFrame {

	private JFrame frame;
	private JTree tree;
	private DefaultTreeModel treeModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTreeHauptprogramm window = new JTreeHauptprogramm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JTreeHauptprogramm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Mathematische ausdr\u00FCcke");
		frame.setBounds(100, 100, 380, 248);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		TreeCellRenderer meinRenderer = new MeinDefaultTreeCellRenderer();
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("unsichtbare Wurzel");

//		node.add(new Division(
//				new Multiplikation(new Konstante(2.0), new Addition(new Konstante(3.0), new Konstante(4.0))),
//				new Subtraktion(new Konstante(7.0), new Konstante(2.0))));
		node.add(new Division());

		treeModel = new DefaultTreeModel(node);
		tree = new JTree(treeModel);

		tree.setCellRenderer(meinRenderer);
		tree.setEditable(true);
		tree.setRootVisible(false);
		ToolTipManager.sharedInstance().registerComponent(tree);

		JPopupMenu pop = new JPopupMenu();

		JMenu item1 = new JMenu("Neu");
		
		JMenuItem item2 = new JMenuItem("Loeschen");
		item2.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() != null) {
				TreePath tp = tree.getSelectionPath().getParentPath();
				MutableTreeNode treeNode = (MutableTreeNode) tree.getLastSelectedPathComponent();
				MutableTreeNode parentTreeNode = (MutableTreeNode) tree.getSelectionPath().getParentPath()
						.getLastPathComponent();
				parentTreeNode.remove(treeNode);
				treeModel.reload();
				tree.expandPath(tp);
			}
		});

		JMenuItem item3 = new JMenuItem("Vertauschen");
		item3.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() != null) {
				TreePath tp = tree.getSelectionPath().getParentPath();
				MutableTreeNode parentTreeNode = (MutableTreeNode) tree.getSelectionPath().getParentPath()
						.getLastPathComponent();
				((Operation) parentTreeNode).vertausche();
				treeModel.reload();
				tree.expandPath(tp);
			}
		});

		JMenuItem sitem1 = new JMenuItem("Konstante");
		sitem1.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() == null) {
				// Hänge neuen Knoten zur Wurzel
				DefaultMutableTreeNode wurzel = ((DefaultMutableTreeNode) treeModel.getRoot());
				if (wurzel.getChildCount() == 0) {
					treeModel.insertNodeInto(new Konstante(), wurzel, 0);
					// Muss gemacht werden, ansonsten wird neuer Knoten nicht angezeigt
					treeModel.reload();
				}
			} else {
				// Hänge neuen Knoten zum ausgewählten Knoten
				MutableTreeNode treeNode = ((MutableTreeNode) tree.getSelectionPath().getLastPathComponent());
				if (treeNode instanceof Operation && ((Operation) treeNode).getChildCount() < 2) {
					treeModel.insertNodeInto(new Konstante(), treeNode, 0);
					TreePath treePath = tree.getSelectionPath();
					treeModel.reload();
					// Damit wird ausgewählter Knoten aufgeklappt
					tree.expandPath(treePath);
				}
			}
		});
		JMenuItem sitem2 = new JMenuItem("Addition");
		sitem2.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() == null) {
				// Haenge einen neuen Knoten an die Wurzel
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
				if (root.getChildCount() == 0) {
					treeModel.insertNodeInto(new Konstante(), root, 0);
					treeModel.reload();
				}
			} else {
				// Haenge den Knoten zum ausgewaehlten Knoten
				MutableTreeNode treeNode = (MutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if (treeNode instanceof Operation && ((Operation) treeNode).getChildCount() < 2) {
					treeModel.insertNodeInto(new Addition(), treeNode, 0);
					TreePath treePath = tree.getSelectionPath();
					System.out.println(treePath.toString());
					treeModel.reload();
					tree.expandPath(treePath);
				}
			}
		});
		JMenuItem sitem3 = new JMenuItem("Subtraktion");
		sitem3.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() == null) {
				// Haenge einen neuen Knoten an die Wurzel
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
				if (root.getChildCount() == 0) {
					treeModel.insertNodeInto(new Konstante(), root, 0);
					treeModel.reload();
				}
			} else {
				// Haenge den Knoten zum ausgewaehlten Knoten
				MutableTreeNode treeNode = (MutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if (treeNode instanceof Operation && ((Operation) treeNode).getChildCount() < 2) {
					treeModel.insertNodeInto(new Subtraktion(), treeNode, 0);
					TreePath treePath = tree.getSelectionPath();
					System.out.println(treePath.toString());
					treeModel.reload();
					tree.expandPath(treePath);
				}
			}
		});
		JMenuItem sitem4 = new JMenuItem("Multiplikation");
		sitem4.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() == null) {
				// Haenge einen neuen Knoten an die Wurzel
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
				if (root.getChildCount() == 0) {
					treeModel.insertNodeInto(new Konstante(), root, 0);
					treeModel.reload();
				}
			} else {
				// Haenge den Knoten zum ausgewaehlten Knoten
				MutableTreeNode treeNode = (MutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if (treeNode instanceof Operation && ((Operation) treeNode).getChildCount() < 2) {
					treeModel.insertNodeInto(new Multiplikation(), treeNode, 0);
					TreePath treePath = tree.getSelectionPath();
					System.out.println(treePath.toString());
					treeModel.reload();
					tree.expandPath(treePath);
				}
			}
		});
		JMenuItem sitem5 = new JMenuItem("Division");
		sitem5.addActionListener(e -> {
			DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			if (tree.getSelectionPath() == null) {
				// Haenge einen neuen Knoten an die Wurzel
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
				if (root.getChildCount() == 0) {
					treeModel.insertNodeInto(new Konstante(), root, 0);
					treeModel.reload();
				}
			} else {
				// Haenge den Knoten zum ausgewaehlten Knoten
				MutableTreeNode treeNode = (MutableTreeNode) tree.getSelectionPath().getLastPathComponent();
				if (treeNode instanceof Operation && ((Operation) treeNode).getChildCount() < 2) {
					treeModel.insertNodeInto(new Division(), treeNode, 0);
					TreePath treePath = tree.getSelectionPath();
					System.out.println(treePath.toString());
					treeModel.reload();
					tree.expandPath(treePath);
				}
			}
		});

		item1.add(sitem1);
		item1.addSeparator();
		item1.add(sitem2);
		item1.add(sitem3);
		item1.add(sitem4);
		item1.add(sitem5);

		pop.add(item1);
		pop.add(item2);
		pop.add(item3);

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					try {
						TreePath tpath = tree.getClosestPathForLocation(e.getX(), e.getY());
						tree.setSelectionPath(tpath);

					} catch (Exception e1) {
						;
					}
				}
			}
		});

		tree.setComponentPopupMenu(pop);
		tree.setInheritsPopupMenu(true);
		tree.setBounds(0, 0, 364, 209);
		frame.getContentPane().add(tree);
		treeModel.reload();

	}
}
