import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class artistesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable artistesTable;
	private JPanel panelListeAlbums;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNumro;
	private JLabel lblNom;
	private JLabel lblMembre;
	private JCheckBox checkBox;
	private JButton button;
	private JButton button_1;
	private JButton btnQuitter;
	private JButton button_3;
	private JButton button_4;
	private JPanel panelButtons;
	private JLabel lblImageAlbum;
	private JList<Albums> list;
	private JScrollPane scrollPane;
	private JButton btnConfirmer;
	private JButton btnImage;
	private Artistes artiste;
	private GestionArtiste gestionArtiste;
	private ModeleArtistes modeleArtistes;
	
	


	/**
	 * Create the frame.
	 */
	public artistesFrame() {
		setTitle("Gestion des artistes, Ajout, Modification, Suppression, Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getPanelListeAlbums());
		contentPane.add(getPanel_2());
		btnConfirmer.setVisible(false);
		btnImage.setVisible(false);
		button_3.setEnabled(false);
		button_1.setEnabled(false);
	}
	public JTable setArtistesTable(ArrayList<Artistes> liste) {
		
		modeleArtistes = new ModeleArtistes(liste);
		
		artistesTable.setModel(modeleArtistes);
		artistesTable.getColumnModel().getColumn(2).setCellRenderer(new RendererIcon());
		
		
		return artistesTable;
		
		
		
		
	}
	private JTable getArtistesTable() {
	
			
			if (artistesTable == null) {
				artistesTable = new JTable();
				artistesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				gestionArtiste = new GestionArtiste();
				modeleArtistes= new ModeleArtistes(gestionArtiste.getListeArtistes());
				artistesTable.setModel(modeleArtistes);
				artistesTable.getColumnModel().getColumn(2).setCellRenderer(new RendererIcon());
				
				
				
				artistesTable.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						button_3.setEnabled(true);
						button_1.setEnabled(true);
						textField.setEditable(false);
						btnImage.setVisible(false);
						int numLigne;
						numLigne = artistesTable.getSelectedRow();
						artiste = modeleArtistes.getElement(numLigne);

						btnConfirmer.setVisible(false);
				

						
						textField.setText(String.valueOf(artiste.getNumero()));
						textField_1.setText(String.valueOf(artiste.getNom()));
						artistesTable.getColumnModel().getColumn(2).setCellRenderer(new RendererIcon());
						
						if (artiste.getMembre()) {
							checkBox.setSelected(true);
						} else {
							checkBox.setSelected(false);
						}	
						String image = artiste.getPhoto();
						try {
							lblImageAlbum.setIcon(new ImageIcon(artistesFrame.class.getResource("/Images/" + image)));
						} catch (Exception error) {
							lblImageAlbum.setIcon(null);
							lblImageAlbum.setText("Image non disponible");
						}	
						
						list.setVisible(true);
						list.setModel(gestionArtiste.getListeAlbum(artiste.getNumero()));
					}

					
					
					
				});
				
				modeleArtistes.addTableModelListener(new TableModelListener() {

					@Override
					public void tableChanged(TableModelEvent e) {
						// TODO Auto-generated method stub
						switch(e.getType()) {
						case TableModelEvent.INSERT:
							System.out.println("Il y a eu insertion");
							break;
						case TableModelEvent.DELETE:
							System.out.println("Il y a ey suppression");
							break;
						case TableModelEvent.UPDATE:
							System.out.println("Il y a eu modification");
							break;
						default:break;
						}
					}
					
				});
				
						
			}
			
			return artistesTable;
				
	}
	private JPanel getPanelListeAlbums() {
		if (panelListeAlbums == null) {
			panelListeAlbums = new JPanel();
			panelListeAlbums.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panelListeAlbums.setBackground(Color.WHITE);
			panelListeAlbums.setBounds(266, 11, 387, 264);
			panelListeAlbums.setLayout(null);
			panelListeAlbums.add(getTextField());
			panelListeAlbums.add(getTextField_1());
			panelListeAlbums.add(getLblNumro());
			panelListeAlbums.add(getLblNom());
			panelListeAlbums.add(getLblMembre());
			panelListeAlbums.add(getCheckBox());
			panelListeAlbums.add(getLblImageAlbum());
			panelListeAlbums.add(getList_1());
			panelListeAlbums.add(getBtnConfirmer());
			panelListeAlbums.add(getBtnImage());
		}
		return panelListeAlbums;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(95, 78, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(95, 109, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNumro() {
		if (lblNumro == null) {
			lblNumro = new JLabel("Num\u00E9ro");
			lblNumro.setBounds(25, 81, 46, 14);
		}
		return lblNumro;
	}
	private JLabel getLblNom() {
		if (lblNom == null) {
			lblNom = new JLabel("Nom");
			lblNom.setBounds(25, 112, 46, 14);
		}
		return lblNom;
	}
	private JLabel getLblMembre() {
		if (lblMembre == null) {
			lblMembre = new JLabel("Membre");
			lblMembre.setBounds(25, 141, 63, 14);
		}
		return lblMembre;
	}
	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("");
			checkBox.setBackground(Color.WHITE);
			checkBox.setBounds(94, 137, 21, 23);
		}
		return checkBox;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Rechercher");
			button.setBounds(48, 234, 132, 23);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					RechercheArtistes recherche = new RechercheArtistes(artistesFrame.this);
					recherche.setModal(true);
					recherche.setLocationRelativeTo(null);
					recherche.setVisible(true);
					recherche.setResizable(false);
				}
				
			});
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Supprimer");
			button_1.setBounds(48, 176, 132, 23);
			button_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					if (artiste!=null) {
						
						int option = JOptionPane.showConfirmDialog(null,
								"Voulez-vous vraiment supprimer "+artiste.getNom()+"?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						
						if (option==JOptionPane.YES_OPTION) {
							gestionArtiste.supprimerArtistesBD(artiste);

							setArtistesTable(gestionArtiste.getListeArtistes());
							
							effacerInfos();
						}
						
						
						
					}
					
				}
				
				
				
				
				
				
				
				
			});
		}
		return button_1;
	}
	private JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(48, 298, 132, 23);
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
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("Modifier");
			button_3.setBounds(48, 112, 132, 23);
			
			button_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					modifier();
				}
				
			});
		}
		return button_3;
	}
	private JButton getButton_4() {
		
		if (button_4 == null) {
			button_4 = new JButton("Ajouter");
			button_4.setBounds(48, 54, 132, 23);
			
			button_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ajouter();
				}
				
			});
		}
			
		return button_4;
	}
	
	private void ajouter() {
		
		effacerInfos();
		
		textField.setEditable(true);	
		button_3.setEnabled(false);
		button_1.setEnabled(false);
		btnImage.setVisible(true);
		
		
		btnConfirmer.setVisible(true);
		btnConfirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmerAjout();
			}
		});
	}
	
	private void effacerInfos() {
		
		artistesTable.clearSelection();
		textField.setText("");
		textField_1.setText("");
		lblImageAlbum.setIcon(null);
		lblImageAlbum.setText("Choisir une image");	
		checkBox.setSelected(false);
		list.setVisible(false);
		
	}
	
	private void modifier() {
		btnConfirmer.setVisible(true);
		textField.setEditable(false);
		btnImage.setVisible(true);

		
		btnConfirmer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confirmerModif();
			}
		});
	}
	
	private void confirmerAjout() {
		///////////////////
		try {
			int numero = Integer.parseInt(textField.getText());
			
			String nom = textField_1.getText();
			
			boolean membre = false;
			
			if ( checkBox.isSelected()) {
				membre = true;
			}
			
			String iconfilename = lblImageAlbum.getIcon().toString();
			String fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
			
			artiste = new Artistes(numero,nom,membre,fileName);
			
			gestionArtiste.ajouterArtistesBD(artiste);

			
			setArtistesTable(gestionArtiste.getListeArtistes());


			
			effacerInfos();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de l'ajout d'un artiste: Assurez vous de bien remplir les informations et l'image "  ,"Ajouté un artiste", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void confirmerModif() {
		
		int numero = Integer.parseInt(textField.getText());
		
		String nom = textField_1.getText();
		
		boolean membre = false;
		
		if ( checkBox.isSelected()) {
			membre = true;
		}
		
		String iconfilename = lblImageAlbum.getIcon().toString();
		String fileName = iconfilename.substring(iconfilename.lastIndexOf("/"  ) + 1);
		
		try {
			artiste = new Artistes(numero,nom,membre,fileName);
			
			gestionArtiste.modifierArtistesBD(artiste);
			setArtistesTable(gestionArtiste.getListeArtistes());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problème rencontr\u00E9 lors de la modification d'un artiste : Assurez vous de bien remplir les informations et l'image" ,"Ajouté un artiste", JOptionPane.ERROR_MESSAGE);
		}


		
	}
	
	private void ajouterImage() {
		//////////////////////
		String chemin = GestionFichier.Ouvrir(this);
		lblImageAlbum.setIcon(new ImageIcon(artistesFrame.class.getResource("/Images/" + chemin)));

		
	}
	

	private JPanel getPanel_2() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setBackground(Color.WHITE);
			panelButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panelButtons.setBounds(10, 11, 231, 432);
			panelButtons.setLayout(null);
			panelButtons.add(getButton());
			panelButtons.add(getButton_1());
			panelButtons.add(getBtnQuitter());
			panelButtons.add(getButton_3());
			panelButtons.add(getButton_4());
		}
		return panelButtons;
	}
	private JLabel getLblImageAlbum() {
		if (lblImageAlbum == null) {
			lblImageAlbum = new JLabel("");
			lblImageAlbum.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblImageAlbum.setBounds(209, 11, 90, 90);
		}
		return lblImageAlbum;
	}
	private JList<Albums> getList_1() {
		if (list == null) {
			list = new JList<Albums>();
			list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			list.setBounds(209, 112, 147, 115);
		}
		return list;
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(266, 286, 387, 157);
			scrollPane.setViewportView(getArtistesTable());
		}
		return scrollPane;
	}
	private JButton getBtnConfirmer() {
		if (btnConfirmer == null) {
			btnConfirmer = new JButton("Confirmer");
			btnConfirmer.setBounds(25, 198, 129, 23);
		}
		return btnConfirmer;
	}

	private JButton getBtnImage() {
		if (btnImage == null) {
			btnImage = new JButton("Image");
			btnImage.setFont(new Font("Tahoma", Font.PLAIN, 8));
			btnImage.setBounds(25, 166, 63, 23);
			
			btnImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ajouterImage();
				}
			});
		}
		return btnImage;
	}
}
