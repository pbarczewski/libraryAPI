package com.pbarczewski.customSerialization;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
/**
 * This is a specific class contains a method which deserialize a JSON property. 
 * @author Patryk Barczewski
 * @version 0.0.1-SNAPSHOT 05/05/2019
 */
public class DeserializeDate extends JsonDeserializer<Long> {

	/**
	 * The method takes the <code>Date</code> format and returns the <code>long</code> value. 
	 * Supports three types of date formats
	 * @throws ParseException
	 */
	@Override
	public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		Date date;
		long unixTime = 0;
		if(p != null) {
		String publishDate = p.getText();
		List<String> formatStrings = Arrays.asList("yyyy", "yyyy-mm", "yyyy-mm-dd");
		for (String formatString : formatStrings) {
			try {
				date = new SimpleDateFormat(formatString).parse(publishDate);
				unixTime = (long) date.getTime();
				break;
			} catch (ParseException e) {
				return null;
			}
		}
		return unixTime;
		} else {
			return null;
		}
	}

}