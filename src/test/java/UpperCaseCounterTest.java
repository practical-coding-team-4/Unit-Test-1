import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void numberOfUpperCharactersInString_return_0_for_null_input(){
        //김민석MTG
        String str = null;
        int numberOfUpperCaseCharinString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result :: " + numberOfUpperCaseCharinString);
        assertTrue(numberOfUpperCaseCharinString == 0);
        // 황진우
        assertThat(numberOfUpperCaseCharinString, is(0));
        // 이준하
        assertEquals(numberOfUpperCaseCharinString, 0);
    }

    //빈값을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void numberOfUpperCharactersInString_return_0_for_empty_input() {
        //김민석MTG
        String str = "";
        int numberOfUpperCaseCharinString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result :: " + numberOfUpperCaseCharinString);
        assertTrue(numberOfUpperCaseCharinString == 0);
        // 황진우
        assertThat(numberOfUpperCaseCharinString, is(0));
        // 이준하
        assertEquals(numberOfUpperCaseCharinString, 0);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void numberOfUpperCharactersInString_return_10_for_ABCDEFGHIJ() {
        //김민석MTG
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        //assertTrue로 맞는 테스트 코드 작성
        org.junit.Assert.assertTrue(numberOfUpperCaseCharactersInString == 10);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        org.junit.Assert.assertFalse(numberOfUpperCaseCharactersInString == 9);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        org.junit.Assert.assertThat(numberOfUpperCaseCharactersInString, is(10));
        // 황진우
        assertThat(numberOfUpperCaseCharactersInString, not(9));
        // 이준하
        assertEquals(numberOfUpperCaseCharactersInString, 10);
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void numberOfUpperCharacterInString_return_6_for_ABCdefGHI(){
        //김민석MTG
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //assertTrue로 맞는 테스트 코드 작성
        assertTrue(result == 6);
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        assertFalse(result == 7);
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        assertThat(result, is(6));
        System.out.println("result :: " + result);
        // 황진우
        assertThat(result, not(7));
        // 이준하
        assertEquals(result, 6);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test(expected = IndexOutOfBoundsException.class)
    public void expectedExceptionSegmentFault()
    {
        //김민석MTG
        // new ArrayList<String>().get(3);
        // 황진우
        new ArrayList<String>().remove(3);
        // 이준하
        new ArrayList<String>().indexOf(3);
    }


    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    @Test(timeout = 5000)   //5초안에 성공 못하면 실패
    public void testShouldRunIn5sec() throws InterruptedException {
        //김민석MTG
        Thread.sleep(4000);
        System.out.println("테스트 Passed!");
        // 황진우
        Thread.sleep(500);
        System.out.println("테스트 Passed Again!");
        // 이준하
        Thread.sleep(1);
        System.out.println("Test pass.");

    }
}
