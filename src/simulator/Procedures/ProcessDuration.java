package Procedures;

public class ProcessDuration extends Process{
    private double waitingTime;
    private double turnAroundTime;
    private double responseTime;
    private int startTime;

    private int endTime;


    public ProcessDuration(String name, int arrivalTime, int burstTime, int priority, String color) {
        super(name, arrivalTime, burstTime, priority, color);
        this.waitingTime = 0;

        this.turnAroundTime = 0;
        this.responseTime = 0;
        this.startTime = 0;
        this.endTime = 0;
    }

    public void setStartTime(int time) {
        this.startTime = time;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public void calculateWaitingTime(){
    this.waitingTime = this.startTime - this.getArrivalTime();
    }

    public void calculateTurnAroundTime(){
        this.turnAroundTime = this.endTime - this.getArrivalTime();

    }

    public void calculateResponseTime(){
        this.responseTime = this.startTime - this.getArrivalTime();

    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public double getTurnAroundTime() {
        return turnAroundTime;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setTurnAroundTime(double turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }





}
