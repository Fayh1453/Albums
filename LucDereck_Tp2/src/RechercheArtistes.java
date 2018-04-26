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

public class RechercheArtistes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3951303816400529286L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNumroDeLartiste;
	private JLabel lblNomDeLartiste;
	private JTextField textNum;
	private JTextField textNom;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param artistesFrame 
	 */
	public RechercheArtistes(artistesFrame artistesFrame) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RechercheArtistes.class.getResource("/Images/recherche.png")));
		setTitle("Rechercher un artiste");
		setBounds(100, 100, 327, 172);
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
						GestionArtiste temp = new GestionArtiste();
						
						artistesFrame.setArtistesTable(temp.rechercherArtistesBD(textNum.getText(), textNom.getText()));
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
			panel.setBounds(10, 11, 289, 80);
			panel.setLayout(null);
			panel.add(getLblNumroDeLartiste());
			panel.add(getLblNomDeLartiste());
			panel.add(getTextNum());
			panel.add(getTextNom());
		}
		return panel;
	}
	private JLabel getLblNumroDeLartiste() {
		if (lblNumroDeLartiste == null) {
			lblNumroDeLartiste = new JLabel("Num\u00E9ro de l'artiste :");
			lblNumroDeLartiste.setBounds(10, 11, 114, 14);
		}
		return lblNumroDeLartiste;
	}
	private JLabel getLblNomDeLartiste() {
		if (lblNomDeLartiste == null) {
			lblNomDeLartiste = new JLabel("Nom de l'artiste :");
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
	private JTextField getTextNom() {
		if (textNom == null) {
			textNom = new JTextField();
			textNom.setColumns(10);
			textNom.setBounds(128, 40, 151, 20);
		}
		return textNom;
	}
}
