
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private String taskTitle;
    private String task;
    private String createDate;
    private String ETA;
    private String CompletedStatus;

    // public Task() {
    // }

    public Task(String taskTitle, String task, String eTA) {
        this.taskTitle = taskTitle;
        this.task = task;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH.mm");
        this.createDate = LocalDateTime.now().format(formatter);
        ETA = eTA;
        CompletedStatus = "Not Completed";
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

    public String getCompletedStatus(){
        return CompletedStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task{");
        sb.append("taskTitle=").append(taskTitle);
        sb.append(", task=").append(task);
        sb.append(", createDate=").append(createDate);
        sb.append(", ETA=").append(ETA);
        sb.append('}');
        return sb.toString();
    }
}
