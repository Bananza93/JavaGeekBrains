package ru.geekbrains.algo_and_data_struct.lesson2;

public enum Vendor {
    LENUVO("Lenuvo", 1),
    ASOS("Asos", 2),
    MACNOTE("MacNote", 3),
    ESER("Eser", 4),
    XAMIOU("Xamiou", 5);

    private final String name;
    private final int sortPriority;

    Vendor(String name, int sortPriority) {
        this.name = name;
        this.sortPriority = sortPriority;
    }

    public String getName() {
        return name;
    }

    public int getSortPriority() {
        return sortPriority;
    }
}
