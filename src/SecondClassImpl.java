import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class SecondClassImpl implements MyInterface{
    @Private
    @Public
    @Override
    public String getId() {
        return null;
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        return null;
    }

    @Public
    @Override
    public Double divide(Double a, Double B) throws Exception {
        return null;
    }

    @Private
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
