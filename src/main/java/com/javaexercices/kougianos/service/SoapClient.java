package com.javaexercices.kougianos.service;

import com.javaexercices.kougianos.dto.soap.GetBankResponseType;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class SoapClient extends WebServiceGatewaySupport {
    public GetBankResponseType getBank(String uri, Object request) {
        JAXBElement<?> res = (JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(uri, request);
        return (GetBankResponseType) res.getValue();
    }
}
