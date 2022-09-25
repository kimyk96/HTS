package com.hts.market.global.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Slf4j
public class ChatSocketHandler extends TextWebSocketHandler {
//	private List<MembersEntity> list = new Vector<>();
//	@Override
//	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getSession().equals(session))
//				list.remove(i);
//		}
//	}
//	@Override
//	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		System.out.println(session.getId());
//		list.add(new MembersEntity(session.getPrincipal().getName(), session));
//	}
//	@Override
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		for(MembersEntity user:list) {
//			TextMessage msg = new TextMessage(user.getId() + ":" +  message.getPayload());
//			user.getSession().sendMessage(msg);
//		}
//	}
}
