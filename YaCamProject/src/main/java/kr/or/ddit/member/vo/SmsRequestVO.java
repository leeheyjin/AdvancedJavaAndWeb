package kr.or.ddit.member.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SmsRequestVO {
    private String type;
    private String contentType;
    private String countryCode;
    private String from;
    private String content;
    private List<MessagesDto> messages;
    

    public SmsRequestVO(String type, String contentType, String countryCode, String from, String content, List<MessagesDto> messages) {
        this.type = type;
        this.contentType = contentType;
        this.countryCode = countryCode;
        this.from = from;
        this.content = content;
        this.messages = messages;
    }
    
	public String toJsonString () {
    	    StringBuilder jsonBuilder = new StringBuilder();
    	    jsonBuilder.append("{");
    	    // content
    	    jsonBuilder.append("\"content\":\"").append(content).append("\",");
    	    // subject
    	    jsonBuilder.append("\"subject\":\"").append("").append("\",");
    	    // from
    	    jsonBuilder.append("\"from\":\"").append(from).append("\",");
    	    // countryCode
    	    jsonBuilder.append("\"countryCode\":\"").append(countryCode).append("\",");
    	    // messages
    	    jsonBuilder.append("\"messages\":[");
    	    for (int i = 0; i < messages.size(); i++) {
    	        MessagesDto message = messages.get(i);
    	        jsonBuilder.append("{")
    	                .append("\"to\":\"").append(message.getTo()).append("\"")
    	                .append("}");
    	        
    	        if (i < messages.size() - 1) {
    	            jsonBuilder.append(",");
    	        }
    	    }
    	    jsonBuilder.append("],");
    	    // type
    	    jsonBuilder.append("\"type\":\"").append("sms").append("\",");
    	    // contentType
    	    jsonBuilder.append("\"contentType\":\"").append("COMM").append("\"");
    	    jsonBuilder.append("}");
    	    return jsonBuilder.toString();
    }
    
    
    
    
}