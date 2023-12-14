package Priority;

import Procedures.Process;
import Procedures.ProcessDuration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Priority {

    public ArrayList<ProcessDuration> priorityScheduling(ArrayList<Process> processes) {
        double totalWaitingTime = 0, totalTurnAroundTime = 0, AgingInterval = 5;
        List<ProcessDuration> sortedProcesses = new ArrayList<>();

        // Convert processes to ProcessDuration and add to sortedProcesses
        for (Process process : processes) {
            sortedProcesses.add(new ProcessDuration(process.getName(), process.getArrivalTime(),
                    process.getBurstTime(), process.getPriority(), process.getColor()));
        }

        // Sort processes based on arrival time and priority
        sortedProcesses.sort(Comparator.comparingInt(ProcessDuration::getArrivalTime)
                .thenComparingInt(ProcessDuration::getPriority));

        for (ProcessDuration process : sortedProcesses) {
            process.setStartTime(process == sortedProcesses.get(0) ? 0 :
                    sortedProcesses.get(sortedProcesses.indexOf(process) - 1).getEndTime());
            process.setEndTime(process.getStartTime() + process.getBurstTime());

            // Calculate waiting time and update process attributes
            int waitingTime = Math.max(0, process.getStartTime() - process.getArrivalTime());
            process.setWaitingTime(waitingTime);

            // Aging logic
            if (waitingTime >= AgingInterval && !process.getProcessIsDone()) {
                process.increasePriority();
            }

            // Calculate turnaround time and update attributes
            int turnaroundTime = process.getEndTime() - process.getArrivalTime();
            process.setTurnAroundTime(turnaroundTime);

            // Update process status as done after scheduling
            process.setProcessIsDone(true);

            // Accumulate waiting and turnaround times
            totalWaitingTime += waitingTime;
            totalTurnAroundTime += turnaroundTime;
        }

        return new ArrayList<>(sortedProcesses);
    }

    public double getAverageWaitingTime(ArrayList<ProcessDuration> processesDuration) {
        double totalWaitingTime = 0;
        for (ProcessDuration process : processesDuration) {
            totalWaitingTime += process.getWaitingTime();
        }
        return totalWaitingTime / processesDuration.size();
    }

    public double getAverageTurnAroundTime(ArrayList<ProcessDuration> processesDuration) {
        double totalTurnAroundTime = 0;
        for (ProcessDuration process : processesDuration) {
            totalTurnAroundTime += process.getTurnAroundTime();
        }
        return totalTurnAroundTime / processesDuration.size();
    }
}
