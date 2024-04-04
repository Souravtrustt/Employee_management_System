package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
    @Query("select u from Payroll u where empId = ?1")
    Payroll findByEmpId(int id);
}
