package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.Model.Attendance;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

     Attendance save(Attendance theAttendance);
     Attendance findById(int id);
     List<Attendance> findAll();
     Attendance update(int id, Attendance updateAttendance);
     void deleteById(int id);
     Attendance findByPresentdate(LocalDate date);
}
