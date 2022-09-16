package com.spring.bookmydr.ctrl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookmydr.entity.Doctor;
import com.spring.bookmydr.entity.Feedback;
import com.spring.bookmydr.service.FeedbackService;
@RestController
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	@PostMapping("/feedbacks")
public Feedback addFeedback(@Valid @RequestBody Feedback fdb) {
		return feedbackService.addFeedback(fdb);
	}
	@GetMapping("/feedbacks/{feedbackId}")
public Feedback getFeedback(@PathVariable int feedbackId) {
		return feedbackService.getFeedback(feedbackId);
	}
	@GetMapping("/feedbacks")
public List<Feedback> getAllFeedbacks() {
	return feedbackService.getAllFeedbacks();
}
}
