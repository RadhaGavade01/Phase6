package com.icinbank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.icinbank.domain.RequestChequeBook;

public interface RequestChequeBookDao extends CrudRepository<RequestChequeBook, Long> {

    List<RequestChequeBook> findAll();

	/*RequestChequeBook findOne(Long id);*/
}
