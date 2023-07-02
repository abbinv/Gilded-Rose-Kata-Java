# Gilded Rose starting position in Java

## Run the Text Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

## NOTES : 
- I intentionally checked the if the name starts with certain characters instead of matching the whole name with assumption that there could be more of items of same type with different names
- For backstage passes, I noticed that the original code updates the quality first(based on `items[i].sellIn < 11` and `items[i].sellIn < 6`)) and then update sell in date. So, when the days are less equal to 10 & 5, it is not having the expected behaviour of 
increase 2 and 3 respectively. I observed it through my unit test assertion which is commented out for now to keep the original behaviour
