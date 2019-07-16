
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.not;
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
        // 황진우
        assertThat(customCalculator.add(3, 2), not(6));
        // 이준하
        assertEquals(customCalculator.add(10,5), 15);
        // 이주형
        assertThat(customCalculator.add(3,6),equalTo(9));
    }

    //빼기 테스트 작성
    @Test
    public void subtract7by2Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(7,2);
        assertThat(result, is(5));
        System.out.println("result = "+result);
        // 황진우
        assertThat(customCalculator.subtract(7, 2), not(6));
        // 이준하
        assertEquals(customCalculator.subtract(10,5), 5);
        // 이주형
        assertThat(customCalculator.subtract(10,4),equalTo(6) );
    }

    //곱하기 테스트 작성
    @Test
    public void multiply1with5Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(1,5);
        assertThat(result, is(5));
        System.out.println("result = "+result);
        // 황진우
        assertThat(customCalculator.multiply(1, 5), notNullValue());
        // 이준하
        assertEquals(customCalculator.multiply(10,5), 50);
        // 이주형
        assertThat(customCalculator.multiply(5,6),not(20));
    }

    //나누기 테스트 작성
    @Test
    public void divide10by2Test() {
        //김민석MTG
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(10,2);
        assertThat(result, is(5));
        System.out.println("result = "+result);
        // 황진우
        assertThat(customCalculator.divide(10, 2), not(6));
        // 이준하
        assertEquals(customCalculator.divide(10,5), 2);
        // 이주형
        assertThat(customCalculator.divide(4,2),is(2));
    }
}