package AddSyllabus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseForm extends DataEntryForm {

    private JFrame frame = new JFrame("Add New Course");
    private Container container;
    private JLabel courseNameLabel = new JLabel("Course Name:"), courseCodeLabel = new JLabel("Course Code:"), fileNameLabel = new JLabel("File Name: "), noteIconLabel;
    private JTextField courseNameField = new JTextField(), courseCodeField = new JTextField(), fileNameField = new JTextField();
    private JButton addCourseButton = new JButton("Add Course");
    private List<CourseForm> courseList = new ArrayList<>();
    private ImageIcon noteIcon;

    public CourseForm(String name, String code) {
        super(name, code);
    }

    public CourseForm() {
        frame.setBounds(550, 270, 1000, 800);
        container = frame.getContentPane();
        noteIcon = new ImageIcon(ChapterForm.class.getResource("NoteIcon.png"));
        noteIconLabel = new JLabel(noteIcon);
        noteIconLabel.setBounds(0, 0, 200, 200);

        dataEntryForm(frame, container, courseNameLabel, courseNameField, courseCodeLabel, courseCodeField, addCourseButton);

        container.add(noteIconLabel);

        fileNameLabel.setForeground(new Color(237, 87, 56));
        fileNameLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        fileNameLabel.setBounds(150, 250, 170, 40);
        container.add(fileNameLabel);

        fileNameField.setFont(new Font("Aerial", Font.PLAIN, 20));
        fileNameField.setOpaque(true);
        fileNameField.setBounds(340, 240, 500, 60);
        container.add(fileNameField);

        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(courseNameField.getText().equals("") || courseCodeField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    saveData(courseNameField.getText(), courseCodeField.getText(), fileNameField.getText());
                }
            }
        });
    }

    @Override
    public void saveData(String name, String code, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt", true))) {
            writer.write("Course Name: " + name);
            writer.newLine();
            writer.write("Course Code: " + code);
            writer.newLine();
            writer.newLine();
            writer.write("Chapters included in this Course: ");
            writer.newLine();
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Course Data saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
