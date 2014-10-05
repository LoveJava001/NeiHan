package stu.love.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class ADEntity {

	
//	广告类型  5 代表广告
	private int type;
	private long displayTime;
	private long onlineTime;
//	下面是广告的具题信息
	private int displayImageHeight;
//	广告的ID
	private long adId;
	private int displayImageWidth;
//	广告的源
	private String source;
//	广告包
	private String package1;
//	广告名称
	private String title;
//	广告开源的Url
	private String openUrl;
//	广告下载Url
	private String downloadUrl;
//	1 代表是广告
	private int isAd;
//	广告的信息
	private String displayInfo;
//	广告网站的url
	private String webUrl;
//	TODO 广告的类型 3 是什么意思?
	private int displayType;
//	按钮的信息
	private String buttonText;
//	
	private String appleid;
	private String trackUrl;
//	广告的标签 “推广”
	private String label;
//	广告类新  “app”
	private String adtype;
//	广告的ID
	private long aId;
	private String ipaUrl;
//	显示图片的网址！
	private String displayImage;

	
	/**
	 * 
	 * 广告的解析数据：
	 * //	先解析： 后提取 成员变量！
	 * 
	 * @param json
	 * @throws JSONException
	 * 
	 */
	public void pareJson(JSONObject json) throws JSONException
	{
		if(json != null)
		{
			type = json.getInt("type");
			displayTime = json.getLong("display_time");
			onlineTime = json.getLong("online_time");
			
//			广告的细节信息：
			JSONObject ad = json.getJSONObject("ad");
			displayImageHeight = ad.getInt("display_image_height");
			adId = ad.getLong("ad_id");
			displayImageWidth = ad.getInt("display_image_width");
			source = ad.getString("source");
			package1 = ad.getString("package");
			title = ad.getString("title");
			openUrl = ad.getString("open_url");
			downloadUrl = ad.getString("download_url");
			isAd = ad.getInt("is_ad");
			displayInfo = ad.getString("display_info");
			webUrl = ad.getString("web_url");
			displayType = ad.getInt("display_type");
			buttonText = ad.getString("button_text");
			appleid = ad.getString("appleid");
			trackUrl = ad.getString("track_url");
			label = ad.getString("label");
			adtype = ad.getString("type");
			aId = ad.getLong("id");
			ipaUrl = ad.getString("ipa_url");
			displayImage = ad.getString("display_image");
			
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(long displayTime) {
		this.displayTime = displayTime;
	}

	public long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public int getDisplayImageHeight() {
		return displayImageHeight;
	}

	public void setDisplayImageHeight(int displayImageHeight) {
		this.displayImageHeight = displayImageHeight;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}

	public int getDisplayImageWidth() {
		return displayImageWidth;
	}

	public void setDisplayImageWidth(int displayImageWidth) {
		this.displayImageWidth = displayImageWidth;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPackage1() {
		return package1;
	}

	public void setPackage1(String package1) {
		this.package1 = package1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public int getIsAd() {
		return isAd;
	}

	public void setIsAd(int isAd) {
		this.isAd = isAd;
	}

	public String getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public int getDisplayType() {
		return displayType;
	}

	public void setDisplayType(int displayType) {
		this.displayType = displayType;
	}

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getAppleid() {
		return appleid;
	}

	public void setAppleid(String appleid) {
		this.appleid = appleid;
	}

	public String getTrackUrl() {
		return trackUrl;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAdtype() {
		return adtype;
	}

	public void setAdtype(String adtype) {
		this.adtype = adtype;
	}

	public long getaId() {
		return aId;
	}

	public void setaId(long aId) {
		this.aId = aId;
	}

	public String getIpaUrl() {
		return ipaUrl;
	}

	public void setIpaUrl(String ipaUrl) {
		this.ipaUrl = ipaUrl;
	}

	public String getDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(String displayImage) {
		this.displayImage = displayImage;
	}
	
	
	
}
