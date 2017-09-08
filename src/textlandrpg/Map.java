public class Map {

	public String[][] mapArray; //ARRAY THAT CONTAINS THE MAP&CHARACTER
	public static String[][] movementMapArray; //ARRAY THAT CONTAINS ONLY MAP NUMBERS
	public static int y; 
	public static int x;

	public Map (int x, int y){               //MAP CONSTRUCTOR

		mapArray = new String[x][y];
		movementMapArray = new String[x][y];

		for (int i = 0; i < x; i++) {	
			for (int j = 0; j < y; j++) {
				mapArray[i][j] = Integer.toString((int)(Math.random()*9)); 
			}
		}
		for (int i=0;i<x; i++){
			for (int j=0; j<y; j++){
				movementMapArray[i][j] = mapArray[i][j];
			}
		}//creating a copy of mapArray to use in the Environment 
	}
	
	 static void environment() { // METHOD THAT SELECTS THE RIGHT ENVIRONMENT CONSIDERING THE CURRENT
								 // POSITION ON THE MAP
		y = Character.getY();
		x = Character.getX();
		
		
			int temp = Integer.parseInt(movementMapArray[y][x]);
			switch (temp){
				case 0: Game.village();
					break;
				case 1: Game.forest();
					break;
				case 2: Game.river();
					break;
				case 3: Game.cave();
					break;
				case 4: Game.castle();
					break;
				case 5: Game.plains();
					break;
				case 6: Game.mountain();
					break;
				case 7: Game.swamp();
					break;
				case 8: Game.crypta();
					break;
				case 9: Game.countryside();
					break;
				default:
					System.out.println("BUG 001!");
					break;
			}
		
	}

	public void printmap() {                 //OBJECT THAT PRINTS THE MAP
		for (int i = 0; i < mapArray.length; i++){
			
			System.out.print("|");
			
			for (int j = 0; j < mapArray[i].length; j++){
				System.out.print(mapArray[i][j]);
				System.out.print("  ");
			}
			
			System.out.println("|\n");
		}
	}
	

}
