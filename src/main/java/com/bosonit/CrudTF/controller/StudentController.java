package com.bosonit.CrudTF.controller;

import com.bosonit.CrudTF.services.StudentService;
import com.bosonit.CrudTF.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/*
* Para trabajar con Thymeleaf es necesario trabajar con Model, de esta manera podemos dar un
* objeto de la clase Model a la vista.
* */

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping({"/students","/"})
    public String getStudents(Model model) {
        /*Al modelo le pasamos el nombre del atributo y el modelo
        El nombre del atributo será la variable que utilizaremos en los html
        */
        model.addAttribute("students", studentService.getAllStudents());
        //El nombre que tiene el String del retorno debe ser igual al nombre del archivo html
        return "get_students";
    }

    @GetMapping("/students/form")
    public String showFormRegister(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add_student";
    }

    @GetMapping("/students/update/{id}")
    public String showFormUpdate(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "update_student";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }
}
