package com.orion10110.test.anotation.services;

import com.orion10110.test.anotation.anotations.Init;
import com.orion10110.test.anotation.anotations.Service;

@Service(name="verylazy service")
public class LazyService {
	@Init
	public void lazyInit() throws Exception{
		System.out.println("lazy hhh");
	}
}
