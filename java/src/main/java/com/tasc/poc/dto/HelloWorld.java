package com.tasc.poc.dto;

import lombok.Data;

/**
 * Simple DTO to use in the helloworldrest service.
 */
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
