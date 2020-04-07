package com.example.demo.entity;

import lombok.Data;

/**
 * 2020/3/11
 *
 * @author Ch-shuai
 * @Description
 *      权限对应实体类
 *
 */
@Data
public class Permissions {
    private String id;
    private String permissionsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public Permissions(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;

    }

    public Permissions() {
    }

}
