package com.spring.bookmydr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bookmydr.entity.Feedback;
import com.spring.bookmydr.repo.FeedbackRepository;
@Service
public class FeedbackService {
@Autowired
	private FeedbackRepository feedbackRepository;
public Feedback addFeedback(Feedback fdb) {
		return feedbackRepository.save(fdb);
	}
public Feedback getFeedback(int feedbackId) {
	Optional<Feedback> bookmydrContainer=feedbackRepository.findById(feedbackId);
	if(bookmydrContainer.isPresent()) {
	return bookmydrContainer.get();
	}
	else
	return null;

	}
public List<Feedback> getAllFeedbacks() {
	return feedbackRepository.findAll();
}
}
