package stu.love.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * 图片的 实体类：
 * 
 * 对于代码的重构的使用.
 * 
 * 
 * */
public class ImageBean extends TextEntity{

	private ImageUrlList largeList;
	private ImageUrlList midelList;

	public void ParseJson(JSONObject item) throws JSONException
	{
		super.pareJson(item);
		
		type = item.getInt("type");
		JSONObject group = item.getJSONObject("group");
		commentCount = group.getInt("comment_count");
		JSONObject largerImage = group.getJSONObject("large_image");
		JSONObject midelImage = group.getJSONObject("middle_image");
		groupId = group.getLong("group_id");
		content = group.getString("content");
		
//		urls 图片的url 
		largeList = new ImageUrlList();
		largeList.pareJson(largerImage);
		midelList = new ImageUrlList();
		midelList.pareJson(midelImage);
		
	}

	public ImageUrlList getLargeList() {
		return largeList;
	}

	public ImageUrlList getMidelList() {
		return midelList;
	}

	
	
	
	
}
