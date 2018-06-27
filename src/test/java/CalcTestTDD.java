import calculator.Calculator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static calculator.Calculator.*;
import static calculator.Calculator.Command.*;

public class CalcTestTDD {
    final int ZERO = 0;
    private Calculator calculator;

    private int number;
    private int number2;
    private int res;

    @Before
    public void startUp() {
        calculator = new Calculator();
    }

    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testSum() {
        given_number(2, 2);
        where_command_is(SUM);
        then_result_is(4);
        /*int result = calculator.sum(2, 2);
        Assert.assertThat(result, Is.is(4));*/
    }

    @Test
    public void testSum_abc() {
        given_number(5, -3);
        where_command_is(SUM);
        then_result_is(8);
      /*  int result = calculator.sum(5, -3);
        Assert.assertThat(result, Is.is(8));*/
    }


    @Test
    public void testMinus() {
        given_number(5, 3);
        where_command_is(MIN);
        then_result_is(2);
       /* int resMin = calculator.min(5, 3);
        Assert.assertThat(resMin, Is.is(2));*/
    }

    @Test
    public void test_Div() {
        given_number(16, 4);
        where_command_is(DIV);
        then_result_is(4);
        /*int resDiv = calculator.div(16, 4);
        Assert.assertThat(resDiv, Is.is(4));*/
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Div_on_zero() {
        given_number(20, ZERO);
        where_command_is(DIV);
        then_result_exception();
        /*calculator.div(20, ZERO);
        Assert.fail();*/
    }

    @Test
    public void test_Div_on_abs() {
        given_number(20, -2);
        where_command_is(DIV);
        then_result_is(10);
    /*    int resAbs = calculator.div(20, -2);
        Assert.assertThat(resAbs, Is.is(10));*/
    }
    @Test(expected = UnsupportedOperationException.class)
    public void test_Multi(){
        given_number(10,10);
        where_command_is(MULTI);
        then_result_exception();
    }

    private void given_number(int numb, int numb2) {
        this.number = numb;
        this.number2 = numb2;
    }

    private void where_command_is(Command command) {
        this.res = calculator.calculate(command, number, number2);
    }

    private void then_result_is(int expectRes) {
        Assert.assertThat(res, Is.is(expectRes));
    }

    private void then_result_exception() {
        Assert.fail();
    }
}
