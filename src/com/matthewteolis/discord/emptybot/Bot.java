package com.matthewteolis.discord.emptybot;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import com.matthewteolis.discord.emptybot.config.BotConfig;
import com.matthewteolis.discord.emptybot.config.PropertiesConfig;
import com.matthewteolis.discord.emptybot.controllers.MessageListener;

public class Bot
{
	private static String prefix;
	
	public static void main(String[] args) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException, IOException
	{
		BotConfig config = new PropertiesConfig("bot.properties");
		prefix = config.getPrefix();
		
		String token = config.getToken();
		JDA bot = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
		
		bot.addEventListener(new MessageListener());
	}
	
	public static String getPrefix()
	{
		return prefix;
	}
}