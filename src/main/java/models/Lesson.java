package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson {

    private int id;
    private String title;
    private int classNo;
    private Course course;
    private Set<Student> students;

    public Lesson() {
    }

    public Lesson(String title, int classNo, Course course) {
        this.title = title;
        this.classNo = classNo;
        this.course = course;
        this.students = new HashSet<Student>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "class_no")
    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_lesson",
            inverseJoinColumns = {@JoinColumn(name = "student_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name = "lesson_id", nullable = false, updatable = false)})
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);

    }
}
