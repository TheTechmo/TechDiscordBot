package me.TechsCode.TechDiscordBot.util;

import me.TechsCode.TechDiscordBot.Query;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CustomEmbedBuilder extends EmbedBuilder {

    public CustomEmbedBuilder(String title) {
        if(title != null) setAuthor(title, "http://techsco.de", "https://i.imgur.com/nnegGEV.png");
        setColor(new Color(81, 153, 226));
        setFooter("Developed by Tech & Team");
    }

    public CustomEmbedBuilder(String title, boolean footer) {
        if(title != null) setAuthor(title, "http://techsco.de", "https://i.imgur.com/nnegGEV.png");
        setColor(new Color(81, 153, 226));
        if(footer) setFooter("Developed by Tech & Team");
    }

    public CustomEmbedBuilder(boolean footer) {
        setColor(new Color(81, 153, 226));
        if(footer) setFooter("Developed by Tech & Team");
    }

    public CustomEmbedBuilder setFooter(String text) {
        setFooter("Tech's Plugin Support • " + text, "https://i.imgur.com/nzfiUTy.png");
        return this;
    }

    public CustomEmbedBuilder error() {
        setColor(new Color(178,34,34));
        return this;
    }

    public CustomEmbedBuilder success() {
        setColor(new Color(50, 205, 50));
        return this;
    }

    public CustomEmbedBuilder setText(String text) {
        setDescription(text);
        return this;
    }

    public Message send(TextChannel textChannel) {
        return textChannel.sendMessage(build()).complete();
    }

    public Message send(Query<TextChannel> msg) {
        return msg.first().sendMessage(build()).complete();
    }

    public Message sendAfter(TextChannel textChannel, TimeUnit unit, int amount) {
        return textChannel.sendMessage(build()).completeAfter(amount, unit);
    }

    public Message send(User user) {
        return user.openPrivateChannel().complete().sendMessage(build()).complete();
    }

    public Message send(Member member) {
        return send(member.getUser());
    }

    public void sendTemporary(TextChannel textChannel, int duration, TimeUnit timeUnit) {
        Message message = send(textChannel);
        message.delete().submitAfter(duration, timeUnit);
    }

    public void sendTemporary(TextChannel textChannel, int duration) {
        sendTemporary(textChannel, duration, TimeUnit.SECONDS);
    }

    @Override
    public CustomEmbedBuilder setThumbnail(String url) {
        super.setThumbnail(url);
        return this;
    }

    @Override
    public CustomEmbedBuilder setColor(Color color) {
        super.setColor(color);
        return this;
    }

    @Override
    public CustomEmbedBuilder setImage(String url) {
        super.setImage(url);
        return this;
    }

    @Override
    public CustomEmbedBuilder addField(String name, String value, boolean inline) {
        super.addField(name, value, inline);
        return this;
    }

    @Override
    public CustomEmbedBuilder addBlankField(boolean inline) {
        super.addBlankField(inline);
        return this;
    }
}
