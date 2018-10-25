package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class NewNoteIntentHandler extends BaseRequestHandler {

	public static final String NEW_NOTE = "note";

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return intentName("NewNoteIntent");
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		input.getSlot(NEW_NOTE).ifPresent(input::addUserNote);
		return "Guardado";
	}

}
