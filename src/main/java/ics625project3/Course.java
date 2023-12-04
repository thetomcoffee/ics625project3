/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ics625project3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author tomco
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    private String number;
    private String subject;
    private String title;
    private int credits;
    private boolean offered;
    private String description;
}
