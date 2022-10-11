package net.tfobz.listen;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AutoListeGUI extends JFrame {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private MeineDefaultListe autoListe = new MeineDefaultListe();
	private MeinIterator autoIterator = autoListe.elemente();
	private Auto auto = new Auto();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoListeGUI window = new AutoListeGUI();
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
	public AutoListeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Autoliste");
		frame.setBounds(100, 100, 334, 154);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton löschen = new JButton("L\u00F6schen");
		löschen.setBounds(219, 81, 89, 23);
		frame.getContentPane().add(löschen);
		löschen.addActionListener(e -> {
			if (autoListe.istLeer() == true) {
				JOptionPane.showMessageDialog(frame, "Liste ist leer");

			} else if (autoListe.istLeer() == false) {
				try {
					// autoIterator.setzenAktuellesElement(autoIterator.naechstesElement());
					autoIterator.loeschenAktuellesElement();
					t1.setText("");
					t2.setText("");
					if (autoListe.istLeer() == true) {
						JOptionPane.showMessageDialog(frame, "Liste ist jetzt leer");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Fehler löschen des Elements");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Fehler");
			}
		});

		JButton neu = new JButton("Neu");
		neu.setBounds(153, 81, 56, 23);
		frame.getContentPane().add(neu);
		neu.addActionListener(e -> {
			String auto = t2.getText();
			int jahr;
			try {
				jahr = Integer.parseInt(t1.getText());

				if (autoListe.istLeer() == true) {
					try {
						autoListe.einfuegenErstesElement(new Auto(auto, jahr));
						t1.setText("");
						t2.setText("");
					} catch (Exception e1) {
						t2.setText("");
						t1.setText("");
						JOptionPane.showMessageDialog(frame, "Fehler beim erstellen");
					}
				} else if (autoListe.istLeer() == false) {
					try {
						t1.setText("");
						t2.setText("");
						autoListe.elemente().einfuegenElement(new Auto(auto, jahr));

					} catch (Exception e1) {
						t2.setText("");
						t1.setText("");
						JOptionPane.showMessageDialog(frame, "Fehler beim erstellen");
					}
				} else {
					t2.setText("");
					t1.setText("");
					JOptionPane.showMessageDialog(frame, "Fehler");
				}
			} catch (NumberFormatException e1) {
				t2.setText("");
				t1.setText("");
				JOptionPane.showMessageDialog(frame, "Erstzulassung darf keine Buchstaben Beinhalten");
			}
		});

		JButton next = new JButton("N\u00E4chstes");
		next.setBounds(54, 81, 89, 23);
		frame.getContentPane().add(next);
		next.addActionListener(e -> {
			if (autoListe.istLeer() == true) {
				JOptionPane.showMessageDialog(frame, "Liste ist leer");

			} else if (autoListe.istLeer() == false && autoListe.elemente().hatNaechstesElement() == true) {
				try {
					Auto a = (Auto) autoIterator.naechstesElement();

					t2.setText(a.getName());
					t1.setText(a.getErstzulassung() + "");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Liste ist am Ende");
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Fehler");
			}
		});
		JLabel auto = new JLabel("Auto");
		auto.setHorizontalAlignment(SwingConstants.RIGHT);
		auto.setBounds(64, 19, 46, 14);
		frame.getContentPane().add(auto);

		JLabel lblNewLabel = new JLabel("Erstzulassung");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 44, 110, 14);
		frame.getContentPane().add(lblNewLabel);

		t1 = new JTextField();
		t1.setBounds(120, 41, 56, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setBounds(120, 16, 121, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
	}
}
