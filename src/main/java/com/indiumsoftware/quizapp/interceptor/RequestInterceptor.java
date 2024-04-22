package com.indiumsoftware.quizapp.interceptor;

import com.indiumsoftware.quizapp.exception.InvalidHeaderException;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;


/*

// ------------------------- one way to store logs --------------------------

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object handler) throws Exception{

        String clientIP = httpServletRequest.getRemoteAddr();
        String method = httpServletRequest.getMethod();
        LocalDateTime timestamp = LocalDateTime.now();

        String logMessage = String.format(
                "Client IP: %s | Accessed Method: %s | Timestamp: %s",
                clientIP, method, timestamp
        );

        // Log the information using SLF4J logger
        logger.info(logMessage);


        if(StringUtils.isBlank(httpServletRequest.getHeader("quiz-auth-key"))){

            throw new InvalidHeaderException("Invalid request,it will not be processed");

        }
        return true;



    }


}
*/


// --------------------------- another way to store logs --------------------------------------


@Component
public class RequestInterceptor implements HandlerInterceptor {

public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIP = request.getRemoteAddr();
        String method = request.getMethod();
        String url = request.getRequestURI();
        LocalDateTime timestamp = LocalDateTime.now();

        String logMessage = String.format(
                "Client IP: %s | Accessed Method: %s | URL: %s | Timestamp: %s",
                clientIP, method, url, timestamp
        );

        // Log the information into a file
        logToFile(logMessage);

        return true; // Continue with the handler chain
        }

private void logToFile(String logMessage) {
        String fileName = "clients_log_details.txt";
        File logFile = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
        fileWriter.write(logMessage + "\n");
        fileWriter.flush();
        }
        catch (IOException e) {
        e.printStackTrace();
        }
}

        }