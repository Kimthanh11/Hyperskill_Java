import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;
    public String state = "ready";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        CoffeeMachine cf = new CoffeeMachine(400, 540, 120, 9, 550);
        while (!cf.state.equals("exit")) {
            cf.working(scanner.nextLine());
        }
    }

    public CoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }

    public void working(String input) {
        switch (this.state) {
            case "ready":
                setState(input);
                break;
            case "buying":
                buy(input);
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.state = "ready";
                break;
            case "filling-water":
                this.water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk you want to add:");
                this.state = "filling-milk";
                break;
            case "filling-milk":
                this.milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans you want to add: ");
                this.state = "filling-coffee";
                break;
            case "filling-coffee":
                this.coffee += Integer.parseInt(input);
                System.out.println("Write how many disposable cups you want to add:");
                this.state = "filling-cups";
                break;
            case "filling-cups":
                this.cups += Integer.parseInt(input);
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.state = "ready";
                break;
        }
    }

    public void setState(String input) {
        switch (input) {
            case "buy":
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:\n> ");
                this.state = "buying";
                break;
            case "take":
                take();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.state = "ready";
                break;
            case "remaining":
                remaining();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                this.state = "ready";
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                this.state = "filling-water";
                break;
            case "exit":
                this.state = "exit";
                break;

        }
    }

    public void buy(String option) {
        switch (option) {
            case "1":
                if (this.water - 250 >= 0 && this.coffee - 16 >= 0 && this.cups - 1 >= 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water = water - 250;
                    coffee = coffee - 16;
                    money = money + 4;
                    cups = cups - 1;
                } else if (this.water - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (this.water - 350 >= 0 && this.milk - 75 >= 0 && this.coffee - 20 >= 0 && this.cups - 1 >= 0) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water = water - 350;
                    milk = milk - 75;
                    coffee = coffee - 20;
                    money = money + 7;
                    cups = cups - 1;
                } else if (this.water - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                }

                break;
            case "3":
                water = water - 200;
                milk = milk - 100;
                coffee = coffee - 12;
                money = money + 6;
                cups = cups - 1;
                break;

            case "back":
                break;
        }
    }

    public void take() {
        System.out.println("I gave you " + this.money);
        this.money = 0;
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

}
