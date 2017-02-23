package com.alienlab.wechat.util;

import java.io.Writer;
import java.util.Date;
import java.util.List;

import com.alienlab.wechat.bean.MessageResponse;
import com.alienlab.wechat.bean.TextMessageResponse;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONObject;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 消息处理器
 * @author 	Eric
 *
 */
@Component
public class MessageProcessor {
	private static Logger logger = Logger.getLogger(MessageProcessor.class);
	/** 
     * xml转换json
     * @author Eric
     * @param  xml			格式的字符串
     * @return 成功返回json 字符串;失败反回null 
     */  
	@SuppressWarnings("unchecked")
	public static  JSONObject xml2JSON(String xml) {
			logger.info("jsonobject xml to json>>>"+xml);
		// 将解析结果存储在HashMap中
			JSONObject map = new JSONObject();
				// 读取输入流
				SAXReader reader = new SAXReader();
				Document document=null;
				try {
					document = DocumentHelper.parseText(xml);
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 得到xml根元素
				Element root = document.getRootElement();
				// 得到根元素的所有子节点
				List<Element> elementList = root.elements();

				// 遍历所有子节点
				for (Element e : elementList)
					map.put(e.getName(), e.getText());
				return map;
    }  
	

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
  
//    /** 
//     * 一个迭代方法 
//     * @author Eric
//     * @param element ( : org.jdom.Element )
//     * @return java.util.Map 实例 
//     */  
//    @SuppressWarnings("unchecked")  
//    private static Map  iterateElement(Element element) {  
//        List jiedian = element.getChildren();  
//        Element et = null;  
//        Map obj = new HashMap();  
//        List list = null;  
//        for (int i = 0; i < jiedian.size(); i++) {  
//            list = new LinkedList();  
//            et = (Element) jiedian.get(i);  
//            if (et.getTextTrim().equals("")) {  
//                if (et.getChildren().size() == 0)  
//                    continue;  
//                if (obj.containsKey(et.getName())) {  
//                    list = (List) obj.get(et.getName());  
//                }  
//                list.add(iterateElement(et));  
//                obj.put(et.getName(), list);  
//            } else {  
//                if (obj.containsKey(et.getName())) {  
//                    list = (List) obj.get(et.getName());  
//                }  
//                list.add(et.getTextTrim());  
//                obj.put(et.getName(), list);  
//            }  
//        }  
//        return obj;  
//    }  
  	public TextMessageResponse getTextMsg(String from,String to,String text){
		TextMessageResponse tmr=new TextMessageResponse();
		tmr.setCreateTime(new Date().getTime());
		tmr.setFromUserName(from);
		tmr.setMsgType("text");
		tmr.setToUserName(to);
		tmr.setContent(text);
		return tmr;
	}


    // 测试  
    public static void main(String[] args) {  
        System.out.println(  MessageProcessor.xml2JSON("<xml>"
        		+"<ToUserName>"+"<![CDATA[toUser]]>"+"</ToUserName>"
        		 +"<FromUserName>"+"<![CDATA[fromUser]]>"+"</FromUserName> "
        		+ "<CreateTime>"+"1348831860"+"</CreateTime>"
        		+ "<MsgType>"+"<![CDATA[text]]>"+"</MsgType>"
        		+ "<Content>"+"<![CDATA[this is a test]]>"+"</Content>"
        		+ "<MsgId>"+"1234567890123456"+"</MsgId>"
        		+"</xml>"));  
    }  

}
