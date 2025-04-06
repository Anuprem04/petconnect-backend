
package com.presidency.petconnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "queries")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queryId;
    
    private String name;
    
    private String email;
    
    private String subject;
    
    @Column(length = 5000)
    private String message;
    
    // We'll store the chosen shelter's ID
    private Long shelterId;


    // Getters and setters

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getSubject() {
        return subject;
    }
  
    public void setSubject(String subject) {
        this.subject = subject;
    }
  
    public String getMessage() {
        return message;
    }
  
    public void setMessage(String message) {
        this.message = message;
    }

    public Long getShelterId() {
        return shelterId;
    }

    public void setShelterId(Long shelterId) {
        this.shelterId = shelterId;
    }
}
