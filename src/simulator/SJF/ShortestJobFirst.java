package simulator.SJF;
import simulator.Procedures.Process;
import simulator.Procedures.ProcessDuration;

import java.util.ArrayList;




// sort the processes according to their burst time
// context switching is considered to be as the user input
// the process with the shortest burst time will be executed first
// if two processes have the same burst time, the one with the lowest arrival time will be executed first
// if two processes have the same burst time and arrival time, the one with the lowest priority will be executed first
// save the waiting time and the turn around time for each process
// calculate the average waiting time and the average turn around time
// calculate the throughput
// calculate the CPU utilization
// calculate the response time


public class ShortestJobFirst {

    public ArrayList<ProcessDuration> run(ArrayList<Process> processes, int contextSwitching){
        ArrayList<ProcessDuration> processesDuration = new ArrayList<>();
        processes = sortProcesses(processes);
        int time = processes.get(0).getArrivalTime();
        int i = 0;
        for (Process process : processes) {
            ProcessDuration pd = new ProcessDuration(process.getName(), process.getArrivalTime(), process.getBurstTime(), process.getPriority(), process.getColor());
            pd.setStartTime(time);
            time += process.getBurstTime() + contextSwitching;
            if (time < process.getArrivalTime() + process.getBurstTime() + contextSwitching)
                time = process.getArrivalTime() + process.getBurstTime() + contextSwitching;
            pd.setEndTime(time);
            pd.calculateWaitingTime();
            pd.calculateTurnAroundTime();
            pd.calculateResponseTime();
            processesDuration.add(pd);
            processes.remove(i);
            i++;
        }


        return processesDuration;
    }

    public  ArrayList<Process> sortProcesses(ArrayList<Process> processes){
        processes.sort((p1, p2)-> {
            if (p1.getArrivalTime() != p2.getArrivalTime()) {
                return Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            }
            else if (p1.getBurstTime() != p2.getBurstTime()) {
                return Integer.compare(p1.getBurstTime(), p2.getBurstTime());
            }
            else {
                return Integer.compare(p1.getPriority(), p2.getPriority());
            }   
        });

        return processes;
    }



}
