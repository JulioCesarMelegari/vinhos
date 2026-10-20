package com.jcm.catalogo.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcm.catalogo.config.VinhoToolsConfig;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vinhos")
@Tag(name = "Sommelier Virtual", description = "Chatbot com memória para recomendação de vinhos")
@CrossOrigin(origins = "*") // Permite que seu frontend acesse o backend
public class SommelierController {

    private final ChatClient chatClient;
    private final VinhoToolsConfig vinhoToolsConfig;

    public SommelierController(ChatClient.Builder chatClientBuilder, ChatMemory chatMemory, VinhoToolsConfig vinhoToolsConfig) {
        this.vinhoToolsConfig = vinhoToolsConfig;
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                    Você é um Sommelier Virtual especialista da nossa loja de vinhos.
                    Sempre que o cliente pedir recomendações ou perguntar se temos um vinho, use a função
                    'consultarCatalogoDeVinhos' para verificar o que está realmente disponível no banco de dados.
                    Responda listando os nomes e os preços reais retornados pela função.Ao buscar vinhos por origem, 
                    lembre-se de adaptar termos como 'chileno' para 'Chile', 'argentino' para 'Argentina' ou 'português' para 'Portugal' 
                    ao acionar a ferramenta de busca.
                """)
                // FIX: Alterado de PromptChatMemoryAdvisor para MessageChatMemoryAdvisor
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("/chat")
    public String conversar(
            @RequestParam String mensagem,
            @RequestParam(value = "sessionId", defaultValue = "default-user") String sessionId) {

        return this.chatClient.prompt()
        		.tools(vinhoToolsConfig)
                .user(mensagem)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, sessionId))
                .call()
                .content();
    }
}
