package sg.edu.nus.CA.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sg.edu.nus.CA.Model.Leavedetails;;


@Repository
public interface LeaveRepository extends JpaRepository<Leavedetails, Integer>{
	//public ArrayList<Leavedetails> findByLeaveName(String leavedetails);
	@Transactional
	@Modifying
	@Query("UPDATE Leavedetails l SET l.status = :status WHERE l.leaveId= :leaveId")
	void updateLeaveStatuse(@Param("status") String status, @Param("leaveId") Integer  leaveId);
	
}