package com.gildedrose;

public enum ItemType {

    DEFAULT("Default"),
    BACKSTAGE_PASSES("Backstage passes"),
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras"),
    CONJURED("Conjured");

    private final String name;
    ItemType(String name) {
        this.name = name;
    }

    public static ItemType getItemTypeFromName(String name) {
            ItemType result = ItemType.DEFAULT;
            if (name.startsWith(AGED_BRIE.name)) {
                result = ItemType.AGED_BRIE;
            }
            else if (name.startsWith(BACKSTAGE_PASSES.name)) {
                result = ItemType.BACKSTAGE_PASSES;
            }
            else if (name.startsWith(CONJURED.name)) {
                result = ItemType.CONJURED;
            }
            else if (name.startsWith(SULFURAS.name)) {
                result = ItemType.SULFURAS;
            }
        return result;
    }

}
