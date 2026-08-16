package org.example.hardware.exceptions;

public class NotInitializedException extends HardwareException {
    public NotInitializedException(String componentName) {
        super(componentName, "Component is not initialized or missing configuration.");
    }
}
