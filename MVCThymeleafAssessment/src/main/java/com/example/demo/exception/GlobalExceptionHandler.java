package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidDateFormatException.class)
	public ModelAndView handleInvalidDate(InvalidDateFormatException ex) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("dateError", "Error");
		mv.setViewName("edit");

		return mv;
	}
}