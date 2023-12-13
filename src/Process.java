public class Process {

    public String ProcessName;

    public String ProcessColor;

    public int ProcessArrivalTime;

    public int ProcessBurstTime;

    public int newProcessBurstTime;

    public int ProcessPriority;

    public int ProcessStartTime;

    public int ProcessEndTime;

    public int ProcessWaitingTime;

    public int ProcessTurnAroundTime;


    Process (String ProcessName, String ProcessColor, int ProcessArrivalTime, int ProcessBurstTime, int ProcessPriority) {
        this.ProcessName = ProcessName;
        this.ProcessColor = ProcessColor;
        this.ProcessArrivalTime = ProcessArrivalTime;
        this.ProcessBurstTime = ProcessBurstTime;
        this.ProcessPriority = ProcessPriority;
    }





    public int getProcessArrivalTime() {
        return ProcessArrivalTime;
    }


    public int getProcessPriority() {
        return ProcessPriority;
    }






}
