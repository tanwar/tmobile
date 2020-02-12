package com.tanwar.tmobiletest.service.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tanwar.tmobiletest.model.LinkType;
import com.tanwar.tmobiletest.model.SiteData;

public class TitleDataExtractor implements DataExtractor {
	
	private final static Pattern LINK_PATTERN = Pattern.compile("<title>(.*?)<\\/title>", Pattern.CASE_INSENSITIVE);

	@Override
	public SiteData getLinkDetails(String line) {
		SiteData data = new SiteData();

		Matcher matcher = LINK_PATTERN.matcher(line);
		if (matcher.find()) {
			data.setLink(matcher.group(1).trim());
		}
		data.setLinkType(LinkType.TITLE);
		return data;
	}

}
