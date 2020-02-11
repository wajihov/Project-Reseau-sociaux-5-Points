package com.fivePoints.Socket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fivePoints.Socket.entities.Message;

@Repository("messagerepository")
public interface MessageRepository extends JpaRepository<Message, Long> {

}
