package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "presentdate",unique = true)
    private LocalDate presentdate;

    @Column(name = "check_in")
    private LocalTime check_in;

    @Column(name = "check_out")
    private LocalTime check_out;

    @ManyToOne()
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Attendance(){

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Attendance(LocalDate presentdate, LocalTime check_in, LocalTime check_out) {
        this.presentdate = presentdate;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPresentdate() {
        return presentdate;
    }

    public void setPresentdate(LocalDate presentdate) {
        this.presentdate = presentdate;
    }

    public LocalTime getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalTime check_in) {
        this.check_in = check_in;
    }

    public LocalTime getCheck_out() {
        return check_out;
    }

    public void setCheck_out(LocalTime check_out) {
        this.check_out = check_out;
    }


}
