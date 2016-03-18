package test;

import Bean.*;
public class testPage {
	
	public static void main(String args[]){
		Page p=new AnswerPage("https://www.zhihu.com/question/35846840/answer/68324779");
		p.saveDisk("d:\\zhihu");
		//System.out.println(p.getContent());
	}
}
