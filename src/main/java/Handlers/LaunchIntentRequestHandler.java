package Handlers;

import Utils.Util;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static Utils.Util.getSimpleResponse;
import static com.amazon.ask.request.Predicates.requestType;

public class LaunchIntentRequestHandler implements RequestHandler
{
    @Override
    public boolean canHandle(HandlerInput input)
    {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input)
    {
        if (Util.supportsApl(input))
        {
            String message = "Hi, welcome to not touch keyboard. I'm a programming designer. " +
                    "And also i'm a first version of not touch keyboard. " +
                    "In this first i'm creating only web applications. " +
                    "My assistants are working hard to build advance things to create a type of applications. " +
                    "Okay now say your bucket name, file name and file format to get your access key and secret key. " +
                    "If you don't know the access key and secret key goto your aws iam console. " +
                    "And create user with give permission to access the storage. " +
                    "And after that get the access key and secret key. " +
                    "And goto your local computer and paste your keys in the note pad with the name access key and secret key. " +
                    "And after that take screenshot of that note pad window. " +
                    "After that goto your aws storage and upload the screenshot image into storage and also give public permission to access the screenshot. " +
                    "And come here, and say the bucket name, file name and file format of the screenshot. " +
                    "Why i want your keys?. " +
                    "Answer is to store application files. " +
                    "Okay now say the bucket name, file name and file format of your screenshot. " +
                    "Example bucket name screenshots file name keys file format png.";

            String rePrompt =  "Okay now say the bucket name, file name and file format of your screenshot. " +
                    "Example bucket name screenshots file name keys file format png.";

            String title = "welcome!";

            Map<String,Object> session = new HashMap<>();

            session.put("repeat_message",message);
            session.put("repeat_re_prompt_message",rePrompt);

            return getSimpleResponse(input,title,message,message,rePrompt,session);
        }
        else
        {
            return input.getResponseBuilder()
                    .withSpeech(Util.unSupportDeviceFallbackMessage)
                    .build();
        }
    }
}
