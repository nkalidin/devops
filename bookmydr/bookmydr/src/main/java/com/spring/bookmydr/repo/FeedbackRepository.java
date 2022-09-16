package com.spring.bookmydr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.bookmydr.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

}
