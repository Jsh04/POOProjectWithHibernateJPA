package com.silvio.Exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com")
public class LojaFerramentasException extends RuntimeException {
	
	public LojaFerramentasException(String msg) {
		super(msg);
	}
}
