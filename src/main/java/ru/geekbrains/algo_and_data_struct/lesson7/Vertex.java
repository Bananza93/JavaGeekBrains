package ru.geekbrains.algo_and_data_struct.lesson7;

import java.util.Objects;

public class Vertex {

    private final String label;
    private boolean isProcessed;

    public Vertex(String label) {
        this.label = label;
        isProcessed = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
