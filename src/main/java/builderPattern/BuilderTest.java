package builderPattern;

import builderPattern.builderClassHierarchy.Calzone;
import builderPattern.builderClassHierarchy.NyPizza;
import builderPattern.builderClassHierarchy.Pizza;

class BuilderTest {
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .setCalories(100).setSodium(35).setCarbohydrate(27).build();

    NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
            .addTopping(Pizza.Topping.MUSHROOM).addTopping(Pizza.Topping.ONION).build();

    Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM)
            .sauceInside().build();
}
