package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class Employee {

    @ApiModelProperty(name = "id", value = "id")
    private Long id;

    @ApiModelProperty(name = "eid", value = "员工序列号")
    private String eid;

    @ApiModelProperty(name = "name", value = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(name = "mobile", value = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "(^1[2|3|4|5|6|7|8|9]\\d{9}$)|(^09\\d{8}$)", message = "请输入合法手机号码")
    private String mobile;

    @ApiModelProperty(name = "sex", value = "性别")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    @ApiModelProperty(name = "age", value = "年龄")
    private Integer age;

    @ApiModelProperty(name = "password", value = "密码")
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 18, message = "请输入正确长度的密码")
    private String password;

    private String salt;

    @ApiModelProperty(name = "roleId", value = "角色id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    @ApiModelProperty(name = "groupId", value = "小组id")
    @NotNull(message = "小组id不能为空")
    private Integer groupId;

    private Integer[] groupIds;

    @ApiModelProperty(name = "group", value = "小组名称")
    private String group;

    @ApiModelProperty(name = "role", value = "角色")
    private String role;

    @ApiModelProperty(name = "education", value = "教育")
    private Integer education;

    @ApiModelProperty(name = "provinceId", value = "省份id")
    private Integer provinceId;

    @ApiModelProperty(name = "cityId", value = "城市id")
    @NotNull(message = "城市id不能为空")
    private Integer cityId;

    @ApiModelProperty(name = "townId", value = "区域id")
    @NotNull(message = "区域id不能为空")
    private Integer townId;

    @ApiModelProperty(name = "detailAddress", value = "详细地址")
    @NotBlank(message = "详细地址不能为空")
    private String detailAddress;

    @ApiModelProperty(name = "birthday", value = "生日")
    private Date birthday;

    @ApiModelProperty(name = "email", value = "邮箱")
    @Pattern(message = "请输入正确的邮箱", regexp = "^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$")
    private String email;

    @ApiModelProperty(name = "contactName", value = "紧急联系人姓名")
    private String contactName;

    @ApiModelProperty(name = "contactPhone", value = "紧急联系人电话")
    private String contactPhone;

    private List<Permission> permissions;

    @ApiModelProperty(name = "attachment", value = "附件")
    private Integer[] attachment;


    private Date createTime;

    @ApiModelProperty(name = "queryStartTime", value = "查询开始时间")
    private Date queryStartTime;

    @ApiModelProperty(name = "queryEndTime", value = "查询结束时间")
    private Date queryEndTime;

    private Date updateTime;

    @ApiModelProperty(name = "status", value = "状态")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public Date getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer[] getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(Integer[] groupIds) {
        this.groupIds = groupIds;
    }

    public Integer[] getAttachment() {
        return attachment;
    }

    public void setAttachment(Integer[] attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleId=" + roleId +
                ", groupId=" + groupId +
                ", group='" + group + '\'' +
                ", role='" + role + '\'' +
                ", education=" + education +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", townId=" + townId +
                ", detailAddress='" + detailAddress + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", permissions=" + permissions +
                ", createTime=" + createTime +
                ", queryStartTime=" + queryStartTime +
                ", queryEndTime=" + queryEndTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}
