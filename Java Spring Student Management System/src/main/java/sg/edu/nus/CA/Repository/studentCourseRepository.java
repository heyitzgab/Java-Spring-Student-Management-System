package sg.edu.nus.CA.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.edu.nus.CA.Model.StudentCourse;

@Repository
public interface studentCourseRepository extends JpaRepository< StudentCourse, Integer> {

	
	//public  ArrayList<StudentCourse> findAll();
	
//	@Query("select s from StudentCourse s ")
//	public ArrayList<StudentCourse>  findStudentCourseall();
	
	

}
