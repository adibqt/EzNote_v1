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

    private JFrame frame = new JFrame("EzNote - Add New Course");
    private Container container;
    JLabel courseNameLabel = new JLabel("Course Name:");
    JLabel courseCodeLabel = new JLabel("Course Code:");
    private JTextField courseNameField = new JTextField();
    private JTextField courseCodeField = new JTextField();
    private JButton addCourseButton = new JButton("Add Course");
    private List<CourseForm> courseList = new ArrayList<>();

    public CourseForm(String name, String code) {
        super(name, code);
    }

    public CourseForm() {
        frame.setBounds(550, 270, 1000, 800);
        container = frame.getContentPane();
        dataEntryForm(frame, container, courseNameLabel, courseNameField, courseCodeLabel, courseCodeField, addCourseButton);

        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(courseNameField.getText().equals("") || courseCodeField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addData();
                    saveData(courseNameField.getText(), courseCodeField.getText());
                }
            }
        });
    }

    @Override
    public void addData() {
        try {
            String courseName = courseNameField.getText();
            String courseCode = courseCodeField.getText();

            CourseForm course = new CourseForm(courseName, courseCode);
            courseList.add(course);
        } catch(Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void saveData(String name, String code) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Syllabus.txt", true))) {
            writer.write("Course Name: " + name);
            writer.newLine();
            writer.write("Course Code: " + code);
            writer.newLine();
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Course Data saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
