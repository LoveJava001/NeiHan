package stu.love.fragments;

import java.util.ArrayList;
import java.util.List;

import stu.love.neihan.R;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TextListFragment extends Fragment  implements OnClickListener,OnScrollListener,OnRefreshListener2<ListView>{

	private View quickTools;
	private TextView textNotify;
	public TextListFragment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_textlist, container, false);
		
		PullToRefreshListView refreshListView=(PullToRefreshListView) view.findViewById(R.id.textlist_pulltorefresh);	
		refreshListView.setMode(Mode.BOTH);	
		ListView listView=refreshListView.getRefreshableView();
		//设置上啦与下拉的事件监听
		
		refreshListView.setOnRefreshListener(this);
		
		//获取标题控件，增加点击，进行新消息悬浮框的显示
		
		View titleView=view.findViewById(R.id.textView_title);
		titleView.setOnClickListener(this);
		
		List<String> strings=new ArrayList<String>();
		strings.add("java");
		strings.add("c");
		strings.add("c++");
		strings.add("php");
		strings.add("obc");
		strings.add("lub");
		strings.add("html");
		strings.add("xml");
		strings.add("c#");
		strings.add("java");
		strings.add("c");
		strings.add("c++");
		strings.add("php");
		strings.add("obc");
		strings.add("lub");
		strings.add("html");
		strings.add("xml");
		strings.add("c#");
		strings.add("java");
		strings.add("c");
		strings.add("c++");
		strings.add("php");
		strings.add("obc");
		strings.add("lub");
		strings.add("html");
		strings.add("xml");
		strings.add("c#");
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strings);		
		
			
		header = inflater.inflate(R.layout.header_textlist_tool, listView, false);		
		listView.addHeaderView(header);
		
		
		View quickPublish=header.findViewById(R.id.quick_notify);//投稿
		quickPublish.setOnClickListener(this);
		
		View check=header.findViewById(R.id.quick_check);//审核
		check.setOnClickListener(this);
		
		listView.setAdapter(adapter);
		listView.setOnScrollListener(this);
		
		
		//线性布局
		quickTools = view.findViewById(R.id.textlist_quick_tools);
		quickTools.setVisibility(View.INVISIBLE);
		
		quickPublish=quickTools.findViewById(R.id.quick_notify);
		quickPublish.setOnClickListener(this);
		
		check=quickTools.findViewById(R.id.quick_check);
		check.setOnClickListener(this);
		
		//新消息
		textNotify = (TextView) view.findViewById(R.id.textlist_new_notify);
		textNotify.setVisibility(View.INVISIBLE);
		
		
		
		//TextView textCheck=view.findViewById(R.id.te)
		//TODO 获取快速的工具条， 用于列表的 滚动和隐藏
		
		///TODO 获取新条目控件有新数据现实
		
		return view;
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
				int what=msg.what;
				if (what==1) {
					textNotify.setVisibility(View.INVISIBLE);
				}
		}
	};
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch(id){
		case R.id.textView_title:
			textNotify.setVisibility(View.VISIBLE);
			handler.sendEmptyMessageAtTime(1, 3000);
			break;
		}
	}
	
	///////////////////////////////////////////
	//列表  滚动  显示工具条
	
	private int lastIndex=0;
	private View header;
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
			if (lastIndex-firstVisibleItem<0||firstVisibleItem==0) {
				//证明向上移动
				if (quickTools!=null) {
						quickTools.setVisibility(View.INVISIBLE);
				}			
			}else if (lastIndex-firstVisibleItem>0) {
				if (quickTools!=null) {
					quickTools.setVisibility(View.VISIBLE);
				}		
			}
			lastIndex=firstVisibleItem;
	}
	
	
	
	///////////////////////////////////
	//下拉 加载新数据
	@Override
	public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
	//上拉  
	@Override
	public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		
	}
}
