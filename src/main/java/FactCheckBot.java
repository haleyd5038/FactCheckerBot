import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.*;

import java.io.IOException;

public class FactCheckBot extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        JDABuilder builder = JDABuilder.createDefault("MTA2MzkyMjc3NDc1OTk3NzA2MA.GS_d_h.Ju4E9QZJnm2tjLDBdMt6hCu2OyledKBfTVubrg");
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
                .url("https://api.openai.com/v1/engines/davinci/completions")
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
