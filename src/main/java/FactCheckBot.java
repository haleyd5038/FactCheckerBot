import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.*;

import java.io.IOException;

public class FactCheckBot extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        JDABuilder builder = JDABuilder.createDefault("bot_token");
        JDA jda = builder.build();
        jda.addEventListener(new FactCheckBot());
    }

    public void onMessageRecieved(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith("!factcheck")) {
            String query = event.getMessage().getContentRaw().substring("!factcheck".length()).trim();
            String result = factCheck(query);
            event.getChannel().sendMessage(result).queue();
        }
    }
    private static String factCheck(String query) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("api_key")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer YOUR_API_KEY")
                .post(RequestBody.create(MediaType.get("application/json"), "{\"prompt\":\"" + query + "\",\"max_tokens\":10}"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while fact checking:" + e.getMessage();
        }
    }
    }
