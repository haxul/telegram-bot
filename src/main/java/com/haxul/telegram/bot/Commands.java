package com.haxul.telegram.bot;

public enum Commands {
    HELP("/help");

    private String command;

    public String getCommand()
    {
        return command;
    }

    private Commands(final String action)
    {
        this.command = action;
    }
}
