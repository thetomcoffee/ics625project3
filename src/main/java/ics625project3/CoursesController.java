/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics625project3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tomco
 */
@Controller
public class CoursesController {
    @RequestMapping("/courses")
    public String courses(Model model){
        model.addAttribute("data", new Course());
        return "index";
    }
   
    @PostMapping("/add")
    public String tip(@ModelAttribute Course data, Model model) {
        model.addAttribute("data", data);
        return "add-form";  
    }
}
