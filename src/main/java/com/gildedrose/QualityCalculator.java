package com.gildedrose;

class QualityCalculator {

    public static int getQualityMutation(Item item) {
        int qualityMutation = item.sellIn <= 0 ? -2 : -1;
        ItemType itemType = ItemType.getItemTypeFromName(item.name);
        switch (itemType) {
            case AGED_BRIE:
                qualityMutation = -qualityMutation;
                break;
            case BACKSTAGE_PASSES:
                qualityMutation = getQualityMutationForBackstagePasses(item);
                break;
            case CONJURED:
                qualityMutation = qualityMutation * 2;
                break;
            case SULFURAS:
                qualityMutation = 0;
                break;
            default:
                break;
        }
        return qualityMutation;
    }

    private static int getQualityMutationForBackstagePasses(Item item) {
        int qualityMutation = -item.quality;
        if (item.sellIn > 10) {
            qualityMutation = 1;
        }
        else if (item.sellIn > 5) {
            qualityMutation = 2;
        }
        else if (item.sellIn > 0) {
            qualityMutation = 3;
        }
        return qualityMutation;
    }
}