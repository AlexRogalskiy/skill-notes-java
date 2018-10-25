package org.sgitario.alexa.notes.intents;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.LaunchRequest;

public class LaunchRequestHandler extends BaseRequestHandler {

	@Override
	protected Predicate<HandlerInput> canHandle() {
		return requestType(LaunchRequest.class);
	}

	@Override
	protected String handleInput(NotesHandlerInput input) {
		return "Bienvenido a tu lista de notas";
	}

}
