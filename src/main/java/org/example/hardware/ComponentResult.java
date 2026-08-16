package org.example.hardware;

public record ComponentResult (
        String componentName,
        boolean passed,
        String message
){
}
