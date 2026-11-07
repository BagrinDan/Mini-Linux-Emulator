package org.example.bios;

import org.example.hardware.ComponentResult;
import org.example.hardware.components.DiagnosticManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Bios {
    private static final Logger log = LoggerFactory.getLogger(Bios.class);
    public final DiagnosticManager diagnosticManager;

    public Bios(DiagnosticManager diagnosticManager){
        this.diagnosticManager = diagnosticManager;
    }

    public boolean boot(){
        // Check for hardware
        log.info("[INFO: BIOS] Checking hardware...");

        List<ComponentResult> resultList = diagnosticManager.testResults();
        for(ComponentResult result : resultList){
            log.info("> {}, {}, {}", result.passed(), result.componentName(), result.message());
        }

        // Check for bootloader


        return true;
    }
}
