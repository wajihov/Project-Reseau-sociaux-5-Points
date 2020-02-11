package com.fivePoints.Socket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivePoints.Socket.entities.Conversation;

@Repository("conversationrepository")
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

}
