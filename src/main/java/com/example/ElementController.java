package com.example;

import java.lang.management.ManagementFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElementController {
	
	@Autowired
	private PeriodicTable repository ;
	
	@RequestMapping(value="/element",method=RequestMethod.GET)
	public Element element(@RequestParam (value="symbol", defaultValue="H") String symbol) {
		System.out.println("Fetch Element with " + symbol);
		System.out.println("Current ProcessId : " + ManagementFactory.getRuntimeMXBean().getName());
		Iterable<Element> all = repository.findAll();
		for(Element e : all)
			System.out.println(e);
		Element e = repository.findOne(symbol);
		if(e == null){
			System.out.println("Null in database");
			return new Element("Crt", 999.999, "Crutonium");
		}
		System.out.println("Element retrieved = " + e);
		return e ;
	}
	
	@RequestMapping(value="/stop",method=RequestMethod.GET)
	public void stop(){
		System.out.println("*********** Received request to Shutdown !! *************");
		Runtime.getRuntime().exit(2);
	}
	
	public Element element(@RequestParam (value="symbol") String symbol,
			@RequestParam(value="mass") double mass,
			@RequestParam (value="name") String name) {
		System.out.println("Post Element =" + symbol + " mass = " + mass + " name = " + name);
		return repository.save(new Element(symbol, mass, name));
	}

}
