import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.EnumMap;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Furkan Demirci", BigDecimal.valueOf(1500),45, LocalDate.of(2006,1,1));
        System.out.println(employee);
        System.out.println("Vergi: " + employee.tax());
        System.out.println("Bonus: " + employee.bonus());
        System.out.println("Maaş artış miktarı: " + employee.raiseSalary());
        System.out.println("Toplam maaş: " + employee.getSalary());

        System.out.println();

        Employee employee2 = new Employee("Sefa Demirci", BigDecimal.valueOf(950),50, LocalDate.of(2013,1,1));
        System.out.println(employee2);
        System.out.println("Vergi: " + employee2.tax());
        System.out.println("Bonus: " + employee2.bonus());
        System.out.println("Maaş artış miktarı: " + employee2.raiseSalary());
        System.out.println("Toplam maaş: " + employee2.getSalary());


    }
}
