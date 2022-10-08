import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String name;
    private BigDecimal salary;
    private Integer workHour;
    private LocalDate hireYear;


    public Employee(String name, BigDecimal salary, Integer workHour, LocalDate hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHour;
        this.hireYear = hireYear;
    }

    public BigDecimal tax() {
        final Long taxableIncomeConstant = 1000L;
        if (this.salary == null) {
            return BigDecimal.valueOf(0L);
        } else if (this.salary.compareTo(BigDecimal.valueOf(taxableIncomeConstant)) <= 0) {
            return BigDecimal.valueOf(0L);
        } else {
            return this.salary.multiply(BigDecimal.valueOf(3L)).divide(BigDecimal.valueOf(100L));
        }
    }

    public BigDecimal bonus() {
        if (this.workHour < 40) {
            return BigDecimal.valueOf(0L);
        }
        Integer extraHour = workHour - 40;
        return BigDecimal.valueOf(30L * extraHour);
    }

    public BigDecimal raiseSalary() {
        LocalDate now = LocalDate.of(2021, 1, 1);

        BigDecimal taxValue = tax();
        BigDecimal bonusValue = bonus();
        this.salary = this.salary.subtract(taxValue).add(bonusValue);

        Integer workingYear = this.hireYear.getYear() - now.getYear();
        BigDecimal riseAmount;
        if (workingYear < 10) {
            riseAmount= this.salary.multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(100));
            this.salary = this.salary.add(riseAmount);
        } else if (workingYear < 20) {
            riseAmount = this.salary.multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100));
            this.salary = this.salary.add(riseAmount);
        } else {
            riseAmount = this.salary.multiply(BigDecimal.valueOf(15)).divide(BigDecimal.valueOf(100));
            this.salary = this.salary.add(riseAmount);
        }
        return riseAmount;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", workHour=" + workHour +
                ", hireYear=" + hireYear +
                '}';
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
