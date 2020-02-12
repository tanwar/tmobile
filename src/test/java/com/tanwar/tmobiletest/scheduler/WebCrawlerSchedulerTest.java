package com.tanwar.tmobiletest.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.tanwar.tmobiletest.model.CrawlResponse;
import com.tanwar.tmobiletest.model.CrawlStatus;
import com.tanwar.tmobiletest.repository.CrawlElementsMongoRepository;
import com.tanwar.tmobiletest.repository.CrawlMongoRepository;
import com.tanwar.tmobiletest.service.WebCrawlerService;
import com.tanwar.tmobiletest.service.reducer.WebCrawlerDataReducer;

public class WebCrawlerSchedulerTest {
	
	private WebCrawlerScheduler webCrawlerScheduler;
	
	@Mock
	private CrawlMongoRepository crawlMongoRepository;
	
	@Mock
	private CrawlElementsMongoRepository crawlElementsMongoRepository;

	@Mock
	private WebCrawlerService webCrawlerService;
	
	@Mock
	private WebCrawlerDataReducer webCrawlerDataReducer;
	
	@Before
	public void setup() {
		webCrawlerScheduler = new WebCrawlerScheduler();
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(webCrawlerScheduler, "crawlMongoRepository", crawlMongoRepository);
		ReflectionTestUtils.setField(webCrawlerScheduler, "crawlElementsMongoRepository", crawlElementsMongoRepository);
		ReflectionTestUtils.setField(webCrawlerScheduler, "webCrawlerService", webCrawlerService);
		ReflectionTestUtils.setField(webCrawlerScheduler, "webCrawlerDataReducer", webCrawlerDataReducer);
	}
	
	@Test
	public void shouldNotSaveWebCrawlResultsForNoSubmittedRequestFound() {
		List<String> requestStatus = new ArrayList<>();
		requestStatus.add(CrawlStatus.SUBMITTED.name());
		requestStatus.add(CrawlStatus.FAILED.name());
		List<CrawlResponse> crawlResponses = new ArrayList<>();
		webCrawlerScheduler.scheduleFixedRateTaskAsync();
		Mockito.when(crawlMongoRepository.findByStatusIn(requestStatus)).thenReturn(crawlResponses);
		CrawlResponse crawlResponse = new CrawlResponse();
		Mockito.verify(crawlMongoRepository, Mockito.times(0)).save(crawlResponse);
	}
	
	// like wise other testcases can be added. to test other cases.
	
	
	
	

}
