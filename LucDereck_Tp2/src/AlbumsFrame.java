import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AlbumsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8283572707302029259L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JTable tableAlbums;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblTire;
	private JLabel lblTitre;
	private JLabel lblAnnee;
	private JLabel lblMaison;
	private JLabel lblPrix;
	private JLabel lblArtiste;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnRechercher;
	private JButton btnQuitter;
	private ModeleAlbums modeleAlbum;
	private GestionAlbums gestionAlbums;


	/**
	 * Create the frame.
	 */
	public AlbumsFrame() {
		setTitle("Gestion des albums, Ajout, Modification, Suppression, Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getScrollPane());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 225, 347);
			panel.setLayout(null);
			panel.add(getBtnNewButton());
			panel.add(getBtnModifier());
			panel.add(getBtnSupprimer());
			panel.add(getBtnRechercher());
			panel.add(getBtnQuitter());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(245, 11, 365, 238);
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel());
			panel_1.add(getLblTire());
			panel_1.add(getLblTitre());
			panel_1.add(getLblAnnee());
			panel_1.add(getLblMaison());
			panel_1.add(getLblPrix());
			panel_1.add(getLblArtiste());
			panel_1.add(getTextField());
			panel_1.add(getTextField_1());
			panel_1.add(getTextField_2());
			panel_1.add(getTextField_3());
			panel_1.add(getTextField_4());
			panel_1.add(getTextField_5());
		}
		return panel_1;
	}
	public JTable setAlbumsTable(ArrayList<Albums> liste) {
		modeleAlbum = new ModeleAlbums(liste);
		tableAlbums.setModel(modeleAlbum);

		
		
		return tableAlbums;
		
		
		
		
	}
	private JTable getTableAlbums() {
		if (tableAlbums == null) {
			tableAlbums = new JTable();
			gestionAlbums = new GestionAlbums();
			modeleAlbum = new ModeleAlbums(gestionAlbums.getListeAlbums());
			tableAlbums.setModel(modeleAlbum);
			
			tableAlbums.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int numLigne;
					numLigne = tableAlbums.getSelectedRow();
					Albums album = modeleAlbum.getElement(numLigne);
					
					textField.setText(String.valueOf(album.getNumero()));
					textField_1.setText(album.getTitre());
					textField_2.setText(String.valueOf(album.getAnnee()));
					textField_3.setText(album.getMaison());
					textField_4.setText(String.valueOf(album.getPrix() + " $"));
					textField_5.setText(gestionAlbums.getNomArtiste(album.getNumeroArtiste()));
					
					String image = album.getImage();
					try {
					lblNewLabel.setIcon(new ImageIcon(AlbumsFrame.class.getResource("/Images/" + image)));
					} catch (Exception error) {
						lblNewLabel.setIcon(null);
						lblNewLabel.setText("Image non disponible");
					}
					
					
					
					
				}
			});
					
			}
		
		return tableAlbums;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(245, 260, 365, 98);
			scrollPane.setViewportView(getTableAlbums());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(AlbumsFrame.class.getResource("/Images/tooMuchTooLate.png")));
			lblNewLabel.setBounds(247, 64, 90, 90);
		}
		return lblNewLabel;
	}
	private JLabel getLblTire() {
		if (lblTire == null) {
			lblTire = new JLabel("Num\u00E9ro");
			lblTire.setBounds(10, 17, 46, 14);
		}
		return lblTire;
	}
	private JLabel getLblTitre() {
		if (lblTitre == null) {
			lblTitre = new JLabel("Titre");
			lblTitre.setBounds(10, 49, 46, 14);
		}
		return lblTitre;
	}
	private JLabel getLblAnnee() {
		if (lblAnnee == null) {
			lblAnnee = new JLabel("Ann\u00E9e");
			lblAnnee.setBounds(10, 87, 46, 14);
		}
		return lblAnnee;
	}
	private JLabel getLblMaison() {
		if (lblMaison == null) {
			lblMaison = new JLabel("Maison");
			lblMaison.setBounds(10, 121, 46, 14);
		}
		return lblMaison;
	}
	private JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix");
			lblPrix.setBounds(10, 159, 46, 14);
		}
		return lblPrix;
	}
	private JLabel getLblArtiste() {
		if (lblArtiste == null) {
			lblArtiste = new JLabel("Artiste");
			lblArtiste.setBounds(10, 201, 46, 14);
		}
		return lblArtiste;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(77, 14, 112, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(77, 46, 112, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(77, 81, 112, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(77, 118, 112, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(77, 156, 112, 20);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(77, 198, 112, 20);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ajouter");
			btnNewButton.setBounds(54, 53, 113, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnModifier() {
		if (btnModifier == null) {
			btnModifier = new JButton("Modifier");
			btnModifier.setBounds(54, 106, 113, 23);
		}
		return btnModifier;
	}
	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBounds(54, 158, 113, 23);
		}
		return btnSupprimer;
	}
	private JButton getBtnRechercher() {
		if (btnRechercher == null) {
			btnRechercher = new JButton("Rechercher");
			btnRechercher.setBounds(54, 216, 113, 23);
			btnRechercher.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					RechercheAlbum recherche = new RechercheAlbum(AlbumsFrame.this);
					recherche.setModal(true);
					recherche.setLocationRelativeTo(null);
					recherche.setVisible(true);
					recherche.setResizable(false);
				}
				
			});
		}
		return btnRechercher;
	}
	private JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(54, 268, 113, 23);
			
			btnQuitter.addActionListener(new ActionListener() {


				@Override
				public void actionPerformed(ActionEvent arg0) {
	
					dispose();
					ChoixDesTraitements choix = new ChoixDesTraitements();
					choix.setLocationRelativeTo(null);
					choix.setVisible(true);
					choix.setResizable(false);
				}
			    
			});
		}
		return btnQuitter;
	}

}
