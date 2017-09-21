package bwie.com.jingdong.base;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 文 件 名: MyApplication
 * 创 建 人: 谢兴张
 * 创建日期: 2017/9/21
 * 邮   箱:
 * 博   客:
 * 修改时间：
 * 修改备注：
 */

public class beans {

    /**
     * News : [{"Comment":[{"content":"This is a Content...-3","date":"2017-02-01 19:20:50.0","id":3,"momentId":15,"toId":0,"userId":82002},{"content":"thank you","date":"2017-03-25 20:28:03.0","id":176,"momentId":15,"toId":166,"userId":38710}],"Moment":{"content":"APIJSON is a JSON Transmission Structure Protocol\u2026","date":"2017-02-08 16:06:11.0","id":15,"pictureList":["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"],"praiseUserIdList":[82055,82002],"userId":70793},"User":{"head":"http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000","id":70793,"name":"Strong"}}]
     * code : 200
     * msg : success
     */

    public int code;
    public String msg;
    @SerializedName("[]")
    public List<NewsBean> News;

    public static beans objectFromData(String str) {

        return new com.google.gson.Gson().fromJson(str, beans.class);
    }

    public static class NewsBean {
        /**
         * Comment : [{"content":"This is a Content...-3","date":"2017-02-01 19:20:50.0","id":3,"momentId":15,"toId":0,"userId":82002},{"content":"thank you","date":"2017-03-25 20:28:03.0","id":176,"momentId":15,"toId":166,"userId":38710}]
         * Moment : {"content":"APIJSON is a JSON Transmission Structure Protocol\u2026","date":"2017-02-08 16:06:11.0","id":15,"pictureList":["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"],"praiseUserIdList":[82055,82002],"userId":70793}
         * User : {"head":"http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000","id":70793,"name":"Strong"}
         */

        public MomentBean Moment;
        public UserBean User;
        @SerializedName("Comment[]")
        public List<CommentBean> Comment;

        public static NewsBean objectFromData(String str) {

            return new com.google.gson.Gson().fromJson(str, NewsBean.class);
        }

        public static class MomentBean {
            /**
             * content : APIJSON is a JSON Transmission Structure Protocol…
             * date : 2017-02-08 16:06:11.0
             * id : 15
             * pictureList : ["http://static.oschina.net/uploads/user/1218/2437072_100.jpg?t=1461076033000","http://common.cnblogs.com/images/icon_weibo_24.png"]
             * praiseUserIdList : [82055,82002]
             * userId : 70793
             */

            public String content;
            public String date;
            public int id;
            public int userId;
            public List<String> pictureList;
            public List<Integer> praiseUserIdList;

            public static MomentBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, MomentBean.class);
            }
        }

        public static class UserBean {
            /**
             * head : http://static.oschina.net/uploads/user/585/1170143_50.jpg?t=1390226446000
             * id : 70793
             * name : Strong
             */

            public String head;
            public int id;
            public String name;

            public static UserBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, UserBean.class);
            }
        }

        public static class CommentBean {
            /**
             * content : This is a Content...-3
             * date : 2017-02-01 19:20:50.0
             * id : 3
             * momentId : 15
             * toId : 0
             * userId : 82002
             */

            public String content;
            public String date;
            public long id;
            public long momentId;
            public long toId;
            public long userId;

            public static CommentBean objectFromData(String str) {

                return new com.google.gson.Gson().fromJson(str, CommentBean.class);
            }
        }
    }
}
