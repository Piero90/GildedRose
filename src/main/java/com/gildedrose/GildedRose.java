package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int item = 0; item < items.length; item++) {

            if (items[item].name.equals("Sulfuras, Hand of Ragnaros")) continue;

            decreaseSellInByOne(item);

            switch (items[item].name) {
                case ("Aged Brie"): updateQualityAgedBrie(item); break;
                case ("Backstage passes to a TAFKAL80ETC concert"): updateQualityBackstage(item); break;
                case ("Conjured"): updateConjured(item); break;
                default: updateQualityDefault(item);
            }
        }
    }

    private void updateQualityDefault(int item) {
        decreaseQualityByOne(item);
        if (items[item].sellIn < 0) {
            decreaseQualityByOne(item);
        }
    }

    private void updateConjured(int item) {
        decreaseQualityByTwo(item);
        if (items[item].sellIn < 0) {
            decreaseQualityByTwo(item);
        }
    }

    private void updateQualityBackstage(int item) {
        increaseQualityByOne(item);
        if (items[item].sellIn < 10) increaseQualityByOne(item);
        if (items[item].sellIn < 5) increaseQualityByOne(item);
        if (items[item].sellIn < 0) items[item].quality = 0;
    }

    private void updateQualityAgedBrie(int item) {
        increaseQualityByOne(item);
        if (items[item].sellIn < 0) increaseQualityByOne(item);
    }

    private void decreaseSellInByOne(int item) {
        items[item].sellIn -= 1;
    }

    private void decreaseQualityByOne(int item) {
        if (items[item].quality > 0) {
            items[item].quality -= 1;
        }
    }

    private void decreaseQualityByTwo(int item) {
        decreaseQualityByOne(item);
        decreaseQualityByOne(item);
    }

    private void increaseQualityByOne(int item) {
        if (items[item].quality < 50) {
            items[item].quality += 1;
        }
    }
}
