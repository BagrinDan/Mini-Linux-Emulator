package org.example.hardware.components;

import org.example.hardware.ComponentResult;
import org.example.hardware.exceptions.NotInitializedException;

public class CPU extends Hardware{

    public CPU(){
        this.hardwareName = "Intel core 5 10400H";
        this.hardwareType = "Central Process Unit";
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
