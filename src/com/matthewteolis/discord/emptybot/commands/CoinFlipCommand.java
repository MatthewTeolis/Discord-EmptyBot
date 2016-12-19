package com.matthewteolis.discord.emptybot.commands;

import java.io.File;
import java.io.IOException;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class CoinFlipCommand extends AbstractCommandChain
{
	private File headsFile = new File("images/heads.png");
	private File tailsFile = new File("images/tails.png");
	
	public CoinFlipCommand(CommandEnum command)
	{
		this.command = command;
	}

	@Override
	protected void process(Message message)
	{
		MessageChannel channel = message.getChannel();
		
		try
		{
			if(Math.round(Math.random()) == 0)
			{
				channel.sendFile(headsFile, null).queue();
			}
			else
			{
				channel.sendFile(tailsFile, null).queue();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}