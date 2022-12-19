
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        boolean cals = Arrays.stream(args).anyMatch("-calories"::equals);
        try {


            food[] food = new food[5];


            food[0] = new Tea(Tea.Black);
            food[1] = new Tea(Tea.Green);
            food[2] = new Cake(Cake.Caramel);
            food[3] = new Cake(Cake.Chocolate);
            food[4] = new Cake(Cake.Creamy);

            Arrays.sort(food, (first, second) -> {
                if (first.calories != second.calories)
                    return first.calories - second.calories;
                return first.calories;
            });
            System.out.println(Arrays.toString(food));

            int sumCalories = 0;
            for (int i = 0; i < food.length; i++) {
                int curCalories = food[i].calculateCalories();
                food[i].consume();
                sumCalories += curCalories;
            }
            System.out.printf("Sum of calories: " + sumCalories);


        } catch (Exception e) {
            e.getMessage();
        }

    }


}