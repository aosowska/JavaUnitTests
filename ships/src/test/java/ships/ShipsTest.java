package ships;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
//import java.util.ArrayList;
//import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import junit.framework.TestSuite;
import ships.Ships;
import ships.Direction;
import ships.ShipPosition;

/**
 * Testing "Ships" game
 * *6. Map configuration -> input map 
 * 
 */
public class ShipsTest 

{
    private Ships ships;
    private int mapLength = 5; 
    private ShipPosition shipPosition;

    private int cleanMap[][]= {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
    
    private int testMap[][]= {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {1,0,1,0,1}
        };

    private int landOnly[][]= {
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1},
            {1,1,1,1,1}
        };
	@Before
    public void setUp(){
     ships = new Ships();
     shipPosition =  new ShipPosition(1,1,Direction.N); 
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void MoveByStepExceptionTest() {
		ships.MoveByStep(Direction.N, shipPosition, landOnly);
	}
	
	@Test
	public void MoveByStepForwardTest() {
	    ShipPosition result =  ships.MoveByStep(Direction.N, shipPosition, testMap);
	    assertEquals(1, result.getX());
	    assertEquals(0, result.getY());
	}
	
	
	
	@Test
	public void MoveByStepLeftTest() {
    ShipPosition result =  ships.MoveByStep(Direction.W, shipPosition, testMap);
    assertEquals(0, result.x);
    assertEquals(1,result.y);
	}
	
	@Test
	public void MoveByStepRightTest() {
	    ShipPosition result =  ships.MoveByStep(Direction.E, shipPosition, testMap);
	    assertEquals(2, result.x);
	    assertEquals(1, result.y);
	}

	
	@Test
	public void MoveByStepBackwardTest() {
	    ShipPosition result =  ships.MoveByStep(Direction.S, shipPosition, testMap);
	    assertEquals(1, result.x);
	    assertEquals(2, result.y);
	}
	
	
	@Test 
	public void SettingNorthMovesTest() {
		Direction result;
		result = ships.SettingNorthMove(Direction.W);
		assertEquals(Direction.W,result);
		
		result = ships.SettingNorthMove(Direction.E);
		assertEquals(Direction.E, result);
		
		result = ships.SettingNorthMove(Direction.N);
		assertEquals(Direction.N, result);
		
		result = ships.SettingNorthMove(Direction.S);
		assertEquals(Direction.S, result);
	}
	
	@Test 
	public void SettingSouthMovesTest() {
		Direction result;

		result = ships.SettingSouthMove(Direction.N);
		assertEquals(Direction.S, result);

		result = ships.SettingSouthMove(Direction.S);
		assertEquals(Direction.N, result);

		result = ships.SettingSouthMove(Direction.E);
		assertEquals(Direction.W, result);

		result = ships.SettingSouthMove(Direction.W);
		assertEquals(Direction.E, result);
	}
	
	@Test 
	public void SettingWestMovesTest() {
		Direction result;
		
		result = ships.SettingWestMove(Direction.N);
		assertEquals(Direction.E, result);
		
		result = ships.SettingWestMove(Direction.S);
		assertEquals(Direction.W, result);
		
		result = ships.SettingWestMove(Direction.E);
		assertEquals(Direction.S, result);
		
		result = ships.SettingWestMove(Direction.W);
		assertEquals(Direction.N, result);
		
	}
	@Test 
	public void SettingEastMovesTest() {
		Direction result;
		
		result = ships.SettingEastMove(Direction.N);
		assertEquals(Direction.W, result);
		
		result = ships.SettingEastMove(Direction.S);
		assertEquals(Direction.E, result);
		
		result = ships.SettingEastMove(Direction.E);
		assertEquals(Direction.N, result);
		
		result = ships.SettingEastMove(Direction.W);
		assertEquals(Direction.S, result);
	
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void isValidBiggerIndexTest() {
		 ships.isValid(testMap, 7,1);
	}
	
	@Test
	public void isValidTest() {
		boolean result = ships.isValid(testMap, 1, 2);
		assertEquals(true, result);
	}
	
	@Test
	public void isWaterFalseTest() {
		boolean result = ships.isWater(testMap, 4, 4);
		assertEquals(false, result);
	}
	
	@Test
	public void isWaterTrueTest() {
		boolean result = ships.isWater(testMap, 1, 0);
		assertEquals(true, result);
	}
	
    @Test
    public void createMapTest() {
       int map[][] = ships.CreateMap();  
      assertEquals(map.length, mapLength);
      for(int i = 0; i < mapLength; i ++ ) {
    	  for(int j = 0; j < mapLength; j ++ ) {
    		 assertThat(map[i][j], is(not(nullValue())));
    	  }
      }
    }
	  
    @Test
    public void fillMapTest() {
    	int insides[][]= {
                {1,1,1,0,1},
                {1,0,0,0,1},
                {1,1,0,0,1},
                {0,0,0,0,1},
                {0,0,0,0,1}
            };
    	int filledMap[][] = ships.FillMap(insides);
        for(int i = 0; i < mapLength; i ++ ) {
      	  for(int j = 0; j < mapLength; j ++ ) {
      		 assertThat(filledMap[i][j], is(insides[i][j]));
      	  }
        }
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void noWaterMapFillingTest() {
    	int filledMap[][] = ships.FillMap(landOnly);
    }
    
    @Test
    public void waterMapFillingTest() {
    	int insides[][]= {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,0,1,1}
            };
    	int filledMap[][] = ships.FillMap(insides);
    //	int counter = 0;
        for(int i = 0; i < mapLength; i ++ ) 
      	  for(int j = 0; j < mapLength; j ++ ) ;
      		//if(filledMap[i][j] == 1) counter++;
        //to refactor, isWater insides versus filledMap
       // assertEquals(counter, is(not(mapLength*mapLength)));
    }
    
    @Test
    public void clearMapTest() {
    	int cleanedMap[][] = ships.ClearMap(testMap);
    	int counter = 0;
        for(int i = 0; i < mapLength; i ++ ) 
        	  for(int j = 0; j < mapLength; j ++ ) 
        		if(cleanedMap[i][j] == 0) counter++;
        assertThat(counter, is(mapLength*mapLength));
    }
    
   
	@After
    public void tearDown(){
       ships = null;
       shipPosition = null;
}
	
}
