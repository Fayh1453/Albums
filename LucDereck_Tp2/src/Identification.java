
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;

public class Identification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1345081747692026013L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel label;
	private JLabel lblConnexionAuProgramme;
	private JLabel lblNomDutilisateur;
	private JLabel lblMotDePasse;
	private JTextField textNom;
	private JButton btnValider;
	private JButton btnQuitter;
	private JPasswordField passwordField;
	private String username = "Test";
	private String password = "123";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identification frame = new Identification();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Identification() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/Images/connexionIcon.png")));
		setTitle("Gestion des albums");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getBtnValider());
		contentPane.add(getBtnQuitter());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(26, 31, 386, 177);
			panel.setLayout(null);
			panel.add(getLblConnexionAuProgramme());
			panel.add(getLblNomDutilisateur());
			panel.add(getLblMotDePasse());
			panel.add(getTextNom());
			panel.add(getPasswordField());
		}
		return panel;
	}

	/**
	 * @wbp.nonvisual location=101,-11
	 */
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("New label");
		}
		return label;
	}

	private JLabel getLblConnexionAuProgramme() {
		if (lblConnexionAuProgramme == null) {
			lblConnexionAuProgramme = new JLabel("Connexion au programme");
			lblConnexionAuProgramme.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblConnexionAuProgramme.setIcon(new ImageIcon(Identification.class.getResource("/Images/connexion.png")));
			lblConnexionAuProgramme.setBounds(39, 11, 311, 60);
		}
		return lblConnexionAuProgramme;
	}

	private JLabel getLblNomDutilisateur() {
		if (lblNomDutilisateur == null) {
			lblNomDutilisateur = new JLabel("Nom d'utilisateur");
			lblNomDutilisateur.setBounds(10, 98, 121, 14);
		}
		return lblNomDutilisateur;
	}

	private JLabel getLblMotDePasse() {
		if (lblMotDePasse == null) {
			lblMotDePasse = new JLabel("Mot de passe");
			lblMotDePasse.setBounds(10, 123, 113, 14);
		}
		return lblMotDePasse;
	}

	private JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField();
			textNom.setBounds(154, 95, 134, 20);
			textNom.setColumns(10);
		}
		return textNom;
	}

	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.setMnemonic('V');
			btnValider.setBounds(116, 230, 89, 23);

			btnValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if (verifier()) {
						System.out.println(textNom.getText());
						ControleConnexion.connecter();

						ChoixDesTraitements choix = new ChoixDesTraitements();
						choix.setLocationRelativeTo(null);
						choix.setVisible(true);
						choix.setResizable(false);
						
						close();
					}


				}

			});
		}
		return btnValider;
	}
	
	private void close() {
		setVisible(false);
		dispose();
	}

	private JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setMnemonic('Q');
			btnQuitter.setBounds(251, 230, 89, 23);

			btnQuitter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					dispose();
				}

			});
		}

		return btnQuitter;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(154, 120, 134, 20);
		}
		return passwordField;
	}
	
	private Boolean verifier() {
		
		Boolean accept = false;
		
		
		String passText = new String(passwordField.getPassword());
		if (textNom.getText().equals(username)&& passText.equals(password)) {
			accept=true;
			System.out.println("ACCEPTED");
		}else {
			JOptionPane.showMessageDialog(null, "Mauvais Nom d'utilisateur et/ou Mot de passe", "Erreur", JOptionPane.WARNING_MESSAGE);
		}
		
		
		return accept;
		
	}
}
