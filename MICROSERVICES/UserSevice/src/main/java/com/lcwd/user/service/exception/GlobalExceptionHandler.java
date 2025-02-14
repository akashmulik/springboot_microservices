package com.lcwd.user.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.payload.ApiResponse;


@RestControllerAdvice
	public class GlobalExceptionHandler {
	
//	@ExceptionHandler(ResourseNotFoundException.class)
//	public ResponseEntity<ApiResponse>  handlerResourceNotFoundException(ResourseNotFoundException ex){
//		
//		String message = ex.getMessage();
//		ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
//		
//		
//	}
	
	
	 @ExceptionHandler(ResourseNotFoundException.class)
	    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourseNotFoundException ex) {
	        String message = ex.getMessage();
	        ApiResponse response = new ApiResponse();
	        response.setMessage(message);
	        response.setSuccess(true);
	        response.setStatus(HttpStatus.NOT_FOUND);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }

		
	}
