package net.wtako.WTAKOTemplate.Utils;

public interface BaseCommands {

    public String getHelpMessage();

    public String name();

    public Class<?> getTargetClass();

    public String getRequiredPermission();

}
