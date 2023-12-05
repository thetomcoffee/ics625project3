
package ics625project3;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable long id, @ModelAttribute Course course, Model model){
        Optional<Course> c = service.get(id);
        if (c.isEmpty())
            return "No course found with id: " + id;
        else {
            course = c.get();
            model.addAttribute("course", course);
            return "update";
        }
    }
    
    @PostMapping("/courses/update/{id}")
    public String updatePost(@PathVariable long id, @ModelAttribute Course c) {
        service.update(id,
                c.getSubject(), 
                c.getNumber(), 
                c.getTitle(), 
                c.getOffered(), 
                c.getDescription(), 
                c.getCredits());
        return "redirect:/courses";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        service.remove(id);
        return "redirect:/courses"; 
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, @ModelAttribute Course course, Model model) {
        Optional<Course> c = service.get(id);
        if (c.isEmpty())
            return "No course found with id: " + id;
        else {
            course = c.get();
            model.addAttribute("course", course);
            return "details";
        }
    }
}
