package com.matthewteolis.discord.emptybot.commands;

import java.io.File;
import java.io.IOException;

import com.matthewteolis.discord.emptybot.helpers.Helper;

import net.dv8tion.jda.core.entities.Message;

public class DiceCommand extends AbstractCommandChain 
{
	private static final String IMAGE_PATH = "images/dice/";
	private File[] files = new File[6];
	
	public DiceCommand(CommandEnum command)
	{
		this.command = command;
		
		for(int i = 0; i < files.length; i++)
		{
		    files[i] = new File(IMAGE_PATH + (i + 1) + ".png");
		}
	}

	@Override
	protected void process(Message message) 
	{
		int randomFile = Helper.randomWithRange(0, 5);
		
		try
		{
			Helper.botSendFile(message.getChannel(), files[randomFile]);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}