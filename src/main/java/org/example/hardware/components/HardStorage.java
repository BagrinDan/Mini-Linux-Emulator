package org.example.hardware.components;

import org.example.hardware.ComponentResult;
import org.example.hardware.exceptions.NotInitializedException;

public class HardStorage extends Hardware{
    public HardStorage(){
        this.hardwareName = "Kingston500E";
        this.hardwareType = "Hard Storge";
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
}
