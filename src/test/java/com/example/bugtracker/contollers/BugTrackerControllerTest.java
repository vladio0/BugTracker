package com.example.bugtracker.contollers;

import com.example.bugtracker.model.BugTrackerItem;
import com.example.bugtracker.repositories.BugTrackerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BugTrackerControllerTest {
    @Mock
    private BugTrackerRepository repository;

    @InjectMocks
    private BugTrackerController controller;

    @Test
   void testAddBug(){
        var item = new BugTrackerItem("Test bug");

        controller.add(item);

        verify(repository, times(1)).save(item);
    }

    @Test
    void testAddBugSecondItem(){
        var item = new BugTrackerItem("Test bug 2");

        controller.add(item);

        verify(repository, times(1)).save(item);
    }

    @Test
    void testRedirectBug(){
        var item = new BugTrackerItem("Test bug");

        String result = controller.add(item);

        verify(repository, times(1)).save(item);
        assertEquals("redirect:/", result);
    }

    @Test
    void testDeleteBug(){
        controller.deleteTodoItem(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void testRemoveAll(){
        controller.removeAllItems();

        verify(repository, times(1)).deleteAll();
    }
}