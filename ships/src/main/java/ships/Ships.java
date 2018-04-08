package ships;

/**
 *1. Establish start point - direction and co-ordinates (x,y)
 *2. Movements - 'n'forward  and 'w' backward
 *3. Movements - 'l' left and 'r' right
 *4. Taking querys of requests (like r,l,p,w)
 *5. Land detection - if the next destination point is land - exception occurs. 
 *6. Map configuration -> input map 
 *
 */
public class Ships 
{    
	private int mapLength = 5;
	private ShipPosition shipPosition;
	private  int map[][]= {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
//region Validation
	public boolean isValid(int[][] map, int parX, int parY) {
		if(parX < 5 && parY < 5) return true;
	throw new ArrayIndexOutOfBoundsException("This coordinates are out of map");
	}
	
	public boolean isWater(int[][] parMap, int parX, int parY) {
		if(parMap[parX][parY] == 0) return true;
		else return false;
	}
	
	public ShipPosition EstablishStartPoint(int x, int y, Direction direction) {
		shipPosition = new ShipPosition(x,y,direction);
		return shipPosition;
	}
//endregion Validation
	
	public void Move(ShipPosition shipPosition, Direction direction, int[][] map) {
		Direction baseDirection = shipPosition.direction;
		Direction whereToGo;
		
		switch(baseDirection) {
		case N:
			whereToGo = SettingNorthMove(direction);
			break;
		case S:
			whereToGo = SettingSouthMove(direction);
			break;
		case E:
			whereToGo = SettingEastMove(direction);
			break;
		case W:
			whereToGo = SettingWestMove(direction);
			break;
			default:
				throw new IllegalArgumentException();				
		}
		MoveByStep(whereToGo, shipPosition, map);
	}
	

	public ShipPosition MoveByStep(Direction direction, ShipPosition shipPosition, int parMap[][]) {
		int parX = shipPosition.x;
		int parY = shipPosition.y;

		switch(direction) {
		case N:
			parY = parY - 1;	
			break;
		case S:
			parY = parY + 1;
			break;
		case E:
			parX = parX + 1;
			break;
		case W:
			parX = parX - 1;	
			break;
		}
		if(isWater(parMap, parX, parY) && isValid(parMap, parX, parY)) {
     		shipPosition.setX(parX);
			shipPosition.setY(parY);
		}
		else {
			throw new ArrayIndexOutOfBoundsException("You can only move by water!");
		}
		return shipPosition;
	}
	
//region Settings moves direction
// Depends on ship base direction
	 public Direction SettingSouthMove(Direction direction) {
		 switch (direction) {
			case N:			
				return Direction.S;
			case S:
				return Direction.N;
			case E:
				return Direction.W;
			case W:
				return Direction.E;
		 }
		 throw new ArrayIndexOutOfBoundsException("Out of range direction parameter.");
	 }
	 
	 public Direction SettingEastMove(Direction direction) {
		 switch (direction) {
			case N:
				return Direction.W;
			case S:
				return Direction.E;
			case E:
				return Direction.N;
			case W:
				return Direction.S;
		 }
		 throw new ArrayIndexOutOfBoundsException("Out of range direction parameter.");
	 }
	 
	 public Direction SettingWestMove(Direction direction) {
		 switch (direction) {
			case N:
				return Direction.E;
			case S:
				return Direction.W;
			case E:
				return Direction.S;
			case W:
				return Direction.N;
		 }
		 throw new ArrayIndexOutOfBoundsException("Out of range direction parameter.");
	 }
	
	 public Direction SettingNorthMove(Direction direction) {
		 return direction;
	 }
//end region
	 
//Map methods region
    public int[][] CreateMap() {   	
    	return map;
    }
    
    public int[][] FillMap(int insides[][]){
    	int counter= 0; 
        for(int i = 0; i < mapLength; i++) {
      	  for(int j = 0; j < mapLength; j++) {
      		 if (insides[i][j] == 1) {
      			 map[i][j] = 1;
      			 counter ++;
      		 }
      	  }
      	  if (counter == mapLength*mapLength) throw new IllegalArgumentException();      		 
        }
    	return map;
    }
    
    public int[][] ClearMap(int mapForClearing[][]){
    	for(int i = 0; i < mapLength; i++) 
      	  for(int j = 0; j < mapLength; j++)
      		  if (mapForClearing[i][j] == 1) mapForClearing[i][j] = 0; 
    	return mapForClearing;
    }
 //End region
}
