package stu.love.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * 每次请求 返回的数据：
 * 
 * EntityList 对应返回数据的第一个 data 
 * 
 * */
public class EntityList {

	private static String Tag = "EntityList";
	private List<TextEntity> entities;
//	是否还有更多的数据
	private boolean hasMore;
	private long minTime;
//	提示信息
	private String tip;
	private long maxTime;

	/**
	 * 每一次返回数据： JSOn 数据的解析
	 * 
	 * @param item
	 * @throws JSONException
	 */
	public void ParseJson(JSONObject json) throws JSONException {
		// json 是所有的数据
		if (json != null) {
			hasMore = json.getBoolean("has_more");
			tip = json.getString("tip");
			if(hasMore)
			{
//				是否有数据的更新！
				minTime = json.getLong("min_time");
			}
			maxTime = json.optLong("max_time");
			
			// 20 条数据
			// 从Data对象中获取名称为data 的数组。它代表的是 段子列表的数据。
			JSONArray arr = json.getJSONArray("data");
			int len = arr.length();
			// 获取的数据
			if (len > 0) {
//				存储数据用的 集合！
				entities = new ArrayList<TextEntity>();
				
				for (int i = 0; i < len; i++) {
					// item 每一条数据的信息
					JSONObject item = arr.getJSONObject(i);
//					Log.i(Tag, "---item=" + item);
					// 获取类型 1 是段子 5 是广告
					int type = item.getInt("type");
					if (type == 1) {
						// TODO 处理段子
						JSONObject group = item.getJSONObject("group");
						int cid = group.getInt("category_id");
						TextEntity entity = null;
						if (cid == 1) {
							// TODO 文本段子
							entity = new TextEntity();
						} else if (cid == 2) {
							// TODO 图片段子
							entity = new ImageBean();
						}
						
						// 文本 解析数据：解析获取到的每一条的数据！
						entity.pareJson(item);
						
//						$$$ 将多有的 每一条数据 添加进 entities  类表中！！
						entities.add(entity);
						
						long id = entity.getGroupId(); 
						Log.i(Tag,"----getGroupId="+id);
						 
					} else if (type == 5) {
						// TODO 处理广告的内容
						ADEntity adEntity = new ADEntity();
						adEntity.pareJson(item);
						String url = adEntity.getDownloadUrl();
						Log.i(Tag, "------adEntity.getDownloadUrl()=" + url);
					}
				}
			}
		}
	}

	public List<TextEntity> getEntities() {
		return entities;
	}

	public boolean isHasMore() {
		return hasMore;
	}

	public long getMinTime() {
		return minTime;
	}

	public String getTip() {
		return tip;
	}

	public long getMaxTime() {
		return maxTime;
	}
	
}
