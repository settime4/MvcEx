package aaa.rest.naver;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NaverBookSearchController {

	@RequestMapping("naver/book/search")
	public String toSearch(){
		return "search";
	}
	
	@RequestMapping(value = "naver/book/search", method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getBooks(@RequestParam String keyword) throws ClientProtocolException, IOException, ParseException, JSONException {
		String clientId = "3EDJn540XVPgotpxpDxp";
		 String clientSecret = "yOWKPHxUe8";
		 String url = "https://openapi.naver.com/v1/search/book.xml?query="+keyword;
		 
		 HttpClient client = HttpClientBuilder.create().build();
		 HttpGet request = new HttpGet(url);
		 
		 request.addHeader("X-Naver-Client-Id", clientId);
		 request.addHeader("X-Naver-Client-Secret", clientSecret);
		 HttpResponse response = client.execute(request);
		 
		 String xml = EntityUtils.toString(response.getEntity());
		 String json = xml2json(xml);
		 System.out.println(json);
		 return json;
	}
	
	public String xml2json(String xml) throws JSONException{
		int PRETTY_PRING_INDENT_FACTOR = 4;
		String json="";
		JSONObject jsonObject = XML.toJSONObject(xml);
		json = jsonObject.toString(PRETTY_PRING_INDENT_FACTOR);
		return json;
	}
}
