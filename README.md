# JavaUnitTests
Unit tests for "Ship game" simple methods

Covered test cases: 

1. EstablishStartPoint
2. MoveByStepExceptionTest
3. MoveByStepForwardTest
4. MoveByStepLeftTest
5. MoveByStepRightTest
6. MoveByStepBackwardTest
7. SettingNorthMovesTest
8. SettingSouthMovesTest
9. SettingWestMovesTest
10. SettingEastMovesTest
11. isValidBiggerIndexTest
12. isValidPassTest
13. isValidFailTest
14. isWaterFalseTest
15. isWaterTrueTest
16. createMapTest
17. fillMapTest
18. noWaterMapFillingTest
19. waterMapFillingTest
20. clearMapTest

Tests checks basic actions and walidate them like checking raising error, eg:

    	assertThrows(IllegalArgumentException.class, () -> ships.FillMap(landOnly));

At Ships.java class there are game methods, like : FillMap, Move, SettingSouthMove, MoveByStep  and walidation methods which checks
if next step can be done like isWater. 
