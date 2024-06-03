package AddSyllabus;

import Home.HomeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChapterForm extends DataEntryForm {

    private JFrame frame = new JFrame("Add New Chapter");
    private Container container;
    private JLabel chapterNameLabel = new JLabel("Chapter Name:"), chapterCodeLabel = new JLabel("Chapter Number:"), whichCourseLabel = new JLabel("Course file name:"), noteIconLabel;
    private JTextField chapterNameField = new JTextField(), chapterCodeField = new JTextField(), whichCourseField = new JTextField();
    private JButton addChapterButton = new JButton("Add Chapter");
    private List<ChapterForm> chapterList = new ArrayList<>();
    private ImageIcon noteIcon;

    public ChapterForm(String name, String code) {
        super(name, code);
    }

    public ChapterForm() {
        frame.setBounds(410, 340, 1000, 800);
        container = frame.getContentPane();
        noteIcon = new ImageIcon(ChapterForm.class.getResource("NoteIcon.png"));
        noteIconLabel = new JLabel(noteIcon);
        noteIconLabel.setBounds(0, 0, 200, 200);


        dataEntryForm(frame, container, chapterNameLabel, chapterNameField, chapterCodeLabel, chapterCodeField, addChapterButton);

        container.add(noteIconLabel);

        addChapterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(chapterNameField.getText().equals("") || chapterCodeField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    saveData(chapterNameField.getText(), chapterCodeField.getText(), whichCourseField.getText());
                }
            }
        });

        whichCourseLabel.setForeground(new Color(237, 87, 56));
        whichCourseLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        whichCourseLabel.setBounds(150, 250, 180, 40);
        container.add(whichCourseLabel);

        whichCourseField.setFont(new Font("Aerial", Font.PLAIN, 20));
        whichCourseField.setOpaque(true);
        whichCourseField.setBounds(340, 240, 500, 60);
        container.add(whichCourseField);
    }

    @Override
    public void saveData(String name, String code, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".txt", true))) {
            writer.newLine();
            writer.write("\tCourse Name: " + name);
            writer.newLine();
            writer.write("\tCourse Code: " + code);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Course Data saved to file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
