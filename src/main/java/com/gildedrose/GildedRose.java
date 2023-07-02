package com.gildedrose;

/**
 * The class Gilded rose.
 */
class GildedRose {
    /**
     * The Items.
     */
    Item[] items;

    /**
     * Instantiates a new Gilded rose.
     *
     * @param items the items
     */
    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Update quality of items based on sell in days
     */
    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item, QualityCalculator.getQualityMutation(item));
            updateSellIn(item);
        }
    }

    private void updateSellIn(Item item) {
        if (!ItemType.SULFURAS.equals(ItemType.getItemTypeFromName(item.name)))
            item.sellIn = item.sellIn - 1;
    }

    private void updateQuality(Item item, int qualityMutation) {
        if (qualityMutation > 0) {
            item.quality = Math.min(item.quality + qualityMutation, 50);
        }
        else {
            item.quality = Math.max(item.quality + qualityMutation, 0);
        }
    }

}