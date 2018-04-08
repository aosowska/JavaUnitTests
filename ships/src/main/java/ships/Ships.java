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
//	private int[][] presentPosition;
	private ShipPosition shipPosition;
	private  int map[][]= {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
	
	public ShipPosition EstablishStartPoint(int x, int y, Direction direction) {
		shipPosition = new ShipPosition(x,y,direction);
		return shipPosition;
	}
	
	public void Move(ShipPosition shipPosition, Direction direction, int[][] map) {
		int x = shipPosition.x;
		int y = shipPosition.x;
		Direction baseDirection = shipPosition.direction;


		switch(direction) {
		case N:
			break;
		case S:
			break;
		case E:
			break;
		case W:
			break;
		default:
			break;
		}		
	}
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
		 return null;//exception added 
	 }
	 
	 public Direction SettingEastMove(Direction direction) {
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
		 return null;//exception added 
	 }
	
	 public Direction SettingNorthMove(Direction direction) {
		 return direction;
	 }
	
	public void MoveLeft() {
		
	}
	public void MoveRight() {
		
	}
	public void MoveForward() {
		
	}
	public void MoveBackward() {
		
	}
	
	public int CheckNextPosition(ShipPosition shipPosition, int[][] map, Direction direction) {
		 int x = shipPosition.x;
		 int y = shipPosition.y;
		 map[x][y] = 0 
		 
		
		return 0;
	}
	
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
    
}
