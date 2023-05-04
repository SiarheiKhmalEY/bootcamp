package exercise3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ScanMe
public class FourthClassImpl implements MyInterface {
    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Private
    @Public
    @Override
    public Date calcDate3DaysAgo() {
        return null;
    }

    @Public
    @Override
    public LocalTime avaysAdd3Hours(LocalDate inDate) {
        return null;
    }

    @Private
    @Override
    public void someMethodWithoutReturnData() {

    }

    @Override
    public void someMethodWithoutDataButHaveVariableNumbersOfArguments(String... varArgs) {

    }
}
