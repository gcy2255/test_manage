package Mapper;

import entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("insert into student(student_id, student_name) values(#{studentId}, #{studentName})")
    int insert(Student student);

    @Select("select * from student")
    List<Student> queryAll();

    @Select("select * from student where student_id=#{studentId}")
    Student queryById(int studentId);

    @Delete("delete from student where student_id=#{studentId}")
    int deleteById(int studentId);
}
