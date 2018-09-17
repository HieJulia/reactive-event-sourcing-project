package com.project.chatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatserviceApplication.class, args);
	}

	@Bean
	public UnicastProcessor<Event> eventPublisher(){
		return UnicastProcessor.create();
	}

	@Bean
	public Flux<Event> events(UnicastProcessor<Event> eventPublisher) {
		return eventPublisher
				.replay(25)
				.autoConnect();
	}

	@Bean
	public RouterFunction<ServerResponse> routes(){
		return RouterFunctions.route(
				GET("/"),
				request -> ServerResponse.ok().body(BodyInserters.fromResource(new ClassPathResource("public/index.html")))
		);
	}

	@Bean
	public HandlerMapping webSocketMapping(UnicastProcessor<Event> eventPublisher, Flux<Event> events) {
		Map<String, Object> map = new HashMap<>();
		map.put("/websocket/chat", new ChatSocketHandler(eventPublisher, events));
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		simpleUrlHandlerMapping.setUrlMap(map);

		//Without the order things break :-/
		simpleUrlHandlerMapping.setOrder(10);
		return simpleUrlHandlerMapping;
	}

	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		return new WebSocketHandlerAdapter();
	}

	@Bean
	public UserStats userStats(Flux<Event> events, UnicastProcessor eventPublisher){
		return new UserStats(events, eventPublisher);
	}
}
