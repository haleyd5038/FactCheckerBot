import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class search extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();

        if (event.getAuthor().isBot())
            return;

        if (msg.equalsIgnoreCase("!hi")) {
            event.getChannel()
                    .sendMessage("Hello there!").queue();
        }
    }
}
