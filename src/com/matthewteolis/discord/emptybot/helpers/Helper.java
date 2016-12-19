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
		String[] rawParameters = message.split(delimiter);
		String[] parsedParameters = new String[rawParameters.length];
		    
		for(int i = 0; i < rawParameters.length; i++)
		{
		    parsedParameters[i] = rawParameters[i].trim();
		}
		    
		return parsedParameters;
	}
	
	public static String[] getParameters(CommandEnum command, String message, String delimiter)
	{
		Pattern pattern = Pattern.compile(command.getRegex());
		Matcher matcher = pattern.matcher(message);
		matcher.matches();
		String[] parameters = parseParameters(matcher.group(1), delimiter);
		
		return parameters;
	}
	
	public static int randomWithRange(int min, int max)
	{
		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}
}