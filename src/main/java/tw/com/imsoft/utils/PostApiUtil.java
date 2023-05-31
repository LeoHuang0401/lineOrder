package tw.com.imsoft.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class PostApiUtil {

    public static JsonNode sendPost(String channelId,String nonce, String signature,String httpsUrl,String mapperData) {
        RestTemplate restTemplate = new RestTemplate();
//      Post Headers 設定
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-LINE-ChannelId", channelId);
        headers.add("X-LINE-Authorization-Nonce", nonce);
        headers.add("X-LINE-Authorization", signature);
        HttpEntity<String> request = new HttpEntity<String>(mapperData, headers);
        String responsebody = restTemplate.postForObject(httpsUrl, request,String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = null;
        try {
            json = mapper.readTree(responsebody);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
