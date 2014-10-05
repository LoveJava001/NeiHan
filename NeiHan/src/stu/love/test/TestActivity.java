package stu.love.test;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import stu.love.bean.ADEntity;
import stu.love.bean.ImageBean;
import stu.love.bean.ImageUrlList;
import stu.love.bean.TextEntity;
import stu.love.neihan.R;
import stu.love.utils.ClientAPI;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

public class TestActivity extends Activity implements Response.Listener<String> {

	// 把服务器的地址和参数 分开. 我的建议:参数 封装对象！
	// public static String baseUrl =
	// "http://ic.snssdk.com/2/essay/zone/category/data/";

	// 类型 段子： 1 是段子 2 是图片
	public static final int CATAGORY_TEXT = 1; // 代表文本
	public static final int CATAGORY_IMAGE = 2; // 代表图片

	public static String Tag = "TestActivity";

	private RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tes);

		// Volley 请求队列
		queue = Volley.newRequestQueue(this);
		int itemCount = 10;

		// 1 获取数据
		ClientAPI.getList(queue, CATAGORY_TEXT, itemCount, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	// 2 Volley 相应的事件！ 所有的activity 内部的恶fragment 的 都可以使用
	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		// 返回的数据：

		// 封装为工具类：
		// 数据转化为JSON数据：
		try {
			JSONObject obj = new JSONObject(arg0);
			String str = obj.toString();
			Log.i(Tag, "---Json data= " + str);

			// 获取JsonIMage 对象的数据
			JSONObject data = obj.getJSONObject("data");
			// 从Data对象中获取名称为data 的数组。它代表的是 段子列表的数据。
			JSONArray arr = data.getJSONArray("data");
			int len = arr.length();
			if (len > 0) {
				for (int i = 0; i < len; i++) {
// 					这种写法很乱！ 很不清晰！
					JSONObject item = arr.getJSONObject(i);
					
					Log.i(Tag, "---item="+item);
					
//					获取类型 1 是段子 5 是广告
					int type = item.getInt("type");
					
					if(type==1)
					{
//						TODO  处理段子
						JSONObject group = item.getJSONObject("group");
						int cid = group.getInt("category_id");
						TextEntity entity= null;
						if(cid == 1)
						{
//							TODO  文本段子
							entity = new TextEntity();
							
						}else if(cid == 2)
						{
//							TODO  图片段子
							entity = new ImageBean();
						}
//						解析数据：
						entity.pareJson(item);
						
						long id = entity.getGroupId();
						Log.i(Tag, "----getGroupId="+id);
						
					}else if(type==5)
					{
						
//						TODO  处理广告的内容
						ADEntity adEntity = new ADEntity();
						adEntity.pareJson(item);
						String url = adEntity.getDownloadUrl();
						Log.i(Tag, "----adEntity.getDownloadUrl() ="+url);
						
					}
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
