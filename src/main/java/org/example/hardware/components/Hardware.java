package org.example.hardware.components;


import org.example.hardware.ComponentResult;

public abstract class Hardware {
    protected String hardwareName = "Unknown Hardware";
    protected String hardwareType = "Unknown Type";

    public abstract ComponentResult test();

    public String getHardwareType(){
        return hardwareType;
    }

    public String getHardwareName(){
        return hardwareName;
    }
}
