package stu.love.test;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import stu.love.bean.ImageBean;
import stu.love.bean.ImageUrlList;
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
		int itemCount = 30;

		// 1 获取数据
		ClientAPI.getList(queue, CATAGORY_IMAGE, itemCount, this);

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
		Log.i(Tag, "---list=" + arg0);

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
//					数据的解析：
					new ImageBean().ParseJson(item);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
