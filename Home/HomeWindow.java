package Home;

import AddSyllabus.ChapterForm;
import AddSyllabus.CourseForm;
import Resources.ClassNotes;
import Resources.PersonalNotes;
import ViewSyllabus.ViewSyllabus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindow extends HomeButtons {

    private JLabel label;
    private ImageIcon icon, image;
    JButton showSyllabusButton = new JButton("View Syllabus");
    JButton addCourseButton = new JButton("Add New Course(s)");
    JButton addChapterButton = new JButton("Add New Chapter(s)");
    JButton addTopicButton = new JButton("Add New Topic(s)"), openClassNotesWindowButton = new JButton("Open Class Notes Window"), openPersonalNotesWindowButton = new JButton("Open Personal Notes Window");

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

        addButton(container, showSyllabusButton, 150, 340, 320, 60);
        showSyllabusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewSyllabus(JOptionPane.showInputDialog(null, "Course: ", "Which Course Syllabus to Open", JOptionPane.QUESTION_MESSAGE));
            }
        });

        addButton(container, addCourseButton, 150, 430, 320, 60);
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CourseForm();
            }
        });

        addButton(container, addChapterButton, 150, 520, 320, 60);
        addChapterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChapterForm();
            }
        });

        addButton(container, addTopicButton, 150, 610, 320, 60);
        addTopicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call the method to open Topic Form window
            }
        });

        addButton(container, openClassNotesWindowButton, 520, 430, 360, 60);
        openClassNotesWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClassNotes();
            }
        });

        addButton(container, openPersonalNotesWindowButton, 520, 520, 360, 60);
        openPersonalNotesWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PersonalNotes();
            }
        });

    }
}
