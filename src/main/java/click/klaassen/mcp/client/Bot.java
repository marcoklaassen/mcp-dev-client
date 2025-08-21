package click.klaassen.mcp.client;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService
@SessionScoped
public interface Bot {

    @SystemMessage("""
            You have tools to interact with the weather forecast systems and the users
            will ask you questions about the weather in different locations.

            If the user asks, tell them you have access to a tool server
            via the Model Context Protocol (MCP) and that they can find more
            information about it on https://modelcontextprotocol.io/.
            """
    )
    String chat(@UserMessage String question);
}