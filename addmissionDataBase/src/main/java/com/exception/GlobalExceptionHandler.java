package com.exception;




import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
  @ExceptionHandler(StudentNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(StudentNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

		
		  @ExceptionHandler(Exception.class) 
		  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
		  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
		  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); 
		  }
 		  
		  @ExceptionHandler(MethodArgumentNotValidException.class)
		  public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exception)
		  {
		         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Validation Error" ,
		        		 exception.getBindingResult().getFieldError().getDefaultMessage());
		         return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		  }
		  
		}