package org.example.hardware.exceptions;



public class HardwareException extends RuntimeException {
    private final String componentName;

    public HardwareException(String componentName, String message) {
        super(String.format("[%s] %s", componentName, message));
        this.componentName = componentName;
    }

    public String getComponentName() {
        return componentName;
    }
}
