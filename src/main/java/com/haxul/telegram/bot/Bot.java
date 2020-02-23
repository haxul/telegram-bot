package com.haxul.telegram.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
@PropertySource("classpath:telegram.properties")
public class Bot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
       switch (update.getMessage().getText()) {
           case "/help":
               update.getMessage().getChatId();
               break;
       }
//        if (update.getMessage().getText().equals(Commands.HELP.getCommand())) {
//            try {
//                sendMessage(chatId, "If you want to order bottle of water please type /");
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//
//        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    private void sendMessage(long chatId, String text) throws TelegramApiException {
        SendMessage message = new SendMessage().setChatId(chatId).setText(text);
        execute(message);
    }
}
