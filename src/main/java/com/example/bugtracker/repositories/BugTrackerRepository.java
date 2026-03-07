package com.example.bugtracker.repositories;

import com.example.bugtracker.model.BugTrackerItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugTrackerRepository extends JpaRepository<BugTrackerItem, Long> {

}
