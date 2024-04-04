package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Payroll;

import java.util.List;

public interface PayrollService {
    Payroll save(Payroll thePayroll);
    List<Payroll> findAll();

    Payroll update(int payroll_id,Payroll updatePayroll);

    Payroll findById(int payroll_id);
    void deleteById(int payroll_id);

//    Payroll findByEmpId(int empId);
}
