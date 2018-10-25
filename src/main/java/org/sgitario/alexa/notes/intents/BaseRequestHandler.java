package org.sgitario.alexa.notes.intents;

import java.util.Optional;
import java.util.function.Predicate;

import org.sgitario.alexa.notes.model.NotesHandlerInput;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

public abstract class BaseRequestHandler implements RequestHandler {

	protected abstract String handleInput(NotesHandlerInput input);

	protected abstract Predicate<HandlerInput> canHandle();

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(canHandle());
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText = handleInput(new NotesHandlerInput(input));
		return input.getResponseBuilder().withSpeech(speechText)
				.withSimpleCard("Notes", speechText).withReprompt(speechText)
				.build();
	}

}
