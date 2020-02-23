package com.haxul.telegram.bot.actions;

import com.haxul.telegram.bot.Bot;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class HelpAction implements BotAction {

    private void sendHelpMessage(Bot bot, Update update) throws TelegramApiException {
        long chatId = update.getMessage().getChatId();
        String text = "if you want to order water please type /order";
        SendMessage message = new SendMessage().setChatId(chatId).setText(text);
        bot.execute(message);
    }

    @Override
    public void execute(Bot bot, Update update) throws TelegramApiException {
        sendHelpMessage(bot, update);
    }

}
