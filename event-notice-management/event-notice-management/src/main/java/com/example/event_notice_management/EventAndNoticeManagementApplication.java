package com.example.event_notice_management;

import org.springframework.ai.autoconfigure.vectorstore.mongo.MongoDBAtlasVectorStoreAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventAndNoticeManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(EventAndNoticeManagementApplication.class, args);
	}

}
