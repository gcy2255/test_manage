package Service;

import Mapper.StudentMapper;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public int addStudent(Student student) {
        return studentMapper.insert(student);
    }

    public List<Student> getAllStudents() {
        return studentMapper.queryAll();
    }

    public Student getStudent(int studentId) {
        return studentMapper.queryById(studentId);
    }

    public int deleteStudent(int studentId) {
        return studentMapper.deleteById(studentId);
    }
}
