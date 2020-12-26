package ru.lidzhiev.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lidzhiev.demo.repository.CounterRepository;

@Controller
public class CounterController {

    @Autowired
    private CounterRepository repository;

    private volatile int counter = -1;

    @GetMapping
    public String index(Model model) {
        counter++;
        repository.setCounter(1,counter);
        model.addAttribute("counter", counter);
        return "index.html";
    }
}
