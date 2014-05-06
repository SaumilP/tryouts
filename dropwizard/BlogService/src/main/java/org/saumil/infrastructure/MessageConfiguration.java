package org.saumil.infrastructure;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.constraints.NotNull;

/**
 * Created by saumil on 2014/04/25.
 */
public class MessageConfiguration extends Configuration {
    @NotNull
    private String welcome;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }
}
