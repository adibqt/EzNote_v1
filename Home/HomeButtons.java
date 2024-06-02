package Home;

import javax.swing.*;
import java.awt.*;

public class HomeButtons {

    public void addButton(Container container, JButton jButton, int x, int y, int width, int height) {
        jButton.setBackground(new Color(237, 87, 56));
        jButton.setOpaque(true);
        jButton.setBorderPainted(false);
        jButton.setForeground(Color.BLACK);
        jButton.setFont(new Font("Aerial", Font.BOLD, 20));
        jButton.setBounds(x, y, width, height);
        container.add(jButton);
    }

}
