package stu.love.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 
 *  图片类表的信息
 * 
 * */
public class ImageUrlList {

	private List<String> largeImageUrls;
	private String uri;
	private String width;
	private String height;

	public void pareJson(JSONObject largerImage) throws JSONException
	{
		largeImageUrls = parseImageUrlList(largerImage);
		uri = largerImage.getString("uri");
		width = largerImage.getString("width");
		height = largerImage.getString("height");
	}
	
	// 重构提取方法
	private List<String> parseImageUrlList(JSONObject largerImage) throws JSONException {
			
			JSONArray url_list = largerImage.getJSONArray("url_list");
			
			List<String> largeImageUils = new LinkedList<String>();
			int ulen = url_list.length();
			for (int i = 0; i < ulen; i++) {
				JSONObject url = url_list.getJSONObject(i);
				String urls = url.getString("url");
				largeImageUils.add(urls);
			}

			return largeImageUils;
	}

	public List<String> getLargeImageUrls() {
		return largeImageUrls;
	}

	public void setLargeImageUrls(List<String> largeImageUrls) {
		this.largeImageUrls = largeImageUrls;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	
}
