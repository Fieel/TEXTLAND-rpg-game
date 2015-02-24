import java.util.Random;
import java.util.Scanner;

public class Game extends Variables {
	
	Random rand = new Random();
	static boolean mapborder = false;
	static int days = 0;
	
	public static void main(String args[]){
	
		Map mainMap = new Map(10, 10);
		Character hero = new Character(mainMap);
		Main.start();
		
		boolean done = false;
		while (!done) { //Main cycle. This is the game running in loop until some of the ending conditions are met.
			
			//printmap(hero, mainMap); //This is just for me for debugging while playing. It displays the array every time i move the character so i know what should happen and if it works properly.
			
			Character.moving();//This asks the player if he wants to move forward left or right, and then waits for input. After that it moves the character in the next cell of the array and next biome
			days += 1;
			System.out.println("Day "+days+":");
			if (!mapborder) {
				Map.environment();// Methods that selects randomly the right environment given the number on the cell where the player is standing. For example it will trigger the method Game.village() if the cells has a number 0
			}
			
			mapborder = false;
				
			if (Character.getHP() <=0) { //Here i list all the ending conditions which will trigger a character end, thus a game end.
			    done = true;
			Main.endHP();
			}
			
			else if (Character.getFood() <=0) {
			    done = true;
			Main.endFood();
			}
			
			else if (Character.getWater() <=0) {
			    done = true;
			Main.endWater();
			}
			
			else if (Character.getStamina() <=0) {
			    done = true;
			Main.endStamina();
			}
			
			else if (Character.getSanity() <=0) {
				done = true;
			Main.endSanity();
			}
			
			else if (Character.victorycondition()) {
			    done = true;
			Main.win();
			}
			
			
		}
	}

	public static void printmap(Character a, Map b) {                 //OBJECT THAT PRINTS THE MAP WITH THE CHARACTER
		b.mapArray[a.y][a.x] = "*";
		for (int i = 0; i < b.mapArray.length; i++){
			
			System.out.print("|");
			
			for (int j = 0; j < b.mapArray[i].length; j++){
				System.out.print(b.mapArray[i][j]);
				System.out.print("  ");
			}
			
			System.out.println("|\n");
		}
	}
	
	public static int returnDays (){
		return days;
	}
	
	public static void village() {
		
		int temp = (int)(Math.random()*100);
		
			if (temp < 20) {
				
				Character.incrementFood(10);
				Character.incrementHP(10);
				Character.incrementWater(10);
				Character.incrementStamina(10);
				Character.incrementSanity(20);
				
				System.out.println("\nYou find a village full of people.");
				System.out.println("As soon as you approach the main street people start looking at you, like you are some sort of hero.");
				System.out.println("A man that calls himself the 'mayor' approaches you: "+ name +", right?");
				System.out.println("Why you don't you take a room at the local tavern and take so e rest? It's free. You can continue your voyage tomorrow.");
				System.out.println("");
				System.out.println("You pass the night sleeping like a child. Your new stamina is "+Character.getStamina()+".");
				System.out.println("The dinner at the tavern was great. Your stomach feels full. Your hunger is at "+Character.getFood()+"and your thirsty is"+Character.getWater()+".");
				
			} else if (temp < 40) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceSanity(20);
				Character.incrementStamina(10);
				
				System.out.println("\nYou arrive in a empty village, when you first saw the roofs of the houses from the distance");
				System.out.println("you realized you had a possibility to get a shelter and some food but now all your hope is gone.");
				System.out.println("After taking the decision to inspect some houses you find a empty house that will fit perfectly for the night.");
				System.out.println("You search for food but you can't find any. This situation is really insolit, you wonder what happened to the villagers that used to live here.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 60) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(40);
				Character.reduceHP(10);
				
				System.out.println("\nYou approach a village, it is really misty. The mist is all around the village, you decide to enter and discover what's going on.");
				System.out.println("A man approaches you willing to ask you where did you came from.");
				System.out.println("All of a sudden a man riding a horse, with a pumpink in fire as head slings his sword and beheads the man you were talking to.");
				System.out.println("You run in fear and escape the liviing fuck out of there.");
				System.out.println("You lose 10 HP. New HP: "+Character.getHP()+".");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				System.out.println("\nYou find a village full of Orcs. They're eating roasted wild boar and you are rally hungry.");
				System.out.println("What do you want to do?");
				System.out.println("1. Try to steal a roaster wild boar and escape from the Orcs");
				System.out.println("2. The risk is not worth it");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(20);
					Character.reduceHP(30);
					Character.reduceWater(10);
					Character.reduceFood(10);
					Character.reduceSanity(10);
										
					System.out.println("\nYou stupidly run into the village, grab a roasted boar and try to escape.");
					System.out.println("While you try to escape an Orc grabs you and the boar fells down from your hands.");
					System.out.println("You get almost killed by the Orc and you get stabbed heavily in the chest.");
					System.out.println("You lose 40 HP in the process. You new HP level: "+Character.getHP()+".");
					System.out.println("Your hunger is at "+Character.getFood()+" and your HP dropped to "+Character.getHP()+".");
				
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
										
					System.out.println("\nYou avoid the problems and continue on your way. You REALLY feel like you made the right choice.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}		
				}
				
			} else if (temp < 100){
				
				System.out.println("\nYou find a Village in the middle of a valley. What you want to do?");
				System.out.println("1. Go towards it and find out.");
				System.out.println("2. Continue on your way and avoid troubles.");
				
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(10);
					Character.reduceHP(30);
					Character.reduceWater(10);
					Character.reduceFood(10);
					Character.reduceSanity(20);
										
					System.out.println("\nJust before reaching the village a titanic landslide generated from the nearby mountains hits the village and all the surounding area.");
					System.out.println("You miracolously survive and manage to get out of the debris. You are heavily wounded.");
					System.out.println("You lose 30 HP. New HP level: "+Character.getHP()+".");
					System.out.println("Your hunger is at "+Character.getFood()+" and your HP dropped to "+Character.getHP()+".");
				
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
										
					System.out.println("\nYou decide to continue on your way.");
					System.out.println("After 30 minutes you hear a distant explosion, you get on the top of a tree.");
					System.out.println("You can see the village you just encountered being hit by a titanic landslide generated by the nearby mountains!");
					System.out.println("If you decided differently, you would probably be dead. Congratulations!");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}		
				}
				
			}
	}
	
	public static void forest() {
		
		double temp = Math.random()*100;
			if (temp < 20) {
				
				Character.incrementStamina(10);
				Character.incrementFood(10);
				Character.incrementWater(10);
				Character.incrementSanity(10);
				
				System.out.println("\nYou find yourself in the middle of a breathtaking forest.");
				System.out.println("You take shelter under a giant tree, you find some fresh water and you some fruits.");
				System.out.println("Finally you can pass the night sleeping without problems or troubles. You wake up and continue your voyage!");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
				
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
	
	public static void river() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceSanity(10);
				Character.reduceFood(10);
				Character.incrementWater(20);
				Character.reduceStamina(10);
				
				System.out.println("\nThere is a river accross your way, you decide to try and reach the other side using a natural bridge not far away.");
				System.out.println("During the process you fall in the water but you manage to reach the other side.");
				System.out.println("You lose stamina and sanity.\tNew sanity level: "+Character.getSanity()+"\tNew stamina: "+Character.getStamina()+".");
				System.out.println("You can drink some water, new Water level: "+Character.getWater()+".");
				
			} else if (temp < 40) {
				
				Character.incrementStamina(10);
				Character.incrementFood(10);
				Character.incrementWater(10);
				
				System.out.println("\nYou find a river and you decide to try to catch some fish.");
				System.out.println("After a good catch you eat some fish and feel better. You sleep and wake up the morning after.");
				
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 60) {
				
				Character.incrementFood(10);
				Character.incrementWater(30);
				Character.incrementStamina(20);
				Character.incrementSanity(20);
				Character.incrementHP(10);
				
				System.out.println("\nYou find a waterfall and you decide to inspect it. There's a pristine lake where you can drink some water.");
				System.out.println("Behind the waterfall you find a cavern and enter it. The cavern is really mystical and is emanating a rainbow-like light.");
				System.out.println("Inside the cavern you find an altar with an amulet lying on it. You take the amulet and imediatelly feel better and powerful.");
				System.out.println("After touching it the amulet disappears, you decide to leave and continue on your journey.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				System.out.println("\nYou're blocked by a frozen river. The ice seems thin and you're not sure it can substain your weight.");
				System.out.println("You have two options:");
				System.out.println("1. Try to walk over the river to get to the other side.");
				System.out.println("2. Find another way. Beware, it could be really far away.");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(30);
					Character.reduceSanity(30);
					Character.reduceFood(10);
					Character.reduceHP(30);
										
					System.out.println("\nYou try to walk over the ice. The river seems solid, and you are already in the middle of the way to the other side.");
					System.out.println("When you're almost there the ice breaks under your feet and you fall into the frozen lake underneath.");
					System.out.println("You try to get up but the ice keeps breaking. After some minutes you get to land.");
					System.out.println("You're freezing, and you thank god to still be alive.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(20);
					Character.reduceFood(10);
										
					System.out.println("\nAfter a full day of walking you find a bridge over the frozen river.");
					System.out.println("You're exhausted but at least you are safe. You feel like you took the right decision.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}
				}
				
			} else if (temp < 100){
				
				System.out.println("\nYou find a bridge right away when you're blocked by a river. You see a big, green monster looking like an Orc stopping your way.");
				System.out.println("He starts speaking to you: 'Come here, don't worry. There is nothing to worry about. You can pass over the bridge and continue on your journey'");
				System.out.println("The Orc is terrifying. He looks really suspicious and you don't know if you should trust him.");
				System.out.println("You have two choices:");
				System.out.println("1. trust the Orc and pass the bridge.");
				System.out.println("2. Turn and run away faster than you can. You'll find another way.");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(20);
					Character.reduceSanity(30);
					Character.reduceWater(10);
					Character.reduceFood(10);
					Character.reduceHP(50);
										
					System.out.println("\nYou start walking towards the bridge, trusting that the Orc won't do anything stupid.");
					System.out.println("Once you are midway towards the other side the Orc starts yelling:");
					System.out.println("'DID YOU REALLY THINK I WOULDN'T ATTACK YOU? DIE! YOU'LL BE MY DINNER!'");
					System.out.println("You're shooked and start running towards the other side of the bridge trying to escape the Orc.");
					System.out.println("You get hit twice before managing to escape. You're really wonded, maybe you took the wrong choice.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(20);
					Character.reduceFood(10);
										
					System.out.println("\nYou take the easy path and you manage to escape easely the Orc.");
					System.out.println("The Orc tried to catch me as soon as i started running so i think i did the right thing!");
					System.out.println("Unfortunatelly you wasted a lot of time and energies finding another way accross the river..");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}
				}
				
			}
	}
	
	public static void cave() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceStamina(5);
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceSanity(10);
				Character.reduceHP(20);
				
				System.out.println("\nIn your way you find a big and comfortable cave.");
				System.out.println("You get inside hoping to pass the night far away from the rigid weather outside.");
				System.out.println("After one hour a bear, coming from the deepts of the cavern attacks you, inflicting you 20 HP damage.");
				System.out.println("You manage to escape, frightened as hell.");
				System.out.println("New Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				System.out.println("You HP dropped by 20. New HP: "+Character.getHP()+".");
				
			} else if (temp < 40) {
				
				Character.incrementStamina(10);
				Character.reduceFood(10);
				Character.incrementWater(10);;
				Character.incrementSanity(10);
				
				System.out.println("\nIn front of you, hidden by some trees, you see a cavern perfect to use during the night.");
				System.out.println("You get some water from a pristine water pond inside the cavern.");
				System.out.println("New Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
				
			} else if (temp < 60) {
				
				Character.incrementFood(10);
				Character.incrementWater(10);
				Character.incrementSanity(10);
				Character.incrementStamina(10);
				
				System.out.println("\nThe sun is falling and i must find a place to sleep during the night.");
				System.out.println("I see a cavern in the distance, a perfect place to hide and sleep.");
				System.out.println("I approach the opening and look around in case there are nearby threats.");
				System.out.println("Given the recent tranquillity i decide to enter and sleep the night in.");
				System.out.println("The night passes and you wake up on the next morning. It has stopped raining.");
				System.out.println("You catch a rabbit and cook it over a fire for breakfast.");
				System.out.println("You continue on your journey.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				Character.incrementFood(20);
				Character.incrementWater(10);
				Character.incrementSanity(10);
				Character.incrementStamina(10);
				
				System.out.println("\nYou manage to catch a nice meal and you decide to take shelter in a icy cave nearby.");
				System.out.println("You light up a fire and eat your prey. You are well protected inside the cave and you pass the night sleeping by the fire.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				System.out.println("\nYou proceed on your way until you find some strange entrance in a rock.");
				System.out.println("At the top of the rocky entrance is written 'Mortals shall not pass.'. What you want to do?");
				System.out.println("1. Enter.");
				System.out.println("2. Avoid the cavern and continue on your way.");
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(20);
					Character.reduceSanity(30);
					Character.reduceWater(10);
					Character.reduceFood(10);
					Character.reduceHP(40);
										
					System.out.println("\nYou enter inside. As soon as you get inside a voice speaks from inside the cavern:");
					System.out.println("'Why did you enter? You will pay for this.' You get stabbed in the back.");
					System.out.println("You wake up outside of the cavern heavily wounded. Even if slowsly, you continue on your way.");
					System.out.println("You lose 40 HP in the process. Your new HP level: "+Character.getHP()+".");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
										
					System.out.println("\nYou decide to avoid the cavern and continue on your way.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}
				}
				
			}
	}
	
	public static void castle() {
		
		double temp = Math.random()*100;
			if (temp < 20) {
				
				System.out.println("\nYou start to spot towers and flags in the horizon and shortly you find yourself in front of a gigantic stone castle.\n");
				System.out.println("As soon as you approach the castle the main gates open and a dark-haired man asks you:");
				System.out.println("'This is Highwalls Castle. This is a pacific domain. Do you come in peace?'");
				System.out.println("1. answer 'Yes'");
				System.out.println("2. answer 'No'");
				
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.incrementFood(10);
					Character.incrementWater(10);
					Character.incrementStamina(20);
					Character.incrementSanity(30);
					Character.incrementHP(20);
										
					System.out.println("\nThe man opens completelly the doors and lets you in. The city inside is full of people, shops and taverns.");
					System.out.println("You decide to try and ask some people what's this place and why you magically appeared here but you can't get an answer. People gets annoyied when you ask.");
					System.out.println("You get some food and water and sleep inside the walls, the next morning you feel great but you decide to continue on your business and depart.");
					System.out.println("You HP increased by 20. New HP: "+Character.getHP()+".");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
					Character.reduceSanity(10);
					Character.reduceHP(10);
										
					System.out.println("\nThe man gets inside and closes the door. No words were spoken. You decide to continua on your journey without the help of those pathetic men inside the safeness of their walls.");
					System.out.println("You HP dropped by 10. New HP: "+Character.getHP()+".");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					
					System.out.println("\nPlease answer with the option '1' or '2'.");
					
				}
				}
				
				
			} else if (temp < 40) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceHP(20);
				Character.reduceSanity(10);
				
				System.out.println("\nYou spot a castle in the distance, the gates are open so you decide to enter to find a shelter.");
				System.out.println("During the night you are attacked by a ghostly figure, after getting hit by the figure you manage to run for your life.");
				System.out.println("The wounds inflicted by the ghost costed you 20 HP. Your new HP value is "+Character.getHP()+".");
				System.out.println("New Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				System.out.println("You HP dropped by 20. New HP: "+Character.getHP()+".");
				
				
			} else if (temp < 60) {
				
				System.out.println("\nYou find a big castle and decide to enter and inspect it.");
				System.out.println("Once inside you can't find your way out, you keep walking through random rooms until you end up in a big room.");
				System.out.println("You want to exit, but the big room offers two choices. The left door and the right door. Which one will you choose?");
				System.out.println("1. The left door.");
				System.out.println("2. The right door.");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceStamina(30);
					Character.reduceSanity(30);
					Character.reduceWater(20);
					Character.reduceFood(20);
					Character.reduceHP(20);
										
					System.out.println("\nYou take the right decision and walk towards the left door.");
					System.out.println("After entering the new room, you find out that the maze continues.");
					System.out.println("You spend what seems days or weeks inside the castle before finding your way out.");
					System.out.println("You leave the castle greatly weakened and wounded.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					System.out.println("You HP dropped by 20. New HP: "+Character.getHP()+".");
										
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(20);
					Character.incrementFood(10);
					Character.incrementWater(10);
					
					System.out.println("\nYou take the right decision and walk towards the right door.");
					System.out.println("You find yourself istantly in the wilderness outside of the castle, with some food and water.");
					System.out.println("You wonder what would have happened if you took the other door.");
					System.out.println("Nevermind, you just continue on your way.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					System.out.println("\nPlease answer with the option '1' or '2'.");
				}
				}
			} else if (temp < 80) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.incrementStamina(10);
				Character.incrementSanity(10);
				
				System.out.println("\nAfter one day of walking you are exhausted. You decide to rest in an abbandoned castle you found on your way.");
				System.out.println("There is no food nor water but you can sleep without worries.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(10);
				
				System.out.println("\nYou decide to ask for help after finding a castle on top of a nearby hill.");
				System.out.println("As soon as you approach people fron the othe side of the big gates start yelling to me to go away.");
				System.out.println("I try to explain, yelling, that i'm just a traveler and that i'd like some help.");
				System.out.println("Soldiers from the top of the walls shot some arrows at me as warning, i turn away and continue my voyage.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			}
	}
	
	public static void plains() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(10);
				
				System.out.println("\nThe horizon extends as far as the eye can see, you see nothing but infinite grasslands.\n");
				System.out.println("You keep walking and hoping to find something, but seems that there's nothing here.");
				System.out.println("New Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 40) {
				
				Character.incrementFood(10);
				Character.incrementWater(10);
				Character.incrementStamina(10);
				Character.incrementSanity(10);
				
				System.out.println("\nWalking through a great plain grassland you encounter an abbandoned firecamp.");
				System.out.println("Seems like someone has been camping here not long ago, and they forgot some water and food. I'll pass the night here.");
				System.out.println("New Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
								
			} else if (temp < 60) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(10);
				
				System.out.println("\nEverything starts turning sandy while you travel trough the land.");
				System.out.println("You find yourself in a desert in less than 30 minutes. You can't do anything but continue walking.");
				System.out.println("After a full day of walking the desert disappears and you stop for the night. You are thirsty and hungry.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(20);
				Character.reduceHP(20);
				
				System.out.println("\nWhile you walk under a nice spring breeze you stumble over a root and hit your head on a stone.");
				System.out.println("You wake up one hour later confused and with a strong headache.");
				System.out.println("You lose 20 HP in the process. New HP: "+Character.getHP()+".");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				Character.reduceFood(20);
				Character.reduceWater(20);
				Character.reduceStamina(20);
				
				System.out.println("\nWhile you travel through infinite green lands you see in the distance hundreds of stendards.");
				System.out.println("As you get closer you realize that you just ran into an Orc army. They're still too far away to get to you.");
				System.out.println("This will cost you an entire day but it's your only option. Turn back and find another way to continue on your journey.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			}
	}
	
	public static void mountain() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(20);
				Character.reduceHP(10);
				
				System.out.println("\nDuring a trip through a steep mountain you get caught in a tremendous ice storm.");
				System.out.println("You are forced to stop and you almost freeze to death, losing 10 HP, 20 Stamina and 20 Sanity.");
				System.out.println("New HP: "+Character.getHP()+"\tNew Stamina: "+Character.getStamina()+"\tNew Sanity level: "+Character.getSanity()+"\tNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				System.out.println("You HP dropped by 10. New HP: "+Character.getHP()+".");
				
				
			} else if (temp < 40) {
				
				Character.reduceStamina(20);
				Character.reduceSanity(50);
				Character.reduceFood(10);
				Character.reduceWater(10);
				
				System.out.println("\nYou keep walking through a mountain pass until you realize that you're being followed by a strange figure.");
				System.out.println("The figure keeps following you, even if you try to escape or get rid of it you can't manage to get away from it.");
				System.out.println("You pass the whole night in panic until the figure disappears the following morning, when the mountain was already behind your back.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 60) {
				
				Character.incrementFood(10);
				Character.incrementWater(10);
				Character.incrementStamina(10);
				
				System.out.println("\nYou travel through a mountain, given the situation you are forced to stop and camp during the night.");
				System.out.println("You manage to catch some venision and eat. You sleep by a campfire and wake up on the morning, ready to complete the descent.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				Character.incrementFood(10);
				Character.incrementWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(10);
				
				System.out.println("\nWhile walking through a mountain you find a strange guy claiming to be the 'Holy Mountains Hermit'.");
				System.out.println("I ask the hermit if he can help me with food or anything, he nods and asks me to follow him, leading the way into the pine forest.");
				System.out.println("The hermit leads me to his little mountain hut and offers me an hot meal.");
				System.out.println("After the meal he asks me to leave, he says that no adventurer should travel in this mountains during the night, and urges me to quickly get out of the mountain.");
				System.out.println("I reach the other side of my path before night, i should continue my mission and go on.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				Character.reduceFood(20);
				Character.reduceWater(20);
				Character.reduceStamina(20);
				Character.reduceSanity(10);
				
				System.out.println("\nYou can't continue your voyage unless you climb a giant mountain blocking your path.");
				System.out.println("Unfortunatelly this will cost you a lot of time and energies, but it's the only way.");
				System.out.println("After two days you get to the other side and you can finally rest.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			}
	}
	
	public static void swamp() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(5);
				
				System.out.println("\nAir begins to stink and you find yourself in a hostile and putrid swamp.");
				System.out.println("It seemed like an eternity but you manage to get out of the swamp.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
				
			} else if (temp < 40) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(10);
				Character.reduceHP(20);
								
				
				System.out.println("\nDuring your trip you fall into a stinky swamp, a slime creature attacks you from behind a pond.");
				System.out.println("You almost drawn before managing to attack the creature with a kick and get out of the pond.");
				System.out.println("You get out of the swamp as soon as possible. You lose 20 HP.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				System.out.println("You HP dropped by 20. New HP: "+Character.getHP()+".");
				
				
			} else if (temp < 60) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				
				System.out.println("\nWhile walking through a swamp you find a tiny boat lying near a putrid green lake.");
				System.out.println("You decide to get on the boat. It wasa good idea, because following the lake and the nearest rivers");
				System.out.println("you got to get out of the swamp in less than two hours. After that, you continue on your journey.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				System.out.println("\nIn the middle of a swamp you find an altar with a strange potion lying on top of it.");
				System.out.println("What do you want to do?");
				System.out.println("1. Drink the potion");
				System.out.println("2. leave it alone and continue on your way");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.reduceFood(20);
					Character.reduceWater(20);
					Character.reduceSanity(10);
					Character.incrementStamina(10);
					Character.reduceHP(20);
										
					System.out.println("\nYou drink the potion and you start feeling bad and contorting. You skin turns green and you lose counsciousness..");
					System.out.println("You wake up one day after, hungry and thirsty. You arrived at the conclusion that you simply felt in a coma and woke up one day after.");
					System.out.println("You lose 20 HP in the process. New HP level: "+Character.getHP()+".");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
										
					System.out.println("\nYou simply continue on your way.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					
					System.out.println("\nPlease answer with the option '1' or '2'.");
					
				}
				}
				
			} else if (temp < 100){
				
				Character.reduceFood(20);
				Character.reduceWater(20);
				Character.reduceStamina(20);
				Character.reduceSanity(20);
				Character.reduceHP(10);
				
				System.out.println("\nYou are so unlocky that you fall inside a pond in a stinky swamp.");
				System.out.println("You throw up by the stinky odor the pond is emanating.");
				System.out.println("You get out and continue on your way. You feel bad, maybe something intoxicated you.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			}
	}
	
	public static void crypta() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceStamina(10);
				Character.reduceWater(10);
				Character.reduceSanity(10);
				Character.reduceFood(10);
				
				System.out.println("\nYou find a hole in the ground, you don't know why but you go inside looking for hints.\n");
				System.out.println("In the hole you find out that you're in some catacombs, you look around around and you see only corpses.\n");
				System.out.println("After moments of panic, you find a golden holy cross lying on the ground. The cross is emaning some kind of power, you cn feel it. You pick it up.");
				System.out.println("You get out and continue on your journey.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 40) {
				
				Character.reduceSanity(20);
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				
				System.out.println("\nYou walk through a cemetery abbandoned in the middle of nowhere.");
				System.out.println("You start seeing things. Your brain begins distorting reality and you start running.");
				System.out.println("You wake up, the sun is shining. You are lying in camp, you can't remember what happened.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 60) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(40);
				Character.reduceHP(30);
				
				System.out.println("\nWhile traveling in the middle of a forest you find an abbandoned little church.");
				System.out.println("You decide to enter and investigate. As soon as you enter the door closes rapidly.");
				System.out.println("You immediately notice blood on the ground and the corpses of what seems people, the corpses start to move..");
				System.out.println("they get up and try to catch you, in a swift movement you manage to kick a corpse out of your way and open the door.");
				System.out.println("During the process you get wound by a zombie and you lose 30 HP. New HP level: "+Character.getHP()+".");
				System.out.println("You run away in the forest. You are frightened and disturbed by what you just experienced.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 80) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(10);
				Character.reduceHP(30);
				
				System.out.println("\nYou get bit by a rat while trepassing an abbandoned cemetery in the top of an hill.");
				System.out.println("The bit hurts, you think that it is infected. You heal the wound as much as you can.");
				System.out.println("You lose 30 HP in the process. New HP level: "+Character.getHP()+".");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(10);
				Character.reduceSanity(10);
				
				System.out.println("\nDuring your voyage you trepass a graveyard. It took just one minute, but you feel like you lost something inside.");
				System.out.println("You continue on your trip but you feel that something bad is going to happen.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			}
	}
	
	public static void countryside() {
		
		double temp = Math.random()*100;
		
			if (temp < 20) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
								
				System.out.println("\nThis part of the world seems more inhabitated by humans. Wheat fields extend for kilometers.\n");
				System.out.println("Even if the environment seems friendly you can't find water or food, and you have to sleep under a tree.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 40) {
				
				Character.incrementFood(20);
				Character.incrementWater(20);
				Character.incrementStamina(20);
				Character.incrementSanity(20);
				
				System.out.println("\nWhile you travel through a country road you encounter a farmer that offers you shelter for the night.");
				System.out.println("You accept the invite and you stay for dinner. You eat and sleep, thank the farmers for their help and depart during the next morning.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 60) {
				
				Character.reduceFood(10);
				Character.reduceWater(10);
				Character.reduceStamina(20);
				Character.reduceSanity(20);
				Character.reduceHP(10);
				
				System.out.println("\nWhile travelling near a wheat field you are attacked by living scarecrows!");
				System.out.println("You take a log from the ground and start swinging it. You manage to take down two scarecrows before escaping to safety");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				System.out.println("You HP dropped by 10. New HP: "+Character.getHP()+".");
				
			} else if (temp < 80) {
				
				Character.reduceFood(10);
				Character.incrementWater(10);
				Character.reduceStamina(10);
				Character.incrementSanity(10);
				
				System.out.println("\nYou encounter a man that asks you where you come from since he never saw around.");
				System.out.println("You explain that you simply woke up here and you're trying to get home but he says he can't help you.");
				System.out.println("He points at nord and says that you better keep walking if you want to get out of there.");
				System.out.println("You get some water but you're hungry and tired. You want to get home.");
				System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
				
			} else if (temp < 100){
				
				System.out.println("\nYou find a farmer's house in the middle of nowhere. You can choose, what you want to do?");
				System.out.println("1. Knock the door and ask for help.");
				System.out.println("2. Go away and keep walking.");
				
				boolean corr = true;
				while (corr) {
				
					Scanner temp2 = new Scanner(System.in);
					String b = temp2.next().toLowerCase();
					
				if (b.equals("1")){
				
					corr = false;
					Character.incrementFood(20);
					Character.incrementWater(10);
					Character.reduceSanity(30);
					Character.reduceStamina(10);
										
					System.out.println("\nYou get to the door and knock it. A farmer greets you and asks you if you want something to eat.");
					System.out.println("You accept and enter the house. You eat a lot of food but after an hour you are attack by the farmer and his wife.");
					System.out.println("You avoid their slow attacks and kill them with a knife you found in the nearby kitchen.");
					System.out.println("By inspecting the house you discover pieces of corpses everywhere, that couple did eat people! You hope that what you ate earlier wasn't the same, and you barely contain yourself from throwing up.");
					System.out.println("You get away as soon as possible and continue on your voyage.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
				} else if (b.equals("2")){
					
					corr = false;
					Character.reduceStamina(10);
					Character.reduceFood(10);
					Character.reduceWater(10);
										
					System.out.println("\nYou realize that avoiding the farm was the best thing to do and start walking again.");
					System.out.println("You continue on your path without problems.");
					System.out.println("New Stamina: "+Character.getStamina()+"\nNew Sanity level: "+Character.getSanity()+"\nNew Water and food level: "+Character.getWater()+", "+Character.getFood()+".");
					
					
				} else {
					
					System.out.println("\nPlease answer with the option '1' or '2'.");
					
				}
				}
			}
	}
	
}