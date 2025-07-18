package com.example.school_hackathon_2025.global;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    public String handleException(Exception e, HttpServletResponse response) {
        // Log the exception (optional)
        System.err.println("An error occurred: " + e.getMessage());

        if (e instanceof NotFoundException) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else if (e instanceof Exception) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        // Return a generic error view or message
        return "error"; // This should correspond to an error view in your templates
    }
}
