package Support;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SupportWindow {

    private JFrame frame;
    private Container container;
    private JButton needSupport = new JButton("Need Support"), giveSupport = new JButton("Give Support"), viewList = new JButton("View HelpList");

    public SupportWindow() {
        frame = new JFrame("Support");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(550, 270, 1000, 800);

        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.BLACK);

        needSupport.setBounds(350, 325, 300, 60);
        needSupport.setBackground(new Color(237, 87, 56));
        needSupport.setOpaque(true);
        needSupport.setBorderPainted(false);
        needSupport.setForeground(Color.BLACK);
        needSupport.setFont(new Font("Aerial", Font.BOLD, 20));
        container.add(needSupport);
        needSupport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HelpList();
            }
        });

        giveSupport.setBounds(350, 415, 300, 60);
        giveSupport.setBackground(new Color(237, 87, 56));
        giveSupport.setOpaque(true);
        giveSupport.setBorderPainted(false);
        giveSupport.setForeground(Color.BLACK);
        giveSupport.setFont(new Font("Aerial", Font.BOLD, 20));
        container.add(giveSupport);
        giveSupport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HelpList();
            }
        });

        viewList.setBounds(425, 710, 150, 40);
        container.add(viewList);
        viewList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewHelpList();
            }
        });
    }

    public void viewHelpList() {

        JFrame frame = new JFrame("HelpList");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(550, 270, 1000, 800);
        frame.setVisible(true);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(new Font("Aerial", Font.BOLD, 20));
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            String fileContents = readFile("HelpList.txt");
            textArea.setText(fileContents);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }



    private String readFile(String filename) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
