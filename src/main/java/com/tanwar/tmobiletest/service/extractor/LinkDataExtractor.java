package com.tanwar.tmobiletest.service.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tanwar.tmobiletest.model.LinkType;
import com.tanwar.tmobiletest.model.SiteData;

public class LinkDataExtractor implements DataExtractor {
	
	private final static Pattern LINK_PATTERN = Pattern.compile("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", Pattern.CASE_INSENSITIVE);

	@Override
	public SiteData getLinkDetails(String line) {
		SiteData data = new SiteData();

		Matcher matcher = LINK_PATTERN.matcher(line);
		if (matcher.find()) {
			data.setLink(matcher.group(1).trim());
		}
		data.setLinkType(LinkType.LINK);
		return data;
	}

}
