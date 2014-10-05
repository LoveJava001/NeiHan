package stu.love.test;

import java.util.List;

import org.json.JSONObject;

import stu.love.bean.CommentEntity;
import stu.love.bean.CommentList;
import stu.love.bean.EntityList;
import stu.love.bean.TextEntity;
import stu.love.neihan.R;
import stu.love.utils.ClientAPI;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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

	private static RequestQueue queue;
	
	private Button buttonRefrush;
	
	private long lastTime = 0;
	
//	对应文本段子的ID
	long groupId = 3577157367L;
	
	final int itemCount = 20;

//	评论的刷新
	int offSet = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		// Volley 请求队列
		queue = Volley.newRequestQueue(this);

		// 1 获取数据
//		ClientAPI.getList(queue, CATAGORY_IMAGE, itemCount, lastTime, this);
		
//		2 刷新数据
		/*buttonRefrush = (Button) this.findViewById(R.id.reflust);
		buttonRefrush.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ClientAPI.getList(queue, CATAGORY_TEXT, itemCount, lastTime, TestActivity.this);
			}
		});*/
		
		ClientAPI.getComment(queue,groupId, offSet,this);
		
//		3 评论的刷新
		buttonRefrush = (Button) this.findViewById(R.id.reflust);
		buttonRefrush.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
//				获取 评论数据！
				ClientAPI.getComment(queue, groupId, offSet,TestActivity.this);
				
			}
		});
		
	}


/**
	 * 评论 
	 * 
	 * */
	@Override
	public void onResponse(String arg0) {
		// TODO Auto-generated method stub
		
		try {
			
			JSONObject json = new JSONObject(arg0);
		
//			已经后渠道数据
//			Log.i("lvoe", "---json"+json.toString());
			
//			解析返回的数据信息！  分为热门评论和新鲜评论
			CommentList commentList = new CommentList();
			commentList.pareJson(json);
			
//			表示当前的文章的ID
			long groupId = commentList.getGroupId();
//			表示评论列表 是否还可以继续加载！
			boolean hasMore = commentList.isHasMore();
			int totalNub = commentList.getTotalMunber();
			
			Log.i("lvoe", "---groupId="+groupId);
			Log.i("lvoe", "---hasMore="+hasMore);
			Log.i("lvoe", "---offset="+offSet);
			Log.i("lvoe", "---TotalMunber="+totalNub);
			
//			热门评论  第一次 offset 为0 是可能有数据
			List<CommentEntity> top = commentList.getTopComment();
//			新鲜评论
			List<CommentEntity> recent = commentList.getRecentComment();
			
//			TODO 直接把 Comment 提交给 ListView的adapter，  可用于内容数据 更新！
//			分页表示：  Offset  没回返回 20 条数据！ 通过 hasMore 进行判断 是否还有新的数据加载！
			
			if(top != null)
			{
				for(CommentEntity entity : top)
				{
					Log.i("lvoe", "---top="+entity.getText());
				}
				
			}
			if(recent != null)
			{
				for(CommentEntity entity : recent)
				{
					Log.i("lvoe", "---recent="+entity.getText());
				}
			}
				
//			如果 有话，继续增加！
			offSet+=20;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * 类表网络获取回调部分
	 * 
	 * @arg0 JSon 字符串！
	 * 
	 * */
	public void listOnResponse(String arg0) {
		// TODO Auto-generated method stub
		// 返回的数据：

		// 封装为工具类：
		// 数据转化为JSON数据：
		try {
			JSONObject obj = new JSONObject(arg0);
			String str = obj.toString();
//			Log.i(Tag, "---Json data= " + str);

			// 获取JsonIMage 对象的数据
			JSONObject data = obj.getJSONObject("data");
			
//			1 解析段子列表的完整数据！  包含 图片 文本 广告！等对象的信息！
			EntityList entityList = new EntityList();
			entityList.ParseJson(data);
			
//			2 下拉刷新时：  如果 有更新数据的话！ hasMore  false 她的 min_time  为0.
			if(entityList.isHasMore())
			{
//				1 获取下次刷新 时间标志
				long lastTime = entityList.getMinTime();
				Log.i(Tag, "---lastTime="+lastTime);
			}else{
//				获取提示信息
				String tip = entityList.getTip();
				Log.d(Tag, "-----tip"+tip);
			}
			
//			获取段子内容列表！
			List<TextEntity> entities = entityList.getEntities();
			
//			TODO enitities 段子数据的结合 传递给 listView 的Adapter 绑定数据！
//			之后 

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
