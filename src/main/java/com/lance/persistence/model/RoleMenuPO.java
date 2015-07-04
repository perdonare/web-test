package com.lance.persistence.model;

public class RoleMenuPO {
    private String id;

    private String roleId;

    private String menuId;

    private String actions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions == null ? null : actions.trim();
    }
}