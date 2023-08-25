package com.tms.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<HttpStatus>  UserNotFound(){
        log.info("UserNotFoundException");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value =  IllegalArgumentException.class)
    public ResponseEntity<HttpStatus> illegalArgumentException(){
        log.info("illegalArgumentException exception ");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value =  OptimisticEntityLockException.class)
    public ResponseEntity<HttpStatus> optimisticEntityLockException(){
        log.info("OptimisticEntityLockException exception");
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
