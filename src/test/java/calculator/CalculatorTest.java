package calculator;
import org.testng.annotations.*;
import org.testng.Assert;
import com.hillel.hw1_22.Calculator;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass
    public void tearDown() {
        calculator = null;
    }

    @Test(priority = 1, description = "Test addition")
    public void testAddition() {
        int result = calculator.add(5, 3);
        System.out.println("Addition result: " + result);
        Assert.assertEquals(result, 8);
    }

    @Test(priority = 2, description = "Test subtraction")
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        System.out.println("Subtraction result: " + result);
        Assert.assertEquals(result, 6);
    }

    @Test(priority = 3, description = "Test multiplication")
    public void testMultiplication() {
        int result = calculator.multiply(6, 7);
        System.out.println("Multiplication result: " + result);
        Assert.assertEquals(result, 42);
    }

    @Test(priority = 4, description = "Test division")
    public void testDivision() {
        int result = calculator.divide(20, 5);
        System.out.println("Division result: " + result);
        Assert.assertEquals(result, 4);
    }

    @Test(priority = 5, description = "Test division by zero", expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
}
