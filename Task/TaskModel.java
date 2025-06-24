package Task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<String> taskList;
    private final String filePath = "list.txt";

    public TaskModel() {
        taskList = new ArrayList<>();
        loadTasksFromFile();
    }

    public List<String> getTaskList() {
        return taskList;
    }

    public void addTask(String task) {
        taskList.add(task);
        saveTasksToFile();
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            saveTasksToFile();
        }
    }

    private void loadTasksFromFile() {
        taskList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                taskList.add(line);
            }
        } catch (IOException e) {
            // Súbor neexistuje? Nevadí. Môžeme ho neskôr vytvoriť.
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String task : taskList) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Tu by mohla byť aj lepšia obsluha chýb
        }
    }
}
