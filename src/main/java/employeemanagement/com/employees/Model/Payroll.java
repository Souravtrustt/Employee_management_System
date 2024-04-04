package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

@Entity
@Table(name="payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="amount")
    private long amount;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="empId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Payroll()
    {

    }

    public Payroll(long amount, int emp_id, int role_id) {
        this.amount = amount;
    }

    public int getPayroll_id() {
        return id;
    }

    public void setPayroll_id(int payroll_id) {
        this.id = payroll_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payroll_id=" + id +
                ", amount=" + amount +
                '}';
    }
}
