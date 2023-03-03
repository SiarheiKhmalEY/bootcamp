import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
public interface MyInterface {
    String getId();
    Integer sum(Integer a,Integer b);
    Double divide(Double a, Double B) throws Exception;
    Date calcDate3DaysAgo();
    LocalTime avaysAdd3Hours(LocalDate inDate);
    void someMethodWithoutReturnData();
    void someMethodWithoutDataButHaveVariableNumbersOfArguments(String...varArgs);
}
