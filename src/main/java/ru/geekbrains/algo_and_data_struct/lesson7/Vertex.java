package ru.geekbrains.algo_and_data_struct.lesson7;

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
}
