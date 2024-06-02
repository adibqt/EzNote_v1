package AddSyllabus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CourseForm extends Syllabus {

    private Container c;
    private JTextField courseNameField;
    private JTextField courseCodeField;
    private JButton addCourseButton;
    private List<CourseForm> courseList = new ArrayList<>();

    public CourseForm(String name, String code) {
        super(name, code);
    }

    public CourseForm() {
        JFrame frame = new JFrame();
        frame.setTitle("EzNote - Add New Course");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(550, 270, 1000, 800);

        c = frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        //Adding the Course Name:
        JLabel courseNameLabel = new JLabel("Course Name:");
        courseNameLabel.setForeground(new Color(237, 87, 56));
        courseNameLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseNameLabel.setBounds(170, 300, 140, 40);
        c.add(courseNameLabel);
        courseNameField = new JTextField();
        courseNameField.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseNameField.setOpaque(true);
        courseNameField.setBounds(330, 290, 500, 60);
        c.add(courseNameField);

        //Adding the Course Code:
        JLabel courseCodeLabel = new JLabel("Course Code:");
        courseCodeLabel.setForeground(new Color(237, 87, 56));
        courseCodeLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseCodeLabel.setBounds(170, 400, 140, 40);
        c.add(courseCodeLabel);
        courseCodeField = new JTextField();
        courseCodeField.setFont(new Font("Aerial", Font.PLAIN, 20));
        courseCodeField.setOpaque(true);
        courseCodeField.setBounds(330, 390, 500, 60);
        c.add(courseCodeField);

        //"Add Course" Button:
        addCourseButton = new JButton("Add Course");
        addCourseButton.setBounds(425, 710, 150, 40);
        c.add(addCourseButton);
        //Add Action Listener to this Button:
        addCourseButton.addActionListener(new ActionListener() {
            @Override
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
        super.saveData(name, code);
    }

}
