package com.amardeep.leetcodepractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionJava {

    //PayPal Interview question
    public static String findMostSoldItem(List<String> items) {
        if (items == null || items.isEmpty()) {
            return "No items in the list.";
        }

        // Step 1: Count the frequency of each item
        Map<String, Integer> itemCounts = new HashMap<>();
        for (String item : items) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }

        // Step 2: Find the maximum count
        int maxCount = 0;
        for (int count : itemCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Step 3: Find the first item with the maximum count
        for (String item : items) {
            if (itemCounts.get(item) == maxCount) {
                return item + " : " + maxCount;
            }
        }

        return "No items in the list.";
    }
}
