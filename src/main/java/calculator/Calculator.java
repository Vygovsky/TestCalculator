package calculator;

public class Calculator {

    public enum Command {
        SUM,
        DIV,
        MIN,
        MULTI
    }

    public int calculate(Command command, int arg1, int arg2) {
        int resAbs = Math.abs(arg1);
        int resAbs2 = Math.abs(arg2);
        switch (command) {
            case SUM:
                return sum(resAbs, resAbs2);
            case MIN:
                return min(resAbs, resAbs2);
            case DIV:
                return div(resAbs, resAbs2);
            default:
                throw new UnsupportedOperationException("Unknown operation!");
        }
    }


    public int sum(int numb, int numb1) {
        return numb + numb1;
    }

    public int min(int num1, int num2) {
        return num1 - num2;
    }

    public int div(int div, int div2) {
        if (div2 == 0)
            throw new IllegalArgumentException("Div2 can not be zero!");
        else
            return div / div2;
    }
}
