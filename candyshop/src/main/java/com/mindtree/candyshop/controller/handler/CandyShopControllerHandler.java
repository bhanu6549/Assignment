package com.mindtree.candyshop.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.candyshop.dto.ErrorDTO;
import com.mindtree.candyshop.dto.ResponseBody;
import com.mindtree.candyshop.exception.ApplicationException;

@RestControllerAdvice
public class CandyShopControllerHandler {
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> errorHandler(Exception e) {
		return new ResponseEntity<ResponseBody<Void>>(
				new ResponseBody<Void>(null, new ErrorDTO(e.getMessage(), e.getCause()), "Error in Application", false),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//		String errorMessaage = "";
//		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
//			errorMessaage += error.getDefaultMessage() + ", ";
//		}
//
//		return new ResponseEntity<ResponseBody<Void>>(
//				new ResponseBody<Void>(null, new ErrorDTO(errorMessaage, ex.getCause()), "Error in Application", false),
//				HttpStatus.BAD_REQUEST);
//
//	}
}
