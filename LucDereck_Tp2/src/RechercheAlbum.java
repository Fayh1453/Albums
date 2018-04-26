import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechercheAlbum extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3951303816400529286L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNumroDeLartiste;
	private JLabel lblNomDeLartiste;
	private JTextField textNum;
	private JTextField textTitre;
	private JLabel lblArtisteDeLalbum;
	private JTextField textArtiste;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param albumsFrame 
	 */
	public RechercheAlbum(AlbumsFrame albumsFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RechercheAlbum.class.getResource("/Images/recherche.png")));
		setTitle("Rechercher un album");
		setBounds(100, 100, 327, 201);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPanel());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Rechercher");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						GestionAlbums temp = new GestionAlbums();
						
						albumsFrame.setAlbumsTable(temp.rechercherAlbumsBD(textNum.getText(), textTitre.getText(), textArtiste.getText()));
						dispose();
					}
					
				});
				
		
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
					
				});
			}
		}
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 289, 112);
			panel.setLayout(null);
			panel.add(getLblNumroDeLartiste());
			panel.add(getLblNomDeLartiste());
			panel.add(getTextNum());
			panel.add(getTextTitre());
			panel.add(getLblArtisteDeLalbum());
			panel.add(getTextArtiste());
		}
		return panel;
	}
	private JLabel getLblNumroDeLartiste() {
		if (lblNumroDeLartiste == null) {
			lblNumroDeLartiste = new JLabel("Num\u00E9ro de l'album :");
			lblNumroDeLartiste.setBounds(10, 11, 114, 14);
		}
		return lblNumroDeLartiste;
	}
	private JLabel getLblNomDeLartiste() {
		if (lblNomDeLartiste == null) {
			lblNomDeLartiste = new JLabel("Titre de l'album :");
			lblNomDeLartiste.setBounds(10, 43, 114, 14);
		}
		return lblNomDeLartiste;
	}
	private JTextField getTextNum() {
		if (textNum == null) {
			textNum = new JTextField();
			textNum.setBounds(128, 8, 151, 20);
			textNum.setColumns(10);
		}
		return textNum;
	}
	private JTextField getTextTitre() {
		if (textTitre == null) {
			textTitre = new JTextField();
			textTitre.setColumns(10);
			textTitre.setBounds(128, 40, 151, 20);
		}
		return textTitre;
	}
	private JLabel getLblArtisteDeLalbum() {
		if (lblArtisteDeLalbum == null) {
			lblArtisteDeLalbum = new JLabel("Artiste de l'album :");
			lblArtisteDeLalbum.setBounds(10, 71, 114, 14);
		}
		return lblArtisteDeLalbum;
	}
	private JTextField getTextArtiste() {
		if (textArtiste == null) {
			textArtiste = new JTextField();
			textArtiste.setColumns(10);
			textArtiste.setBounds(128, 68, 151, 20);
		}
		return textArtiste;
	}
}
