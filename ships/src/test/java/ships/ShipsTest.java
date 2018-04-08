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

	@Before
    public void setUp(){
     ships = new Ships();
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
