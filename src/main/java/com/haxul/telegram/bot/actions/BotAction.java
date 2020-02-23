package com.haxul.telegram.bot.actions;

import com.haxul.telegram.bot.Bot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface BotAction {
    void execute (Bot bot, Update update) throws TelegramApiException;
}
