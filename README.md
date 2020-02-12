# tmobile

This repository is for crawling the url for a specified depth. 

1. Code is implenented as per the requirement.
2. MOngodb is used as a persistent store.
3. Failiure retry is not included but it can be done with an inclusion of a failed attemtps in crawlresponse collection and a config wihich will decide till how many attempts we can allow. this wil be taken care by scheduler.
4. Rest endpoints are created as per the requirement
5. A scheduler is created to pick the submitted, failed jobs and perform the required action on them.
6. Code is documented.
7. application.yml is not used extensivley but hard coded config can be put up there and used based on profile.
8. Could not put more time on the testcase as I had a prod issue(app recently went live) and had to call it done from my side. However, updatin and enhancements can be done.

Assumptions:

1. robots.txt file is not scanned. 
2. no check for invalid urls.
3. url in javascript with div click events or on elements


Note: We can discuss if anything you are looking for is missed.
