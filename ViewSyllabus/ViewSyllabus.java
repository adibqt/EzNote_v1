package ViewSyllabus;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewSyllabus {

    public ViewSyllabus() {

        JFrame frame = new JFrame("EzNote - Full Syllabus");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(550, 270, 1000, 800);
        frame.setVisible(true);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
//        textArea.setBackground(Color.BLACK);
//        textArea.setForeground(new Color(237, 87, 56));
        textArea.setFont(new Font("Aerial", Font.BOLD, 20));
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            String fileContents = readFile("Syllabus.txt");
            textArea.setText(fileContents);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}

