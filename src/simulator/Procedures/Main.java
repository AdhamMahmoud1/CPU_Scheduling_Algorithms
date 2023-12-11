package simulator.Procedures;

import simulator.SJF.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Process process1 = new Process("P1", 0, 5, 1, "red");
        Process process2 = new Process("P2", 1, 3, 2, "blue");
        Process process3 = new Process("P3", 2, 8, 3, "green");
        Process process4 = new Process("P4", 3, 6, 4, "yellow");
        Process process5 = new Process("P5", 4, 4, 5, "pink");
        Process process6 = new Process("P6", 5, 2, 6, "orange");
        Process process7 = new Process("P7", 6, 4, 7, "purple");
        Process process8 = new Process("P8", 7, 5, 8, "brown");
        Process process9 = new Process("P9", 8, 3, 9, "gray");
        Process process10 = new Process("P10", 9, 2, 10, "cyan");

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(process1);
        processes.add(process2);
        processes.add(process3);
        processes.add(process4);
        processes.add(process5);
        processes.add(process6);
        processes.add(process7);
        processes.add(process8);
        processes.add(process9);
        processes.add(process10);

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


    }
}