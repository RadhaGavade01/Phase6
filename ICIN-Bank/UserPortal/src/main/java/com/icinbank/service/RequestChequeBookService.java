package com.icinbank.service;

import java.util.List;

import com.icinbank.domain.RequestChequeBook;

public interface RequestChequeBookService {
	RequestChequeBook createRequestChequeBook(RequestChequeBook requestChequeBook);

    List<RequestChequeBook> findAll();

    RequestChequeBook findRequestChequeBook(Long id);

    void confirmRequestChequeBook(Long id);
}
