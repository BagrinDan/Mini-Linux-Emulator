package org.example.hardware.components;

import org.example.hardware.ComponentResult;
import org.example.hardware.exceptions.NotInitializedException;

public class RAM extends Hardware {
    public RAM(){
        this.hardwareName = "BubbleTea16GB";
        this.hardwareType = "Random Access Memory";
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
