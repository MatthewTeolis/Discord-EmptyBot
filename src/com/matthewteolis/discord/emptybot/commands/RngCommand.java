package com.matthewteolis.discord.emptybot.commands;

import com.matthewteolis.discord.emptybot.helpers.Helper;

import net.dv8tion.jda.core.entities.Message;

public class RngCommand extends AbstractCommandChain 
{
	public RngCommand(CommandEnum command)
	{
		this.command = command;
	}
	
	@Override
	protected void process(Message message) 
	{
		String messageContent = message.getContent();
		String[] parameters = Helper.getParameters(command, messageContent, ";");
		int result = Helper.randomWithRange(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
		
		Helper.botPrint(message.getChannel(), "RNG result: `" + String.valueOf(result) + "`");
	}
}