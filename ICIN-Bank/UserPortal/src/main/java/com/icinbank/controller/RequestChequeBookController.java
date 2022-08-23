package com.icinbank.controller;

import java.security.Principal;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icinbank.domain.RequestChequeBook;
import com.icinbank.domain.User;
import com.icinbank.service.RequestChequeBookService;
import com.icinbank.service.UserService;

@Controller
@RequestMapping("/requestChequeBook")
public class RequestChequeBookController {

    @Autowired
    private RequestChequeBookService requestChequeBookService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createRequestChequeBook(Model model) {
        RequestChequeBook requestChequeBook = new RequestChequeBook();
        model.addAttribute("requestChequeBook", requestChequeBook);
        model.addAttribute("dateString", "");

        return "requestChequeBook";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createRequestChequeBookPost(@ModelAttribute("requestChequeBook") RequestChequeBook requestChequeBook,  Model model, Principal principal) throws ParseException {


        User user = userService.findByUsername(principal.getName());
        requestChequeBook.setUser(user);

        requestChequeBookService.createRequestChequeBook(requestChequeBook);

        return "redirect:/ICINBank";
    }


}
