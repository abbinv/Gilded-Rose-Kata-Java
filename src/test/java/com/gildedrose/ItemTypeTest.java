package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemTypeTest {

    @Test
    void getItemTypeFromName() {
        assertEquals(ItemType.DEFAULT, ItemType.getItemTypeFromName("foo"), "DEFAULT type extraction failed");
        assertEquals(ItemType.SULFURAS, ItemType.getItemTypeFromName("Sulfuras, Hand of Ragnaros"), "SULFURAS type extraction failed");
        assertEquals(ItemType.AGED_BRIE, ItemType.getItemTypeFromName("Aged Brie"), "AGED_BRIE type extraction failed");
        assertEquals(ItemType.BACKSTAGE_PASSES, ItemType.getItemTypeFromName("Backstage passes to a AMSTERDAM concert"), "BACKSTAGE_PASSES type extraction failed");
    }

}
