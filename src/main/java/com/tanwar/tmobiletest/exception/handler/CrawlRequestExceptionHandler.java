package com.tanwar.tmobiletest.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.tanwar.tmobiletest.exception.CrawlRequestNotFoundException;
import com.tanwar.tmobiletest.model.CrawlResponse;
import com.tanwar.tmobiletest.model.Errors;

/**
 * CrawlRequestExceptionHandler class to handle the exception thrown by the application.
 * @author tanwar
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class CrawlRequestExceptionHandler {

	/**
	 * Method to handle CrawlRequestNotFoundException exception thrown when requested token is not found. 
	 * @param crawlRequestNotFoundException
	 * @return
	 */
	@ExceptionHandler(CrawlRequestNotFoundException.class)
	public CrawlResponse returnErrorResponse(CrawlRequestNotFoundException crawlRequestNotFoundException) {
		CrawlResponse crawlResponse = new CrawlResponse();
		Errors error = new Errors();
		error.setCode("ERR:Not-FOUND");
		error.setMessage(crawlRequestNotFoundException.getToken() + " not found");
		List<Errors> errors = new ArrayList<>();
		errors.add(error);
		crawlResponse.setErrors(errors);
		return crawlResponse;
	}

}
