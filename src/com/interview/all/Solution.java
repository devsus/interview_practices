package com.interview.all;

import java.util.Scanner;
//https://gist.github.com/fdominguezgsysusit/d6fa369fa659662bb78a8cda95c8c7b7/revisions
abstract class Cuisine {
    public abstract Cuisine serveFood(String dish);
}
class UnservableCuisineRequestException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public UnservableCuisineRequestException(String message) {
        super(message);
    }
}
class Italian extends Cuisine{
    private String dish;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
    @Override
    public Cuisine serveFood(String dish) {
        setDish(dish);
        return this;
    }
}
class Mexican extends Cuisine{
    private String dish;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
    @Override
    public Cuisine serveFood(String dish) {
        setDish(dish);
        return this;
    }
}
class Japanese extends Cuisine{

    private String dish;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
    @Override
    public Cuisine serveFood(String dish) {
        setDish(dish);
        return this;
    }
}

class Chinese extends Cuisine {
    private String dish;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }
    @Override
    public Cuisine serveFood(String dish) {
        setDish(dish);
        return this;
    }
}

class FoodFactory {
    static FoodFactory getFactory() {
        return new FoodFactory();
    }

    java.util.Map<String, Cuisine> cuisines =  new java.util.HashMap<String, Cuisine>();


    void registerCuisine(String cuisineKey, Cuisine cuisine){
        cuisines.put(cuisineKey, cuisine.serveFood(cuisineKey));
    }

    public Cuisine serveCuisine(String cuisine, String dish) throws UnservableCuisineRequestException {
        if(!cuisines.containsKey(cuisine)){
            throw new UnservableCuisineRequestException("Unservable cuisine " + cuisine + "for dish "+ dish);
        }
        else
            return cuisines.get(cuisine).serveFood(dish);
    }
}

public class Solution {
	private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();

    static {
        FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
        FoodFactory.getFactory().registerCuisine("Italian", new Italian());
        FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
        FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
    }
	public static void main(String[] args) {
		int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
        while (totalNumberOfOrders-- > 0) {
            String[] food = INPUT_READER.nextLine().split(" ");
            String cuisine = food[0];
            String dish = food[1];

            try {
                if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
                    Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);

                    switch (cuisine) {
                        case "Chinese":
                            Chinese chineseDish = (Chinese) servedFood;
                            System.out.println("Serving " + chineseDish.getDish() + "(Chinese)");
                            break;
                        case "Italian":
                            Italian italianDish = (Italian) servedFood;
                            System.out.println("Serving " + italianDish.getDish() + "(Italian)");
                            break;
                        case "Japanese":
                            Japanese japaneseDish = (Japanese) servedFood;
                            System.out.println("Serving " + japaneseDish.getDish() + "(Japanese)");
                            break;
                        case "Mexican":
                            Mexican mexicanDish = (Mexican) servedFood;
                            System.out.println("Serving " + mexicanDish.getDish() + "(Mexican)");
                            break;
                        default:
                            break;
                    }
                }
            } catch (UnservableCuisineRequestException ex) {
                System.out.println(ex.getMessage());
            }
        }

	}

}
