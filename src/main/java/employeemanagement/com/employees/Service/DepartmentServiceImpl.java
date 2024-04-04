package employeemanagement.com.employees.Service;

import employeemanagement.com.employees.DAO.DepartmentRepository;
import employeemanagement.com.employees.Model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository theDepartmentRepository;
    @Autowired

    public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
        this.theDepartmentRepository = theDepartmentRepository;
    }

    @Override
    public Department save(Department theDepartment) {
        return theDepartmentRepository.save(theDepartment);
    }

    @Override
    public Department findById(int id) {
        Optional<Department> result=theDepartmentRepository.findById(id);
        Department theDepartment=null;
        if(result.isPresent())
        {
            theDepartment=result.get();
        }
        else
        {
            throw new RuntimeException("Department id not found" + id);
        }
        return theDepartment;
    }

    @Override
    public List<Department> findAll() {
        return theDepartmentRepository.findAll();
    }

    @Override
    public void deleteById(int dept_id) {
        theDepartmentRepository.deleteById(dept_id);
    }

    public Department update(int dept_id, Department updateDepartment) {
        Department existingDepartment = theDepartmentRepository.findById(dept_id).orElse(null);
        if (existingDepartment != null) {
            //existingDepartment.setDept_id(updateDepartment.getDept_id());
            existingDepartment.setName(updateDepartment.getName());
            return theDepartmentRepository.save(existingDepartment);
        }
        return null; // Or throw an exception
    }

    @Override
    public Department findByDeptName(String theDept) {
        return theDepartmentRepository.findByDeptName(theDept);
    }
}
