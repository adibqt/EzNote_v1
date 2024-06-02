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

public class ChapterForm extends DataEntryForm {

    private JFrame frame = new JFrame("EzNote - Add New Chapter");
    private Container container;
    private JLabel chapterNameLabel = new JLabel("Chapter Name:");
    private JLabel chapterCodeLabel = new JLabel("Chapter Number:");
    private JLabel whichCourseLabel = new JLabel("Course Code:");
    private JTextField chapterNameField = new JTextField();
    private JTextField chapterCodeField = new JTextField();
    private JTextField whichCourseField = new JTextField();
    private JButton addChapterButton = new JButton("Add Chapter");
    private List<ChapterForm> chapterList = new ArrayList<>();

    public ChapterForm(String name, String code) {
        super(name, code);
    }

    public ChapterForm() {
        frame.setBounds(410, 340, 1000, 800);
        container = frame.getContentPane();
        dataEntryForm(frame, container, chapterNameLabel, chapterNameField, chapterCodeLabel, chapterCodeField, addChapterButton);

        addChapterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(chapterNameField.getText().equals("") || chapterCodeField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addData();

                    String newData = "\t" + "Chapter Name: " + chapterNameField.getText() + "\n" + "\t" + "Chapter Number: " + chapterCodeField.getText() + "\n";
                    try {
                        insertDataAfterText("Syllabus.txt", whichCourseField.getText(), newData, chapterNameField.getText(), chapterCodeField.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        whichCourseLabel.setForeground(new Color(237, 87, 56));
        whichCourseLabel.setFont(new Font("Aerial", Font.PLAIN, 20));
        whichCourseLabel.setBounds(150, 100, 140, 40);
        container.add(whichCourseLabel);

        whichCourseField.setFont(new Font("Aerial", Font.PLAIN, 20));
        whichCourseField.setOpaque(true);
        whichCourseField.setBounds(330, 90, 500, 60);
        container.add(whichCourseField);
    }

    @Override
    public void addData() {
        try {
            String chapterName = chapterNameField.getText();
            String chapterNumber = chapterCodeField.getText();

            ChapterForm chapter = new ChapterForm(chapterName, chapterNumber);
            chapterList.add(chapter);
        } catch(Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void insertDataAfterText(String fileName, String marker, String newData, String chapterName, String chapterNumber) throws IOException {
        super.insertDataAfterText(fileName, marker, newData, chapterName, chapterNumber);
    }

}
