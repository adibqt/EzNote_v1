package Resources;

import AddSyllabus.ChapterForm;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PersonalNotes extends Notes {

    private JFrame frame = new JFrame("Personal Notes Links");
    private Container container;
    private JButton openLinkButton1 = new JButton("P.N." + this.getNoteProviderName1() + " " + this.getNoteProviderID()), openLinkButton2 = new JButton("P.N." + this.getNoteProviderName2() + " " + this.getNoteProviderID());
    private JLabel noteIconLabel;
    private ImageIcon noteIcon;

    public PersonalNotes(String noteProviderName, String noteProviderID) {
        super(noteProviderName, noteProviderID);
    }

    public PersonalNotes() {
        frame.setVisible(true);
        frame.setBounds(440, 230, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        noteIcon = new ImageIcon(ChapterForm.class.getResource("NoteIcon.png"));
        noteIconLabel = new JLabel(noteIcon);
        noteIconLabel.setBounds(0, 0, 200, 200);

        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.BLACK);
        container.add(noteIconLabel);

        openLinkButton1.setBounds(350, 325, 300, 60);
        openLinkButton1.setBackground(new Color(237, 87, 56));
        openLinkButton1.setOpaque(true);
        openLinkButton1.setBorderPainted(false);
        openLinkButton1.setForeground(Color.BLACK);
        openLinkButton1.setFont(new Font("Aerial", Font.BOLD, 20));
        openLinkButton1.addActionListener(e -> openWebLink("https://drive.google.com/drive/folders/1MiCEOlp78JXM59neUp_nuRhm1zlDHumG?usp=sharing"));
        container.add(openLinkButton1);

        openLinkButton2.setBounds(350, 415, 300, 60);
        openLinkButton2.setBackground(new Color(237, 87, 56));
        openLinkButton2.setOpaque(true);
        openLinkButton2.setBorderPainted(false);
        openLinkButton2.setForeground(Color.BLACK);
        openLinkButton2.setFont(new Font("Aerial", Font.BOLD, 20));
        openLinkButton2.addActionListener(e -> openWebLink("https://drive.google.com/drive/folders/11bsnn9QVks4Huh6u9hUTYmxLl1sbqOuF?usp=sharing"));
        container.add(openLinkButton2);
    }

    private void openWebLink(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to open link: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desktop is not supported on this system", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
