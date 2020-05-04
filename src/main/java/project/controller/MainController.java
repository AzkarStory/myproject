package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.Cup;
import project.repository.CupRepository;

import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private CupRepository cupRepository;

    Integer maxCup = 5;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Cup> cups = cupRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            cups = cupRepository.findByNumber(filter);
        } else {
            cups = cupRepository.findAll();
        }

        model.addAttribute("cups", cups);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam String number, Map<String, Object> model) {
        Cup cup = new Cup(name, number);

        cupRepository.save(cup);

        Iterable<Cup> cups = cupRepository.findAll();

        model.put("cups", cups);

        return "main";
    }

    @PostMapping("/main/update")
    public String update(@RequestParam Long id, @RequestParam String name, @RequestParam String number,
                      @RequestParam Integer cup, @RequestParam Integer cupzapas, @RequestParam Integer totalcup, Map<String, Object> model) {

        if (cup <= maxCup)
        {
        Cup cupNew = new Cup(id, name, number, cup+1, cupzapas, totalcup + 1);
        return saveAndFlushCup(cupNew, model);
        } else{
            Cup cupNew = new Cup(id, name, number, cup, cupzapas, totalcup);

           return saveAndFlushCup(cupNew, model);
        }
    }

    @PostMapping("/main/free")
    public String freeCup(@RequestParam Long id, @RequestParam String name, @RequestParam String number,
                         @RequestParam Integer cup, @RequestParam Integer cupzapas, @RequestParam Integer totalcup, Map<String, Object> model) {
        Cup cupNew = new Cup(id, name, number, cup, cupzapas, totalcup);

        if (cupNew.getCup() == 6) {
            cupNew.setCup(0);
            if (cupNew.getCupZapas() > 0 && cupNew.getCupZapas() <= 6) {
                cupNew.setCup(cupNew.getCupZapas());
                cupNew.setCupZapas(0);
            }
            if (cupNew.getCupZapas() > 6) {
                cupNew.setCup(6);
                cupNew.setCupZapas(cupNew.getCupZapas() - 6);
            }

        }
        return saveAndFlushCup(cupNew, model);
    }


    @PostMapping("/main/zapas")
    public String zapasCup(@RequestParam Long id, @RequestParam String name, @RequestParam String number,
                         @RequestParam Integer cup, @RequestParam Integer cupzapas, @RequestParam Integer totalcup, Map<String, Object> model){
        int plusCup = 1;

        Cup cupNew = new Cup(id, name, number, cup, cupzapas + plusCup, totalcup);

        return saveAndFlushCup(cupNew, model);
    }

    public String saveAndFlushCup(Cup cup, Map<String, Object> model){

        cupRepository.saveAndFlush(cup);

        Iterable<Cup> cups = cupRepository.findAll();

        model.put("cups", cups);

        return "main";
    }


}