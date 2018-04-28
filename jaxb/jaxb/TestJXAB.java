package com.lsw.jaxb;

import java.util.Random;

public class TestJXAB {
	public static void main(String[] args) {
		RootEntity root = new RootEntity();
		 root.setId("ddd");
		 root.setSurname("jiiii");
		 root.setName("lishi");//由于在javabean中赋值为空，这句可以不要，也可以去掉javabean中的赋空值语句
		 root.setBaseName("jjjkk");
		 
		 Random random = new Random();
		 if(random.nextInt(10) > 5) {
			 Music mu = new Music();
			 mu.setAaa("12");
			 mu.setBbb("34");
			 root.setMu(mu);
		 }else {
			 Video vd = new Video();
			 vd.setVideo2("vd");
			 root.setVd(vd);
		 }
		 
		 
		 String str = JaxbToXmlUtil.convertToXml(root);
		 System.out.println(str);
		 }
}
