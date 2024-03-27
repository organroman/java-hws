package Homework3;

import java.util.Scanner;

public class Homework3 {
    // declare array
    static String[][] schedule = new String[7][2];

    // fill the array with initial data
    static void initialSchedule() {
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "go to gym";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "read the point of lie";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "meeting with client";
        schedule[5][0] = "Friday";
        schedule[5][1] = "team building";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "go to the concert";
    }

    // getting input from user
    static String getDayFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, input the day of the week:");
        return scanner.nextLine().trim();
    }

    // capitalize word
    static String capitalizeStr(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // build an output string with task message
    static String generateOutputTask(String day, String task) {
        StringBuilder outcome = new StringBuilder("Your tasks for ");
        outcome
                .append(capitalizeStr(day))
                .append(": ")
                .append(task)
                .append(".");

        return outcome.toString();
    }

    // getting the task from given day
    static String extractTaskOfTheDay(String day) {
        String task;
        switch (day.toLowerCase()) {
            case "sunday" -> task = generateOutputTask(day, schedule[0][1]);
            case "monday" -> task = generateOutputTask(day, schedule[1][1]);
            case "tuesday" -> task = generateOutputTask(day, schedule[2][1]);
            case "wednesday" -> task = generateOutputTask(day, schedule[3][1]);
            case "thursday" -> task = generateOutputTask(day, schedule[4][1]);
            case "friday" -> task = generateOutputTask(day, schedule[5][1]);
            case "saturday" -> task = generateOutputTask(day, schedule[6][1]);
            default -> task = "Sorry, I don't understand you, please try again.";
        }
        return task;
    }

    // update array with task for given day
    static void updateTaskOfTheDay(String command) {
        String[] userCommandArr = command.split(" ");
        // define the day from user's input (last word in the command)
        String dayToChangeTask = userCommandArr[userCommandArr.length - 1];
        // getting the task from user for given day
        String newTask = getNewTaskFromUser(dayToChangeTask);
        // setting new task value in array
        switch (dayToChangeTask.toLowerCase()) {
            case "sunday" -> schedule[0][1] = newTask;
            case "monday" -> schedule[1][1] = newTask;
            case "tuesday" -> schedule[2][1] = newTask;
            case "wednesday" -> schedule[3][1] = newTask;
            case "thursday" -> schedule[4][1] = newTask;
            case "friday" -> schedule[5][1] = newTask;
            case "saturday" -> schedule[6][1] = newTask;
        }
    }

    // just print the task to console
    static void renderTask(String userCommand) {
        System.out.println(extractTaskOfTheDay(userCommand));
    }

    // getting new task from user
    static String getNewTaskFromUser(String day) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please, input new tasks for %s:", capitalizeStr(day));
        return scanner.nextLine().trim();
    }

    // run our app
    static void startApp() {
        initialSchedule();
        String userCommand;
        boolean isExit;

        do {
            userCommand = getDayFromUser();
            isExit = userCommand.equals("exit");

            if (!isExit) {

                if (userCommand.contains("change")) updateTaskOfTheDay(userCommand);
                else renderTask(userCommand);
            }

        } while (!isExit);
    }

    public static void main(String[] args) {
        startApp();
    }
}
