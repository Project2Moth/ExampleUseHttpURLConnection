import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostMethod {
    private String url = "https://selfsolve.apple.com/wcResults.do";
    private String urlParameter = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
    private int responseCode;
    private String inputLine;

    public void sendPost(String USER_AGENT) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Gent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameter);
        wr.flush();
        wr.close();
        responseCode = con.getResponseCode();
        System.out.println("\nSending POST request to URL : " + url);
        System.out.println("Post parameters : " + urlParameter);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

    }
}
