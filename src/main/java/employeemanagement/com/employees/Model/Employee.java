package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int  id;

    @Column(name="name")
    private String name;

    @Column(nullable = false)
    private long phn_number;

    @Column(name="gender")
    private String gender;
    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="account_number")
    private long account_number;

    @OneToMany(mappedBy = "employee")
    private List<Attendance> attendance;

    @OneToMany(mappedBy = "employee",cascade = {CascadeType.ALL})
    private List<Leave_details>leaveDetails;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="dept_id")
    private Department department;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="role")
    private Role role;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    private Payroll payroll;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee()
    {

    }
    public Employee(String emp_name, long phn_number, String gender, String email, String address, long account_number) {
        this.name = emp_name;
        this.phn_number = phn_number;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.account_number = account_number;
    }

    public int getEmp_id() {
        return id;
    }

    public void setEmp_id(int emp_id) {
        this.id = emp_id;
    }

    public String getEmp_name() {
        return name;
    }

    public void setEmp_name(String emp_name) {
        this.name = emp_name;
    }

    public long getPhn_number() {
        return phn_number;
    }

    public void setPhn_number(long phn_number) {
        this.phn_number = phn_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + id +
                ", emp_name='" + name + '\'' +
                ", phn_number=" + phn_number +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", account_number=" + account_number +
                '}';
    }

//    adding convenience method for bi-directional mapping
//    public  void add(Attendance tempAttendance){
//        if(attendance == null){
//            attendance = new ArrayList<>();
//        }
//        attendance.add(tempAttendance);
//        tempAttendance.setEmployee(this);
//    }
}
