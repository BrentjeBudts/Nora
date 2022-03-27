package be.thomasmore.app.controllers;

import be.thomasmore.app.model.CodingLanguage;
import be.thomasmore.app.repositories.CodingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CodingController {
    @Autowired
    private CodingRepository codingRepository;

    @GetMapping("/codingList")
    public String codingList(Model model){

        Iterable<CodingLanguage> allCoding = codingRepository.findAll();
        model.addAttribute("list", allCoding);


        return "codingList";
    }

    @GetMapping({"/codingDetails/{id}","/codingDetails"})
    public String codingDetails(Model model, @PathVariable(required = false) Integer id){

        if(id==null) return "codingDetails";
        Optional<CodingLanguage> optionalCodingLanguage = codingRepository.findById(id);
        if(optionalCodingLanguage.isPresent()){
            model.addAttribute("code", optionalCodingLanguage.get());
        }
        return  "codingDetails";
    }
}
