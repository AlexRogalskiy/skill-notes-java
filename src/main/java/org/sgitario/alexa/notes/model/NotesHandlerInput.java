package org.sgitario.alexa.notes.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;

public class NotesHandlerInput {

	public static final String LIST = "list";
	private static final String NOTE_POSITION = "noteCurrentPos";

	private final HandlerInput input;

	public NotesHandlerInput(HandlerInput input) {
		this.input = input;
	}

	public Optional<String> getSlot(String key) {
		String value = null;
		Request request = input.getRequestEnvelope().getRequest();
		if (request instanceof IntentRequest) {
			IntentRequest intentRequest = (IntentRequest) request;
			value = intentRequest.getIntent().getSlots().get(key).getValue();
		}

		return Optional.ofNullable(value);
	}

	@SuppressWarnings("unchecked")
	public List<String> getUserNotes() {
		Map<String, Object> userData = input.getAttributesManager()
				.getPersistentAttributes();
		return (List<String>) userData.computeIfAbsent(LIST,
				k -> new LinkedList<>());
	}

	public void addUserNote(String newNote) {
		getUserNotes().add(newNote);
		persistAttributes();
	}

	public void setNotePositionAt(int pos) {
		input.getAttributesManager().getSessionAttributes().put(NOTE_POSITION,
				pos);
	}

	public int getNotePosition() {
		Map<String, Object> sessionData = input.getAttributesManager()
				.getSessionAttributes();
		return Optional.ofNullable(sessionData.get(NOTE_POSITION))
				.map(v -> (Integer) v).orElse(-1);
	}

	private void persistAttributes() {
		input.getAttributesManager().savePersistentAttributes();
	}

}
