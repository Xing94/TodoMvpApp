package com.lucio.mvpapp.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.lucio.appframework.base.BaseBean;


/**
 * 登录实体类
 * 安装Parcelable插件一键生成
 */
public class LoginBean extends BaseBean implements Parcelable {

    /**
     * userInfo : {"id":10356,"phone":"13122576190","nickName":"新用户","headImg":null,"gender":null,"birthday":null,"email":null,"addTime":1501108716430,"deviceId":null,"thirdId":null,"thirdType":null,"status":"0"}
     * reCode : 0
     * reMsg :
     */

    private UserInfoBean userInfo;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean implements Parcelable {
        /**
         * id : 10356
         * phone : 13122576190
         * nickName : 新用户
         * headImg : null
         * gender : null
         * birthday : null
         * email : null
         * addTime : 1501108716430
         * deviceId : null
         * thirdId : null
         * thirdType : null
         * status : 0
         */

        private int id;
        private String phone;
        private String nickName;
        private String headImg;
        private String gender;
        private String birthday;
        private String email;
        private long addTime;
        private String deviceId;
        private String thirdId;
        private String thirdType;
        private String status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getThirdId() {
            return thirdId;
        }

        public void setThirdId(String thirdId) {
            this.thirdId = thirdId;
        }

        public String getThirdType() {
            return thirdType;
        }

        public void setThirdType(String thirdType) {
            this.thirdType = thirdType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.phone);
            dest.writeString(this.nickName);
            dest.writeString(this.headImg);
            dest.writeString(this.gender);
            dest.writeString(this.birthday);
            dest.writeString(this.email);
            dest.writeLong(this.addTime);
            dest.writeString(this.deviceId);
            dest.writeString(this.thirdId);
            dest.writeString(this.thirdType);
            dest.writeString(this.status);
        }

        public UserInfoBean() {
        }

        protected UserInfoBean(Parcel in) {
            this.id = in.readInt();
            this.phone = in.readString();
            this.nickName = in.readString();
            this.headImg = in.readString();
            this.gender = in.readString();
            this.birthday = in.readString();
            this.email = in.readString();
            this.addTime = in.readLong();
            this.deviceId = in.readString();
            this.thirdId = in.readString();
            this.thirdType = in.readString();
            this.status = in.readString();
        }

        public static final Creator<UserInfoBean> CREATOR = new Creator<UserInfoBean>() {
            @Override
            public UserInfoBean createFromParcel(Parcel source) {
                return new UserInfoBean(source);
            }

            @Override
            public UserInfoBean[] newArray(int size) {
                return new UserInfoBean[size];
            }
        };

        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "id=" + id +
                    ", phone='" + phone + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", headImg='" + headImg + '\'' +
                    ", gender='" + gender + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", email='" + email + '\'' +
                    ", addTime=" + addTime +
                    ", deviceId='" + deviceId + '\'' +
                    ", thirdId='" + thirdId + '\'' +
                    ", thirdType='" + thirdType + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "LoginBean{" +
                "userInfo=" + userInfo +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.userInfo, flags);
    }

    public LoginBean() {
    }

    protected LoginBean(Parcel in) {
        this.userInfo = in.readParcelable(UserInfoBean.class.getClassLoader());
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel source) {
            return new LoginBean(source);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };
}
