/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics625project3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Tom Coffee
 */
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String number;
    private String subject;
    private String title;
    private int credits;
    private boolean offered;
    private String description;
    
    public Course() {
    }
    
    public Course(String number, String subject, String title, int credits, boolean offered, String description) {
        this.number = number;
        this.subject = subject;
        this.title = title;
        this.credits = credits;
        this.offered = offered;
        this.description = description;
    }    
    
    public boolean getOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }

}
