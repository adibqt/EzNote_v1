import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class PersonForm {
    private JFrame frame;
    private JPanel panel;
    private JTextField nameField;
    private JTextField ageField;
    private JButton createButton;
    private JButton showAllButton;
    private JLabel resultLabel;
    private List<Person> personList;

    public PersonForm() {
        frame = new JFrame("Person Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(10, 60, 80, 25);
        panel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(100, 60, 165, 25);
        panel.add(ageField);

        createButton = new JButton("Create Person");
        createButton.setBounds(10, 100, 150, 25);
        panel.add(createButton);

        showAllButton = new JButton("Show All Persons");
        showAllButton.setBounds(170, 100, 150, 25);
        panel.add(showAllButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 140, 360, 25);
        panel.add(resultLabel);

        personList = new ArrayList<>();

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPerson();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllPersons();
            }
        });

        frame.setVisible(true);
    }

    private void createPerson() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());

            Person person = new Person(name, age);
            personList.add(person);
            resultLabel.setText("Person created: " + person.toString());
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid age. Please enter a number.");
        }
    }

    private void showAllPersons() {
        StringBuilder allPersons = new StringBuilder("<html>");
        for (Person person : personList) {
            allPersons.append(person.toString()).append("<br>");
        }
        allPersons.append("</html>");
        resultLabel.setText(allPersons.toString());
    }

    public static void main(String[] args) {
        new PersonForm();
    }
}


