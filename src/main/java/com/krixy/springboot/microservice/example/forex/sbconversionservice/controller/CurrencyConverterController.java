package com.krixy.springboot.microservice.example.forex.sbconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.krixy.springboot.microservice.example.forex.sbconversionservice.model.CurrencyConversionBean;
import com.krixy.springboot.microservice.example.forex.sbconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConverterController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);
	
	@Autowired
	private CurrencyExchangeServiceProxy exchangeServiceProxy;
	
	@GetMapping("/convert-currency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
	
//		Map<String, String> uriVariables = new HashMap<String, String>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//		
//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
//		CurrencyConversionBean response = responseEntity.getBody();
		
		CurrencyConversionBean response = exchangeServiceProxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
