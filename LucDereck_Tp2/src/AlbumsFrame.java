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
import javax.swing.JOptionPane;
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
	private Albums album;
	private JButton btnImage;
	private JButton btnConfirmer;
	private JLabel lblGenre;
	private JTextField textField_6;


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
		btnModifier.setEnabled(false);
		btnSupprimer.setEnabled(false);
		btnImage.setVisible(false);
		btnConfirmer.setVisible(false);
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
			panel_1.add(getBtnImage());
			panel_1.add(getBtnConfirmer());
			panel_1.add(getLblGenre());
			panel_1.add(getTextField_6());
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
					lblArtiste.setText("Artiste");
					textField.setEditable(false);
					btnModifier.setEnabled(true);
					btnSupprimer.setEnabled(true);
					btnImage.setVisible(false);
					btnConfirmer.setVisible(false);
					
					int numLigne;
					numLigne = tableAlbums.getSelectedRow();
					album = modeleAlbum.getElement(numLigne);
					
					textField.setText(String.valueOf(album.getNumero()));
					textField_1.setText(album.getTitre());
					textField_2.setText(String.valueOf(album.getAnnee()));
					textField_3.setText(album.getMaison());
					textField_4.setText(String.valueOf(album.getPrix()));
					textField_5.setText(gestionAlbums.getNomArtiste(album.getNumeroArtiste()));
					textField_6.setText(album.getGenre());
					
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
			lblNewLabel.setIcon(null);
			lblNewLabel.setText("");
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
			lblMaison.setBounds(10, 112, 46, 14);
		}
		return lblMaison;
	}
	private JLabel getLblPrix() {
		if (lblPrix == null) {
			lblPrix = new JLabel("Prix");
			lblPrix.setBounds(10, 146, 46, 14);
		}
		return lblPrix;
	}
	private JLabel getLblArtiste() {
		if (lblArtiste == null) {
			lblArtiste = new JLabel("Artiste");
			lblArtiste.setBounds(10, 177, 46, 14);
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
			textField_3.setBounds(77, 112, 112, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(77, 143, 112, 20);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(77, 174, 112, 20);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Ajouter");
			btnNewButton.setBounds(54, 53, 113, 23);
			
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ajouter();
				}
				
			});
		}
		return btnNewButton;
	}
	
	private void ajouter() {
		
		effacerInfos();
		lblArtiste.setText("#Artiste");
		
		textField.setEditable(true);	
		btnModifier.setEnabled(false);
		btnSupprimer.setEnabled(false);
		btnImage.setVisible(true);
		btnConfirmer.setVisible(true);

		
		
		btnConfirmer.setVisible(true);
		btnConfirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmerAjout();
			}
		});
	}
	
	private void confirmerAjout() {
		///////////////////
		try {
			int numero = Integer.parseInt(textField.getText());			
			String titre = textField_1.getText();
			int annee = Integer.parseInt(textField_2.getText());
			String maison =  textField_3.getText();
			double prix =  Double.parseDouble(textField_4.getText());
			int numeroArtiste = Integer.parseInt(textField_5.getText());
			String genre = textField_6.getText();
			String iconfilename = lblNewLabel.getIcon().toString();
			String fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
			

			
			album = new Albums(numero,titre,prix,genre,annee,maison,fileName,numeroArtiste);
			
			gestionAlbums.ajouterAlbumsBD(album);
			
			setAlbumsTable(gestionAlbums.getListeAlbums());

			
			effacerInfos();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification d'un album: Assurez vous de bien remplir les informations et de choisir une image"
					,"Ajouté un album", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void ajouterImage() {
		//////////////////////
		String chemin = GestionFichier.Ouvrir(this);
		lblNewLabel.setIcon(new ImageIcon(artistesFrame.class.getResource("/Images/" + chemin)));

		
	}
	
	private void effacerInfos() {
		
		tableAlbums.clearSelection();
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("Choisir une image");

		
		
	}
	
	private JButton getBtnModifier() {
		if (btnModifier == null) {
			btnModifier = new JButton("Modifier");
			btnModifier.setBounds(54, 106, 113, 23);
			
			
			btnModifier.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					modifier();
				}
				
			});
		}
		return btnModifier;
	}
	
	
	private void modifier() {
		btnConfirmer.setVisible(true);
		textField.setEditable(false);
		btnImage.setVisible(true);
		btnConfirmer.setVisible(true);
		lblArtiste.setText("# Artiste");
		textField_5.setText(String.valueOf(album.getNumeroArtiste()));

		
		btnConfirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmerModif();
			}
		});
	}
	
	
	private void confirmerModif() {
		
		String fileName;
		try {
		int numero = Integer.parseInt(textField.getText());			
		String titre = textField_1.getText();
		int annee = Integer.parseInt(textField_2.getText());
		String maison =  textField_3.getText();
		double prix =  Double.parseDouble(textField_4.getText());
		int numeroArtiste = Integer.parseInt(textField_5.getText());
		String genre = textField_6.getText();

		
		
		String iconfilename = lblNewLabel.getIcon().toString();
		fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);

		album = new Albums(numero,titre,prix,genre,annee,maison,fileName,numeroArtiste);
		
		gestionAlbums.modifierAlbumsBD(album);
		setAlbumsTable(gestionAlbums.getListeAlbums());
		
		} catch (Exception e) {
			fileName = "";
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification d'un album: Assurez vous de bien remplir les informations et de choisir une image" 
					,"Ajouté un album", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	private JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setBounds(54, 158, 113, 23);
			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if (album!=null) {
						
						int option = JOptionPane.showConfirmDialog(null,
								"Voulez-vous vraiment supprimer "+album.getTitre()+"?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if (option==JOptionPane.YES_OPTION) {
							gestionAlbums.supprimerAlbumBD(album);
							setAlbumsTable(gestionAlbums.getListeAlbums());
							effacerInfos();

						}
						
						
						
					}
					
				}
				
				
				
				
				
				
				
				
			});
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

	private JButton getBtnImage() {
		if (btnImage == null) {
			btnImage = new JButton("Image");
			btnImage.setBounds(247, 167, 93, 23);
			btnImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ajouterImage();
				}
			});
		}
		return btnImage;
	}
	private JButton getBtnConfirmer() {
		if (btnConfirmer == null) {
			btnConfirmer = new JButton("Confirmer");
			btnConfirmer.setBounds(247, 197, 93, 23);
			
		}
		return btnConfirmer;
	}
	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel("Genre");
			lblGenre.setBounds(10, 206, 46, 14);
		}
		return lblGenre;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setBounds(77, 205, 112, 20);
			textField_6.setColumns(10);
		}
		return textField_6;
	}
}
