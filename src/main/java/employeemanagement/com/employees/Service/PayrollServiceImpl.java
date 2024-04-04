package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.PayrollRepository;
import employeemanagement.com.employees.Model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService{
    private PayrollRepository thePayrollRepository;
    @Autowired

    public PayrollServiceImpl(PayrollRepository thePayrollRepository) {
        this.thePayrollRepository = thePayrollRepository;
    }

    @Override
    public Payroll save(Payroll thePayroll) {
        return thePayrollRepository.save(thePayroll);
    }

    @Override
    public List<Payroll> findAll(){
        return thePayrollRepository.findAll();
    }

    @Override
    public Payroll update(int payroll_id, Payroll updatePayroll) {
        Payroll existingPayroll=thePayrollRepository.findById(payroll_id).orElse(null);
        if(existingPayroll!=null)
        {
            existingPayroll.setAmount(updatePayroll.getAmount());
            return thePayrollRepository.save(existingPayroll);
        }
        return null;
    }

    @Override
    public Payroll findById(int payroll_id) {
            Optional<Payroll> result=thePayrollRepository.findById(payroll_id);
           Payroll thePayroll=null;
            if(result.isPresent())
            {
                thePayroll=result.get();
            }
            else
            {
                throw new RuntimeException("payroll id not found" + payroll_id);
            }
            return thePayroll;
        }

    @Override
    public void deleteById(int payroll_id) {
        thePayrollRepository.deleteById(payroll_id);
    }

//    @Override
//    public Payroll findByEmpId(int empId) {
//
//        return thePayrollRepository.findByEmpId(empId);
//    }


}



