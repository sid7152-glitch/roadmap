
public class TaskModel {

    private String taskTitle;
    private String task;
    private String createDate;
    private String ETA;
    private String completionStatus;

    @Override

    public String toString() {
        return "TaskTitle =" + taskTitle + ", Task = " + task + ", CreateDate =" + createDate + "\"" + ", ETA =" + ETA + ", Status =" + completionStatus;
    }

    public TaskModel() {
    }

    // public Task() {
    // }
    public TaskModel(String taskTitle, String task, String ETA, String createDate, String completionStatus) {
        this.ETA = ETA;
        this.createDate = createDate;
        this.task = task;
        this.taskTitle = taskTitle;
        this.completionStatus = completionStatus;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTask() {
        return task;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getETA() {
        return ETA;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setETA(String ETA) {
        this.ETA = ETA;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }
}
