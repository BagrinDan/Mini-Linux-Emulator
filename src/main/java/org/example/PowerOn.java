package org.example;


import org.example.bios.Bios;
import org.example.hardware.components.DiagnosticManager;
import org.example.hardware.components.Motherboard;

public class PowerOn {
    public static void main(String[] args) {
        // Bios
        DiagnosticManager diagnosticManager = new Motherboard();
        Bios bios = new Bios(diagnosticManager);
        bios.boot();

        // Bootloader

        // Kernel
    }
}
