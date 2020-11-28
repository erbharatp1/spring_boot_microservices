package com.school.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Bharat
 *
 */
@RestController
public class SchoolServiceController {

	private static final Logger log = LoggerFactory.getLogger(SchoolServiceController.class);

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		log.info("Getting School details for " + schoolname);

		String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}",
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, schoolname).getBody();

		log.info("Response Received as " + response);

		return "School Name -  " + schoolname + " \n Student Details " + response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		log.info("SchoolServiceController.restTemplate()");
		return new RestTemplate();
	}
}