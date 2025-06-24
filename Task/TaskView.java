package Task;

import Utility.GenerateUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TaskView {
    private final JPanel TaskListPanel = new JPanel();           // obsah scrollu
    private final JScrollPane TaskScrollPane;                    // scroll samotný

    public TaskView() {
        TaskListPanel.setLayout(new BoxLayout(TaskListPanel, BoxLayout.Y_AXIS)); // úlohy pod seba
        TaskScrollPane = new JScrollPane(TaskListPanel);                         // obalíme scrollom
        TaskScrollPane.setBounds(100, 100, 200, 400);
        TaskScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        TaskScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void RenderTask(String Task, List<String> Tasks, TaskController controller) {
        JLabel TaskLabel = new JLabel(Task);
        JButton FinishTaskButton;
        FinishTaskButton = GenerateUtilities.buttonCreate("D");

        JPanel TaskRow = new JPanel(new FlowLayout(FlowLayout.LEFT)); // každý riadok úlohy
        TaskRow.add(TaskLabel);
        TaskRow.add(FinishTaskButton);

        FinishTaskButton.addActionListener(e -> {
            controller.finishTask(controller.getTaskModel().getTaskList().indexOf(Task));
            TaskListPanel.remove(TaskRow);
            TaskListPanel.revalidate(); // obnov GUI
            TaskListPanel.repaint();
        });

        TaskListPanel.add(TaskRow); // pridaj úlohu do panelu
        TaskListPanel.revalidate(); // obnov GUI
        TaskListPanel.repaint();
    }

    public JPanel getTaskListPanel() {
        return TaskListPanel;
    }

    public JScrollPane getTaskScrollPane() {
        return TaskScrollPane;
    }
}

