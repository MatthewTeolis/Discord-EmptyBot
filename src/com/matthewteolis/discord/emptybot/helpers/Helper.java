package com.matthewteolis.discord.emptybot.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.matthewteolis.discord.emptybot.commands.CommandEnum;

import net.dv8tion.jda.core.entities.MessageChannel;

public class Helper 
{
	public static void botPrint(MessageChannel channel, String message)
	{
		channel.sendMessage(message).queue();
	}
	
	public static String[] parseParameters(String message, String delimiter)
	{
	    String[] rawOptions = message.split(delimiter);
	    String[] parsedOptions = new String[rawOptions.length];
	        
	    for(int i = 0; i < rawOptions.length; i++)
	    {
	        parsedOptions[i] = rawOptions[i].trim();
	    }
	        
	    return parsedOptions;
	}
	
	public static String[] getParameters(CommandEnum command, String message, String delimiter)
	{
		Pattern pattern = Pattern.compile(command.getRegex());
		Matcher matcher = pattern.matcher(message);
		matcher.matches();
		String[] parameters = parseParameters(matcher.group(), delimiter);
		
		return parameters;
	}
}