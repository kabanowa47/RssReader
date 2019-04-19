import java.net.URL;

import it.sauronsoftware.feed4j.FeedParser;
import it.sauronsoftware.feed4j.bean.Feed;
import it.sauronsoftware.feed4j.bean.FeedHeader;
import it.sauronsoftware.feed4j.bean.FeedItem;

public class RssEngine {
    private String headerName = "***** HEADER *****";
    private String titleName = "Title: ";
    private String linkName = "Link: ";
    private String descriptionName = "Description: ";
    private String languageName = "Language: ";
    private String pubDateNme = "PubDate: ";
    private String itemsNAme = "*** ITEMS ***";
    private String plainTextDescriptionName = "Plain text description: ";
    private String htmlDescriptionName = "HTML description: ";


    public void rssEngine(String urlDefined) throws Exception {

        URL url = new URL(urlDefined);

        Feed feed = FeedParser.parse(url);

        FeedHeader header = feed.getHeader();

        System.out.println( headerName + "\n" +
                titleName + header.getTitle()+ "\n" +
                linkName + header.getLink() + "\n" +
                descriptionName + header.getDescription()+ "\n" +
                languageName + header.getLanguage() + "\n" +
                pubDateNme + header.getPubDate() + "\n" +
                itemsNAme);

        int items = feed.getItemCount();
        for (int i = 0; i < items; i++) {
            FeedItem item = feed.getItem(i);
            System.out.println(titleName + item.getTitle() + "\n" +
                    linkName + item.getLink() + "\n" +
                    plainTextDescriptionName + item.getDescriptionAsText() + "\n" +
                    htmlDescriptionName + item.getDescriptionAsHTML() + "\n" +
                    pubDateNme + item.getPubDate());
        }
    }
}

