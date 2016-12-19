package com.matthewteolis.discord.emptybot.commands;

import com.matthewteolis.discord.emptybot.helpers.Helper;

import net.dv8tion.jda.core.entities.Message;

public class ChooseCommand extends AbstractCommandChain 
{
	public ChooseCommand(CommandEnum command)
	{
		this.command = command;
	}
	
	@Override
	protected void process(Message message) 
	{
		String messageContent = message.getContent();
		String[] options = Helper.getParameters(command, messageContent, ";");
		
		int random = (int) (Math.random() * options.length) + 1;
		
		String result = options[random - 1];
		
		Helper.botPrint(message.getChannel(), "Chosen result: `" + result + "`");
	}
}