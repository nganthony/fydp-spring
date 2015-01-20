package com.fydp.structure;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Holds all request response information which includes metadata, 
 * result of response, and pagination information
 * @author Anthony
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Envelope {
	private Metadata metadata;
	private Object result;
	
	/**
	 * Envelope constructor for unsuccessful requests returning only meta data response
	 * @param errorType
	 * @param code
	 * @param errorMessage
	 */
	public Envelope(String errorType, int code, String errorMessage) {
		metadata = new Metadata(errorType, code, errorMessage);
	}
	
	/**
	 * Envelope to return only the HTTP status code
	 * @param code
	 */
	public Envelope(int code) {
		metadata = new Metadata(code);
	}
	
	/**
	 * Envelope constructor for successful requests
	 * @param code
	 * @param result
	 */
	public Envelope(int code, Object result) {
		metadata = new Metadata(code);
		this.result = result;
	}
	
	public Metadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	public Object getResult() {
		return result;
	}
	
	public void setResult(List<Object> result) {
		this.result = result;
	}
}
