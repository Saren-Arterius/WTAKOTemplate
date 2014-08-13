package net.wtako.WTAKOTemplate.Utils;

import net.wtako.WTAKOTemplate.Main;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgHelp;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgReload;

public enum Commands {

    MAIN_COMMAND(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    H(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    HELP(Lang.HELP_HELP.toString(), ArgHelp.class, Main.artifactId + ".use"),
    RELOAD(Lang.HELP_RELOAD.toString(), ArgReload.class, Main.artifactId + ".reload");

    private String   helpMessage;
    private Class<?> targetClass;
    private String   permission;

    private Commands(String helpMessage, Class<?> targetClass, String permission) {
        this.helpMessage = helpMessage;
        this.targetClass = targetClass;
        this.permission = permission;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public String getRequiredPermission() {
        return permission;
    }
}
