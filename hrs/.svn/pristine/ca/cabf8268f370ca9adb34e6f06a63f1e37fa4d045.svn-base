package com.qfedu.hrs.controller;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(IOException.class)
	public String handleIOE() {
		return "err/ioe";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleRE(Exception ex, Model model) {
		model.addAttribute("hint", ex.getMessage());
		return "err/error";
	}
}
