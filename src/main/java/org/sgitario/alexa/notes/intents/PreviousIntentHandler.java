package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class PreviousIntentHandler extends BaseRequestHandler {

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return intentName("AMAZON.PreviousIntent");
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		List<String> list = input.getUserNotes();
		if (list.isEmpty()) {
			return "No tiene ninguna nota";
		}

		int currentPosition = input.getNotePosition();
		if (currentPosition < 0) {
			return "No hay ninguna nota anterior";
		}

		String previousNote = list.get(currentPosition);
		input.setNotePositionAt(--currentPosition);
		return previousNote;
	}

}
