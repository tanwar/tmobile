package com.tanwar.tmobiletest.service.extractor;

import com.tanwar.tmobiletest.model.SiteData;

public interface DataExtractor {
	
	SiteData getLinkDetails(String url);

}
