package Utility;

import javax.swing.*;
import java.awt.*;

public class GenerateUtilities {
    public static JButton buttonCreate(String text) {
        JButton button = new JButton(text);
        button.setBounds(150, 520, 100, 30);
        button.setBackground(Color.DARK_GRAY); // oceľová modrá
        button.setForeground(Color.WHITE);             // biely text
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);

        return button;
    }

    public static JLabel labelCreate(String text) {
        JLabel label = new JLabel("Task list");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.white);
        label.setBounds(150, 50, 250, 30);

        return label;
    }
}
