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
    private String token = "MTA2MzkyMjc3NDc1OTk3NzA2MA.GoULm3.NDRl20_15MOMP3BU8fEKFEB1yiCPxiZqJeZy78";

    public FactCheckBot() throws LoginException, InterruptedException {
        api = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES , GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new search()).build()
                .awaitReady();
    }

    public static void main(String[] args) throws LoginException, InterruptedException {
        new FactCheckBot();
    }
}