package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Model.Payroll;
import employeemanagement.com.employees.Service.EmployeeService;
import employeemanagement.com.employees.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//added rest controller
//added cross origin
@RestController
@CrossOrigin
public class PayrollController {
    private PayrollService thePayrollService;
    private EmployeeService theEmployeService;
    @Autowired
    public PayrollController(PayrollService thePayrollService,EmployeeService employeeService) {
        this.thePayrollService = thePayrollService;
        theEmployeService = employeeService;
    }
    @PostMapping("/addPayroll/{empId}")
    public Payroll addPayroll(@PathVariable(value="empId") int id,@RequestBody Payroll thePayroll)
    {

        Employee emp = theEmployeService.findById(id);
        thePayroll.setEmployee(emp);

        Payroll payroll=thePayrollService.save(thePayroll);
        return payroll;
    }

    //This code is used to check if emp id is present in the payroll or not. if present return that it is present.
//    @PostMapping("/addPayroll/{empId}")
//    public ResponseEntity<Map<String, Object>> addPayroll(@PathVariable(value="empId") int id, @RequestBody Payroll thePayroll)
//    {
//        Map<String, Object> result = new HashMap<>();
//        boolean isPresent = false;
//        String message = "";
//        Employee emp = theEmployeService.findById(id);
//        thePayroll.setEmployee(emp);
//
//        List<Payroll> data = thePayrollService.findAll();
//        for(int i =0; i<data.size(); i++){
//            Payroll check = data.get(i);
//            if(check.getEmployee().equals(emp))
//            {
//                isPresent = true;
//                message = "Id already exists.";
//                result.put("employee",emp);
//                break;
//            }
//        }
//        result.put("message",message);
//        result.put("status",isPresent);
//        if(isPresent == false){
//            Payroll payroll=thePayrollService.save(thePayroll);
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @GetMapping("/payroll")
    public List<Payroll> findAll()
    {
        return thePayrollService.findAll();
    }
    
    @PutMapping("/payroll/{payroll_id}")
    public Payroll updatepayroll(@PathVariable int payroll_id,@RequestBody Payroll updatePayroll)
    {
        return thePayrollService.update(payroll_id,updatePayroll);
    }
    @GetMapping("/payroll/{payroll_id}")
    public Payroll findById(@PathVariable int payroll_id)
    {
    Payroll thePayroll=thePayrollService.findById(payroll_id);
        if(thePayroll==null)
        {
            throw new RuntimeException("Payroll id not found -" + payroll_id);
        }
        return thePayroll;
    } @DeleteMapping("/payroll/{payroll_id}")
    private void deleteEmployee(@PathVariable("payroll_id") int payroll_id)
    {
       thePayrollService.deleteById(payroll_id);
    }

//    @GetMapping("/payroll/{empId}")
//    public Payroll findPayrollByEmp(@PathVariable(value="empId") int id){
//        return thePayrollService.findByEmpId(id);
//    }

}
