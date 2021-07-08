package com.example.demo.DBConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configurable
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getProperty("spring.data.mongodb.database");
	}

	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString(env.getProperty("spring.data.mongodb.uri"));
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), env.getProperty("spring.data.mongodb.database"));
	}

//	@Bean
//	public MongoDbFactory mongoDbFactory() {
//		return new SimpleMongoDbFactory(new MongoClientURI(env.getProperty("spring.data.mongodb.uri")));
//	}
//
//	@Bean
//	public MongoTemplate mongoTemplate() {
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//		return mongoTemplate;
//
//	}

}
