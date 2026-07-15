package com.plantcareapp.controller;

import java.util.List;

import com.plantcareapp.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.plantcareapp.model.Plant;

@Controller
public class PlantController {

    @Autowired
    private PlantRepository plantRepository;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }

    @GetMapping("/plants")
    public String showAllPlants(Model model) {
        List<Plant> plants = plantRepository.findAllByOrderByCommonNameAsc();
        model.addAttribute("plants", plants);
        return "plants";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchPlant(@RequestParam("search") String search, Model model) {
        List<Plant> plants = plantRepository.findByCommonNameContainingIgnoreCase(search);

        if (plants.isEmpty()) {
            return "missing-plant";
        }
        model.addAttribute("plant", plants.get(0));
        return "output";
    }
}
