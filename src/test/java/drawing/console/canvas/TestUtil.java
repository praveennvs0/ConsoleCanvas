package drawing.console.canvas;

import junit.framework.Assert;

public class TestUtil {

    public static void validateCharArrays(char[][] actualCharArray, char[][] expectedCharArray) {
        Assert.assertEquals ("canvas not created properly",actualCharArray.length, expectedCharArray.length);
        for(int i=0; i< actualCharArray.length ; i++) {
            int interiorLength = actualCharArray[i].length ;
            for(int j=0; j < interiorLength ; j++) {
                Assert.assertEquals("character mismatching at " +  i + "," + j , actualCharArray[i][j],expectedCharArray[i][j]);
            }
         }
       
        
    }
}
