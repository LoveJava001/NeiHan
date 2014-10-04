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
public class ImageBean {
	
	private int type;
	private int commnetCount;
	private long group_id;
	private String content;
	private ImageUrlList largeList;
	private ImageUrlList midelList;

	public void ParseJson(JSONObject item) throws JSONException
	{
		type = item.getInt("type");
		JSONObject group = item.getJSONObject("group");
		commnetCount = group.getInt("comment_count");
		JSONObject largerImage = group.getJSONObject("large_image");
		JSONObject midelImage = group.getJSONObject("middle_image");
		group_id = group.getLong("group_id");
		content = group.getString("content");
		
//		urls 图片的url 
		largeList = new ImageUrlList();
		largeList.pareJson(largerImage);
		midelList = new ImageUrlList();
		midelList.pareJson(midelImage);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCommnetCount() {
		return commnetCount;
	}

	public void setCommnetCount(int commnetCount) {
		this.commnetCount = commnetCount;
	}

	public long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ImageUrlList getLargeList() {
		return largeList;
	}

	public void setLargeList(ImageUrlList largeList) {
		this.largeList = largeList;
	}

	public ImageUrlList getMidelList() {
		return midelList;
	}

	public void setMidelList(ImageUrlList midelList) {
		this.midelList = midelList;
	}
	
	
	
}
