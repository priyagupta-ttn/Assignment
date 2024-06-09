package com.ttn.demo.core.service.impl;

import com.ttn.demo.core.beans.Student;
import com.ttn.demo.core.service.ClassConfigurationService;
import com.ttn.demo.core.service.StudentClassService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component( service = StudentClassServiceImpl.class, immediate = true)
public class StudentClassServiceImpl implements StudentClassService {

    @Reference
    ClassConfigurationService classConfigurationService;

    List<Student> studentList = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    @Reference
    private ClassConfigurationService classConfigService;

    @Override
    public boolean addStudent(Student student) {
        if (!classConfigService.isClassLimitReached(students)) {
            students.add(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public boolean isStudentPassed(String id) {
        Optional<Student> studentOpt = students.stream().filter(student -> student.getId().equals(id)).findFirst();
        return studentOpt.map(student -> student.getMarks() >= classConfigService.getPassingMarks()).orElse(false);
    }

    @Override
    public Student getStudent(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
