package Frames;

import javax.swing.*;
import java.awt.*;

public abstract class Frame {
    protected final JFrame frame;
    private final int height = 600;
    private final int width = 400;

    protected Frame(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setBackground(new Color(0, 0, 81));
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // môžeš zmeniť na iný LayoutManager
        addComponents();       // zavolá metódu z potomka
        frame.setVisible(true);
    }

    protected abstract void addComponents();

}
