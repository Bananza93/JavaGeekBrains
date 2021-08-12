package ru.geekbrains.algo_and_data_struct.lesson5;

import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem {
    private static List<Item> items;
    private static int capacity;
    private static List<Item> maxCostCombination;
    private static int maxCost;
    private static List<Item> currCombination;

    public static List<Item> getMaxProfitCombination(List<Item> items, int backpackCapacity) {
        if (items == null) return null;
        initVars(items, backpackCapacity);
        checkAllCombinations(0, 0, 0);
        return maxCostCombination;
    }

    private static void checkAllCombinations(int startPos, int currWeight, int currCost) {
        if (startPos >= items.size()) return;
        for (int i = startPos; i < items.size(); i++) {
            int weight = items.get(i).getWeight();
            int cost = items.get(i).getCost();
            if (currWeight + weight <= capacity) {
                currCombination.add(items.get(i));
                if (currCost + cost > maxCost) {
                    maxCost = currCost + cost;
                    maxCostCombination = new ArrayList<>(currCombination);
                }
                for (int j = i + 1; j < items.size(); j++) {
                    checkAllCombinations(j, currWeight + weight, currCost + cost);
                }
                currCombination.remove(currCombination.size() - 1);
            }
        }
    }

    private static void initVars(List<Item> itemsList, int backpackCapacity) {
        items = itemsList;
        capacity = backpackCapacity;
        maxCost  = 0;
        maxCostCombination = new ArrayList<>();
        currCombination = new ArrayList<>();
    }
}
