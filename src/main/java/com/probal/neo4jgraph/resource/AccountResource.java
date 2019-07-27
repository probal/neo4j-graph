package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Account;
import com.probal.neo4jgraph.node.Mobile;
import com.probal.neo4jgraph.node.Nid;
import com.probal.neo4jgraph.node.Passport;
import com.probal.neo4jgraph.repository.AccountRepository;
import com.probal.neo4jgraph.repository.MobileRepository;
import com.probal.neo4jgraph.repository.NidRepository;
import com.probal.neo4jgraph.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/account-list")
    public String showAll(Model model) {
        model.addAttribute("accountList", accountRepository.findAll());
        return "account-list";
    }

    @GetMapping("/{name}")
    public Account getAccountByName(@PathVariable String name) {
        return accountRepository.findByName(name);
    }

    @GetMapping("/{mobile}")
    public Account getAccountByMobile(@PathVariable String mobile) {
        return accountRepository.findByMobile(mobile);
    }

    @GetMapping("/{nid}")
    public Account getAccountByNID(@PathVariable String nid) {
        return accountRepository.findByNid(nid);
    }

    @GetMapping("/{address}")
    public Account getAccountByAddress(@PathVariable String address) {
        return accountRepository.findByAddress(address);
    }

    @GetMapping("/{passport}")
    public Account getAccountByPassport(@PathVariable String passport) {
        return accountRepository.findByPassport(passport);
    }

    @GetMapping("/account")
    public String greetingForm(Model model) {
        model.addAttribute("account", new Account());
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
