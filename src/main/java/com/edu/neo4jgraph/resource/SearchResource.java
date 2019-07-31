package com.edu.neo4jgraph.resource;

import com.edu.neo4jgraph.node.Account;
import com.edu.neo4jgraph.node.SearchCriteria;
import com.edu.neo4jgraph.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchResource {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/search1")
    public String getResult(@RequestParam(value = "mobile", required = false) String mobile,
                            @RequestParam(value = "nid", required = false) String nid,
                            @RequestParam(value = "passport", required = false) String passport,
                            @RequestParam(value = "searchType", required = false) String searchType,
                            Model model) {

        List<Account> accountList = new ArrayList<>();

        if(searchType == "mobile") {
            accountList = (List<Account>) accountRepository.findByMobile(mobile);
        } else if( searchType == "nid") {
            accountList = (List<Account>) accountRepository.findByNid(nid);
        } else if(searchType == "passport") {
            accountList = (List<Account>) accountRepository.findByPassport(passport);
        }

        model.addAttribute("accountList", accountList);
        return "search";
    }

    @GetMapping("/search")
    public String getSearchResult(Model model,
                             @ModelAttribute("searchcriteria") SearchCriteria searchCriteria) {

        List<Account> accountList = new ArrayList<>();
        if(searchCriteria.getSearchType() != null && "mobile".equalsIgnoreCase(searchCriteria.getSearchType())) {
                accountList = (List<Account>) accountRepository.findByMobile(searchCriteria.getSearchString());
        } else if(searchCriteria.getSearchType() != null && "nid".equalsIgnoreCase(searchCriteria.getSearchType())) {
            accountList = (List<Account>) accountRepository.findByNid(searchCriteria.getSearchString());
        } else if(searchCriteria.getSearchType() != null && "passport".equalsIgnoreCase(searchCriteria.getSearchType())) {
            accountList = (List<Account>) accountRepository.findByPassport(searchCriteria.getSearchString());
        }
        model.addAttribute("accountList", accountList);
        return "search";
    }


}
