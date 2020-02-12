package com.tanwar.tmobiletest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tanwar.tmobiletest.model.CrawlResponse;

/**
 * CrawlMongoRepository manages crawl response collection.
 * @author tanwar
 *
 */
@Repository
public interface CrawlMongoRepository extends MongoRepository<CrawlResponse, String> {
	List<CrawlResponse> findByStatusIn(List<String> status);
}