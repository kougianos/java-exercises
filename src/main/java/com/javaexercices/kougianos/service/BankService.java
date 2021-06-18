package com.javaexercices.kougianos.service;

import com.javaexercices.kougianos.dto.soap.GetBankResponseType;
import com.javaexercices.kougianos.dto.soap.GetBankType;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class BankService extends WebServiceGatewaySupport {

    public static final String BANK_URI = "http://www.thomas-bayer.com/axis2/services/BLZService";

    public GetBankResponseType getBank(JAXBElement<GetBankType> request) {
        JAXBElement<?> res = (JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(BANK_URI, request);
        return (GetBankResponseType) res.getValue();
    }
}
