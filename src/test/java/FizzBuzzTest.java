import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FizzBuzzTest {


    FizzBuzz fizzBuzz;


    @DataProvider(name = "fizzBuzzTestInputs")
    public Object[][] getData() {
        return new Object[][]{
                {"1", "1"},
                {"2", "2"},
                {"3", "fizz"},
                {"4", "4"},
                {"5", "buzz"},
                {"6", "fizz"},
                {"7", "7"},
                {"8", "8"},
                {"9", "fizz"},
                {"10", "buzz"},
                {"11", "11"},
                {"12", "fizz"},
                {"13", "13"},
                {"14", "14"},
                {"15", "fizzbuzz"},
        };
    }

    @DataProvider(name = "fizzBuzzEdgeCaseInputs")
    public Object[][] getEdgeCaseData() {
        return new Object[][]{
                {"0", "fizzbuzz"},
                {"-1", "-1"},
                {"-3", "fizz"},
                {"-5", "buzz"},
                {"-15", "fizzbuzz"},
                {"+15", "fizzbuzz"},
                {"2147483647", "2147483647"},
                {"-2147483648", "-2147483648"},
        };
    }

    @DataProvider(name = "fizzBuzzInvalidInputs")
    public Object[][] getInvalidData() {
        return new Object[][]{
                {null},
                {""},
                {"abc"},
                {"3.14"},
                {" 3"},
                {"3 "},
        };
    }


    @BeforeClass
    public void setUp() {
        fizzBuzz = new FizzBuzz();
    }


    @Test(dataProvider = "fizzBuzzTestInputs")
    public void fizzBuzzTestWithDataProvider(String input, String output) {
        assertEquals(fizzBuzz.convert(input), output);
    }

    @Test(dataProvider = "fizzBuzzEdgeCaseInputs")
    public void fizzBuzzEdgeCaseTestWithDataProvider(String input, String output) {
        assertEquals(fizzBuzz.convert(input), output);
    }

    @Test(dataProvider = "fizzBuzzInvalidInputs", expectedExceptions = NumberFormatException.class)
    public void fizzBuzzInvalidInputsShouldThrowNumberFormatException(String input) {
        fizzBuzz.convert(input);
    }

    // dummy change to trigger CI/webhook

}
