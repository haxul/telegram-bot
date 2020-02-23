package com.haxul.telegram.bot;

import com.haxul.telegram.bot.actions.HelpAction;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final HelpAction helpAction;

    public Bot(HelpAction helpAction) {
        this.helpAction = helpAction;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            switch (update.getMessage().getText()) {
                case "/help":
                    helpAction.execute(this, update);
                    break;
                default:
                    long chatId = update.getMessage().getChatId();
                    String message = "Sorry, I don't recognize this command";
                    sendMessage(chatId, message);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
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
