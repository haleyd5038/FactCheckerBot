import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;


import javax.security.auth.login.LoginException;

import static net.dv8tion.jda.api.JDABuilder.createDefault;

public class FactCheckBot {

    private JDA api;
    private String token = "token";

    public FactCheckBot() throws LoginException, InterruptedException {
        api = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.DIRECT_MESSAGES)
                .enableIntents(GatewayIntent.getIntents(GatewayIntent.DEFAULT))
                .addEventListeners(new BotMessaging()).build()
                .awaitReady();
    }

    public static void main(String[] args) throws LoginException, InterruptedException {
        new FactCheckBot();
    }
}