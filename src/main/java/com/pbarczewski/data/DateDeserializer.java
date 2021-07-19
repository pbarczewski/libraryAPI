package com.pbarczewski.data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserializer extends JsonDeserializer<Long> {

	@Override
	public Long deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Date date;
		long unixTime = 0;
		if (parser != null) {
			String publishDate = parser.getText();
			List<String> formatStrings = Arrays.asList("yyyy", "yyyy-mm", "yyyy-mm-dd");
			for (String formatString : formatStrings) {
				try {
					date = new SimpleDateFormat(formatString).parse(publishDate);
					unixTime = (long) date.getTime();
					break;
				}  catch (java.text.ParseException e) {
					e.printStackTrace();
				}
			}
			return unixTime;
		} else {
			return null;
		}
	}
}
