package sg.edu.nus.CA.Repository;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.CA.Model.Course;
import sg.edu.nus.CA.Model.Student;




@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	public ArrayList<Course> findByCourseName(String courseName);
	
//	@Transactional
//	@Query("SELECT s FROM Course c JOIN c.student s WHERE c.courseName = :courseName ")
//	public ArrayList<Student> findStudentByCourseName(String courseName);
	
	@Transactional
	@Query("SELECT s FROM StudentCourse sc JOIN sc.student s WHERE sc.courseName = :courseName ")
	public ArrayList<Student> findStudentByCourseName(String courseName);
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Course c SET c.courseid = :cid,c.courseName = :courseName,c.startDate = :startDate,c.endDate=:endDate WHERE c.courseid = :cid")
	void updateDetails(@Param("cid") int courseid, @Param("courseName") String courseName, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);


}
