import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.*;

import java.io.IOException;
import java.net.URL;

public class FactCheckBot extends ListenerAdapter {
//    public static void main(String[] args) throws Exception {
//        JDABuilder builder = JDABuilder.createDefault("MTA2MzkyMjc3NDc1OTk3NzA2MA.G523mq.j5RR3ptsx5VOtrryrlTLvJ5QebT1jkA-d1f-xI");
//        JDA jda = builder.build();
//        jda.addEventListener(new FactCheckBot());
//    }
//
//    public void onMessageRecieved(MessageReceivedEvent event) throws IOException {
//        if (event.getMessage().getContentRaw().startsWith("!factcheck")) {
//            String query = event.getMessage().getContentRaw().substring("!factcheck".length()).trim();
//            String result = run(String.valueOf(query));
//            event.getChannel().sendMessage(result).queue();
//        }
//    }


    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();

    }

        run("http://placekitten.com/200/300");
//    private static String factCheck(String query) {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.openai.com/v1/engines/davinci/completions")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", "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")
//                .get().build();
//
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "An error occurred while fact checking:" + e.getMessage();
//        }
    }
    }
