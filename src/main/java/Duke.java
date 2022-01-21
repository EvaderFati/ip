import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Duke {
    private List<Task> lst = new ArrayList<Task>();

    /**
     * Print the msg between line breaks.
     *
     * @param msg A string of message to be printed.
     */
    private void printMsg(String msg) {
        String br = "\t____________________________________________________________\n";
        System.out.println(br + msg + br);
        return;
    }

    /**
     * Print out the greeting words.
     */
    private void greeting() {
        this.printMsg("\t Hello! I'm Duke\n\t What can I do for you?\n");
    }

    /**
     * Print out the goodbye words.
     */
    private void bye() {
        this.printMsg("\t Bye. Hope to see you again soon!\n");
    }

    /**
     * List out the current tasks as well as their status.
     */
    private void list() {
		String msg = "";
        for (int i = 1; i <= lst.size(); i++) {
			msg += "\t " + i + "." + lst.get(i-1).print() + "\n";
        }
		this.printMsg(msg);
    }

    /**
     * Add a task to the todo list.
     *
     * @param description The description of the task to be added.
     */
    private void add(String description) {
        Task t = new Task(description);
        this.lst.add(t);
        this.printMsg("\t added: " + description + "\n");
    }

    /**
     * Mark a particular task as done.
     *
     * @param num The number of the task to be marked.
     */
    private void mark(int num) {
        this.lst.get(num).markAsDone();
        this.printMsg("\t Nice! I've marked this task as done:\n\t   " + lst.get(num).print() + "\n"); 
    }

    /**
     * Unmark a particular task as done.
     *
     * @param num The number of the task to be unmarked.
     */
    private void unmark(int num) {
        this.lst.get(num).unmarkAsDone();
        this.printMsg("\t OK, I've marked this task as not done yet:\n\t   " + lst.get(num).print() + "\n");
    }

    public static void main(String[] args) {
        Duke bot = new Duke();
        Scanner sc= new Scanner(System.in);
        String input;

        bot.greeting();
        input = sc.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                bot.list();
                input = sc.nextLine();
                continue;
            }
            String[] splitted = input.split("\\s+");
            if (splitted.length == 2 && splitted[0].equals("mark")) {
                try {
                    int num = Integer.parseInt(splitted[1]);
                    bot.mark(num-1);
                    input = sc.nextLine();
                    continue;
                } catch (NumberFormatException e) {
                    bot.add(input);
                }
            } else if (splitted.length == 2 && splitted[0].equals("unmark")) {
                try {
                    int num = Integer.parseInt(splitted[1]);
                    bot.unmark(num-1);
                    input = sc.nextLine();
                    continue;
                } catch (NumberFormatException e) {
                    bot.add(input);
                }
            }
            bot.add(input);
            input = sc.nextLine();
        }
        bot.bye();
    }
}
