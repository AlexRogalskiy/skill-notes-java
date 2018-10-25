package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class CancelandStopIntentHandler extends BaseRequestHandler {

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return intentName("AMAZON.StopIntent")
				.or(intentName("AMAZON.CancelIntent"))
				.or(intentName("AMAZON.NoIntent"));
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		return "Adiós";
	}
}
