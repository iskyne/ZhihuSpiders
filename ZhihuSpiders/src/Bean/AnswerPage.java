package Bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnswerPage extends Page{
	private List<InterestingThing>  interestingThing;
	public AnswerPage(String urlstr) {
		super(urlstr);
		interestingThing=getPic(getContent());
	}
	
	public List<InterestingThing> getPic(String content){
		interestingThing=new LinkedList<InterestingThing>();
		Pattern pattern = Pattern.compile("<img.+?src=\"(https.+?)\".+?");
		Matcher matcher = pattern.matcher(content);
		boolean isFind = matcher.find();
		while (isFind) {
			String picUrl=matcher.group(1);
			System.out.println(picUrl);
			InterestingThing picture=new Picture(picUrl);
			interestingThing.add(picture);
			isFind = matcher.find();
		}
		return interestingThing;
	}
	
	@Override
	public void saveDisk(String dirPath){
		File dir=new File(dirPath);
		if(!dir.exists()||(dir.exists()&&dir.isFile())){
			dir.mkdirs();
		}
		
		Iterator it=interestingThing.iterator();
		
		try{
			while(it.hasNext()){
				String urlStr=((InterestingThing)it.next()).getUrl();
				URL url=new URL(urlStr);
				InputStream is=url.openStream();
				int len=0;
				byte[] buffer=new byte[1024];
				String fileName=dirPath+url.getFile();
				System.out.println(fileName);
				FileOutputStream fileO=new FileOutputStream(fileName);
				try{
					while((len=is.read(buffer))!=-1){
						fileO.write(buffer, 0, len);
					}
				}catch(IOException e){
					e.printStackTrace();
				}finally{
					fileO.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
