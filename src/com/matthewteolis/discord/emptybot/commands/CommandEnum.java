package com.matthewteolis.discord.emptybot.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.matthewteolis.discord.emptybot.Bot;
import com.matthewteolis.discord.emptybot.exceptions.CommandNotFoundException;

public enum CommandEnum
{
	;
	
	private String regex;
	
	private CommandEnum(String regex)
	{
		this.regex = regex;
	}
	
	public static CommandEnum parse(String message) throws CommandNotFoundException
	{
		CommandEnum[] enumCommands = CommandEnum.values();
		for(CommandEnum enumCommand : enumCommands)
		{
			Pattern pattern = Pattern.compile(enumCommand.regex);
			Matcher matcher = pattern.matcher(message);
			if(matcher.matches())
			{
				return enumCommand;
			}
		}
		throw new CommandNotFoundException();
	}
}