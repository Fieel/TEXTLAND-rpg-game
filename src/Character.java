
public class Character extends Variables {

	public static int HP = 100;  //CHARACTER STARTING VITAL HIT POINTS
	
	public static int food = 100;       //CHARACTER STARTING FOOD
	public static int water = 100;      //CHARACTER STARTING WATER
	public static int sanity = 100;     //CHARACTER MENTAL SANITY
	
	public static int stamina = 100;    //CHARACTER STARTING STAMINA
	
	public static boolean escape = false;
	
	
	public static int x;
	public static int y;
	
	Character(Map a) {  // OUR CHARACTER POSITION IN THE MAP
		y=a.mapArray.length-1;
		x=(int)(Math.random()*a.mapArray[0].length);
		if(x==a.mapArray[0].length)
		{
			x--;
		}
	}
	
	public static void moving(){
		
		System.out.println("\nI can continue walking forward, turn left or turn right. What should i do?");
		boolean a = true;
		
		while (a) {
			
			text = input.next().toLowerCase();
			
			if (text.equals("forward")) {
				a = false;
				forwardMove();
				
			} else if (text.equalsIgnoreCase("left")) {
				if (x <= 0) {
					System.out.println("You can't move left!");
					Game.mapborder = true;
					rightMove();
				} else
				a = false;
				leftMove();
				
			} else if (text.equalsIgnoreCase("right")){
				if (x >= 9) {
					System.out.println("You can't move right! Your path is blocked by a deep forest.");
					
					Game.mapborder = true;
					leftMove();
				} else
				a = false;
				rightMove();
			} else {
				System.out.println("please answer with 'forward','left' or 'right'.");
			}
		}
	}
	
		
	public static void forwardMove(){       // MOVING FORWARD
		if (y == 0){
			escape = true;
		} else
		y -= 1;
	
	}
	
	public static void leftMove(){ 		    // MOVING LEFT
		
		x -= 1;		
	}
	
	public static void rightMove(){         // MOVING RIGHT
				
		x += 1;	
	}
	
	public static boolean victorycondition(){
		return escape;
	}
	
	
	public static int getX() {
	     return Character.x;
	  }
	public static int getY() {
	     return Character.y;
	  }
	
	
	
	
	public static void reduceHP(int a) { //METHODS TO MODIFY HP
	    HP -= a; 
	  }
	public static void incrementHP(int a) {
		if (HP <=90){
			HP += a;
		}
	}
	public static int getHP(){
		return Character.HP;
	}
	public static void reduceFood(int a) {   //METHODS TO MODIFY FOOD
	    food -= a; 
	  }
	public static void incrementFood(int a) {
		if (food <=90){
			food += a;
		}
	}
	public static int getFood(){
		return Character.food;
	}
	public static void reduceWater(int a) {  //METHODS TO MODIFY WATER
	    water -= a; 
	  }
	public static void incrementWater(int a) {
		if (water <=90){
			water += a;
		}
	}
	public static int getWater(){
		return Character.water;
	}
	public static void reduceStamina(int a) { //METHODS TO MODIFY STAMINA
	    stamina -= a; 
	  }
	public static void incrementStamina(int a) {
		if (stamina <=90){
			stamina += a;
		}
	}
	public static int getStamina(){
		return Character.stamina;
	}
	public static void reduceSanity(int a) { //METHODS TO MODIFY MENTAL SANITY
	    sanity -= a; 
	  }
	public static void incrementSanity(int a) {
		if (sanity <=90){
			sanity += a;
		}
	}
	public static int getSanity(){
		return Character.sanity;
	}

	
}
