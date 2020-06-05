package sg.edu.nus.CA.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

//Repository for pagination

import org.springframework.stereotype.Repository;

import sg.edu.nus.CA.Model.Student;


@Repository
public interface StudentPaginationRepository extends PagingAndSortingRepository<Student, Integer> {

}
