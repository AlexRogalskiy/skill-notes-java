package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class HelpIntentHandler extends BaseRequestHandler {

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return intentName("AMAZON.HelpIntent");
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		return "Puedo guardar tus notas. Prueba a decir, guarda, y seguidamente, esta nueva nota.";
	}

}