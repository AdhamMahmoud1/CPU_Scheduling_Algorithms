package Procedures;
import Priority.Priority;
import SJF.ShortestJobFirst;
import Procedures.ProcessDuration;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Process process1 = new Process("P1", 0, 10, 3, "red");
        Process process2 = new Process("P2", 1, 1, 1, "blue");
        Process process3 = new Process("P3", 0, 2, 4, "green");
        Process process4 = new Process("P4", 0, 1, 5, "yellow");
        Process process5 = new Process("P5", 0, 5, 2, "pink");
//        Process process6 = new Process("P6", 5, 2, 6, "orange");
//        Process process7 = new Process("P7", 6, 4, 7, "purple");
//        Process process8 = new Process("P8", 7, 5, 8, "brown");
//        Process process9 = new Process("P9", 8, 3, 9, "gray");
//        Process process10 = new Process("P10", 9, 2, 10, "cyan");

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(process1);
        processes.add(process2);
        processes.add(process3);
        processes.add(process4);
        processes.add(process5);
//        processes.add(process6);
//        processes.add(process7);
//        processes.add(process8);
//        processes.add(process9);
//        processes.add(process10);


        System.out.println("What algorithm do you want to use?");
        System.out.println("1- Shortest Job First");
        System.out.println("2- Priority");

        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                ArrayList<ProcessDuration> processesDuration = new ArrayList<>();
                processesDuration = new ShortestJobFirst().run(processes, 0);

                for (ProcessDuration processDuration : processesDuration) {
                    System.out.println("Process Name: " + processDuration.getName() +
                            " Start Time: " + processDuration.getStartTime() +
                            " End Time: " + processDuration.getEndTime() +
                            " Waiting Time: " + processDuration.getWaitingTime() +
                            " Turn Around Time: " + processDuration.getTurnAroundTime() +
                            " Response Time: " + processDuration.getResponseTime());
                }
                break;
            case 2:
                Priority priority = new Priority();
                processesDuration = priority.priorityScheduling(processes);

                for (ProcessDuration processDuration : processesDuration) {
                    System.out.println("Process Name: " + processDuration.getName() +
                            " Start Time: " + processDuration.getStartTime() +
                            " End Time: " + processDuration.getEndTime() +
                            " Waiting Time: " + processDuration.getWaitingTime() +
                            " Turn Around Time: " + processDuration.getTurnAroundTime());

                }
                System.out.println("Average Waiting Time: " + priority.getAverageWaitingTime(processesDuration));
                System.out.println("Average Turn Around Time: " + priority.getAverageTurnAroundTime(processesDuration));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }


    }
}