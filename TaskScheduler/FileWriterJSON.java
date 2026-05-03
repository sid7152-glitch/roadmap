
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileWriterJSON {

    public void writeJSON(Task task) {
        String json = "{\"task_title\": \"" + task.getTaskTitle() + "\" ,"
                + "  \"task\":\"" + task.getTask() + "\" ,"
                + "  \"eta\": \"" + task.getETA() + "\" ,"
                + "  \"createTime\": \"" + task.getCreateDate() + "\" ,"
                + "  \"completionStatus\": \"" + task.getCompletedStatus() + "\""
                + "},";

        try {
            File file = new File("TaskScheduler/Tasks.json");
            boolean appendComma = file.exists() && file.length() > 0;
            String text = fileReaderJSON();
            FileWriter writer = new FileWriter("TaskScheduler/Tasks.json", false);
            if (appendComma) {
                text = text.substring(0, text.length() - 1);
                json = text + "\n" + json + "\n]";
                System.out.println(json);
                writer.write(json);
            } else {
                writer.write("[\n" + json + "\n]");
            }
            writer.close();
            // fileReaderJSON();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String fileReaderJSON() throws Exception {
        FileInputStream fstream = new FileInputStream("TaskScheduler/Tasks.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String value = "";
        String fullText = "";
        while ((value = br.readLine()) != null) {
            // System.out.println(value);
            fullText = fullText + value;
        }
        fstream.close();
        return fullText;
    }

    public List<TaskModel> processJSONString(String jsonString) {
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        jsonString = jsonString.substring(0, jsonString.length() - 1);
        String[] arr = jsonString.split("\\},\\{");
        List<TaskModel> listValues = new ArrayList<>();

        for (String a : arr) {
            String[] a1 = a.split(",");
            TaskModel task = new TaskModel(a1[0].split(":")[1], a1[1].split(":")[1], a1[2].split(":")[1], a1[3].split(":")[1], a1[4].split(":")[1]);
            listValues.add(task);
        }
        return listValues;
    }

    public void listToJSONConverter(List<TaskModel> list) {
        String jsonArray = "";
        jsonArray = jsonArray + "[";
        for (TaskModel task : list) {
            jsonArray = jsonArray
                    + "{\"task_title\":" + task.getTaskTitle() + " ,"
                    + "  \"task\":" + task.getTask() + ","
                    + "  \"eta\":" + task.getETA() + ","
                    + "  \"createTime\":" + task.getCreateDate() + ","
                    + "  \"completionStatus\":" + task.getCompletionStatus() 
                    + "},";

        }
        jsonArray = jsonArray + "]";
        try (FileWriter writer = new FileWriter("TaskScheduler/Tasks.json", false)) {
            writer.write(jsonArray);
            System.out.println("Tasks Updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
