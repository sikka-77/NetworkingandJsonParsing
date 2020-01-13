package com.example.networkingexample;

import androidx.recyclerview.widget.RecyclerView;

public class UsersClass  {

        private String mlogin;
        private int mid;
        private String mnodeid;
        private String mavatar;
        private String mhtml;

        public UsersClass(String login, int id, String node_id, String avatar_url, String html_url){
                mlogin=login;
                mid=id;
                mnodeid=node_id;
                mavatar=avatar_url;
                mhtml=html_url;
        }
        public String getLogin() {
            return mlogin;
        }
        public String getHtml(){
            return mhtml;
        }
        public String getUrl() {
            return mnodeid;
        }


}
