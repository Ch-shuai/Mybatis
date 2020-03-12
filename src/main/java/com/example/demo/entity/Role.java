package com.example.demo.entity;

import lombok.Data;

import java.util.Set;

/**
 * 2020/3/11
 *
 * @author Ch-shuai
 * @Description
 */
@Data
public class Role {
    private String id;
    private String roleName;
    /**
     * 角色对应集合权限
     */
    private Set<Permissions> permissions;
}
