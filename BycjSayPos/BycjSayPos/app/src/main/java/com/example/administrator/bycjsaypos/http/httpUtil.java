package com.example.administrator.bycjsaypos.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import android.util.Log;
import com.example.administrator.bycjsaypos.model.user;
import com.google.gson.Gson;
//网络请求；
public class httpUtil {
//	public static String pss;
//	public static String token;

	//http get 请求；
	public static String get(String http) {
		String result = "";//请求服务器的数据；
		try {
			URL url = new URL(result);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setConnectTimeout(3000);
			connection.setRequestMethod("GET");
			if (connection.getResponseCode() == 200) {
				//获取服务器返回的输入流；
				InputStream in = connection.getInputStream();
				//创建内容输出流（临时储存的内容转化为byte数组）
				ByteArrayOutputStream dateout = new ByteArrayOutputStream();
				byte[] date = new byte[1024];
				int number;
				while ((number = in.read(date)) != -1) {
					dateout.write(date, 0, number);
				}
				dateout.flush();
				result = new String(dateout.toByteArray());
				dateout.close();
				in.close();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
//http post 请求；
	public static String post(String http,Map<String,String> map){
		String result = "";
		try {
			URL mUrl = new URL(http);
			HttpURLConnection mConnection = (HttpURLConnection) mUrl.openConnection();
			mConnection.setDoInput(true);
			mConnection.setDoOutput(true);
			mConnection.setConnectTimeout(3000);
			mConnection.setRequestMethod("POST");
			mConnection.connect();
			if (map !=null){
				//提教参数；
				StringBuffer nBuffer = new StringBuffer();
				Iterator<Entry<String, String>> it = map.entrySet().iterator();
				while(it.hasNext()){
					Entry<String ,String> entity = it.next();
					nBuffer.append(entity.getKey()).append("=")
							.append(entity.getValue()).append("&");
				}
				//将最后一个&删除掉；
				nBuffer.delete(nBuffer.length()-1,nBuffer.length());
				String string = nBuffer.toString();
				Log.d("TAG","##############################"+string);
				OutputStreamWriter output = new OutputStreamWriter(mConnection.getOutputStream(),"UTF-8");
				output.write(string);
				output.flush();
				output.close();
			}
			//判断是否连接成功；
			if (mConnection.getResponseCode()== 200) {
				InputStream input = mConnection.getInputStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte[] date = new byte[1024];
				int lenght;
				while((lenght = input.read(date)) !=-1){
					out.write(date,0,lenght);
				}
				out.flush();
				//网络请求返回值；
				result = new String(out.toByteArray(),"UTF-8");
//					Gson gson = new Gson();
//					user muser = new user();
//					user min = gson.fromJson(result, user.class);
//					Log.i("TAG", "=====================>" + min.toString());
//					String[] str = min.getMessage().split("\\*");
//					for (int i = 0; i <str.length; i++) {
//					Log.i("TAG", "post: ------------------->"+ str[i]);
//					 pss = str[0].toString();
//					 token = str[1].toString();
//					Log.i("TAG", "post: "+pss.toString());
//						Log.i("TAG", "post:"+token.toString());
//				}
				Log.i("TAG======", result.toString());
				input.close();
				out.close();
			}
			mConnection.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("TAG","----连接成功------"+result.toString());
		return result;//是将json返回回去啊，整个过程result的值没有做任何修改啊
	}
}