package stu.love.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * <pre>
 * 评论 接口 返回的  data 数据部分。
 * 
 * 包含了 top_comments
 * recent_comments 两个数组！
 * 
 * JSON格式如下：<br/>
 * 
 * "data": {
        "recent_comments": [], 
        "top_comments": []
    }
 * </pre>
 * */
public class CommentList {
	
	private List<CommentEntity> topComment;
	private List<CommentEntity> recentComment;
	
	private long groupId;
	private int totalMunber;
	private boolean hasMore;
	
	public void pareJson(JSONObject json) throws JSONException
	{
		if(json!= null)
		{
			groupId = json.getLong("group_id");
			totalMunber = json.getInt("total_number");
			hasMore = json.getBoolean("has_more");
			
			JSONObject data = json.getJSONObject("data");
			
//			数据
			JSONArray top= data.optJSONArray("top_comments");
			if(top!= null)
			{
				topComment = new ArrayList<CommentEntity>();
				int len = top.length();
				if(len>0)
				{
					for(int index=0;index<len;index++)
					{
						JSONObject obj = top.getJSONObject(index);
						CommentEntity comm = new CommentEntity();
						comm.pareJson(obj);
						topComment.add(comm);
					}
				}
			}
			
//			真是的数据
			JSONArray recent = data.optJSONArray("recent_comments");
			if(recent!= null)
			{
				recentComment = new ArrayList<CommentEntity>();
				int len = recent.length();
				if(len>0)
				{
					for(int index=0;index<len;index++)
					{
						JSONObject obj = recent.getJSONObject(index);
						CommentEntity comm = new CommentEntity();
						comm.pareJson(obj);
						recentComment.add(comm);
					}
				}
			}
			
		}

	}

	public List<CommentEntity> getTopComment() {
		return topComment;
	}

	public List<CommentEntity> getRecentComment() {
		return recentComment;
	}

	public long getGroupId() {
		return groupId;
	}

	public int getTotalMunber() {
		return totalMunber;
	}

	public boolean isHasMore() {
		return hasMore;
	}
	

}
