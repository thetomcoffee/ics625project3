
package ics625project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tom Coffee
 */
@Service
public class CourseService {
    
    @Autowired
    private CourseRepo repo;
    
    private final List<Course> courses = new ArrayList<>();
    
    public void add(String number, 
            String subject, 
            String title, 
            int credits, 
            boolean offered, 
            String description){
        Course c = new Course(number, 
                subject, 
                title, 
                credits, 
                offered, 
                description);
        repo.save(c);
    }
    
    public  Optional<Course> get(long id){
        return repo.findById(id);
    }
    
    public List<Course> getAll(){
        List<Course> courses = new ArrayList<>();
        repo.findAll().forEach(courses::add);
        return courses;
    }
    
    public void remove(long id){
        repo.deleteById(id);
    }
    
    public void update(long id, 
            String subject, 
            String number, 
            String title, 
            boolean offered, 
            String description, 
            int credits){
        Optional<Course> op = repo.findById(id);
        if (op.isEmpty()) return;
        
        Course c = op.get();
        c.setSubject(subject);
        c.setNumber(number);
        c.setTitle(title);
        c.setOffered(offered);
        c.setCredits(credits);
        c.setDescription(description);
        repo.save(c);
    }
}
