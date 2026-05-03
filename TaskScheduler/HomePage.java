
import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {

    private String option;

    public void showHomePage() throws Exception {
        System.out.println("Hey there, welcome to task scheduler" + "\n" + "Here are the list of options you can perform");
        showOptions();
        Scanner sc = new Scanner(System.in);
        int optionValue = sc.nextInt();
        validateOption(optionValue);
    }

    protected ArrayList<String> getOptions() {
        ArrayList<String> options = new ArrayList<>();
        options.add("1. Create Task");
        options.add("2. List Tasks");
        options.add("3. Exit");
        return options;
    }

    private void showOptions() {
        ArrayList<String> listOptions = getOptions();
        int listPointer = 0;
        while (listPointer < listOptions.size()) {
            System.out.println(listOptions.get(listPointer));
            listPointer++;
        }
    }

    private void validateOption(int optionValue) throws Exception {
        TaskManager taskManager = new TaskManager();
        if (optionValue > getOptions().size() || optionValue < 0) {
            throw new Exception("Invalid Option");
        } else {
            switch (optionValue - 1) {
                case 0:
                    taskManager.createTask();
                    break;
                case 1:
                    taskManager.displayAllTasks();
                    break;
                case 3:
                    System.out.println("Thank You");
                    break;
                default:
                    throw new Exception("Invalid Option");
            }
        }
    }

}
