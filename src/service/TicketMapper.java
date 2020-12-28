package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import domain.Ticket;
import domain.TicketField;

public class TicketMapper {
	
	public static final String FILE_NAME = "data\\tickets.json";
	
	/**
	 * Map data of Ticket from Json Array to List Ticket
	 * @param ticketsJson
	 * @return
	 */
	public static List<Ticket> map(JSONArray ticketsJson) {
		List<Ticket> result = new ArrayList<>();
		Iterator<JSONObject> iterator = ticketsJson.iterator();
		while(iterator.hasNext()) {
			JSONObject ticketJson = iterator.next();
			Ticket ticket = new Ticket();
			
			ticket.setId((String) ticketJson.get(TicketField.ID.getValue()));
			ticket.setUrl((String) ticketJson.get(TicketField.URL.getValue()));
			ticket.setExternalId((String) ticketJson.get(TicketField.EXTERNAL_ID.getValue()));
			ticket.setCreatedAt((String) ticketJson.get(TicketField.CREATED_AT.getValue()));
			ticket.setType((String) ticketJson.get(TicketField.TYPE.getValue()));
			ticket.setSubject((String) ticketJson.get(TicketField.SUBJECT.getValue()));
			ticket.setDescription((String) ticketJson.get(TicketField.DESCRIPTION.getValue()));
			ticket.setPriority((String) ticketJson.get(TicketField.PRIORITY.getValue()));
			ticket.setStatus((String) ticketJson.get(TicketField.STATUS.getValue()));
			
			JSONArray tags = (JSONArray) ticketJson.get(TicketField.TAGS.getValue());
			ticket.setTags(mapToStrings(tags));
			
			ticket.setHasIncidents((Boolean) ticketJson.get(TicketField.HAS_INCIDENTS.getValue()));
			ticket.setDueAt((String) ticketJson.get(TicketField.DUE_AT.getValue()));
			ticket.setVia((String) ticketJson.get(TicketField.VIA.getValue()));
			ticket.setSubmitterId((Long) ticketJson.get(TicketField.SUBMITTER_ID.getValue()));
			ticket.setAssigneeId((Long) ticketJson.get(TicketField.ASSIGNEE_ID.getValue()));
			ticket.setOrganizationId((Long) ticketJson.get(TicketField.ORGANIZATION_ID.getValue()));
			
			ticket.buildFullText();
			
			result.add(ticket);
		}
		
		return result;
	}
	
	private static List<String> mapToStrings(JSONArray stringsJson){
		List<String> result = new ArrayList<>();
		Iterator<String> iterator = stringsJson.iterator();
		while(iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return result;
	}

}
