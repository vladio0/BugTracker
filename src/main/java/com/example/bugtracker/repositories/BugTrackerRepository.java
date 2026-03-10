package com.example.bugtracker.repositories;

import com.example.bugtracker.model.BugTrackerItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugTrackerRepository extends JpaRepository<BugTrackerItem, Long> {

    List<BugTrackerItem> findByTitleContainingIgnoreCaseOrderByDateDesc(String title);
}
