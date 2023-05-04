package exercise3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ScanMe
public class FirstClassImpl implements MyInterface {
    @Private
    @Override
    public String getId() {
        return null;
    }

    @Public
    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Private
    @Public
    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}
