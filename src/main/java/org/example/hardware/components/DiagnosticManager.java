package org.example.hardware.components;

import org.example.hardware.ComponentResult;

import java.util.List;

public interface DiagnosticManager {
    List<ComponentResult> testResults();
}
