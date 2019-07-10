
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add3and2Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(3,2);
        assertThat(result, is(5));
        System.out.println("result = "+result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract7by2Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(7,2);
        assertThat(result, is(5));
        System.out.println("result = "+result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply1with5Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(1,5);
        assertThat(result, is(5));
        System.out.println("result = "+result);
    }

    //나누기 테스트 작성
    @Test
    public void divide10by2Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(10,2);
        assertThat(result, is(5));
        System.out.println("result = "+result);
    }
}