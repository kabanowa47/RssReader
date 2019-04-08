import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;

public class RssEngine {

    public String readRSS(String urlAddress) {
        try {
            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("<title>")) {
                    int firstPos = line.indexOf("<title>");
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0, lastPos);
                    sourceCode += temp + "\n";
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            System.out.println("Malformed URL");
        } catch (IOException ioe) {
            System.out.println("Sth wrong with reading the contents");
        }
        return "";
    }
}

