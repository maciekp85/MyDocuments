package com.apress.isf.spring.web;

import com.apress.isf.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nishi on 2016-04-03.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    DocumentDAO documentDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String searchAll(Model model) {
        model.addAttribute("docs", documentDAO.getAll());
        return "search/all";
    }

}
