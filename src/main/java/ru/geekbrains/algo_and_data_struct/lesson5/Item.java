package ru.geekbrains.algo_and_data_struct.lesson5;

import lombok.Value;

import java.util.Objects;

@Value
public class Item {

    String name;
    int weight;
    int cost;

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return weight == item.weight && cost == item.cost && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, cost);
    }
}
