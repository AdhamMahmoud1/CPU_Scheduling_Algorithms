import java.util.*;

public class CPUScheduler {

    public void roundRobinScheduling(List<Process> processes, int QuantumTime) {
        int startTime = 0, totalWaitingTime = 0, totalTurnAroundTime = 0;
        int initialSize = processes.size();

        for (int i = 0; i < processes.size(); i++) {
            processes.get(i).ProcessStartTime = startTime;
            processes.get(i).ProcessEndTime = startTime + Math.min(processes.get(i).ProcessBurstTime, QuantumTime);

            if (processes.get(i).ProcessBurstTime <= QuantumTime) {
                System.out.println(processes.get(i).ProcessName + ": " + startTime + " - " + (startTime + processes.get(i).ProcessBurstTime));
                startTime += processes.get(i).ProcessBurstTime;
            } else {
                System.out.println(processes.get(i).ProcessName + ": " + startTime + " - " + (startTime + QuantumTime));
                Process newProcess = new Process(processes.get(i).ProcessName, processes.get(i).ProcessColor, processes.get(i).ProcessArrivalTime, processes.get(i).ProcessBurstTime - QuantumTime, processes.get(i).ProcessPriority);
                processes.get(i).newProcessBurstTime = processes.get(i).ProcessBurstTime - QuantumTime;
                processes.add(newProcess);
                startTime = processes.get(i).ProcessEndTime;
            }

        }

        for (int i = 0; i < initialSize; i++) {
            int maxEndTime = 0, turnAroundTime;
            for (Process process : processes) {
                if (Objects.equals(process.ProcessName, processes.get(i).ProcessName)) {
                    maxEndTime = Math.max(maxEndTime, process.ProcessEndTime);
                }
            }
            System.out.println(processes.get(i).ProcessName + " Waiting Time: " + (maxEndTime - processes.get(i).ProcessArrivalTime - processes.get(i).ProcessBurstTime));
            totalWaitingTime += maxEndTime - processes.get(i).ProcessArrivalTime - processes.get(i).ProcessBurstTime;
            turnAroundTime = maxEndTime - processes.get(i).ProcessArrivalTime;
            totalTurnAroundTime += turnAroundTime;
            System.out.println(processes.get(i).ProcessName + " Turn Around Time: " + turnAroundTime);

        }
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / initialSize);
        System.out.println("Average Turn Around Time: " + (double) totalTurnAroundTime / initialSize);

    }


    public void priorityScheduling(List<Process> processes) {
        double totalWaitingTime = 0, totalTurnAroundTime = 0;
        List<Process> sortedProcesses = new ArrayList<>(processes);
        sortedProcesses.sort(Comparator.comparingInt(Process::getProcessArrivalTime).thenComparingInt(Process::getProcessPriority));

        for (int i = 0; i < sortedProcesses.size(); i++) {
                sortedProcesses.get(i).ProcessStartTime = i == 0 ? 0 : sortedProcesses.get(i - 1).ProcessEndTime;
                sortedProcesses.get(i).ProcessEndTime = sortedProcesses.get(i).ProcessStartTime + sortedProcesses.get(i).ProcessBurstTime;
            int waitingTime = Math.max(0, sortedProcesses.get(i).ProcessStartTime - sortedProcesses.get(i).ProcessArrivalTime);
            sortedProcesses.get(i).ProcessWaitingTime = waitingTime;
            totalWaitingTime += waitingTime;
            processes.get(i).ProcessTurnAroundTime = sortedProcesses.get(i).ProcessEndTime - sortedProcesses.get(i).ProcessArrivalTime;
            totalTurnAroundTime += sortedProcesses.get(i).ProcessTurnAroundTime;
        }

        for (Process sortedProcess : sortedProcesses) {
            System.out.println(sortedProcess.ProcessName + ": " + sortedProcess.ProcessStartTime + " - " +
            sortedProcess.ProcessEndTime + "| Waiting Time: " + sortedProcess.ProcessWaitingTime + " | Turn Around Time: " + sortedProcess.ProcessTurnAroundTime);
        }

        System.out.println("Average Waiting Time: " + totalWaitingTime / sortedProcesses.size());
        System.out.println("Average Turn Around Time: " + totalTurnAroundTime / sortedProcesses.size());
    }
}



