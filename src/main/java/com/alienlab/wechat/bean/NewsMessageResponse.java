package com.alienlab.wechat.bean;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by 橘 on 2016/12/23.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.NONE)
public class NewsMessageResponse extends MessageResponse{
    public NewsMessageResponse(){
        super();
    }
    @XmlElement
    private Integer ArticleCount;
    @XmlElement
    private List<Article> Articles;
    public Integer getArticleCount() {
        return ArticleCount;
    }
    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }
    public List<Article> getArticles() {
        return Articles;
    }
    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}