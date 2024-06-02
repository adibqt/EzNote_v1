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

    public void addData() {}

    public void saveData(String name, String code) {}

}
