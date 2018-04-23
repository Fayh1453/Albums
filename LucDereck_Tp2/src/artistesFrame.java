import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

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
	private JList list;
	private JScrollPane scrollPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					artistesFrame frame = new artistesFrame();
					frame.setVisible(true);
					GestionArtiste gestion = new GestionArtiste(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public artistesFrame() {
		setTitle("Gestion des artistes, Ajout, Modification, Suppression, Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getPanelListeAlbums());
		contentPane.add(getPanel_2());
	}
	private JTable getArtistesTable() {
		if (artistesTable == null) {
			Icon membre = new ImageIcon("C:\\Users\\Luc\\Tp2\\LucDereck_Tp2\\bin\\Images\\member.gif");
			artistesTable = new JTable();
			artistesTable.setColumnSelectionAllowed(true);
			artistesTable.setCellSelectionEnabled(true);

			Object[][] data ={	
					{"1","Céline Dion", membre},
					{"2","Patrick Norman"},
					{"3","Martin Stevens", membre},	
					{"4","Coeur de Pirate"},
					{"4","Elvis Presley"}
			};
			
			
				/*for (Artistes art: liste.getListeArtistes()) {
					
					data[0][number]=art.getNumero();
					data[1][number]=art.getNom();
					if (art.getMembre())
					{data[2][number]=art.getMembre();}
					
					number++;
				};*/
			
			String[] columnNames = {"Num\u00E9ro", "Nom", "Membre"};
			
			artistesTable.setModel(new DefaultTableModel(data, columnNames) {
				
				public Class getColumnClass(int column)
				{
					return getValueAt(2,column).getClass();
				}
				
				
				
			}
					);
			
			artistesTable.getColumnModel().getColumn(0).setResizable(false);
			artistesTable.getColumnModel().getColumn(0).setPreferredWidth(50);
			artistesTable.getColumnModel().getColumn(0).setMinWidth(50);
			artistesTable.getColumnModel().getColumn(0).setMaxWidth(50);
			artistesTable.getColumnModel().getColumn(1).setResizable(false);
			artistesTable.getColumnModel().getColumn(1).setMinWidth(75);
			artistesTable.getColumnModel().getColumn(2).setResizable(false);
			artistesTable.getColumnModel().getColumn(2).setMinWidth(75);
			artistesTable.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		}
		return artistesTable;
	}
	private JPanel getPanelListeAlbums() {
		if (panelListeAlbums == null) {
			panelListeAlbums = new JPanel();
			panelListeAlbums.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panelListeAlbums.setBackground(Color.WHITE);
			panelListeAlbums.setBounds(266, 11, 387, 251);
			panelListeAlbums.setLayout(null);
			panelListeAlbums.add(getTextField());
			panelListeAlbums.add(getTextField_1());
			panelListeAlbums.add(getLblNumro());
			panelListeAlbums.add(getLblNom());
			panelListeAlbums.add(getLblMembre());
			panelListeAlbums.add(getCheckBox());
			panelListeAlbums.add(getLblImageAlbum());
			panelListeAlbums.add(getList_1());
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
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Supprimer");
			button_1.setBounds(48, 176, 132, 23);
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
				}
			    
			});
		}
		return btnQuitter;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("Modifier");
			button_3.setBounds(48, 112, 132, 23);
		}
		return button_3;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("Ajouter");
			button_4.setBounds(48, 54, 132, 23);
		}
		return button_4;
	}
	private JPanel getPanel_2() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setBackground(Color.WHITE);
			panelButtons.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panelButtons.setBounds(10, 11, 231, 419);
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
			lblImageAlbum.setIcon(new ImageIcon(artistesFrame.class.getResource("/Images/coeurDePirate.jpg")));
			lblImageAlbum.setBounds(209, 11, 90, 90);
		}
		return lblImageAlbum;
	}
	private JList getList_1() {
		if (list == null) {
			list = new JList();
			list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			list.setBounds(209, 112, 147, 115);
		}
		return list;
	}
	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(266, 273, 387, 157);
			scrollPane.setViewportView(getArtistesTable());
		}
		return scrollPane;
	}
}
