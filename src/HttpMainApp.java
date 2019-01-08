import java.io.IOException;

public class HttpMainApp {
    private static final String USER_AGENT = "Mozilla/5.0";
    public static void main(String[] args) throws IOException {
        HttpGetMethod httpGetMethod = new HttpGetMethod();
        System.out.println("Test send get request ");
        boolean checkSendGet = httpGetMethod.sendGet(USER_AGENT);
        if (checkSendGet) {
            System.out.println("Test send get request done");
        }

        HttpPostMethod httpPostMethod = new HttpPostMethod();
        System.out.println("Test send post requset");
        httpPostMethod.sendPost(USER_AGENT);
    }
}
