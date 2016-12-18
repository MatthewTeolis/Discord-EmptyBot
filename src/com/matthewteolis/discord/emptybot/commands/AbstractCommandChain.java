package com.matthewteolis.discord.emptybot.commands;

import net.dv8tion.jda.core.entities.Message;

import com.matthewteolis.discord.emptybot.exceptions.CommandNotFoundException;

public abstract class AbstractCommandChain
{
	protected CommandEnum command;
	protected AbstractCommandChain nextCommand;
	
	public void setNextCommand(AbstractCommandChain nextCommand)
	{
		this.nextCommand = nextCommand;
	}
	
	public void executeCommand(Message message) throws CommandNotFoundException
	{
		if(CommandEnum.parse(message.getContent()) == this.command)
		{
			process(message);
		}
		else if(nextCommand != null)
		{
			nextCommand.executeCommand(message);
		}
	}
	
	protected abstract void process(Message message);
}