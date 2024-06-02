package Home;

import AddSyllabus.CourseForm;
import ViewSyllabus.ViewSyllabus;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeWindow {

    private JLabel label1;
    private ImageIcon icon, image;

    public HomeWindow() {

        //Home Window Frame:
        JFrame frame = new JFrame("EzNote - Home Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(480, 200, 1000, 800);

        icon = new ImageIcon(HomeWindow.class.getResource("EzNote.png"));
        frame.setIconImage(icon.getImage());

        image = new ImageIcon(HomeWindow.class.getResource("EzNote2.png"));
        label1 = new JLabel(image);
        label1.setBounds(0, 0, 1000, 300);

        //Home Window Container:
        Container containerOne = frame.getContentPane();
        containerOne.setLayout(null);
        containerOne.setBackground(Color.BLACK);
        containerOne.add(label1);

        try {
            // Load the image from a local file
            String imagePath = "D:/Chrome Download/EzNote (4).png"; // Replace with your local image path
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Define the crop area (x, y, width, height)
            int cropX = 20;
            int cropY = 20;
            int cropWidth = 100;
            int cropHeight = 100;

            // Crop the image
            BufferedImage croppedImage = originalImage.getSubimage(cropX, cropY, cropWidth, cropHeight);

            // Create an ImageIcon from the cropped image
            ImageIcon croppedIcon = new ImageIcon(croppedImage);

            // Create a JButton with the cropped image and text
            JButton showSyllabusButton = new JButton( croppedIcon);
            showSyllabusButton.setText("Show Syllabus");
            showSyllabusButton.setHorizontalTextPosition(SwingConstants.RIGHT); // Set text to the right of the image
            showSyllabusButton.setVerticalTextPosition(SwingConstants.CENTER);
            showSyllabusButton.setFont(new Font("Aerial", Font.BOLD, 20));
            showSyllabusButton.setBackground(new Color(237,87,56));
            showSyllabusButton.setBounds(170, 340, 300, 60);
            showSyllabusButton.setForeground( Color.BLACK);

            // Center the text vertically

            // Add the button to the frame
            //frame.setLayout(new FlowLayout()); // Set layout manager
            frame.add(showSyllabusButton);

            // Display the frame
            frame.setVisible(true);
            showSyllabusButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Call the method to show full syllabus
                    new ViewSyllabus();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*//Home Window Buttons:
        //String imagePath = "C:/Users/adip rohman/Pictures/robotics.jpg"; // Replace with your local image path
        //ImageIcon imageIcon = new ImageIcon(imagePath);
        //JButton showSyllabusButton = new JButton(imageIcon);
        //showSyllabusButton.setText("show full syllabus");
        showSyllabusButton.setFont(new Font("Aerial", Font.BOLD, 20));
        showSyllabusButton.setBackground(new Color(237,87,56));
        showSyllabusButton.setBounds(170, 340, 300, 60);
        showSyllabusButton.setForeground( Color.BLACK);
        containerOne.add(showSyllabusButton);*/
        /*showSyllabusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call the method to show full syllabus
                new ViewSyllabus();
            }
        });*/
        JButton addCourseButton = new JButton("Add New Course(s)");
        addCourseButton.setFont(new Font("Aerial", Font.PLAIN, 20));
        addCourseButton.setBounds(170, 430, 300, 60);
        addCourseButton.setForeground(Color.BLACK);
        containerOne.add(addCourseButton);
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Calling the method to open Course Form window
                new CourseForm();
            }
        });
        JButton addChapterButton = new JButton("Add New Chapter(s)");
        addChapterButton.setFont(new Font("Aerial", Font.PLAIN, 20));
        addChapterButton.setBounds(170, 520, 300, 60);
        addChapterButton.setForeground(new Color(237, 87, 56));
        containerOne.add(addChapterButton);
        addChapterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call the method to open Chapter Form window
            }
        });
        JButton addTopicButton = new JButton("Add New Topic(s)");
        addTopicButton.setFont(new Font("Aerial", Font.PLAIN, 20));
        addTopicButton.setBounds(170, 610, 300, 60);
        addTopicButton.setForeground(new Color(237, 87, 56));
        containerOne.add(addTopicButton);
        addTopicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call the method to open Topic Form window
            }
        });

    }
}
