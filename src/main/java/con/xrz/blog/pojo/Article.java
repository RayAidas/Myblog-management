package con.xrz.blog.pojo;

import java.util.Date;

public class Article {
    private Integer art_id;
    private int art_user_id;
    private String art_title;
    private String art_type;
    private String art_tag;
    private String art_description;
    private String art_content;
    private Date art_cre_time;
    private int art_view;
    private int art_com_num;
    private int art_hot_num;
    private int art_like_num;
    private String art_img;

    public Article(int art_user_id, String art_title, String art_type, String art_tag, String art_description, String art_content){
        this.art_user_id = art_user_id;
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_tag = art_tag;
        this.art_description = art_description;
        this.art_content = art_content;
    }

    public Article(Integer art_id, String art_title, String art_type, String art_tag, String art_description, String art_content){
        this.art_id = art_id;
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_tag = art_tag;
        this.art_description = art_description;
        this.art_content = art_content;
    }

    public Article(Integer art_id,int art_user_id,String art_title,String art_type,String art_tag,String art_description,String art_content,Date art_cre_time,int art_view,int art_com_num,int art_hot_num,int art_like_num,String art_img){
        this.art_id = art_id;
        this.art_user_id = art_user_id;
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_tag = art_tag;
        this.art_description = art_description;
        this.art_content = art_content;
        this.art_cre_time = art_cre_time;
        this.art_view = art_view;
        this.art_com_num = art_com_num;
        this.art_hot_num = art_hot_num;
        this.art_like_num = art_like_num;
        this.art_img = art_img;
    }

    public Article(Article article){
        this.art_id = art_id;
        this.art_user_id = art_user_id;
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_tag = art_tag;
        this.art_description = art_description;
        this.art_content = art_content;
        this.art_cre_time = art_cre_time;
        this.art_view = art_view;
        this.art_com_num = art_com_num;
        this.art_hot_num = art_hot_num;
        this.art_like_num = art_like_num;
        this.art_img = art_img;
    }

    public Article(String art_title,String art_type,String art_tag,String art_content,Date art_cre_time){
        this.art_title = art_title;
        this.art_type = art_type;
        this.art_tag = art_tag;
        this.art_content = art_content;
        this.art_cre_time = art_cre_time;
    }

    public Article() {
        super();
    }

    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }

    public int getArt_user_id() {
        return art_user_id;
    }

    public void setArt_user_id(int art_user_id) {
        this.art_user_id = art_user_id;
    }

    public String getArt_title() {
        return art_title;
    }

    public void setArt_title(String art_title) {
        this.art_title = art_title;
    }

    public String getArt_type() {
        return art_type;
    }

    public void setArt_type(String art_type) {
        this.art_type = art_type;
    }

    public String getArt_tag() {
        return art_tag;
    }

    public void setArt_tag(String art_tag) {
        this.art_tag = art_tag;
    }

    public String getArt_description() {
        return art_description;
    }

    public void setArt_description(String art_description) {
        this.art_description = art_description;
    }

    public String getArt_content() {
        return art_content;
    }

    public void setArt_content(String art_content) {
        this.art_content = art_content;
    }

    public Date getArt_cre_time() {
        return art_cre_time;
    }

    public void setArt_cre_time(Date art_cre_time) {
        this.art_cre_time = art_cre_time;
    }

    public int getArt_view() {
        return art_view;
    }

    public void setArt_view(int art_view) {
        this.art_view = art_view;
    }

    public int getArt_com_num() {
        return art_com_num;
    }

    public void setArt_com_num(int art_com_num) {
        this.art_com_num = art_com_num;
    }

    public int getArt_hot_num() {
        return art_hot_num;
    }

    public void setArt_hot_num(int art_hot_num) {
        this.art_hot_num = art_hot_num;
    }

    public int getArt_like_num() {
        return art_like_num;
    }

    public void setArt_like_num(int art_like_num) {
        this.art_like_num = art_like_num;
    }

    public String getArt_img() {
        return art_img;
    }

    public void setArt_img(String art_img) {
        this.art_img = art_img;
    }
}
