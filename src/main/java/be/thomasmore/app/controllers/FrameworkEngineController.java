package be.thomasmore.app.controllers;

import be.thomasmore.app.model.CodingLanguage;
import be.thomasmore.app.model.FrameworkEngine;
import be.thomasmore.app.repositories.CodingRepository;
import be.thomasmore.app.repositories.FrameworkEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class FrameworkEngineController {
    @Autowired
    private FrameworkEngineRepository frameworkEngineRepository;

    @GetMapping("/frameEnEngineList")
    public String frameEnEngineList(Model model,
                                    @RequestParam(required = false) Boolean popularity,
                                    @RequestParam(required = false) Boolean paidForStudents,
                                    @RequestParam(required = false) Boolean paidForCompany){


        List<FrameworkEngine> allFrameEngine;

        allFrameEngine = frameworkEngineRepository.findFilters(paidForStudents, paidForCompany);
        if(popularity != null && popularity){
            Collections.sort(allFrameEngine, Comparator.comparingInt(FrameworkEngine::getPopularity));
            Collections.reverse(allFrameEngine);
        }


        model.addAttribute("list", allFrameEngine);
        model.addAttribute("popularity", popularity);
        model.addAttribute("paidForStudents", paidForStudents);
        model.addAttribute("paidForCompany", paidForCompany);


        return "frameEnEngineList";
    }

    @GetMapping({"/frameEnEngineDetails/{id}","/frameEnEngineDetails"})
    public String frameworkEnEngineDetails(Model model, @PathVariable(required = false) Integer id){

        if(id==null) return "frameEnEngineDetails";
        Optional<FrameworkEngine> optionalFrameworkEngine = frameworkEngineRepository.findById(id);
        if(optionalFrameworkEngine.isPresent()){
            model.addAttribute("frameEngine", optionalFrameworkEngine.get());
        }
        return  "frameEnEngineDetails";
    }
}
