import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotMessaging extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String msg = event.getMessage().getContentRaw();
        String message = "Helloooo";
        if (event.getAuthor().isBot())
            return;

        if (msg.equals("!hi")) {
            event.getChannel()
                    .sendMessage(message).queue();
            System.out.print(message);
        }
    }
}
