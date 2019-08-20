package com.edu.neo4jgraph.resource;

import com.edu.neo4jgraph.node.*;
import com.edu.neo4jgraph.repository.AccountRepository;
import com.edu.neo4jgraph.repository.MobileRepository;
import com.edu.neo4jgraph.repository.NidRepository;
import com.edu.neo4jgraph.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AccountResource {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    NidRepository nidRepository;

    @Autowired
    MobileRepository mobileRepository;

    @Autowired
    PassportRepository passportRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/account-list")
    public String showAll(Model model) {
        model.addAttribute("accountList", (List<Account>) accountRepository.findAll());
        return "account-list";
    }

    @GetMapping("/account")
    public String getAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account";
    }


    @GetMapping("/account/{id}")
    public String getAccountById(Model model, @ModelAttribute("id") String id) {
        Optional<Account> account = accountRepository.findById(Long.valueOf(id));
        model.addAttribute("account", account);
        return "account";
    }


    @PostMapping("/account")
    public String createAccount(@ModelAttribute Account account) {

        List<Nid> nids = nidRepository.findByNid(account.getNid());
        if(nids.size() == 0) {
            nidRepository.save(new Nid(account.getNid()));
        }
        account.setNids(nidRepository.findByNid(account.getNid()));

        List<Passport> passports = passportRepository.findByPassport(account.getPassport());
        if(passports.size() == 0) {
            passportRepository.save(new Passport(account.getPassport()));
        }
        account.setPassports(passportRepository.findByPassport(account.getPassport()));

        List<Mobile> mobiles = mobileRepository.findByMobile(account.getMobile());
        if(mobiles.size() == 0) {
            mobileRepository.save(new Mobile(account.getMobile()));
        }
        account.setMobiles(mobileRepository.findByMobile(account.getMobile()));

        accountRepository.save(account);
        return "account-success";
    }

}
