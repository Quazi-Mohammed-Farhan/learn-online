package com.learn.online.exceptions.handlers;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.learn.online.exceptions.CourseNotFoundtException;
import com.learn.online.exceptions.CourseServiceException;
import com.learn.online.exceptions.LearnOnLineException;
import com.learn.online.exceptions.StudentServiceException;
import com.learn.online.responses.ErrorMessageResponse;

@ControllerAdvice
public class LearnOnlineExceptionHandler {

	@ExceptionHandler(value = {StudentServiceException.class})
	public ResponseEntity<Object> handleStudentServiceException(
			StudentServiceException ex, WebRequest wb) {
		return new ResponseEntity<>(new ErrorMessageResponse(LocalDate.now(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(value = {CourseServiceException.class})
	public ResponseEntity<Object> handleCourserServiceException(
			CourseServiceException ex, WebRequest wb) {
		
		return new ResponseEntity<>(new ErrorMessageResponse(LocalDate.now(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {CourseNotFoundtException.class})
	public ResponseEntity<Object> handleCourseNotFoundException(
			CourseNotFoundtException ex, WebRequest web) {
		
		return new ResponseEntity<>(new ErrorMessageResponse(LocalDate.now(),
				ex.getMessage()), new HttpHeaders(),  HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = {LearnOnLineException.class})
	public ResponseEntity<Object> handleLearnOnLineException(
			LearnOnLineException ex, WebRequest rq) {
		
		return new ResponseEntity<>(
				new ErrorMessageResponse(LocalDate.now(), ex.getMessage()),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
