package Frames;

import Task.TaskController;
import Task.TaskModel;
import Task.TaskView;
import Utility.GenerateUtilities;

import javax.swing.*;
import java.awt.*;

public class AddFrame extends Frame {
    public AddFrame(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        JLabel label = GenerateUtilities.labelCreate("Write task");

        TextArea textArea = new TextArea();
        textArea.setBounds(100, 150, 200, 60);

        JButton addButton = GenerateUtilities.buttonCreate("Add!");
        addButton.setBounds(150, 240, 100, 30);

        TaskModel TaskModel = new TaskModel();
        TaskView TaskView = new TaskView();
        TaskController TaskController = new TaskController(TaskModel, TaskView);

        addButton.addActionListener( e-> {
            TaskModel.addTask(textArea.getText());
            frame.dispose();
            FrameFactory frameFactory = new FrameFactory();
            frameFactory.create("main");
        });

        frame.add(label);
        frame.add(textArea);
        frame.add(addButton);


    }
}
