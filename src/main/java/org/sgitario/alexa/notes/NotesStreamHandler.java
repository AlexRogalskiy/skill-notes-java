package org.sgitario.alexa.notes;

import org.sgitario.alexa.notes.intents.CancelandStopIntentHandler;
import org.sgitario.alexa.notes.intents.HelpIntentHandler;
import org.sgitario.alexa.notes.intents.LaunchRequestHandler;
import org.sgitario.alexa.notes.intents.ListNotesIntentHandler;
import org.sgitario.alexa.notes.intents.NewNoteIntentHandler;
import org.sgitario.alexa.notes.intents.PreviousIntentHandler;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class NotesStreamHandler extends SkillStreamHandler {

	// @formatter:off
	public NotesStreamHandler() {
		super(Skills
				.standard()
					.withTableName("usernotes")
					.withDynamoDbClient(AmazonDynamoDBClientBuilder.defaultClient())
					.addRequestHandlers(new LaunchRequestHandler(),
							new NewNoteIntentHandler(),
							new HelpIntentHandler(),
							new CancelandStopIntentHandler(),
							new ListNotesIntentHandler(),
							new PreviousIntentHandler())
				.build());
	}
	// @formatter:on

}
