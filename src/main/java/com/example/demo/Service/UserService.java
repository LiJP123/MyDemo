package com.example.demo.Service;


import com.example.demo.dto.UserDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "UserService", targetNamespace = "http://service.demo.paybay.cn/")
public interface UserService {
    @WebMethod
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    UserDTO getUser(String userId);
}
