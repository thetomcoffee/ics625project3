/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics625project3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tom Coffee
 */
@Controller
public class CoursesController {
    @Autowired
    private CourseService service;
    
    @GetMapping("/courses")
    public String all(Model model){
        model.addAttribute("courses", service.getAll());
        return "index";
    }
   
    @GetMapping("/add")
    public String addForm(@ModelAttribute Course data, Model model) {
        model.addAttribute("data", data);
        return "add-form";  
    }
    
    @PostMapping("/courses/add")
    public String addPost(@ModelAttribute Course data, Model model) {
        service.add(data.getNumber(), 
                data.getSubject(), 
                data.getTitle(), 
                data.getCredits(), 
                data.getOffered(), 
                data.getDescription());
        return "redirect:/courses";
    }
}
