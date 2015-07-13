package com.htinaung.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.htinaung.DTO.CourseDTO;
import com.htinaung.entities.Course;
import com.htinaung.service.CourseServiceInterface;
import com.htinaung.utils.Validator;

@Controller
@RequestMapping("/")
public class CourseController {
	private Validator validator = new Validator();
	@Autowired
	private CourseServiceInterface courseService;
	
    @ModelAttribute
    public CourseDTO newRequest(@RequestParam(required=false) Integer id) {
        return  new CourseDTO();
    }

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/regit")
	public ModelAndView regit() {
		ModelAndView nextPage=new ModelAndView("registration");
		getLists(nextPage);
		return nextPage;
	}

	@RequestMapping("/registration")
	public ModelAndView comfirm(
			@ModelAttribute(value = "courseDTO") CourseDTO courseDTO,
			BindingResult result, ModelMap model) {
		validator.validate(courseDTO, result);
		ModelAndView nextPage=new ModelAndView("registration");
		if(result.hasErrors()){
			getLists(nextPage);
			return nextPage;
		}
		nextPage.setViewName("comfirm");
		nextPage.addObject("courseDTO", courseDTO);
		return nextPage;
	}
	
	@RequestMapping("/comfirm")
	public String comfirm(@ModelAttribute(value = "courseDTO") CourseDTO courseDTO){
		courseService.saveCourse(new Course(courseDTO));
		return "success";
	}
	
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
	
	public void getLists(ModelAndView model){
		List<String> yearList=new ArrayList<String>();
		List<String> monthList=new ArrayList<String>();
		List<String> dayList=new ArrayList<String>();
		List<String> hourList=new ArrayList<String>();
		List<String> minuteList=new ArrayList<String>();
		int year=2015;
		yearList.add("");
		monthList.add("");
		dayList.add("");
		hourList.add("");
		minuteList.add("");
		for(int i=year;i<year+10;i++){
			yearList.add(i+"");
		}
		for(int i=1;i<13;i++){
			monthList.add(i+"");
		}
		for(int i=1;i<32;i++){
			dayList.add(i+"");
		}
		for(int i=1;i<25;i++){
			hourList.add(i+"");
		}
		for(int i=1;i<61;i++){
			minuteList.add(i+"");
		}
		model.addObject("yearList", yearList);
		model.addObject("monthList", monthList);
		model.addObject("dayList", dayList);
		model.addObject("hourList", hourList);
		model.addObject("minuteList", minuteList);
	}
}
