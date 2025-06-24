package Task;

public class TaskController {
    private TaskModel TaskModel;
    private TaskView TaskView;

    public TaskController(TaskModel TaskModel, TaskView TaskView) {
        this.TaskModel = TaskModel;
        this.TaskView = TaskView;
    }

    public void initView() {
        for(String name: TaskModel.getTaskList()) {
            TaskView.RenderTask(name, TaskModel.getTaskList(), this);
        }
    }

    public void addTask(String task) {
        TaskModel.addTask(task);
        //TaskView.displayTasks(taskModel.getTaskList(), this);
    }

    public void finishTask(int index) {
        TaskModel.removeTask(index);
        //initView();
    }

    public TaskModel getTaskModel() {
        return TaskModel;
    }

    public TaskView getTaskView() {
        return TaskView;
    }
}
