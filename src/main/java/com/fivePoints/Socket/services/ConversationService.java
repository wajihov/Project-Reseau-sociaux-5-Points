package com.fivePoints.Socket.services;

import javax.persistence.NoResultException;

import com.fivePoints.Socket.entities.Conversation;

public interface ConversationService {

	public Conversation getOneConversation(Long user1, Long user2) throws NoResultException;
}
