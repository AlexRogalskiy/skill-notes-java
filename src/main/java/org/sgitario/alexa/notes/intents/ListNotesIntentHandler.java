package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class ListNotesIntentHandler extends BaseRequestHandler {

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return intentName("ListNotesIntent").or(intentName("AMAZON.NextIntent"))
				.or(intentName("AMAZON.MoreIntent"));
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		List<String> list = input.getUserNotes();
		if (list.isEmpty()) {
			return "No tiene ninguna nota";
		}

		int currentPosition = input.getNotePosition() + 1;
		if (currentPosition >= list.size()) {
			return "No hay más notas";
		}

		input.setNotePositionAt(currentPosition);
		return list.get(currentPosition);
	}

}
