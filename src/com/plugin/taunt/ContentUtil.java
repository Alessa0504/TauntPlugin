package com.plugin.taunt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class ContentUtil {
    public static String getContent() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Map> entity = template.getForEntity("https://randomuser.me/api/", Map.class);   //获取请求的返回
        HttpStatus statusCode = entity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {   //获取成功
            Map body = entity.getBody();
            List results = (List) body.get("results");
            Map map = (Map) results.get(0);
            Map mapL = (Map) map.get("location");
            Map mapS = (Map) mapL.get("street");
            String name = (String) mapS.get("name");
            return name;
        }
        return null;
    }
}
