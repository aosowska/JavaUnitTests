package ships;

public class ShipPosition {
	
		int x;
		int y;
		Direction direction;
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
		
	    public Direction getDirection() {
			return direction;
		}

		public void setDirection(Direction direction) {
			this.direction = direction;
		}

		ShipPosition(int parX, int parY, Direction parDirection){
		x = parX;
		y = parY;
		direction = parDirection;		
	}
}
