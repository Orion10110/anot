package com.orion10110.test.anotation.services;

import com.orion10110.test.anotation.anotations.Init;
import com.orion10110.test.anotation.anotations.Service;

@Service(name="Simple class services")
public class SimpleService {
	@Init
	public void initService(){
	 System.out.println("Simplyyy ");
	}
	
	public void OtherMethod(){
		
	}
}
