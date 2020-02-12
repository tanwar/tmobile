package com.tanwar.tmobiletest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tanwar.tmobiletest.model.WebCrawledElements;

/**
 * CrawlElementsMongoRepository class manages web crawl elements collection.
 * @author tanwar
 *
 */
@Repository
public interface CrawlElementsMongoRepository extends MongoRepository<WebCrawledElements, String> {
	
}

