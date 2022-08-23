package com.icinbank.service.UserServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.RequestChequeBookDao;
import com.icinbank.domain.RequestChequeBook;
import com.icinbank.service.RequestChequeBookService;

@Service
public class RequestChequeBookServiceImpl implements RequestChequeBookService {

    @Autowired
    private RequestChequeBookDao requestChequeBookDao;

    public RequestChequeBook createRequestChequeBook(RequestChequeBook requestChequeBook) {
       return requestChequeBookDao.save(requestChequeBook);
    }

    public List<RequestChequeBook> findAll() {
        return requestChequeBookDao.findAll();
    }

    public RequestChequeBook findRequestChequeBook(Long id) {
        //return requestChequeBookDao.findOne(id);
    	return requestChequeBookDao.findById(id).orElse(null);
    }

    public void confirmRequestChequeBook(Long id) {
        RequestChequeBook requestChequeBook = findRequestChequeBook(id);
        requestChequeBook.setConfirmed(true);
        requestChequeBookDao.save(requestChequeBook);
    }

	/*@Override
	public RequestChequeBook findRequestChequeBook(Long id) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
