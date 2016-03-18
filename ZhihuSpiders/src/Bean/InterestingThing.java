package Bean;

import java.nio.ByteBuffer;

public abstract class InterestingThing {
	public final static int PIC=0;
	
	public final static int ANSWER=1;
	
	//current page the interesting thing blongs to 
	protected Page currPage;
	//get the content according to the giving html tag
	protected String Tag;
	
	protected String Url;
	
	protected int Type;
	//the name 
	protected String Name;
	//the interesting thing you want
	protected ByteBuffer Content;
	
	InterestingThing(String url){
		this.Url=url;
	}
	
	
	
	//getter and setter
	public String getTag(){
		return this.Tag;
	}
	
	public String getUrl(){
		return this.Url;
	}
	
	public int getType(){
		return this.Type;
	}
	
	public String getName(){
		return this.Name;
	}
	
	public ByteBuffer getContent(){
		return this.Content;
	}
	
	public void setTag(String newTag){
		this.Tag=newTag;
	}
	
	public void setUrl(String newUrl){
		this.Url=newUrl;
	}
	
	public void setType(int type){
		this.Type=type;
	}
	
	public void setName(String newName){
		this.Name=newName;
	}
	
	public void setContent(ByteBuffer newContent){
		this.Content=newContent;
	}
}
