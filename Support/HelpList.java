package Support;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HelpList {

    private JFrame frame = new JFrame("Help List Manipulation");
    private Container container;
    private JLabel courseLabel = new JLabel("Course: "), topicLabel = new JLabel("Topic: "), exerciseExampleLabel = new JLabel("Exercise/Example: ");
    private JTextField courseField = new JTextField(), topicField = new JTextField(), exerciseExampleField = new JTextField();
    private JButton addToList = new JButton("Add To HelpList"), viewList = new JButton("View HelpList");

    public HelpList() {
        frame.setBounds(550, 270, 1000, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.BLACK);

        courseLabel.setForeground(new Color(237, 87, 56));
        courseLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseLabel.setBounds(150, 250, 170, 40);
        container.add(courseLabel);

        courseField.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseField.setOpaque(true);
        courseField.setBounds(340, 240, 500, 60);
        container.add(courseField);

        topicLabel.setForeground(new Color(237, 87, 56));
        topicLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        topicLabel.setBounds(150, 350, 170, 40);
        container.add(topicLabel);

        topicField.setFont(new Font("Aerial", Font.PLAIN, 20));
        topicField.setOpaque(true);
        topicField.setBounds(340, 340, 500, 60);
        container.add(topicField);

        exerciseExampleLabel.setForeground(new Color(237, 87, 56));
        exerciseExampleLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        exerciseExampleLabel.setBounds(150, 450, 170, 40);
        container.add(exerciseExampleLabel);

        exerciseExampleField.setFont(new Font("Aerial", Font.PLAIN, 20));
        exerciseExampleField.setOpaque(true);
        exerciseExampleField.setBounds(340, 440, 500, 60);
        container.add(exerciseExampleField);

        addToList.setBounds(425, 710, 150, 40);
        container.add(addToList);
        addToList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData(courseField.getText(), topicField.getText(), exerciseExampleField.getText());
            }
        });

    }

    public void saveData(String course, String topic, String exerciseExample) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HelpList.txt", true))) {
            writer.write("Course Name: " + course);
            writer.newLine();
            writer.write("Topic Name: " + topic);
            writer.newLine();
            writer.write("Exercise/Example: " + exerciseExample);
            writer.newLine();
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Course Data saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
