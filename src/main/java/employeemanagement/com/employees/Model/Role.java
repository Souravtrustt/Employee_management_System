package employeemanagement.com.employees.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Employee> employee;

    public  Role()
    {

    }

    public Role(int dept_id, int emp_id, String role_name) {
        this.name = role_name;
    }

    public int getRole_id() {
        return id;
    }

    public void setRole_id(int role_id) {
        this.id = role_id;
    }


    public String getRole_name() {
        return name;
    }

    public void setRole_name(String role_name) {
        this.name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + id +
                ", role_name='" + name + '\'' +
                '}';
    }
}
