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

public class RechercheArtistes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3951303816400529286L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNumroDeLartiste;
	private JLabel lblNomDeLartiste;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RechercheArtistes dialog = new RechercheArtistes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RechercheArtistes() {
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
			}
			{
				JButton cancelButton = new JButton("Annuler");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
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
			panel.add(getTextField());
			panel.add(getTextField_1());
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(128, 8, 151, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(128, 40, 151, 20);
		}
		return textField_1;
	}
}
