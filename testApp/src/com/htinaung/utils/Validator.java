package com.htinaung.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.htinaung.DTO.CourseDTO;



public class Validator implements org.springframework.validation.Validator{

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validate(Object courseDTO, Errors errors) {
		CourseDTO corDto=(CourseDTO) courseDTO;
		
		ValidationUtils.rejectIfEmpty(errors, "courseNumber", "field.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "courseName", "field.number.empty");
		ValidationUtils.rejectIfEmpty(errors, "year", "field.year.empty");
		ValidationUtils.rejectIfEmpty(errors, "month", "field.month.empty");
		ValidationUtils.rejectIfEmpty(errors, "day", "field.day.empty");
		ValidationUtils.rejectIfEmpty(errors, "openHr", "field.openHr.empty");
		ValidationUtils.rejectIfEmpty(errors, "openMin", "field.openMin.empty");
		ValidationUtils.rejectIfEmpty(errors, "endHr", "field.endHr.empty");
		ValidationUtils.rejectIfEmpty(errors, "endMin", "field.endMin.empty");
		ValidationUtils.rejectIfEmpty(errors, "capicity", "field.capacity.empty");
		
		if(corDto.getCourseNumber().length()>4){
			errors.rejectValue("courseNumber", "not.more.than.4");
		}
		
		if(!isInteger(corDto.getCapicity())){
			errors.rejectValue("capicity", "not.number");
		}
		
		if(isInteger(corDto.getCapicity())){
			if(Integer.valueOf(corDto.getCapicity())>50){
				errors.rejectValue("capicity", "not.more.than.50");
			}
		}

	}
	
	public boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}

}
