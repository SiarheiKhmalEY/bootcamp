package exercise3;

import exercise3.MyInterface;
import exercise3.Private;
import exercise3.Public;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ThirdClassImpl implements MyInterface {

    @Private
    @Override
    public String getId() {
        return "";
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Private
    @Public
    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Public
    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}
