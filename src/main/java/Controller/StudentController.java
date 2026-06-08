package Controller;

import Service.StudentService;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Map<String, Object> result(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    // 查询所有学生
    @GetMapping("/list")
    public Map<String, Object> list() {
        List<Student> list = studentService.getAllStudents();
        return result(200, "查询成功", list);
    }

    // 根据id查询学生
    @GetMapping("/{studentId}")
    public Map<String, Object> getById(@PathVariable int studentId) {
        Student s = studentService.getStudent(studentId);
        if (s == null) {
            return result(404, "学生不存在", null);
        }
        return result(200, "查询成功", s);
    }

    // 添加学生
    @PostMapping
    public Map<String, Object> add(@RequestBody Student student) {
        try {
            if (student.getStudentId() <= 0) {
                return result(500, "学号必须大于0", null);
            }
            if (student.getStudentName() == null || student.getStudentName().trim().isEmpty()) {
                return result(500, "姓名不能为空", null);
            }
            int rows = studentService.addStudent(student);
            if (rows > 0) {
                return result(200, "添加成功", null);
            }
            return result(500, "添加失败", null);
        } catch (Exception e) {
            return result(500, "添加失败: " + e.getMessage(), null);
        }
    }

    // 删除学生
    @DeleteMapping("/{studentId}")
    public Map<String, Object> delete(@PathVariable int studentId) {
        int rows = studentService.deleteStudent(studentId);
        if (rows > 0) {
            return result(200, "删除成功", null);
        }
        return result(404, "学生不存在", null);
    }
}
