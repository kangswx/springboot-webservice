package com.kangswx.springbootwebservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.springbootwebservice.kangswx.com")
public interface UserService {

    @WebMethod
    String getUser(@WebParam(name = "id") int id);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String getUserName(@WebParam(name = "id") int id);
}
