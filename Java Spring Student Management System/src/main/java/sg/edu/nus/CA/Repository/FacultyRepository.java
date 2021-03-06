package sg.edu.nus.CA.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sg.edu.nus.CA.Model.Staff;
import sg.edu.nus.CA.Model.Student;

@Repository
public interface FacultyRepository extends JpaRepository<Staff, Integer> {
	@Query("select f from Staff f where f.id= :staffId")
	public Staff findStaffByid(@Param("staffId") String userId);

	@Transactional
	@Modifying
	@Query(value = "insert into staff (id, name,password,role,department_name_id) values ( :SID,:SNAME,:SPASSWORD,:SROLE,:DNAMEiD)", nativeQuery = true)
	void insertStaff(@Param("SID") Integer SID, @Param("SNAME") String SNAME, @Param("SPASSWORD") String SPASSWORD,
			@Param("SROLE") Integer SROLE, @Param("DNAMEiD") Integer DNAMEiD);
	
	@Query("select s from Staff s where s.name= :stfName")
	public Staff findStaffByname(@Param("stfName") String stfName);

}
