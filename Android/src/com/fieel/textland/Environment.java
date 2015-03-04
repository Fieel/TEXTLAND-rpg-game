package com.fieel.textland;

/**
 * Created by diazm on 3/2/2015.
 */
public class Environment {
    public static void forest() {
        int temp = StaticData.getRandomInt(StaticData.PROBABILITY_MAX);

        if (temp < 20) {

            StaticData.incrementStamina(10);
            StaticData.incrementFood(10);
            StaticData.incrementWater(10);
            StaticData.incrementSanity(10);

            System.out.println("\nYou find yourself in the middle of a breathtaking forest.");
            System.out.println("You take shelter under a giant tree, you find some fresh water and you some fruits.");
            System.out.println("Finally you can pass the night sleeping without problems or troubles. You wake up and continue your voyage!");
            System.out.println("New Stamina: "+StaticData.getStamina()+"\nNew Sanity level: "+StaticData.getSanity()+"\nNew Water and food level: "+StaticData.getWater()+", "+StaticData.getFood()+".");


        } else if (temp < 40) {

            System.out.println("\nYou find some mushrooms in a forest.");
            System.out.println("What do you want to do? 1. Eat them\t2. Leave them alone.");


            boolean corr = true;
            while (corr) {

                Scanner temp2 = new Scanner(System.in);
                String b = temp2.next().toLowerCase();

                if (b.equals("1")){

                    corr = false;
                    Character.reduceStamina(10);
                    Character.reduceHP(10);
                    Character.reduceWater(5);
                    Character.incrementFood(10);

                    System.out.println("\nYou eat the mushrooms. You feel satisfyied at first, but after some hours your stomach starts hurting.");
                    System.out.println("Your hunger is at "+Character.getFood()+" and your HP dropped to "+Character.getHP()+".");

                } else if (b.equals("2")){

                    corr = false;
                    Character.reduceStamina(10);
                    Character.reduceFood(10);
                    Character.reduceWater(10);

                    System.out.println("\nYou avoid the mushrooms and continue on your way.");
                    System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");


                } else {
                    System.out.println("\nPlease answer with the option '1' or '2'.");
                }


            }

        } else if (temp < 60) {

            System.out.println("\nAfter some hours of walking up a steep hill you find yourself in front of a burnt forest, probably a fire devasted it some days ago.");
            System.out.println("You can't go back, you would waste an entire day just to get to the point where you were this morning.");
            System.out.println("You can decide. You have two choices:");
            System.out.println("1. Enter the burnt forest.");
            System.out.println("2. Circularize the perimeter of the forest, avoiding entering but wasting a lot of time and power.");

            boolean corr = true;

            while (corr) {

                Scanner temp2 = new Scanner(System.in);
                String b = temp2.next().toLowerCase();

                if (b.equals("1")){

                    corr = false;
                    Character.reduceStamina(10);
                    Character.reduceSanity(30);
                    Character.reduceWater(10);
                    Character.incrementFood(20);
                    Character.reduceHP(10);

                    System.out.println("\nYou decide to enter the forest and pass right in the middle of it.");
                    System.out.println("You spend one hour walking in the middle of dead trees. Everything is dead, but you seem to get lucky:");
                    System.out.println("During your trip you find a dead and awesomely cooked deer just waiting for you to eat it. Your new hunger level is "+Character.getFood()+".");
                    System.out.println("Your HP, due to the bad smoke inhaled during your time in the forest dropped to "+Character.getHP()+".");
                    System.out.println("Your sanity level has been reduced to "+Character.getSanity()+".");

                } else if (b.equals("2")){

                    corr = false;
                    Character.reduceStamina(30);
                    Character.reduceFood(10);
                    Character.reduceWater(10);

                    System.out.println("\nYou decide to take a longer path, curcularizing the forest without entering it.");
                    System.out.println("After a LOT of time you arrive to the other side. Unfortunatelly you didn't find any food nor water and you spent a lot of energies.");
                    System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");


                } else {
                    System.out.println("\nPlease answer with the option '1' or '2'.");
                }
            }
        } else if (temp < 80) {

            Character.incrementFood(20);
            Character.incrementHP(10);
            Character.incrementSanity(20);
            Character.incrementWater(20);
            Character.incrementStamina(20);

            System.out.println("\nDuring the sunset you follow a bright light you can see in the horizon.");
            System.out.println("Once arrived you enter a majestic forest that emanes a sort of green glow miles up on the night sky.");
            System.out.println("You can't remember what happened but you find yourself on the other side of the forest. What happened?");
            System.out.println("You feel full of powers and your stomach feels full. You feel grateful for the lucky encounter and continue traveling.");
            System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");

        } else if (temp < 100){

            Character.reduceFood(10);
            Character.reduceWater(10);
            Character.reduceStamina(20);
            Character.reduceSanity(20);

            System.out.println("\nYou find yourself in the middle of a spooky forest.");
            System.out.println("The atmosphere is really dark, the trees start to look dead and you start to feel dizzy.");
            System.out.println("You can't find the right way to get out of the forest so you start to panick in fear, probably allucinated by the effects of the forest.");
            System.out.println("After hours you start to feel normal. You are still shocked about the circumstances.");
            System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");

        }
    }
}
