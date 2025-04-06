// src/main/java/com/example/petconnect/dto/QueryDTO.java
package com.presidency.petconnect.dto;

public class QueryDTO {

    private Long queryId;
    private String name;
    private String email;
    private String subject;
    private String message;
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
