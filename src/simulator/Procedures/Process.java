package Procedures;

public class Process {
    final private String name;
    final private int arrivalTime;

    private int startTime;
    final private int burstTime;
    // I removed the final keyword from burstTime because I need to change it in the Priority class
    private int priority;
    final private String color;

    private boolean ProcessIsDone ;


    public Process(){
        this.name = "";
        this.arrivalTime = 0;
        this.burstTime = 0;
        this.priority = 0;
        this.color = "";
    }

    public Process(String name, int arrivalTime, int burstTime, int priority, String color) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }


    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }



    public String getColor() {
        return color;
    }

    public int getStartTime() {
        return startTime;
    }

    public void increasePriority(){
        this.priority++;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

   public void setProcessIsDone(boolean ProcessIsDone) {
            this.ProcessIsDone = ProcessIsDone;
        }

        public boolean getProcessIsDone() {
            return ProcessIsDone;
        }


}
