package com.matthewteolis.discord.emptybot.commands;

import java.io.File;
import java.io.IOException;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

public class CoinFlipCommand extends AbstractCommandChain
{
	private File[] files;
	
	public CoinFlipCommand(CommandEnum command)
	{
		this.command = command;
		files = new File[2];
		
		files[0] = new File("images/heads.png");
		files[1] = new File("images/tails.png");
	}

	@Override
	protected void process(Message message)
	{
		try
		{
			int randomNumber = (int)Math.round(Math.random());
			File randomFile = files[randomNumber];
			
			message.getChannel().sendFile(randomFile, null).queue();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}