import java.util.Scanner;

public class Duke {

    private static final String LINE_SEPARATOR = "____________________________________________________________";
    private static final int MAX_TASKS = 100;

    public static void main(String[] args) {
        System.out.println(LINE_SEPARATOR + "\n" +
                "Hello! I'm Duck\n" +
                "What can I do for you?\n" +
                "  _____  _    _  _____ _  __\n" +
                " |  __ \\| |  | |/ ____| |/ /\n" +
                " | |  | | |  | | |    | ' / \n" +
                " | |  | | |  | | |    |  <  \n" +
                " | |__| | |__| | |____| . \\ \n" +
                " |_____/ \\____/ \\_____|_|\\_\\");

        Task[] tasks = new Task[MAX_TASKS]; //stores Tasks in array called tasks
        String userInput;
        int index = 0; //index of where the userInput is stored in texts
        do {
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();
            if (userInput.equals("list")) {
                Task.listTasks(tasks,index);
                System.out.println(LINE_SEPARATOR + "\n");
            } else if(userInput.startsWith("mark ")) {
                Task.markTask(tasks, userInput, index);
            } else if(userInput.startsWith("unmark ")) {
                Task.unmarkTask(tasks, userInput, index);
            } else if(userInput.startsWith("todo ")) {
                index = ToDo.addToDo(tasks, userInput, index);
            } else if (userInput.startsWith("deadline ")) {
                index = Deadline.addDeadline(tasks, userInput, index);
            } else if (userInput.startsWith("event ")) {
                index = Event.addEvent(tasks, userInput, index);
            }
        } while (!userInput.equals("bye"));

        System.out.println(LINE_SEPARATOR + "\n" +
                "Bye. Hope to see you again soon!\n" +
                LINE_SEPARATOR);
    }
}