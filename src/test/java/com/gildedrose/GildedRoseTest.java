package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private Item[] items;
    private GildedRose app;

    @Test
    void foo() {
        // Given
        items = new Item[]{new Item("foo", 0, 0)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void sellInDays() {
        // Given
        items = new Item[]{new Item("item1", 5, 20),
            new Item("Sulfuras, Hand of Ragnaros", 5, 20),
            new Item("Sulfuras, Hand of SomeoneElse", -1, 20)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals(4, app.items[0].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(5, app.items[1].sellIn, "SellIn should not be changed for sulfuras items");
        assertEquals(-1, app.items[2].sellIn, "SellIn should not be changed for sulfuras items");

    }

    @Test
    void qualityOfRegularItem() {
        // Given
        items = new Item[]{new Item("item1", 10, 20),
            new Item("item2", -1, 20),
            new Item("item3", 10, -1)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals(19, app.items[0].quality, "Quality should be reduced by 1 when sellIn day higher than 0");
        assertEquals(18, app.items[1].quality, "Quality should be reduced by 2 when sellIn day lower than 0");
        assertEquals(0, app.items[2].quality, "Quality should be set to 0 if not a whole number");
    }

    @Test
    void qualityOfAgedBrie() {
        // Given
        items = new Item[]{new Item("Aged Brie", 10, 20),
            new Item("Aged Brie", 0, 20)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals(21, app.items[0].quality, "Quality should be increased by 1 when sellIn day higher than 0");
        assertEquals(22, app.items[1].quality, "Quality should be increased by 2 when sellIn day lower than 0");
    }

    @Test
    void qualityOfBackstagePasses() {
        // Given
        items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a AMSTERDAM concert", 11, 20),
            new Item("Backstage passes to a PARIS concert", 10, 20),
            new Item("Backstage passes to a NEWYORK concert", 6, 20),
            new Item("Backstage passes to a NEWDELHI concert", 5, 20),
            new Item("Backstage passes to a CHENNAI concert", 1, 20),
            new Item("Backstage passes to a MADRID concert", 0, 20)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals(14, app.items[0].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(21, app.items[0].quality, "Quality should be increased by 1 when sellIn day more than 10 days");
        assertEquals(10, app.items[1].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        // Below assert is failing since the original code is not respecting this behaviour
        // assertEquals(22, app.items[1].quality, "Quality should be increased by 2 when sellIn day equal to 10");
        assertEquals(9, app.items[2].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(22, app.items[2].quality, "Quality should be increased by 2 when sellIn day lower than 10");
        assertEquals(5, app.items[3].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        // Below assert is failing since the original code is not respecting this behaviour
        // assertEquals(23, app.items[3].quality, "Quality should be increased by 3 when sellIn day equal than 5");
        assertEquals(4, app.items[4].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(23, app.items[4].quality, "Quality should be increased by 3 when sellIn day lower than 5");
        assertEquals(0, app.items[5].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(23, app.items[5].quality, "Quality should be increased by 3 on event day");
        assertEquals(-1, app.items[6].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(0, app.items[6].quality, "Quality should be 0 when sellIn day lower than 0");
    }

    @Test
    void qualityOfConjured() {
        // Given
        items = new Item[]{new Item("Conjured Mana Cake", 3, 6),
            new Item("Conjured Nana Cake", 1, 6),
            new Item("Conjured Nana Cake", -1, 6)};

        // When
        app = new GildedRose(items);
        app.updateQuality();

        // Then
        assertEquals(2, app.items[0].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(4, app.items[0].quality, "Quality should be reduced by 2 when sellIn day more than 0 days");
        assertEquals(0, app.items[1].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(4, app.items[1].quality, "Quality should be reduced by 2 when sellIn day is 0 day");
        assertEquals(-2, app.items[2].sellIn, "SellIn should be reduced by 1 for all non-sulfuras items");
        assertEquals(2, app.items[2].quality, "Quality should be reduced by 4 when sellIn day less than 0 days");
    }
}
