import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        CPUScheduler C = new CPUScheduler();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        List <Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of process " + (i + 1) + ": ");
            String name = sc.next();
            System.out.println("Enter the color of process " + (i + 1) + ": ");
            String color = sc.next();
            System.out.println("Enter the arrival time of process " + (i + 1) + ": ");
            int arrivalTime = sc.nextInt();
            System.out.println("Enter the burst time of process " + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            System.out.println("Enter the priority of process " + (i + 1) + ": ");
            int priority = sc.nextInt();

            processes.add(new Process(name, color, arrivalTime, burstTime, priority));
        }
        System.out.println("Enter Round Robin Quantum");
        int roundRobinTime = sc.nextInt();
        C.roundRobinScheduling( processes , roundRobinTime );



    }
    
}
