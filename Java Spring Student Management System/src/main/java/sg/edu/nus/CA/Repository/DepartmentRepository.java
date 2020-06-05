package sg.edu.nus.CA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.CA.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	//public ArrayList<Department> findByDeptName(String department);

}


