package com.bikash.blogapi.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
    String user;
    String id;

    long userId;

    public ResourceNotFoundException(String user, String id, long userId) {
        super(String.format("%s not found with %s : %s" ,user ,id ,userId ));
        this.user = user;
        this.id = id;
        this.userId = userId;
    }
}
