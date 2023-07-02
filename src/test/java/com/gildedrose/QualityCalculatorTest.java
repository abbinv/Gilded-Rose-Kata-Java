package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QualityCalculatorTest {

    @Test
    void getQualityPoints() {
        assertEquals(-1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("foo", 0, 10)));
        assertEquals(1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Aged Brie", 1, 10)));
        assertEquals(2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Aged Brie", -1, 10)));
        assertEquals(-10, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", -1, 10)));
        assertEquals(3, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 5, 10)));
        assertEquals(2, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 10, 10)));
        assertEquals(1, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Backstage passes to a AMSTERDAM concert", 15, 10)));
        assertEquals(0, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Sulfuras, Hand of Ragnaros", 15, 10)));
        assertEquals(0, com.gildedrose.QualityCalculator.getQualityMutation(new Item("Sulfuras, Hand of Ragnaros", -15, 10)));
    }

}
