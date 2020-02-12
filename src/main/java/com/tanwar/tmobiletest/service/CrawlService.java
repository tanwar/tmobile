package com.tanwar.tmobiletest.service;

import com.tanwar.tmobiletest.model.CrawlRequest;
import com.tanwar.tmobiletest.model.CrawlResponse;
import com.tanwar.tmobiletest.model.WebCrawledElements;

/**
 * CrawlService interface exposes the behaviour for working on the crawls.
 * @author tanwar
 *
 */
public interface CrawlService {
	
	/**
	 * Method to define the behaviour for accepting crawl request.
	 * @param crawlRequest
	 * @return
	 */
	CrawlResponse crawlWeb(final CrawlRequest crawlRequest);
	
	/**
	 * Method to define the behaviour for getting crawl request status.
	 * @param crawlRequestToken
	 * @return
	 */
	CrawlResponse getCrawlWebStatus(final String crawlRequestToken);
	
	/**
	 * Method to define the behaviour for getting the crawl request result.
	 * @param crawlRequestToken
	 * @return
	 */
	WebCrawledElements getCrawlWebResults(final String crawlRequestToken);

}
