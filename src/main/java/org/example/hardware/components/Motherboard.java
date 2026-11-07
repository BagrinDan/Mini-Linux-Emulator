package org.example.hardware.components;

import org.example.hardware.ComponentResult;
import org.example.hardware.exceptions.NotInitializedException;

import java.util.ArrayList;
import java.util.List;

public class Motherboard extends Hardware implements DiagnosticManager{
    private final CPU cpu;
    private final RAM ram;
    private final HardStorage hardStorage;
    private final Timer timer;

    public Motherboard(){
        this.hardwareName = "AssRock";
        this.hardwareType = "Motherboard";

        this.cpu = new CPU();
        this.ram = new RAM();
        this.hardStorage = new HardStorage();
        this.timer = new Timer("System Timer", 100);
    }

    @Override
    public ComponentResult test() {
        if(this.hardwareName == null){
            throw new NotInitializedException(hardwareType);
        }

        return new ComponentResult(
                hardwareName,
                true,
                "OK"
        );
    }

    @Override
    public List<ComponentResult> testResults() {

        List<ComponentResult> resultsList = new ArrayList<>();

        List<Hardware> components = List.of(this, cpu, hardStorage, ram);

        for (Hardware component : components) {
            try{
                ComponentResult result = component.test();
                resultsList.add(result);
            }catch (NotInitializedException e){
                resultsList.add(
                        new ComponentResult(
                                component.getHardwareType(),
                                false,
                                e.getMessage()
                        )
                );
            }
        }

        return resultsList;
    }

    public Timer getTimer(){
        return timer;
    }
}
