package stu.love.bean;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * {
            "online_time": 1411872657,
            "display_time": 1411872657,
            "group": {
                "create_time": 1411365213,
                "favorite_count": 1641,
                "user_bury": 0,
                "user_favorite": 0,
                "bury_count": 2143,
                "share_url": "http://toutiao.com/group/3551461874/?iid=2337593504&app=joke_essay",//
                "label": 1,
                "content": "今天看到七岁的儿子在画画，画了一只小鸡，我问他:儿子，你这画的是什么啊？儿子说:我画的是老鹰捉小鸡。我问他:那鹰去哪了？儿子回:那英去参加中国好声音了。现在的孩子…",
                "comment_count": 111,
                "status": 3,
                "has_comments": 0,
                "go_detail_count": 944,
                "status_desc": "已发表到热门列表",
                "user": {
                    "avatar_url": "http://p2.pstatp.com/thumb/953/2658476120",
                    "user_id": 1791732391,
                    "name": "随遇而安",
                    "user_verified": false
                },
                "user_digg": 0,
                "group_id": 3551461874,
                "level": 4,
                "repin_count": 1641,
                "digg_count": 20001,
                "has_hot_comments": 1,
                "user_repin": 0,
                "category_id": 1
            },
            "comments": [],
            "type": 1//重要
        }*/

public class TextEntity {

	protected int type;//类型
	
	protected long createTime; //创建的时间
	
	protected int favoriteCount;//喜欢的个数
	
	protected int buryCount;//代表踩的个数
	
	/**
	 * 代表当前用户，是否踩了。 0 代表没有  1 带表踩了；
	 * */
	protected int userBury;
	
	/**
	 * 代表当前用户是否 点赞了！
	 */
	protected int userFavorite;
	
	protected String shareUrl; //用于第三方分享提交的网址。
	
	//TODO 分析这个字段的含义      TODO 是需要做的事情！
	protected int label;
	
	/**
	 * 文本段子的内容。
	 */
	protected String content;
	
	protected int commentCount;//评论的个数
	
	/**
	 * TODO 其中的状态值 3  需要分析 其含义！
	 */
	protected int status;// 状态
	
	/**
	 * 
	 * 状态描述的信息<br/>
	 * 可选值<br/>
	 * <ul>
	 * 		<li>
	 *			 "已发表到热门列表" 
	 *		</li> 
	 * </ul>
	 * 
	 */
	protected String statusDesc;//状态的描述信息
	
	protected int hasComments;//当前用户是否评论
	
	
	/**
	 * TODO 需要分析 go_detail_count 的含义：
	 * 
	 */
	protected int goDetailCount;
	
	/**
	 *TODO 需要了解 digg：掘客  的含义。 
	 */
	protected int userDigg;
	
	/**
	 * 段子的ID 访问详情和评论是 需要这个作为借口的参数。
	 */
	protected long groupId;
	
	
	/**
	 *TODO  该参数 需要分析一下。  
	 *  有两处地方出现了：
	 *1 参数 类表借口里面 有一个 level = 6;
	 *2 当前的文本段子实体中 level = 4;
	 */
	protected int level;
	
	/**
	 * TODO 什么含义？
	 */
	protected int repinCount;
	
	/**
	 * 代表用是否 repin ? 0代表没有
	 */
	protected int userRepin;
	
	
	/**
	 * digg 的个数
	 */
	protected int diggCount;
	
	/**
	 * 是否含有热门评论
	 */
	protected int hasHotComments;
	
	/**
	 * category_id 内容类型的分类：
	 * 1 代表文本
	 * 2 代表图片
	 */
	protected int categoryId;
	
	
	/**
	 *TODO 需要去分析 comments[]
	 *   这个 Json数组的内容是什么？
	 * 
	 * */
	
	
//	上线时间
	protected long onlineTime;
	
//	显示时间
	protected long displayTime;
	
//	二级内容：  创建新的实体类：
	protected TextUserEntity userEntity;
	
	/**
	 * 解析 JSON 数据全部放在了 实体类中 ，
	 * 什么好处？
	 * 
	 * @param json
	 * @throws JSONException
	 */
	public void pareJson(JSONObject json) throws JSONException
	{
		if(json != null)
		{
//			真正的板砖
			onlineTime = json.getLong("online_time");
			displayTime = json.getLong("display_time");
			type = json.getInt("type");
			
			JSONObject group = json.getJSONObject("group");
			createTime = group.getLong("create_time");
			favoriteCount = group.getInt("favorite_count");
			userBury = group.getInt("user_bury");
			userFavorite = group.getInt("user_favorite");
			buryCount = group.getInt("bury_count");
			shareUrl = group.getString("share_url");	
			label = group.optInt("label",0);
			content = group.getString("content");
			commentCount = group.getInt("comment_count");
			status = group.getInt("status");
			hasComments = group.getInt("has_comments");
			goDetailCount = group.getInt("go_detail_count");
			statusDesc = group.getString("status_desc");
			
			JSONObject user = group.getJSONObject("user");
			TextUserEntity useEntity = new TextUserEntity();
			useEntity.pareJson(user);
			
			userDigg = group.getInt("user_digg");
			groupId = group.getLong("group_id");
			level = group.getInt("level");
			repinCount = group.getInt("repin_count");
			diggCount = group.getInt("digg_count");
			hasHotComments = group.optInt("has_hot_comments",0);
			userRepin = group.getInt("user_repin");
			categoryId = group.getInt("category_id");
		}
	}




	public int getType() {
		return type;
	}




	public long getCreateTime() {
		return createTime;
	}




	public int getFavoriteCount() {
		return favoriteCount;
	}




	public int getBuryCount() {
		return buryCount;
	}




	public int getUserBury() {
		return userBury;
	}




	public int getUserFavorite() {
		return userFavorite;
	}




	public String getShareUrl() {
		return shareUrl;
	}




	public int getLabel() {
		return label;
	}




	public String getContent() {
		return content;
	}




	public int getCommentCount() {
		return commentCount;
	}




	public int getStatus() {
		return status;
	}




	public String getStatusDesc() {
		return statusDesc;
	}




	public int getHasComments() {
		return hasComments;
	}




	public int getGoDetailCount() {
		return goDetailCount;
	}




	public int getUserDigg() {
		return userDigg;
	}




	public long getGroupId() {
		return groupId;
	}




	public int getLevel() {
		return level;
	}




	public int getRepinCount() {
		return repinCount;
	}




	public int getUserRepin() {
		return userRepin;
	}




	public int getDiggCount() {
		return diggCount;
	}




	public int getHasHotComments() {
		return hasHotComments;
	}




	public int getCategoryId() {
		return categoryId;
	}




	public long getOnlineTime() {
		return onlineTime;
	}




	public long getDisplayTime() {
		return displayTime;
	}




	public TextUserEntity getUserEntity() {
		return userEntity;
	}

	
}