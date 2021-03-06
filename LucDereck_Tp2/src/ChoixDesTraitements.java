
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

public class ChoixDesTraitements extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnArtistes;
	private JButton btnAlbums;
	private JButton btnQuitter;
	private JLabel lblChoixDesTraitements;
	private JButton btnAide;


	/**
	 * Create the frame.
	 */
	public ChoixDesTraitements() {
		setResizable(false);
		setTitle("Choix des traitements");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 10, 275, 275);
			panel.setLayout(null);
			panel.add(getBtnArtistes());
			panel.add(getBtnAlbums());
			panel.add(getBtnQuitter());
			panel.add(getLblChoixDesTraitements());
			panel.add(getBtnAide());
		}
		return panel;
	}

	private JButton getBtnArtistes() {
		if (btnArtistes == null) {
			btnArtistes = new JButton("Artistes");
			btnArtistes.setBounds(84, 100, 89, 23);

			btnArtistes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					ArtistesFrame artistes = new ArtistesFrame();
					
					GestionQuitter.confirmerQuitter(artistes);
					artistes.setLocationRelativeTo(null);
					artistes.setVisible(true);
					artistes.setResizable(false);

				}

			});
		}
		return btnArtistes;
	}

	private JButton getBtnAlbums() {
		if (btnAlbums == null) {
			btnAlbums = new JButton("Albums");
			btnAlbums.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAlbums.setBounds(84, 146, 89, 23);

			btnAlbums.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					AlbumsFrame albums = new AlbumsFrame();
					GestionQuitter.confirmerQuitter(albums);
					albums.setLocationRelativeTo(null);
					albums.setVisible(true);
					albums.setResizable(false);

				}

			});
		}
		return btnAlbums;
	}

	private JButton getBtnQuitter() {
		if (btnQuitter == null) {
			btnQuitter = new JButton("Quitter");
			btnQuitter.setBounds(84, 191, 89, 23);

			btnQuitter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					dispose();
				}

			});
		}
		return btnQuitter;
	}

	private JLabel getLblChoixDesTraitements() {
		if (lblChoixDesTraitements == null) {
			lblChoixDesTraitements = new JLabel("Choix des traitements");
			lblChoixDesTraitements.setHorizontalAlignment(SwingConstants.CENTER);
			lblChoixDesTraitements.setFont(new Font("Times New Roman", Font.BOLD, 20));
			lblChoixDesTraitements.setBounds(10, 41, 239, 35);
		}
		return lblChoixDesTraitements;
	}

	private JButton getBtnAide() {
		if (btnAide == null) {
			btnAide = new JButton("Aide");
			btnAide.setBounds(84, 230, 89, 23);
			btnAide.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						String filePath = new File("").getAbsolutePath();
						File fleFichier = new File(filePath+"/bin/aideEnligne.chm");
						Desktop.getDesktop().open(fleFichier);
						
						
					} catch(IOException msg) {
						System.out.println(msg);
					}
				}

			}

			);

		}
		return btnAide;
	}
}
