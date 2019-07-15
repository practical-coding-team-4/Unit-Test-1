import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        Champion topChamp = new Champion("다리우스", "탑");
        Champion jungleChamp = new Champion("리신", "정글");
        Champion midChamp = new Champion("르블랑", "미드");
        Champion adcChamp = new Champion("베인", "바텀");
        Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        championList.add(topChamp);
        championList.add(jungleChamp);
        championList.add(midChamp);
        championList.add(adcChamp);
        championList.add(supportChamp);
    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionEmptyCheck() {
        //김민석MTG
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
        // 황진우
        List<String> emptyListTwo = null;
        assertThat(emptyList, empty());
        // 이준하
        List<String> emptyListThree = new ArrayList<>();
        assertThat(emptyListThree, empty());

    }

    //notNullValue 활용한 테스트
    @Test
    public void checkStringIsNotNull() {
        //김민석MTG
        String lck = "LCK";
        assertThat(lck, notNullValue());
        // 황진우
        String emptyStr = "";
        assertThat(emptyStr, notNullValue());
        // 이준하
        String lcs ="LCS";
        assertThat(lcs, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void checkStringIsNull() {
        //김민석MTG
        String lck = null;
        assertThat(lck, nullValue());
        // 황진우
        String emptyStr = "";
        assertThat(emptyStr, not(nullValue()));
        // 이준하
        String NullString = null;
        assertThat(NullString, nullValue());
    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString_StartStringSame_But_EndStringDifferent() {
        //김민석MTG
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String startString = "Player";
        String endString = "point";
        assertThat(sampleString1, is(startsWith("Player")));
        assertThat(sampleString2, is(startsWith("Player")));
        assertThat(sampleString1, is(endsWith("Focus")));
        assertThat(sampleString2, is(endsWith("point")));
        assertThat(endString, anyOf(startsWith(endString), containsString(endString)));//둘 중 하나만 맞아도 넘어감 anyof
        assertThat(startString, allOf(startsWith(startString), endsWith(startString)));
        // 황진우
        assertThat(sampleString1, startsWith(startString));
        assertThat(sampleString2, endsWith(endString));
        // 이준하
        assertThat(sampleString1, hasToString("Player Focus"));
        assertThat(sampleString2, hasToString("Player point"));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void floatingPointTest_WhenDivide10by3() {
        //김민석MTG
        assertThat((double)10/3, closeTo(3, 0.5));
        // 황진우
        assertThat(Math.PI, closeTo(3.14, 0.01));
        // 이준하
        assertThat(5.5, closeTo(5,0.6));
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReferenceWhenGet4thChampion() {
        //김민석MTG
        assertThat(championList.get(4), anything());    //anything(아무거나), 값만 가져 올 수 있으면 어떤값이던 괜찮
        // 황진우
        assertThat(null, anything());
        // 이준하
        assertThat(150, anything());
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionListSizeFive() {
        //김민석MTG
        assertTrue(championList.size() == 5);
        assertThat(championList.size(), is(5));
        assertThat(championList, hasSize(5));   //hasSize : 배열자체를 넘겨 주면 사이즈를 알아서 계산(굳이 사이즈 계산을 할 필요 없음)
        // 황진우
        championList.add(new Champion("Test", "Test"));
        assertThat(championList, hasSize(6));
        championList.remove(5);
        // 이준하
        assertFalse(championList.size() == 4);


    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionMustTaric() {
        //김민석MTG
        Champion supportChamp = new Champion("타릭", "바텀");
        assertThat("타릭", is(supportChamp.getName()));
        assertThat("타릭", is(equalTo(supportChamp.getName())));//equalTo는 이런게 있다 정도만..? is랑 거이 같음
        assertThat("타릭", equalTo(supportChamp.getName()));
        // 황진우
        assertThat("바텀", is(supportChamp.getPosition()));
        // 이준하
        assertFalse(supportChamp.getPosition()=="탑");
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasProperty_PositionAndName() {
        //김민석MTG
        assertThat(championList.get(0), hasProperty("position"));
        assertThat(championList.get(0), hasProperty("name"));
        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
        // 황진우
        assertThat(championList.get(0), not(hasProperty("rank")));
        // 이준하
        assertThat(hasProperty("name"), not(equalTo("키아나")));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveMyLoveChampJoy() {
        //김민석MTG
        List<String> iLikeChampNames = Arrays.asList("조이", "티모", "아이번", "징크스", "카밀");
        assertThat(iLikeChampNames.get(0), hasToString("조이"));
        assertThat(iLikeChampNames.get(0), containsString("조"));
        // 황진우
        assertThat(iLikeChampNames.get(1), containsString("티"));
        // 이준하
        assertThat(iLikeChampNames.get(3), containsString(("징")));
    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSameProperty_ButDoesntNeedValue() {
        //김민석MTG
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
        //samePropertyValuesAs : property의 요소가 같느냐?(객체(class)의 구성 요소가 같느냐?)
        // 황진우
        assertThat(championNames1.get(0), not(samePropertyValuesAs("Test")));
        // 이준하
        assertThat(championNames2.get(2), samePropertyValuesAs(championNames1.get(2)));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldJungleChampionIsLeesin() {
        //김민석MTG
        Optional<Champion> filterdChampion = championList.stream()//Optional은 null을 방지하기 위함
                .filter(c -> c.getPosition().equals("정글"))
                .findAny();
        // System.out.println("result :: "+filterdChampion);
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("리신"));
        assertThat("리신", is(champName));
        // 황진우
        assertThat(filterdChampion.get(), is(new Champion("리신", "정글")));
        // 이준하
        assertFalse(filterdChampion.get().getName()=="아무무");
    }
}