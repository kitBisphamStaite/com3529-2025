package uk.ac.shef.com3529;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uk.ac.shef.com3529.DIF.*;


public class KitDIFTest {

    @Test
    public void findLast_failure() {
        int [] arr = {0,1,1,1};
        int result = findLast(arr, 0);
        assertEquals(0, result);
    }

    @Test
    public void findLast_defectNotExecuted() {
        assertThrows(NullPointerException.class, () -> {
           findLast(null, 0);
        });
    }

    @Test
    public void posOrOdd(){
        int[] arr = {-7};
        assertEquals(1, oddOrPos(arr));
    }

}