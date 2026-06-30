package com.plantcareapp.controller;

import com.plantcareapp.dao.PlantDAO;
import com.plantcareapp.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlantController {

    @Autowired
    private PlantDAO plantDAO;

    @GetMapping("/plants")
    public String showAllPlants(Model model) throws Exception {
        List<Plant> plants = plantDAO.getAllPlants();
        model.addAttribute("plants", plants);
        return "plants";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String searchPlant(@RequestParam("search") String search, Model model) throws Exception {
        Plant plant = plantDAO.searchByName(search);
        if (plant == null) {
            return "missing-plant";
        }
        model.addAttribute("plant", plant);
        return "output";
    }
}
