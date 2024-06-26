package org.saumil.infrastructure;

import javax.validation.constraints.NotNull;

/**
 * Created by saumil on 2014/04/25.
 */
public class DatabaseConfiguration {
    @NotNull
    private String driverClass;
    private String user;
    private String password;

    @NotNull
    private String url;


    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
