package com.example.handschoolapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/24.
 */

public class CourseBean {

    /**
     * data : [{"age_range":"2-6岁","course_address":"1","course_capacity":"28","course_id":"1506153404911","course_info":"bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg","course_name":"音乐","course_photo":"bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg","course_state":"0","course_teacher":"1","course_time":"2017-09-23 15:56:44","course_type":"书画,中小学教育","enrol_num":"26","original_price":"660","popularity_num":"107","preferential_price":"330","school_id":"1505805630236","school_name":"我的小学堂a","study_num":"1506153404911","user_id":"8841f54f7b574f06a470ee9002043f8d"},{"age_range":"2-6岁","course_address":"1","course_capacity":"28","course_id":"1506153961723","course_info":"bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg","course_name":"音乐3","course_photo":"bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg","course_state":"0","course_teacher":"1","course_time":"2017-09-23 16:06:02","course_type":"书画,球类","enrol_num":"27","original_price":"660","popularity_num":"90","preferential_price":"330","school_id":"1505805630236","school_name":"我的小学堂a","study_num":"1506153961723","user_id":"8841f54f7b574f06a470ee9002043f8d"}]
     * msg : 成功
     * result : 0
     */

    private String msg;
    private int result;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "age_range='" + age_range + '\'' +
                    ", course_address='" + course_address + '\'' +
                    ", course_capacity='" + course_capacity + '\'' +
                    ", course_id='" + course_id + '\'' +
                    ", course_info='" + course_info + '\'' +
                    ", course_name='" + course_name + '\'' +
                    ", course_photo='" + course_photo + '\'' +
                    ", course_state='" + course_state + '\'' +
                    ", course_teacher='" + course_teacher + '\'' +
                    ", course_time='" + course_time + '\'' +
                    ", course_type='" + course_type + '\'' +
                    ", enrol_num='" + enrol_num + '\'' +
                    ", original_price='" + original_price + '\'' +
                    ", popularity_num='" + popularity_num + '\'' +
                    ", preferential_price='" + preferential_price + '\'' +
                    ", school_id='" + school_id + '\'' +
                    ", school_name='" + school_name + '\'' +
                    ", study_num='" + study_num + '\'' +
                    ", user_id='" + user_id + '\'' +
                    '}';
        }

        /**
         * age_range : 2-6岁
         * course_address : 1
         * course_capacity : 28
         * course_id : 1506153404911
         * course_info : bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg
         * course_name : 音乐
         * course_photo : bicths/1584b04562a84667bd9068d6d2dd09c0/1505809601513.jpg
         * course_state : 0
         * course_teacher : 1
         * course_time : 2017-09-23 15:56:44
         * course_type : 书画,中小学教育
         * enrol_num : 26
         * original_price : 660
         * popularity_num : 107
         * preferential_price : 330
         * school_id : 1505805630236
         * school_name : 我的小学堂a
         * study_num : 1506153404911
         * user_id : 8841f54f7b574f06a470ee9002043f8d
         */


        private String age_range;
        private String course_address;
        private String course_capacity;
        private String course_id;
        private String course_info;
        private String course_name;
        private String course_photo;
        private String course_state;
        private String course_teacher;
        private String course_time;
        private String course_type;
        private String enrol_num;
        private String original_price;
        private String popularity_num;
        private String preferential_price;
        private String school_id;
        private String school_name;
        private String study_num;
        private String user_id;

        public String getAge_range() {
            return age_range;
        }

        public void setAge_range(String age_range) {
            this.age_range = age_range;
        }

        public String getCourse_address() {
            return course_address;
        }

        public void setCourse_address(String course_address) {
            this.course_address = course_address;
        }

        public String getCourse_capacity() {
            return course_capacity;
        }

        public void setCourse_capacity(String course_capacity) {
            this.course_capacity = course_capacity;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_info() {
            return course_info;
        }

        public void setCourse_info(String course_info) {
            this.course_info = course_info;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_photo() {
            return course_photo;
        }

        public void setCourse_photo(String course_photo) {
            this.course_photo = course_photo;
        }

        public String getCourse_state() {
            return course_state;
        }

        public void setCourse_state(String course_state) {
            this.course_state = course_state;
        }

        public String getCourse_teacher() {
            return course_teacher;
        }

        public void setCourse_teacher(String course_teacher) {
            this.course_teacher = course_teacher;
        }

        public String getCourse_time() {
            return course_time;
        }

        public void setCourse_time(String course_time) {
            this.course_time = course_time;
        }

        public String getCourse_type() {
            return course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public String getEnrol_num() {
            return enrol_num;
        }

        public void setEnrol_num(String enrol_num) {
            this.enrol_num = enrol_num;
        }

        public String getOriginal_price() {
            return original_price;
        }

        public void setOriginal_price(String original_price) {
            this.original_price = original_price;
        }

        public String getPopularity_num() {
            return popularity_num;
        }

        public void setPopularity_num(String popularity_num) {
            this.popularity_num = popularity_num;
        }

        public String getPreferential_price() {
            return preferential_price;
        }

        public void setPreferential_price(String preferential_price) {
            this.preferential_price = preferential_price;
        }

        public String getSchool_id() {
            return school_id;
        }

        public void setSchool_id(String school_id) {
            this.school_id = school_id;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }

        public String getStudy_num() {
            return study_num;
        }

        public void setStudy_num(String study_num) {
            this.study_num = study_num;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
