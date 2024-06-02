package Home;

import AddSyllabus.ChapterForm;
import AddSyllabus.CourseForm;
import ViewSyllabus.ViewSyllabus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindow extends HomeButtons {

    private JLabel label;
    private ImageIcon icon, image;
    JButton showSyllabusButton = new JButton("View Complete Syllabus");
    JButton addCourseButton = new JButton("Add New Course(s)");
    JButton addChapterButton = new JButton("Add New Chapter(s)");
    JButton addTopicButton = new JButton("Add New Topic(s)");

    public HomeWindow() {

        JFrame frame = new JFrame("EzNote - Home Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(480, 200, 1000, 800);

        icon = new ImageIcon(HomeWindow.class.getResource("EzNoteIcon.png"));
        frame.setIconImage(icon.getImage());

        image = new ImageIcon(HomeWindow.class.getResource("EzNoteImage.png"));
        label = new JLabel(image);
        label.setBounds(-50, 0, 1000, 300);

        Container container = frame.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.BLACK);
        container.add(label);

        addButton(container, showSyllabusButton, 170, 340, 300, 60);
        showSyllabusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewSyllabus();
            }
        });

        addButton(container, addCourseButton, 170, 430, 300, 60);
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CourseForm();
            }
        });

        addButton(container, addChapterButton, 170, 520, 300, 60);
        addChapterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChapterForm();
            }
        });

        addButton(container, addTopicButton, 170, 610, 300, 60);
        addTopicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call the method to open Topic Form window
            }
        });

    }
}
