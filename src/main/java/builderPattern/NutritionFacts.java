package builderPattern;

class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //required parameters
        private final int servingSize;
        private final int servings;

        //optional parameters;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(final int servingSize, final int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCalories(int val){
            calories = val;
            return this;
        }

        public Builder setFat(int val){
            fat = val;
            return this;
        }

        public Builder setCarbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public Builder setSodium(int val){
            sodium = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
            .setCalories(100).setSodium(35).setCarbohydrate(27).build();
}
