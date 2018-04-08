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
    private int cleanMap[][]= {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
    
    private int testMap[][]= {
            {1,0,0,0,0},
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {1,0,0,0,0}
        };

	@Before
    public void setUp(){
     ships = new Ships();
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void isValidBiggerIndexTest() {
		 ships.isValid(testMap, 7,1);
	}
	
	@Test
	public void isValidTest() {
		boolean result = ships.isValid(testMap, 1, 2);
		assertEquals(result, true);
	}
	
	@Test
	public void isWaterFalseTest() {
		boolean result = ships.isWater(testMap, 0, 0);
		assertEquals(result, false);
	}
	
	@Test
	public void isWaterTrueTest() {
		boolean result = ships.isWater(testMap, 1, 0);
		assertEquals(result, true);
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
    	int insides[][]= {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1}
            };
    	int filledMap[][] = ships.FillMap(insides);
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
    	int counter = 0;
        for(int i = 0; i < mapLength; i ++ ) 
      	  for(int j = 0; j < mapLength; j ++ ) 
      		if(filledMap[i][j] == 1) counter++;
        assertEquals(counter, is(not(mapLength*mapLength)));
    }
    
    @Test
    public void clearMapTest() {
    	int map[][]= {
                {1,1,1,0,1},
                {1,0,0,0,1},
                {1,1,0,0,1},
                {0,0,0,0,1},
                {0,0,0,0,1}
            };	
    	int cleanedMap[][] = ships.ClearMap(map);
    	int counter = 0;
        for(int i = 0; i < mapLength; i ++ ) 
        	  for(int j = 0; j < mapLength; j ++ ) 
        		if(cleanedMap[i][j] == 0) counter++;
        assertThat(counter, is(mapLength*mapLength));
    }
    
   
	@After
    public void tearDown(){
       ships = null;
}
	
}
