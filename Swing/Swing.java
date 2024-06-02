package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing extends JFrame {

//Basics of Java Swing JFrame:
//    public static void main(String[] args) {
//
//        JFrame frame = new JFrame();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setLocation(2400, 50);
//        frame.setBounds(200, 50, 800, 600);
//        frame.setTitle("EzNote");
//        frame.setResizable(false);
//
//        Swing.Swing frame2 = new Swing.Swing();
//        frame2.setVisible(true);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }

//3rd method (setting the properties via the constructor):
//    Swing.Swing() {
//
//        setVisible(true);
//        setBounds(100, 100, 100, 100);
//        setTitle("Swing.Swing");
//
//    }
//
//    public static void main(String[] args) {
//        Swing.Swing frame = new Swing.Swing();
//    }

//Changing icon of JFrame:
//    private ImageIcon icon;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        icon = new ImageIcon(getClass().getResource("dogememe.png"));
//        this.setIconImage(icon.getImage());
//    }
//
//    public static void main(String[] args) {
//        Swing frame = new Swing();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setLocation(2400, 50);
//        frame.setBounds(200, 50, 800, 600);
//        frame.setTitle("EzNote");
//        frame.setResizable(false);
//    }

//Changing background color of JFrame:
//    private Container c;
//    private ImageIcon icon;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setBackground(Color.BLACK);
//        icon = new ImageIcon(getClass().getResource("dogememe.png"));
//        this.setIconImage(icon.getImage());
//    }
//
//    public static void main(String[] args) {
//        Swing frame = new Swing();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//        frame.setLocationRelativeTo(null);
//        frame.setLocation(2400, 50);
//        frame.setBounds(200, 50, 800, 600);
//        frame.setTitle("EzNote");
//        frame.setResizable(false);
//    }

//JLabel basics:
//    private Container c;
//    private JLabel userLabel, newLabel;
//    private Font f, f2;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        f = new Font(" Serif", Font.PLAIN, 20);
//        f2 = new Font("Serif", Font.PLAIN, 20);
//
//        userLabel = new JLabel();
//        userLabel.setText("Hello nigga");
//        userLabel.setBounds(50, 20, 150, 50);
//        userLabel.setFont(f);
//        userLabel.setForeground(Color.BLUE);
//        userLabel.setOpaque(true);
//        userLabel.setBackground(Color.WHITE);
//        c.add(userLabel);
//
//        newLabel = new JLabel("Sup");
//        newLabel.setBounds(50, 80, 150, 50);
//        newLabel.setFont(f2);
//        newLabel.setToolTipText("U Nigga");
//        c.add(newLabel);
//    }
//
//    public static void main(String[] args) {
//
//        Swing frame = new Swing();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(700, 400, 500, 400);
//        frame.setTitle("Label Demo");
//
//    }

//Adding Image to JLabel:
    private Container c;
    private JLabel label1;
    private ImageIcon icon;

    Swing() {
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLACK);

        icon = new ImageIcon(getClass().getResource("dogememe.png"));
        label1 = new JLabel(icon);
        label1.setBounds(50, 50, icon.getIconWidth(), icon.getIconHeight());
        c.add(label1);

    }

    public static void main(String[] args) {

        Swing frame = new Swing();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(700, 400, 500, 400);
        frame.setTitle("Nigga");

    }

//JTextField basics:
//    private Container c;
//    private JTextField tf1, tf2;
//    private Font f;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        f = new Font("Serif", Font.PLAIN + Font.ITALIC, 20);
//
//        tf1 = new JTextField();
//        tf1.setBounds(100, 100, 100, 20);
//        tf1.setFont(f);
//        tf1.setHorizontalAlignment(JTextField.CENTER);
//        c.add(tf1);
//
//        tf2 = new JTextField("Sup Nigga");
//        tf2.setBounds(100, 150, 100, 20);
//        tf2.setForeground(Color.white);
//        tf2.setBackground(Color.BLUE);
//        c.add(tf2);
//    }
//
//    public static void main(String[] args) {
//        Swing frame = new Swing();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(700, 400, 500, 400);
//        frame.setTitle("Nigga");
//    }

//Action Listener basics:
//    private Container c;
//    private JTextField tf1, tf2;
//
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.ORANGE);
//
//        tf1 = new JTextField();
//        tf1.setBounds(100, 100, 100, 20);
//        tf1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String s = tf1.getText();
//                if(s.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Nothing entered");
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, s);
//                }
//            }
//        });
//
//        tf2 = new JTextField();
//        tf2.setBounds(100, 150, 100, 20);
//        tf2.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String s = tf2.getText();
//                if(s.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Nothing entered");
//                }
//                else {
//                     JOptionPane.showMessageDialog(null, s);
//                }
//            }
//        });
//        c.add(tf1);
//        c.add(tf2);
//    }
//
//    public static void main(String[] args) {
//        Swing frame = new Swing();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setBounds(1000, 300, 450, 300);
//    }

//Action Listener:
//    private Container c;
//    private JTextField tf1, tf2;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        tf1 = new JTextField();
//        tf1.setBounds(100, 100, 100, 20);
//        c.add(tf1);
//
//        tf2 = new JTextField();
//        tf2.setBounds(100, 150, 100, 20);
//        c.add(tf2);
//
//        Handler handler = new Handler();
//
//        tf1.addActionListener(handler);
//        tf2.addActionListener(handler);
//    }
//
//    class Handler implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            if(e.getSource() == tf1) {
//                String s = tf1.getText();
//                if(s.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Nothing entered");
//                } else {
//                    JOptionPane.showMessageDialog(null, s);
//                }
//            } else {
//                String s = tf2.getText();
//                if(s.isEmpty()) {
//                    JOptionPane.showMessageDialog(null, "Nothing entered");
//                } else {
//                    JOptionPane.showMessageDialog(null, s);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Swing frame = new Swing();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setBounds(1000, 300, 450, 300);
//
//    }

//JPasswordField
//    private Container c;
//    private JPasswordField pf;
//    private Font f;
//
//    Swing() {
//        initComponents();
//    }
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        f = new Font("Serif", Font.BOLD, 20);
//
//        pf = new JPasswordField();
//        pf.setBounds(10, 10, 100, 20);
//        pf.setEchoChar('*');
//        pf.setFont(f);
//        pf.setForeground(Color.RED);
//        pf.setBackground(Color.YELLOW);
//        c.add(pf);
//    }
//
//    public static void main(String[] args) {
//        Swing frame = new Swing();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setBounds(1000, 300, 450, 300);
//    }

//JButton basics:
//    private Container c;
//    private JButton button1, button2;
//    private Font f;
//    private Cursor cur;
//    private ImageIcon img;
//
//    Swing() {
//        initComponents();
//    }
//
//    public void initComponents() {
//        c = this.getContentPane();
//        c.setLayout(null);
//        c.setBackground(Color.CYAN);
//
//        f = new Font("Serif", Font.BOLD, 20);
//        cur = new Cursor(Cursor.NE_RESIZE_CURSOR);
//        img = new ImageIcon(getClass().getResource("dogememe.png"));
//
//        button1 = new JButton(img);
//        button1.setBounds(100, 50, 100, 50);
//        button1.setFont(f);
//        button1.setBackground(Color.BLUE);
//        button1.setCursor(cur);
//        c.add(button1);
//
//
//        button2 = new JButton("Nigga");
//        button2.setForeground(Color.BLUE);
//        button2.setBackground(Color.black);
//        button2.setBounds(100, 110, 100, 50);
//        c.add(button2);
//    }
//
//    public static void main(String[] args) {
//
//        Swing frame = new Swing();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setBounds(1000, 300, 450, 300);
//
//    }



}














