package net.wtako.WTAKOTemplate.Utils;

import net.wtako.WTAKOTemplate.Commands.Temp.ArgHelp;
import net.wtako.WTAKOTemplate.Commands.Temp.ArgReload;

public enum Commands {

    MAIN_COMMAND(Lang.HELP_HELP.toString(), ArgHelp.class),
    H(Lang.HELP_HELP.toString(), ArgHelp.class),
    HELP(Lang.HELP_HELP.toString(), ArgHelp.class),
    RELOAD(Lang.HELP_RELOAD.toString(), ArgReload.class);

    private String   helpMessage;
    private Class<?> targetClass;

    private Commands(String helpMessage, Class<?> targetClass) {
        this.helpMessage = helpMessage;
        this.targetClass = targetClass;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}
