import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetMethod {
    private static String url = "http://www.google.com/search?q=mkyong";
    private static int responseCode;
    private static String inputLine;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        HttpGetMethod.url = url;
    }

    public static int getResponseCode() {
        return responseCode;
    }

    public static void setResponseCode(int responseCode) {
        HttpGetMethod.responseCode = responseCode;
    }

    public static String getInputLine() {
        return inputLine;
    }

    public static void setInputLine(String inputLine) {
        HttpGetMethod.inputLine = inputLine;
    }

    public static boolean sendGet(String USER_AGENT) throws IOException {
//        Init 1 object URL from url config
        URL obj = new URL(url);
//        Tạo kết nối bằng object HttpURLConnection
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        Chọn method get
        con.setRequestMethod("GET");
//        Cấu hình client sử dụng bằng 1 string, ở đây dùng morila
        con.setRequestProperty("User-Agent",USER_AGENT);
//        Lấy kết quả trả về mã int. Ví dụ thành công: 200
        responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
//        Đọc responese trả về
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Response nhận được là : " + "\n" + response.toString());
        return true;
    }
}
