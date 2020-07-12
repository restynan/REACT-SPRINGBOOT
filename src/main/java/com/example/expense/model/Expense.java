package com.example.expense.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name=  "expense")
public class Expense {
    @Id
    private Long id;
    private String Description;
    private Instant expenseDate;
    private String location;

    //Id    Date        Description       user        catergory
   // 1000 ,6/16/2019   visting Newyork    1            Travel

    @ManyToOne
    private Category category;
    @ManyToOne
    private User user;


}
