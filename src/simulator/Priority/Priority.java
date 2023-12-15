package Priority;

import Procedures.Process;
import Procedures.ProcessDuration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Priority {

    public ArrayList<ProcessDuration> priorityScheduling(ArrayList<Process> processes) {
        double AgingInterval = 5;
        List<ProcessDuration> sortedProcesses = new ArrayList<>();

        for (Process process : processes) {
            sortedProcesses.add(new ProcessDuration(process.getName(), process.getArrivalTime(),
                    process.getBurstTime(), process.getPriority(), process.getColor()));
        }

        sortedProcesses.sort(Comparator.comparingInt(ProcessDuration::getArrivalTime)
                .thenComparingInt(ProcessDuration::getPriority));

        for (ProcessDuration process : sortedProcesses) {
            process.setStartTime(process == sortedProcesses.get(0) ? 0 :
                    sortedProcesses.get(sortedProcesses.indexOf(process) - 1).getEndTime());
            process.setEndTime(process.getStartTime() + process.getBurstTime());

            int waitingTime = Math.max(0, process.getStartTime() - process.getArrivalTime());
            process.setWaitingTime(waitingTime);

            if (waitingTime >= AgingInterval && !process.getProcessIsDone()) {
                process.increasePriority();
            }

            int turnaroundTime = process.getEndTime() - process.getArrivalTime();
            process.setTurnAroundTime(turnaroundTime);

            process.setProcessIsDone(true);

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
