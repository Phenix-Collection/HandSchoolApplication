package com.example.handschoolapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/20.
 */

public class ClassDealManagerBean implements Serializable{

    /**
     * class_money : 333
     * class_name : 舞蹈
     * class_photo : images/head.jpg
     * class_time : 1
     * course_id : 1505888150982
     * course_num : 2
     * is_coupons : 0
     * is_gold : 0
     * order_id : 1505979101519
     * order_money : 666
     * order_state : 0
     * order_type : 0
     * ordre_time : 2017-09-21 15:31:41
     * pay_num : 0
     * pay_type : 0
     * school_id : 1505805630235
     * school_logo : bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1506565555092.jpg
     * school_name : 我的小学堂b
     * userInfo : {"data_integrity":"100","head_photo":"images/head.jpg","mechanism_address":"1505459605958","mechanism_name":"我的小学堂b","mechanism_type":"早教","member_name":"","mid_photo":"bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605990.jpg,bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605993.jpg","qualification_prove":"bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605961.jpg,bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605967.jpg,bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605971.jpg,bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605977.jpg,bicths/4c975ad7eeb646f7b0e06cabc8290ddd/1505459605983.jpg","school_id":"1505805630235","signed_num":"1","user_code":"000000","user_create_time":"2017-09-15 15:07:22","user_dengji":"0","user_gold":"20","user_id":"4c975ad7eeb646f7b0e06cabc8290ddd","user_integral":"20","user_password":"0","user_phone":"15122947309","user_renqi":"9","user_state":"0","user_type":"1"}
     * user_id : 4c975ad7eeb646f7b0e06cabc8290ddd
     * user_name : chuan
     * user_phone : 13930989708
     * class_teacher : 1505888221351
     */

    private String class_money;
    private String class_name;
    private String class_photo;
    private String picture_one;
    private String picture_two;
    private String picture_three;
    private String picture_four;
    private String picture_five;
    private String class_time;
    private String course_id;
    private String course_num;
    private int is_coupons;
    private String is_gold;
    private String order_id;
    private String order_money;
    private String order_state;
    private String order_type;
    private String ordre_time;
    private String pay_num;
    private String pay_type;
    private String school_id;
    private String school_logo;
    private String school_name;
    private UserInfoBean userInfo;
    private String user_id;
    private String user_name;
    private String user_phone;
    private String class_teacher;
    private CourseInfo courseInfo;

    public String getClass_money() {
        return class_money;
    }

    public void setClass_money(String class_money) {
        this.class_money = class_money;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_photo() {
        return class_photo;
    }

    public void setClass_photo(String class_photo) {

        this.class_photo = class_photo;
    }

    public String getPicture_one() {
        return picture_one;
    }

    public void setPicture_one(String picture_one) {
        this.picture_one = picture_one;
    }

    public String getPicture_two() {
        return picture_two;
    }

    public void setPicture_two(String picture_two) {
        this.picture_two = picture_two;
    }

    public String getPicture_three() {
        return picture_three;
    }

    public void setPicture_three(String picture_three) {
        this.picture_three = picture_three;
    }

    public String getPicture_four() {
        return picture_four;
    }

    public void setPicture_four(String picture_four) {
        this.picture_four = picture_four;
    }

    public String getPicture_five() {
        return picture_five;
    }

    public void setPicture_five(String picture_five) {
        this.picture_five = picture_five;
    }

    public String getClass_time() {
        return class_time;
    }

    public void setClass_time(String class_time) {
        this.class_time = class_time;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public int getIs_coupons() {
        return is_coupons;
    }

    public void setIs_coupons(int is_coupons) {
        this.is_coupons = is_coupons;
    }

    public String getIs_gold() {
        return is_gold;
    }

    public void setIs_gold(String is_gold) {
        this.is_gold = is_gold;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_money() {
        return order_money;
    }

    public void setOrder_money(String order_money) {
        this.order_money = order_money;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrdre_time() {
        return ordre_time;
    }

    public void setOrdre_time(String ordre_time) {
        this.ordre_time = ordre_time;
    }

    public String getPay_num() {
        return pay_num;
    }

    public void setPay_num(String pay_num) {
        this.pay_num = pay_num;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSchool_logo() {
        return school_logo;
    }

    public void setSchool_logo(String school_logo) {
        this.school_logo = school_logo;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public static class UserInfoBean {

        /**
         * data_integrity : 67
         * head_photo : images/head.jpg
         * id_number : 1344234234565465
         * signed_num : 4
         * user_area : 地区
         * user_code : 000000
         * user_create_time : 2017-09-21 09:53:50
         * user_dengji : 1
         * user_gold : 10
         * user_id : 772d42a5a0014faa8706f7cd3f6e8828
         * user_integral : 60
         * user_name : 菲菲
         * user_password : 0
         * user_phone : 18330695171
         * user_sex : 男
         * user_state : 0
         * user_type : 0
         * weixin_id : od4ok1Mv7RNujyzcaSSOJLO7o_-8
         */

        private String data_integrity;
        private String head_photo;
        private String id_number;
        private String signed_num;
        private String user_area;
        private String user_code;
        private String user_create_time;
        private String user_dengji;
        private String user_gold;
        private String user_id;
        private String user_integral;
        private String user_name;
        private String user_password;
        private String user_phone;
        private String user_sex;
        private String user_state;
        private String user_type;
        private String weixin_id;

        public String getData_integrity() {
            return data_integrity;
        }

        public void setData_integrity(String data_integrity) {
            this.data_integrity = data_integrity;
        }

        public String getHead_photo() {
            return head_photo;
        }

        public void setHead_photo(String head_photo) {
            this.head_photo = head_photo;
        }

        public String getId_number() {
            return id_number;
        }

        public void setId_number(String id_number) {
            this.id_number = id_number;
        }

        public String getSigned_num() {
            return signed_num;
        }

        public void setSigned_num(String signed_num) {
            this.signed_num = signed_num;
        }

        public String getUser_area() {
            return user_area;
        }

        public void setUser_area(String user_area) {
            this.user_area = user_area;
        }

        public String getUser_code() {
            return user_code;
        }

        public void setUser_code(String user_code) {
            this.user_code = user_code;
        }

        public String getUser_create_time() {
            return user_create_time;
        }

        public void setUser_create_time(String user_create_time) {
            this.user_create_time = user_create_time;
        }

        public String getUser_dengji() {
            return user_dengji;
        }

        public void setUser_dengji(String user_dengji) {
            this.user_dengji = user_dengji;
        }

        public String getUser_gold() {
            return user_gold;
        }

        public void setUser_gold(String user_gold) {
            this.user_gold = user_gold;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_integral() {
            return user_integral;
        }

        public void setUser_integral(String user_integral) {
            this.user_integral = user_integral;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_sex() {
            return user_sex;
        }

        public void setUser_sex(String user_sex) {
            this.user_sex = user_sex;
        }

        public String getUser_state() {
            return user_state;
        }

        public void setUser_state(String user_state) {
            this.user_state = user_state;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public String getWeixin_id() {
            return weixin_id;
        }

        public void setWeixin_id(String weixin_id) {
            this.weixin_id = weixin_id;
        }
    }

    public static class CourseInfo{


        /**
         * age_range : 5-10岁
         * collect_no : 3
         * course_address : 天津天津河西区合肥道与江西路交汇处西南富力中心
         * course_capacity : 40
         * course_id : 1548320731995
         * course_info :
         * course_money : 0.01元/5节
         * course_name : 声乐
         * course_state : 1
         * course_teacher : 王涛
         * course_time : 2019-01-25 11:34:31
         * course_type : 文体艺术//音乐:声乐
         * dengji : 5
         * enrol_num : 5
         * hot_state : 0
         * is_coups : 1
         * is_golds : 0
         * original_price : 400元
         * picture_five :
         * picture_four :
         * picture_one : 2019/01/24/1548323570119.jpg
         * picture_three :
         * picture_two :
         * popularity_num : 125
         * preferential_price : 380元
         * school_id : 1548319339489
         * school_jing : 117.216826
         * school_name : 安鑫一家科技有限公司
         * school_wei : 39.112351
         * sd_id : 206
         * study_num : 1548320731995
         * user_id : abd3aa90cb6649ab8f4bee6314f2104c
         */

        private String age_range;
        private int collect_no;
        private String course_address;
        private String course_capacity;
        private String course_id;
        private String course_info;
        private String course_money;
        private String course_name;
        private String course_state;
        private String course_teacher;
        private String course_time;
        private String course_type;
        private String dengji;
        private String enrol_num;
        private String hot_state;
        private String is_coups;
        private String is_golds;
        private String original_price;
        private String picture_five;
        private String picture_four;
        private String picture_one;
        private String picture_three;
        private String picture_two;
        private String popularity_num;
        private String preferential_price;
        private String school_id;
        private String school_jing;
        private String school_name;
        private String school_wei;
        private int sd_id;
        private String study_num;
        private String study_code;
        private String user_id;

        public String getStudy_code() {
            return study_code == null ? "" : study_code;
        }

        public void setStudy_code(String study_code) {
            this.study_code = study_code;
        }

        public String getAge_range() {
            return age_range == null ? "" : age_range;
        }

        public void setAge_range(String age_range) {
            this.age_range = age_range;
        }

        public int getCollect_no() {
            return collect_no;
        }

        public void setCollect_no(int collect_no) {
            this.collect_no = collect_no;
        }

        public String getCourse_address() {
            return course_address == null ? "" : course_address;
        }

        public void setCourse_address(String course_address) {
            this.course_address = course_address;
        }

        public String getCourse_capacity() {
            return course_capacity == null ? "" : course_capacity;
        }

        public void setCourse_capacity(String course_capacity) {
            this.course_capacity = course_capacity;
        }

        public String getCourse_id() {
            return course_id == null ? "" : course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_info() {
            return course_info == null ? "" : course_info;
        }

        public void setCourse_info(String course_info) {
            this.course_info = course_info;
        }

        public String getCourse_money() {
            return course_money == null ? "" : course_money;
        }

        public void setCourse_money(String course_money) {
            this.course_money = course_money;
        }

        public String getCourse_name() {
            return course_name == null ? "" : course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public String getCourse_state() {
            return course_state == null ? "" : course_state;
        }

        public void setCourse_state(String course_state) {
            this.course_state = course_state;
        }

        public String getCourse_teacher() {
            return course_teacher == null ? "" : course_teacher;
        }

        public void setCourse_teacher(String course_teacher) {
            this.course_teacher = course_teacher;
        }

        public String getCourse_time() {
            return course_time == null ? "" : course_time;
        }

        public void setCourse_time(String course_time) {
            this.course_time = course_time;
        }

        public String getCourse_type() {
            return course_type == null ? "" : course_type;
        }

        public void setCourse_type(String course_type) {
            this.course_type = course_type;
        }

        public String getDengji() {
            return dengji == null ? "" : dengji;
        }

        public void setDengji(String dengji) {
            this.dengji = dengji;
        }

        public String getEnrol_num() {
            return enrol_num == null ? "" : enrol_num;
        }

        public void setEnrol_num(String enrol_num) {
            this.enrol_num = enrol_num;
        }

        public String getHot_state() {
            return hot_state == null ? "" : hot_state;
        }

        public void setHot_state(String hot_state) {
            this.hot_state = hot_state;
        }

        public String getIs_coups() {
            return is_coups == null ? "" : is_coups;
        }

        public void setIs_coups(String is_coups) {
            this.is_coups = is_coups;
        }

        public String getIs_golds() {
            return is_golds == null ? "" : is_golds;
        }

        public void setIs_golds(String is_golds) {
            this.is_golds = is_golds;
        }

        public String getOriginal_price() {
            return original_price == null ? "" : original_price;
        }

        public void setOriginal_price(String original_price) {
            this.original_price = original_price;
        }

        public String getPicture_five() {
            return picture_five == null ? "" : picture_five;
        }

        public void setPicture_five(String picture_five) {
            this.picture_five = picture_five;
        }

        public String getPicture_four() {
            return picture_four == null ? "" : picture_four;
        }

        public void setPicture_four(String picture_four) {
            this.picture_four = picture_four;
        }

        public String getPicture_one() {
            return picture_one == null ? "" : picture_one;
        }

        public void setPicture_one(String picture_one) {
            this.picture_one = picture_one;
        }

        public String getPicture_three() {
            return picture_three == null ? "" : picture_three;
        }

        public void setPicture_three(String picture_three) {
            this.picture_three = picture_three;
        }

        public String getPicture_two() {
            return picture_two == null ? "" : picture_two;
        }

        public void setPicture_two(String picture_two) {
            this.picture_two = picture_two;
        }

        public String getPopularity_num() {
            return popularity_num == null ? "" : popularity_num;
        }

        public void setPopularity_num(String popularity_num) {
            this.popularity_num = popularity_num;
        }

        public String getPreferential_price() {
            return preferential_price == null ? "" : preferential_price;
        }

        public void setPreferential_price(String preferential_price) {
            this.preferential_price = preferential_price;
        }

        public String getSchool_id() {
            return school_id == null ? "" : school_id;
        }

        public void setSchool_id(String school_id) {
            this.school_id = school_id;
        }

        public String getSchool_jing() {
            return school_jing == null ? "" : school_jing;
        }

        public void setSchool_jing(String school_jing) {
            this.school_jing = school_jing;
        }

        public String getSchool_name() {
            return school_name == null ? "" : school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }

        public String getSchool_wei() {
            return school_wei == null ? "" : school_wei;
        }

        public void setSchool_wei(String school_wei) {
            this.school_wei = school_wei;
        }

        public int getSd_id() {
            return sd_id;
        }

        public void setSd_id(int sd_id) {
            this.sd_id = sd_id;
        }

        public String getStudy_num() {
            return study_num == null ? "" : study_num;
        }

        public void setStudy_num(String study_num) {
            this.study_num = study_num;
        }

        public String getUser_id() {
            return user_id == null ? "" : user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
