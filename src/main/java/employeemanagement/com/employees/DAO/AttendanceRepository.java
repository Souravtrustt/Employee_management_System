package employeemanagement.com.employees.DAO;

import employeemanagement.com.employees.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    @Query("select u from Attendance u where presentdate =?1")
    Attendance findByPresentDate(LocalDate presentdate);
}
