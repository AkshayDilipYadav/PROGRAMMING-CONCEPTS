package Concurrency.Process_vs_Threads_Exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Process_Examples {

    public static void processDemo()throws InterruptedException{
       long pid = ProcessHandle.current().pid();
        Thread.sleep(2000);
        System.out.println("Process ID: " + pid);

    }

    public static void createChildProcess() throws Exception{
        ProcessBuilder pb = new ProcessBuilder("open", "-a");
        Process p = pb.start();
        System.out.println("Started child process with PID: "+ p.pid());

    }

    public static void processMemoryDemo()throws Exception{
        ProcessBuilder pb = new ProcessBuilder("java");
        pb.redirectErrorStream(true);
        Process p = pb.start();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[Child says] " + line);
            }
        }
        p.waitFor();
    }

    public static void main(String[] args) throws Exception{
         processDemo();

        createChildProcess();

        processMemoryDemo();
    }

}
