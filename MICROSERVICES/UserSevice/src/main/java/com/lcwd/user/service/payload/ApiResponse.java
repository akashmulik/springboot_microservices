package com.lcwd.user.service.payload;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;




public class ApiResponse{
private String message;
private boolean success;
private HttpStatus status;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public ApiResponse(String message, boolean success, HttpStatus status) {
	super();
	this.message = message;
	this.success = success;
	this.status = status;
}
public ApiResponse() {
	super();
}


}