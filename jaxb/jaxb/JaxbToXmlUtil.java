package com.lsw.jaxb;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

@SuppressWarnings("restriction")
public class JaxbToXmlUtil {
	@SuppressWarnings("restriction")
	public static String convertToXml(Object obj) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);//去掉生成xml的默认报文头。
            
			//转换所有的适配字符，包括xml实体字符&lt;和&gt;，xml实体字符在好多处理xml
			//的框架中是处理不了的，除非序列化。
            marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
				@Override
				public void escape(char[] ch, int start, int length, boolean isAttVal, Writer writer) throws IOException {
					writer.write(ch, start, length);
				}
            	
            });
            
            StringWriter writer = new StringWriter();
           // writer.write("<xml>");//添加自己想要的xml报文头
            marshaller.marshal(obj, writer);
            //writer.append("</xml>");
            result = writer.toString();
            
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
