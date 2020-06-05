package sg.edu.nus.CA.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sg.edu.nus.CA.Model.Course;

@Repository
public interface CoursePaginationRepository extends PagingAndSortingRepository<Course, Integer> {

}
