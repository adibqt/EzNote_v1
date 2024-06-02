package AddSyllabus;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Syllabus {

    private String name;
    private String code;

    public Syllabus(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Syllabus() {
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Code: " + code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void addData() {};

    public void saveData(String name, String code) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt", true))) {
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
