package com.tanwar.tmobiletest.configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mongodb.MongoClient;
import com.tanwar.tmobiletest.service.extractor.DataExtractor;
import com.tanwar.tmobiletest.service.extractor.ImageDataExtractor;
import com.tanwar.tmobiletest.service.extractor.LinkDataExtractor;
import com.tanwar.tmobiletest.service.extractor.TitleDataExtractor;

@Configuration
@EnableMongoRepositories(basePackages = "com.tanwar.tmobiletest.repository")
@EnableAsync
@EnableScheduling
public class TMobileConfiguration {

	@Bean
	public MongoClient mongo() {
		return new MongoClient("localhost");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "crawl");
	}
	
	@Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
		return Executors.newFixedThreadPool(10);
    }
	
	@Bean
	public List<DataExtractor> extrators(){
		LinkedList<DataExtractor> dataExtractors = new LinkedList<>();
		dataExtractors.add(new TitleDataExtractor());
		dataExtractors.add(new LinkDataExtractor());
		dataExtractors.add(new ImageDataExtractor());
		return dataExtractors;
	}

}
