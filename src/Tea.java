import java.util.Objects;
public  class Tea extends food{

    private String color = "";


    private static int blackTeaAmount = 0;
    private static int greenTeaAmount = 0;

    static final String Black = "Black";
    static final String Green = "Green";


    public Tea(String color) throws InvalidColorException {
        this.color=color;
        this.name="Tea";

        switch (color){
            case (Black):
                this.calories = 100;
                blackTeaAmount++;
                break;
            case(Green):
                this.calories=120;
                greenTeaAmount++;
                break;
            default:
                throw new InvalidColorException("Invalid Tea color");
        }
    }

    public int Amount(){
        switch(color){
            case(Black):
                return blackTeaAmount;
            case(Green):
                return greenTeaAmount;

            default: return 0;
        }
    }

    @Override
    public String toString() {
        return "Tea{" +
                "color='" + color + '\'' +
                ", calories=" + calories +
                '}';
    }

    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Tea tea = (Tea) ob;
        return Objects.equals(color, tea.color);
    }

    @Override
    public void consume() {
        System.out.println(color + " " + name + " has been eaten.");
    }

    @Override
    public int calculateCalories() {
        return calories;
    }
}
