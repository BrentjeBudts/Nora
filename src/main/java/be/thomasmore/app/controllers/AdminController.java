package be.thomasmore.app.controllers;


import be.thomasmore.app.model.FrameworkEngine;
import be.thomasmore.app.repositories.CodingRepository;
import be.thomasmore.app.repositories.FrameworkEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FrameworkEngineRepository frameworkEngineRepository;
    @Autowired
    private CodingRepository codingRepository;

    @ModelAttribute("frameworkEngine")
    public FrameworkEngine frameworkEngine(@PathVariable(required = false) Integer id){

        if(id!=null){
            Optional<FrameworkEngine> optionalFrameworkEngine = frameworkEngineRepository.findById(id);
            if (optionalFrameworkEngine.isPresent()) return optionalFrameworkEngine.get();
        }
        return new FrameworkEngine();
    }

    @GetMapping("/frameworkEdit/{id}")
    public String frameworkEdit(Model model, @PathVariable int id){
        model.addAttribute("codings", codingRepository.findAll());
        return "admin/frameworkEdit";
    }

    @PostMapping("/frameworkEdit/{id}")
    public String frameworkEditPost(Model model, @ModelAttribute("party") @Valid FrameworkEngine frameworkEngine, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("codings", codingRepository.findAll());
            return "admin/frameworkEdit";
        }
        frameworkEngineRepository.save(frameworkEngine);
        return "redirect:/frameEnEngineDetails/"+frameworkEngine.getId();
    }
}
