package com.study.jpa.repositories;

import com.study.jpa.entities.Publisher;
import com.study.jpa.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
}
