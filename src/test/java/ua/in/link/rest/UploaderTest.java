package ua.in.link.rest;

import org.junit.Test;
import ua.in.link.db.URLData;
import ua.in.link.rest.client.URLClient;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Uploader test.
 * User: b0noI
 * Date: 07.04.13
 * Time: 17:07
 */
public class UploaderTest {

    @Test
    public void testPostUrl() throws Exception {
        String fullUrl = "http://test144.in.ua";
        String shortUrl = URLClient.postUrlToRest(fullUrl);
        assertNotNull(shortUrl);
        URLClient.getFullUrl(shortUrl);
    }

    @Test
    public void testGetUrl() throws Exception {
        String fullUrl = "http://dateme222.in.ua";
        String shortUrl = URLClient.postUrlToRest(fullUrl);
        String fromServer = URLClient.getFullUrl(shortUrl);
        assertEquals("<html><head><meta HTTP-EQUIV=\"REFRESH\" content=\"0; url=http://dateme.in.ua\"></head></html>", fromServer);
    }

    @Test
    public void testStat() throws Exception {
        String fullUrl = "http://dateme222.in.ua";
        String shortUrl = URLClient.postUrlToRest(fullUrl);
        URLClient.getFullUrl(shortUrl);
        List<URLData.DataStat> stat = URLClient.getStat(shortUrl);
        assertNotNull(stat);
        assertNotSame(stat.size(), 0);
        String country = stat.get(stat.size() - 1).getCountry();
        assertEquals(country.equals(""), false);
    }

    @Test
    public void testPostNEWUrl() throws Exception {
        String fullUrl = "http://test14444.in.ua";
        String shortUrl = URLClient.postUrlToRest(fullUrl);
        assertNotNull(shortUrl);
        URLClient.getFullUrl(shortUrl);
    }

}
