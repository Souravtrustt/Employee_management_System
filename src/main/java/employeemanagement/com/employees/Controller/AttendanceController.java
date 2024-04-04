package employeemanagement.com.employees.Controller;

import employeemanagement.com.employees.Model.Attendance;
import employeemanagement.com.employees.Model.Employee;
import employeemanagement.com.employees.Service.AttendanceService;
import employeemanagement.com.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@CrossOrigin
public class AttendanceController {
    private AttendanceService attendanceService;
    private EmployeeService employeeService;
    @Autowired
    public AttendanceController(AttendanceService attendanceService,EmployeeService employeeService){
        this.attendanceService=attendanceService;
        this.employeeService = employeeService;
    }

    @GetMapping("/attendance")
    public List<Attendance> findAll(){
        return attendanceService.findAll();
    }

    @PostMapping("/addAttendance/{empId}")
    public Attendance addAttendance(@PathVariable(value="empId") int empId,@RequestBody Attendance attendance){
        Employee data = employeeService.findById(empId);
        attendance.setEmployee(data);
        return attendanceService.save(attendance);

    }
    @GetMapping("/attendance/{id}")
    public Attendance findById(@PathVariable int id){
        Attendance theAttendance=attendanceService.findById(id);
        if (theAttendance==null)
        {
            throw new RuntimeException("Attendance not found " + id);
        }
        return theAttendance;
    }
    @PutMapping("/attendance/{id}")
    public Attendance updateAttendance(@PathVariable int id, @RequestBody Attendance attendance){
        Attendance attd = attendanceService.findById(id);
        Employee emp = attd.getEmployee();
        attendance.setEmployee(emp);
        return attendanceService.update(id, attendance);
    }
    @DeleteMapping("/attendance/{id}")
    public void deleteById(@PathVariable int id){
        attendanceService.deleteById(id);
    }

    @GetMapping("/attendanceDate/{date}")
    public Attendance findByDate(@PathVariable(value="date") LocalDate date){
        Attendance att = attendanceService.findByPresentdate(date);
        return att;
    }

}
