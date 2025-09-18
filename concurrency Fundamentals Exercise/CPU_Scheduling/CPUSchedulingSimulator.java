package Concurrency.CPU_Scheduling;

import java.util.*;

class Process{
  String name;
  int burstTime;
  int remainingTime;
  int priority;

  Process(String name, int burstTime, int priority){
      this.name = name;
      this.burstTime = burstTime;
      this.remainingTime = burstTime;
      this.priority = priority;
  }
}

public class CPUSchedulingSimulator {

    public static void fifo(List<Process> p){

        System.out.println("\n ------ Fifo Scheduling --------\n");
        int currentTime = 0;

        for(Process x : p){
            System.out.println("Time " + currentTime + " : " + x.name+ " starts");
            currentTime += x.burstTime;
            System.out.println("Time " + currentTime + " : " + x.name+ " finishes");
        }

    }

    public static void roundRobinScheduling(List<Process> processes, int quantum) {
        System.out.println("\n--- Round Robin Scheduling (Quantum = " + quantum + ") ---");
        Queue<Process> queue = new LinkedList<>(processes);
        int currentTime = 0;

        while (!queue.isEmpty()) {
            Process p = queue.poll();
            int execTime = Math.min(p.remainingTime, quantum);
            System.out.println("Time " + currentTime + ": " + p.name + " runs for " + execTime);
            p.remainingTime -= execTime;
            currentTime += execTime;

            if (p.remainingTime > 0) {
                queue.add(p); // re-add to the end
            } else {
                System.out.println("Time " + currentTime + ": " + p.name + " finishes");
            }
        }
    }

    // Priority Scheduling (non-preemptive)
    public static void priorityScheduling(List<Process> processes) {
        System.out.println("\n--- Priority Scheduling (Non-preemptive) ---");
        List<Process> queue = new ArrayList<>(processes);
        queue.sort(Comparator.comparingInt(p -> p.priority)); // lower value = higher priority

        int currentTime = 0;
        for (Process p : queue) {
            System.out.println("Time " + currentTime + ": " + p.name + " (Priority " + p.priority + ") starts");
            currentTime += p.burstTime;
            System.out.println("Time " + currentTime + ": " + p.name + " finishes");
        }
    }

    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process("P1", 5, 2),
                new Process("P2", 3, 1),
                new Process("P3", 8, 3)
        );

        fifo(processes);
        roundRobinScheduling(processes, 2);
        priorityScheduling(processes);
    }

}
