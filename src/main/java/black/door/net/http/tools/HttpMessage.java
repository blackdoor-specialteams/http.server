package black.door.net.http.tools;

/**
 * Created by nfischer on 6/10/15.
 */
public interface HttpMessage {
    byte[] getBody();
    String getVersion();
    black.door.net.http.tools.HttpMessage putHeader(String headerName, String value);
    String getHeader(String headerName);
}
