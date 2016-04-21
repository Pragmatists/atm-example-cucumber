package pl.pragmatists.atm.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.pragmatists.atm.domain.Teller;

@Controller
public class WithdrawController {

    @Autowired
    private Teller teller;
    
    @RequestMapping(value = "/withdraw", method = POST)
    public String withdraw(@RequestParam("amount") int amount) {
        
        teller.withdraw(amount);
        
        return "redirect:main";
    }

}
