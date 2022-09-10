package com.otunctan.dp.exceptions.handler;

import com.otunctan.dp.notification.exceptions.NotificationNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotificationNotFoundException.class})
    public String notificationNotFoundExceptionHandle(NotificationNotFoundException ex) {
        return ex.getMessage();
    }
}
