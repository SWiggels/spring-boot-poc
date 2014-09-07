package com.tasc.golden.poc.dto;

import lombok.Data;

@Data
public class HelloWorld {

	/**
	 * Simple id.
	 */
    private final long id;
    
    /**
     * The content to travel on the wire.
     */
    private final String content;
}
