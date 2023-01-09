package builderPattern;

class BuilderTest {
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .setCalories(100).setSodium(35).setCarbohydrate(27).build();
}
