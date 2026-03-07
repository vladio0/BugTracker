package com.example.bugtracker.contollers;

import com.example.bugtracker.model.BugTrackerItem;
import com.example.bugtracker.repositories.BugTrackerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BugTrackerController implements CommandLineRunner {

    private final BugTrackerRepository bugTrackerRepository;

    public BugTrackerController(BugTrackerRepository bugTrackerRepository) {
        this.bugTrackerRepository = bugTrackerRepository;
    }

    @GetMapping
    public String index(Model model){


       List<BugTrackerItem> allBugs = bugTrackerRepository.findAll();
       model.addAttribute("allBugs", allBugs);
       model.addAttribute("newBug", new BugTrackerItem());
      // model.addAttribute("newDate", setDate(LocalDate date));
      // model.addAttribute("DeveloperName", setDevName(devName));

        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BugTrackerItem BugTrackerItem){
        bugTrackerRepository.save(BugTrackerItem);

        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id){
        bugTrackerRepository.deleteById(id);

        return "redirect:/";
    }

    @PostMapping("/removeAll")
    public String removeAllItems(){
        bugTrackerRepository.deleteAll();

        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchTodoItems(@RequestParam("searchTerm") String searchTerm, Model model){
        List<BugTrackerItem> allItems = bugTrackerRepository.findAll();
        List<BugTrackerItem> searchResults = new ArrayList<>();

        for (BugTrackerItem item : allItems){
            if (item.getTitle().toLowerCase().contains(searchTerm.toLowerCase())){
                searchResults.add(item);
            }
        }

        model.addAttribute("allTodos", searchResults);
        model.addAttribute("newTodo", new BugTrackerItem());
        model.addAttribute("searchTerm", searchTerm);

        return "index";
    }

    @Override
    public void run(String... args) throws Exception {
        bugTrackerRepository.save(new BugTrackerItem("Item1"));
        bugTrackerRepository.save(new BugTrackerItem("Item2"));
    }
}
