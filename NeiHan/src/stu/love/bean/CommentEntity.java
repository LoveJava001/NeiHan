package stu.love.bean;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * 一条评论的实体：
 * */
public class CommentEntity {
	
	private long uid;
	private String text;
	private long createTime;
	private int userDigg;
	private long id;
	private int userBury;
	private String userProfileUrl;
	private long userId;
	private int buryCount;
	private String description;
	private int diggCount;
	private boolean userVerified;
	private String platform;
	private String userName;
	private String userProfileImageUrl;

//	解析 一条评论的数据！
	public void pareJson(JSONObject json) throws JSONException
	{
		if(json!= null)
		{
			uid = json.getLong("uid");
			text = json.getString("text");
			createTime = json.getLong("create_time");
			userDigg = json.getInt("user_digg");
			id = json.getLong("id");
			userBury = json.getInt("user_bury");
			userProfileUrl = json.getString("user_profile_url");
			userId = json.getLong("user_id");
			buryCount = json.getInt("bury_count");
			description = json.getString("description");
			diggCount = json.getInt("digg_count");
			userVerified = json.getBoolean("user_verified");
			platform = json.getString("platform");
			userName = json.getString("user_name");
			userProfileImageUrl = json.getString("user_profile_image_url");
		}
	}
	
	

	public long getUid() {
		return uid;
	}

	public String getText() {
		return text;
	}

	public long getCreateTime() {
		return createTime;
	}

	public int getUserDigg() {
		return userDigg;
	}

	public long getId() {
		return id;
	}

	public int getUserBury() {
		return userBury;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public long getUserId() {
		return userId;
	}

	public int getBuryCount() {
		return buryCount;
	}

	public String getDescription() {
		return description;
	}

	public int getDiggCount() {
		return diggCount;
	}

	public boolean isUserVerified() {
		return userVerified;
	}

	public String getPlatform() {
		return platform;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}
	
	
}
