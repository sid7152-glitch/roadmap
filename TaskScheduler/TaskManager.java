
import java.util.*;

public class TaskManager {

    //CreateTask
    public void createTask() {
        System.out.println("Kindly provide the details as requested below");
        System.out.printf("Task Title: ");
        Scanner sc = new Scanner(System.in);
        String taskTitle = sc.nextLine();
        System.out.printf("Task: ");
        String task = sc.nextLine();
        System.out.printf("ETA:");
        String ETA = sc.nextLine();
        sc.close();
        Task taskValue = new Task(taskTitle, task, ETA);
        System.out.println(taskValue.toString());
        FileWriterJSON fw = new FileWriterJSON();
        fw.writeJSON(taskValue);
    }

    //UpdateTask
    public void updateTask(int index, List<TaskModel> tasks) throws Exception {
        System.out.println("What would you like to update ? \n a. Task Title \n b. Task \n c. ETA \n d. Status \n e. Exit \nChoose the options ...");
        Scanner scanner = new Scanner(System.in);
        String options = scanner.next();
        TaskModel task = new TaskModel();
        switch (options) {
            case "a":
                System.out.println("Task Title: ");
                Scanner sc = new Scanner(System.in);
                String title = sc.nextLine();
                task = tasks.get(index);
                task.setTaskTitle("\"" + title + "\"");
                tasks.add(index, task);
                tasks.remove(index + 1);
                break;
            case "b":
                System.out.println("Task: ");
                Scanner sc1 = new Scanner(System.in);
                String task_value = sc1.nextLine();
                task = tasks.get(index);
                task.setTask("\"" + task_value + "\"");
                tasks.add(index, task);
                tasks.remove(index + 1);
                break;
            case "c":
                System.out.println("ETA:  ");
                Scanner sc2 = new Scanner(System.in);
                String eta = sc2.nextLine();
                task = tasks.get(index);
                task.setETA("\"" + eta + "\"");
                tasks.add(index, task);
                tasks.remove(index + 1);
                break;
            case "d":
                System.out.println("Status: ");
                Scanner sc3 = new Scanner(System.in);
                String status = sc3.nextLine();
                task = tasks.get(index);
                task.setCompletionStatus("\"" + status + "\"");
                tasks.add(index, task);
                tasks.remove(index + 1);
                break;
            default:
                System.out.println("Navigating back to homepage ...");
                HomePage homePage = new HomePage();
                homePage.showHomePage();
        }
        System.out.println("Task updated\n" + task);
        FileWriterJSON fjw = new FileWriterJSON();
        fjw.listToJSONConverter(tasks);
    }

    //DeleteTask
    public void deleteTask(int index, List<TaskModel> tasks) {
        tasks.remove(index);
        FileWriterJSON fjw = new FileWriterJSON();
        fjw.listToJSONConverter(tasks);
    }

    //DisplayTasks
    public void displayAllTasks() throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileWriterJSON fw = new FileWriterJSON();
        String test = fw.fileReaderJSON();
        if (test.equals("[]")) {
            throw new Exception("No Task Available, Create a task");
        }
        List<TaskModel> tasks = fw.processJSONString(test);
        System.out.println("Kindly enter the number of the task to view it in detail:");
        for (int i = 0; i < tasks.size(); i++) {
            String displayText = (i + 1) + tasks.get(i).getTaskTitle();
            System.out.println(displayText);
        }
        int value = scanner.nextInt();
        displayTask(value - 1);

    }

    //DisplayTask
    public void displayTask(int index) throws Exception {
        FileWriterJSON fw = new FileWriterJSON();
        String test = fw.fileReaderJSON();
        List<TaskModel> tasks = fw.processJSONString(test);
        System.out.println(tasks.get(index));
        System.out.println("Would you like to update or delete the current task? U/D");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        if (choice.equals("U") || choice.equals("u")) {
            updateTask(index, tasks);
            return;
        } else if (choice.equals("D") || choice.equals("d")) {
            deleteTask(index, tasks);
            return;
        }
        System.out.println("Navigating back to homepage ...");
        HomePage homePage = new HomePage();
        homePage.showHomePage();

        // List<Map<String, String>> tasks = fw.processJSONString(test);
    }
}
