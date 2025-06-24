package Frames;
import Task.*;
import Utility.GenerateUtilities;

import javax.swing.*;

public class MainFrame extends Frame {
    public MainFrame(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        JLabel label = GenerateUtilities.labelCreate("Task list!");

        JButton button = GenerateUtilities.buttonCreate("New task");

        button.addActionListener(e -> {
            FrameFactory frameFactory = new FrameFactory();
            frame.dispose();
            frameFactory.create("add");
        });

        TaskModel TaskModel = new TaskModel();
        TaskView TaskView = new TaskView();
        TaskController TaskController = new TaskController(TaskModel, TaskView);

        TaskController.initView();

        // Pridanie komponentov
        frame.add(label);
        frame.add(TaskController.getTaskView().getTaskScrollPane());
        frame.add(button);
    }


}
