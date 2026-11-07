package org.example.hardware.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Timer implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Timer.class);

    private final int interval;
    private volatile boolean running = false;
    private Runnable interruptHandler;
    private String name;

    public Timer(String name,
                 int interval){
        this.name = name;
        this.interval = interval;
    }

    public void registerInterruptHandler(Runnable handler) {
        this.interruptHandler = handler;
    }

    public void start() {
        if(!running){
            this.running = true;
            Thread thread = new Thread(this, this.name);
            thread.setDaemon(true);
            thread.start();
            log.info("[TIMER] {} started with interval {}", this.name, this.interval);
        }
    }

    public void stop(){
        this.running = false;
    }

    public boolean isRunning(){
        return running;
    }

    @Override
    public void run() {
        while(running){
            try{
                Thread.sleep(interval);

                if(interruptHandler != null){
                    interruptHandler.run();
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
