package com.example.customerservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-06-16T08:56:49.310+01:00
 * Generated source version: 4.0.0
 *
 */
@WebService(targetNamespace = "http://Web.customerservice.example.com/", name = "CustomerSoapService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerSoapService {

    @WebMethod
    @RequestWrapper(localName = "save", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.Save")
    @ResponseWrapper(localName = "saveResponse", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.SaveResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.example.customerservice.web.CustomerResponseDTO save(

        @WebParam(name = "arg0", targetNamespace = "")
        com.example.customerservice.web.CustomerRequestDTO arg0
    );

    @WebMethod
    @RequestWrapper(localName = "findAll", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.FindAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.example.customerservice.web.CustomerResponseDTO> findAll()
;

    @WebMethod
    @RequestWrapper(localName = "findById", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.FindById")
    @ResponseWrapper(localName = "findByIdResponse", targetNamespace = "http://Web.customerservice.example.com/", className = "com.example.customerservice.web.FindByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.example.customerservice.web.CustomerResponseDTO findById(

        @WebParam(name = "id", targetNamespace = "")
        java.lang.Long id
    );
}
