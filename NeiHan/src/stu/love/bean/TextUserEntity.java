package stu.love.bean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 格式化：
 *  "user": {
                    "avatar_url": "http://p2.pstatp.com/thumb/953/2658476120",
                    "user_id": 1791732391,
                    "name": "随遇而安",
                    "user_verified": false
                },
 * 
 * */

public class TextUserEntity {
	
//	个人头像
	private String avatarUrl;
	
//	用户的ID
	private long userId;
	
//	用户名称（昵称）
	private String name;
	
//	用户的 验证信息。
	private boolean userVerified;

	public void pareJson(JSONObject json) throws JSONException
	{
		if(json != null)
		{
			avatarUrl = json.getString("avatar_url");
			userId = json.getLong("user_id");
			name = json.getString("name");
			userVerified = json.getBoolean("user_verified");
		}
	}

}
