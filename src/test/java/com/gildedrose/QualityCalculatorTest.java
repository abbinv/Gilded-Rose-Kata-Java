package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The test class for QualityCalculator.
 */
class QualityCalculatorTest {

    @Test
    @DisplayName("Verify that QualityMutation is calculated properly for default item type")
    void getQualityMutationForDefault() {
        assertEquals(-2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("foo", 0, 10)));
        assertEquals(-1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("foo", 1, 10)));
    }

    @Test
    @DisplayName("Verify that QualityMutation is calculated properly for Aged Brie item type")
    void getQualityMutationForAgedBrie() {
        assertEquals(2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Aged Brie", 0, 10)));
        assertEquals(1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Aged Brie", 1, 10)));
    }
    @Test
    @DisplayName("Verify that QualityMutation is calculated properly for Backstage passes item type")
    void getQualityMutationForBackstagePasses() {
        assertEquals(-10, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 0, 10)));
        assertEquals(3, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 5, 10)));
        assertEquals(2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 10, 10)));
        assertEquals(1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 15, 10)));
    }

    @Test
    @DisplayName("Verify that QualityMutation is calculated properly for Sulfuras item type")
    void getQualityMutationForSulfuras() {
        assertEquals(0, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Sulfuras, Hand of Ragnaros", 0, 10)));
        assertEquals(0, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Sulfuras, Hand of Ragnaros", 1, 10)));
        }

    @Test
    @DisplayName("Verify that QualityMutation is calculated properly for Conjured item type")
    void getQualityMutationForConjured() {
        assertEquals(-4, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Conjured expired item", 0, 10)));
        assertEquals(-2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Conjured non expired item", 1, 10)));
    }
}
