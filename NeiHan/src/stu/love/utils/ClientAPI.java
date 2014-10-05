package stu.love.utils;

import stu.love.test.TestActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


/**
 * 
 * 所有和服务器 接口对接的接口，全部在该类实现！
 * 
 * 
 * */
public class ClientAPI {

	/**
		 * 功能:
		 * 获取 内涵段子列表 list 数据！
		 * 
		 * @param queue   			Volley  请求的队列,
		 * 	避免每一次getList都创建queue 节省内存和空间
		 * @param itemCount		   	请求数据的个数
		 * @param CATAGORY_IMAGE    请求类型
		 * @param minTime			用于分页加载数据，或者 下拉刷新数据时候使用！代表上一次服务器返回 数据的 时间信息！
		 * 	为0  不分页
		 * @param responseListner   用于获取段子列表的毁掉接口，取出段子返回的数据。
		 * 
		 * 
		 * @see TestActivity#CATAGORY_TEXT     
		 * @see TestActivity#CATAGORY_IMAGE
		 * 
		 * 想获取数据： 可以使用  回调函数！
		 * 
		 */
		public static void getList(
				RequestQueue queue,
				int CATAGORY_IMAGE,
				int itemCount,
				long minTime, 
				Response.Listener<String> responseListner)
		{
//			把服务器的地址和参数 分开.  我的建议:参数 封装对象！
			String baseUrl = "http://ic.snssdk.com/2/essay/zone/category/data/";
			
	//		根据用户请求类型 返回不同的数据类型。
			String category_id_param="category_id="+CATAGORY_IMAGE;
	//		段子请求的个数 ，
			String countParam= "count="+itemCount;
	//		每一个 硬件设备
			String deviceType= "device_type=KFTT";
	//		每一个 Android 设备都不一样的恶
			String openudid = "openudid=b90ca6a3a19a78d6";
			
		    String path = baseUrl
					+"?"+category_id_param
					+"&level=6&"
					+countParam
					+"&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&"
					+deviceType
					+"&os_api=15&os_version=4.0.3&"
					+openudid;
			
		    if(minTime >0 )
		    {
		    	path = path + "&min_time="+minTime;
		    }
		    
		    
	//	    输出路径！
//		    Log.i(TestActivity.Tag, "--path= "+path);
			queue.add(new StringRequest(
					Request.Method.GET,
					path,
					responseListner, 
					new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError arg0) {
							// TODO Auto-generated method stub
							
						}
					}
					));
			
	//		启动　queue
			queue.start();
		}

		
	
	/**
	 * 
	 * 	
		获取评论！
	 * 
	 * @param queue
	 * @param groupId
	 * @param offSet
	 * @param listener
	 */
	public static void getComment(RequestQueue queue,
			long groupId, 
			int offSet,
			Response.Listener<String> listener
			) {
		String COMMENT_API = "http://isub.snssdk.com/2/data/get_essay_comments/";
		
		String groupIdParam = "group_id="+groupId;
	
		String offSetParam = "offset="+offSet;
		
		String url = COMMENT_API
				+"?"
				+groupIdParam+"&count=20&"
				+offSetParam
				+"&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&device_type=KFTT&os_api=15&os_version=4.0.3&openudid=b90ca6a3a19a78d6";
		
		queue.add(new StringRequest(
				Request.Method.GET,
				url, 
				listener,
				new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError arg0) {
						// TODO Auto-generated method stub
						
					}
				}));
	}

	
}
