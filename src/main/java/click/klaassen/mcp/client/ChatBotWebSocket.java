package click.klaassen.mcp.client;

import io.quarkus.websockets.next.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;
import io.smallrye.common.annotation.Blocking;

@WebSocket(path = "/chatbot")
public class ChatBotWebSocket {

    private final Bot bot;

    public ChatBotWebSocket(Bot bot) {
        this.bot = bot;
    }

    @OnOpen
    public String onOpen() {
        return "Hello, I am a weather forecast robot, how can I help?";
    }

    @OnTextMessage
    @Blocking
    public String onMessage(String message) {
        return bot.chat(message);
    }

}