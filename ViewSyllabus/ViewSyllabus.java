package ViewSyllabus;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewSyllabus {

    public ViewSyllabus() {
        JFrame frame = new JFrame("EzNote - View Full Syllabus");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(550, 270, 1000, 800);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll bars
        frame.add(scrollPane, BorderLayout.NORTH);

        try {
            String fileContents = readFile("courses.txt"); // Replace "data.txt" with your file name
            textArea.setText(fileContents);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }

        frame.setVisible(true);
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

