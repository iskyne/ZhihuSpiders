package Bean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Page {
	
	/**
	 * the url for search the page
	*/
	private String urlstr;
	
	/**
	 * the html body
	 */
	private String content;
	
	public Page(String urlstr){
		this.urlstr=urlstr;
		 
		try {
			URL url=new URL(urlstr);
			InputStream is=url.openStream();
			ByteArrayOutputStream buffer=new ByteArrayOutputStream();
			byte[] buf=new byte[1024];
			int len=0;
			while((len=is.read(buf))!=-1){
				buffer.write(buf, 0, len);
			}
			this.content=new String(buffer.toByteArray(),"utf-8");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public abstract void saveDisk(String dirPath);
	
	public String getUrl(){
		return this.urlstr;
	}
	
	public String getContent(){
		return this.content;
	}
	
}
