package com.icinbank.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.domain.RequestChequeBook;
import com.icinbank.service.RequestChequeBookService;

@RestController
@RequestMapping("/api/chequeBookRequest")
@PreAuthorize("hasRole('ADMIN')")
public class RequestChequeBookResource {

    @Autowired
    private RequestChequeBookService requestChequeBookService;

    @RequestMapping("/all")
    public List<RequestChequeBook> findRequestChequeBookList() {
        List<RequestChequeBook> requestChequeBookList = requestChequeBookService.findAll();

        return requestChequeBookList;
    }

    @RequestMapping("/{id}/confirm")
    public void confirmRequestChequeBook(@PathVariable("id") Long id) {
        requestChequeBookService.confirmRequestChequeBook(id);
    }
}
