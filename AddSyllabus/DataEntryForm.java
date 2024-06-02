package AddSyllabus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DataEntryForm extends Syllabus {

    public DataEntryForm() {
    }

    public DataEntryForm(String name, String code) {
        super(name, code);
    }

    public void dataEntryForm(JFrame frame, Container container, JLabel jNameLabel, JTextField jNameField, JLabel jCodeLabel, JTextField jCodeField, JButton jButton) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        container.setLayout(null);
        container.setBackground(Color.BLACK);

        jNameLabel.setForeground(new Color(237, 87, 56));
        jNameLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        jNameLabel.setBounds(150, 300, 170, 40);
        container.add(jNameLabel);

        jNameField.setFont(new Font("Aerial", Font.PLAIN, 20));
        jNameField.setOpaque(true);
        jNameField.setBounds(330, 290, 500, 60);
        container.add(jNameField);

        jCodeLabel.setForeground(new Color(237, 87, 56));
        jCodeLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        jCodeLabel.setBounds(150, 400, 170, 40);
        container.add(jCodeLabel);

        jCodeField.setFont(new Font("Aerial", Font.PLAIN, 20));
        jCodeField.setOpaque(true);
        jCodeField.setBounds(330, 390, 500, 60);
        container.add(jCodeField);

        jButton.setBounds(425, 710, 150, 40);
        container.add(jButton);
    }

    public void insertDataAfterText(String fileName, String marker, String newData, String chapterName, String chapterNumber) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        int index1 = content.indexOf(chapterName);
        int index2 = content.indexOf(chapterNumber);

        if (index1 != -1 && index2 != -1) {
            JOptionPane.showMessageDialog(null, "This Chapter has already been added");
        } else {
            int index3 = content.indexOf(marker);
            if (index3 != -1) {
                index3 += marker.length();
                content.insert(index3, "\n" + newData);
            } else {
                content.append("\n").append(newData);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content.toString());
            }

            JOptionPane.showMessageDialog(null, "Data saved to file.");
        }
    }
}


