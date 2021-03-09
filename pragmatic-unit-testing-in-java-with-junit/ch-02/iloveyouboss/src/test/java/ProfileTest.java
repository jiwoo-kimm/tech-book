import org.junit.jupiter.api.*;

public class ProfileTest {

    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    public void create() {
        System.out.println("Before Each");
        profile = new Profile("Bull Hokey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));
        Assertions.assertFalse(profile.matches(criteria));
    }

    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));
        Assertions.assertTrue(profile.matches(criteria));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After Each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }
}
