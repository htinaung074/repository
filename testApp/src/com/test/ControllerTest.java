package com.test;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.htinaung.DTO.CourseDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/WEB-INF/sql-context.xml",
		"classpath:/WEB-INF/mvc-dispatcher-servlet.xml" })
public class ControllerTest {

	private MockMvc mockMvc;

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.xmlConfigSetup(
				"classpath:/WEB-INF/mvc-dispatcher-servlet.xml").build();

	}

	@Test
	public void testConfirmApplicantSuccess() throws Exception {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setCourseNumber("C001");
		courseDTO.setCourseName("Java");
		courseDTO.setCapicity("10");
		courseDTO.setYear("2012");
		courseDTO.setMonth("1");
		courseDTO.setDay("1");
		courseDTO.setOpenHr("8");
		courseDTO.setOpenMin("30");
		courseDTO.setEndHr("5");
		courseDTO.setEndMin("30");

		mockMvc.perform(
				post("/registration")
						.param("courseNumber", courseDTO.getCourseNumber())
						.param("courseName", courseDTO.getCourseName())
						.param("capicity", courseDTO.getCapicity())
						.param("year", courseDTO.getYear())
						.param("month", courseDTO.getMonth())
						.param("day", courseDTO.getDay())
						.param("openHr", courseDTO.getOpenHr())
						.param("openMin", courseDTO.getOpenMin())
						.param("endHr", courseDTO.getEndHr())
						.param("endMin", courseDTO.getEndMin()))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/view/comfirm.jsp"));

	}

	@Test
	public void testValidation() throws Exception {
		mockMvc.perform(
				post("/registration").param("courseNumber", "")
						.param("courseName", "").param("capicity", "")
						.param("year", "").param("month", "").param("day", "")
						.param("openHr", "").param("openMin", "")
						.param("endHr", "").param("endMin", ""))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/view/registration.jsp"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO",
								"courseNumber"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO",
								"courseName"))
				.andExpect(model().attributeHasFieldErrors("courseDTO", "year"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO", "month"))
				.andExpect(model().attributeHasFieldErrors("courseDTO", "day"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO", "openHr"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO", "openMin"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO", "endHr"))
				.andExpect(
						model().attributeHasFieldErrors("courseDTO", "endMin"));
	}

	@Test
	public void testSaveApplicantSuccess() throws Exception {
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setCourseNumber("C001");
		courseDTO.setCourseName("Java");
		courseDTO.setCapicity("10");
		courseDTO.setYear("2012");
		courseDTO.setMonth("1");
		courseDTO.setDay("1");
		courseDTO.setOpenHr("8");
		courseDTO.setOpenMin("30");
		courseDTO.setEndHr("5");
		courseDTO.setEndMin("30");

		mockMvc.perform(
				post("/comfirm")
						.param("courseNumber", courseDTO.getCourseNumber())
						.param("courseName", courseDTO.getCourseName())
						.param("capicity", courseDTO.getCapicity())
						.param("year", courseDTO.getYear())
						.param("month", courseDTO.getMonth())
						.param("day", courseDTO.getDay())
						.param("openHr", courseDTO.getOpenHr())
						.param("openMin", courseDTO.getOpenMin())
						.param("endHr", courseDTO.getEndHr())
						.param("endMin", courseDTO.getEndMin()))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/view/success.jsp"));

	}

}
