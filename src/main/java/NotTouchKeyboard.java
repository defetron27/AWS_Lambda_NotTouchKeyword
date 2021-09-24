import Handlers.InsiderIntentRequestHandler;
import Handlers.LaunchIntentRequestHandler;
import Handlers.TagNameIntentRequestHandler;
import com.amazon.ask.AlexaSkill;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class NotTouchKeyboard extends SkillStreamHandler
{
    private static Skill getSkill()
    {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchIntentRequestHandler(),
                        new TagNameIntentRequestHandler(),
                        new InsiderIntentRequestHandler())
                .withSkillId("amzn1.ask.skill.20d30cf6-3775-4539-a5f6-6e90861defbc")
                .build();
    }

    public NotTouchKeyboard()
    {
        super(getSkill());
    }
}
