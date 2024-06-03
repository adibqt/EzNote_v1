package ViewSyllabus;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewSyllabus {

    public ViewSyllabus(String filename) {

        JFrame frame = new JFrame(filename + " Syllabus");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(550, 270, 1000, 800);
        frame.setVisible(true);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setFont(new Font("Aerial", Font.BOLD, 20));
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            String fileContents = readFile(filename + ".txt");
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

