package com.matthewteolis.discord.emptybot.commands;

import java.io.File;
import java.io.IOException;

import com.matthewteolis.discord.emptybot.helpers.Helper;

import net.dv8tion.jda.core.entities.Message;

public class CoinFlipCommand extends AbstractCommandChain
{
	private static final String IMAGE_PATH = "images/coin/";
	
	private File[] files;
	
	public CoinFlipCommand(CommandEnum command)
	{
		this.command = command;
		files = new File[2];
		
		files[0] = new File(IMAGE_PATH + "heads.png");
		files[1] = new File(IMAGE_PATH + "tails.png");
	}

	@Override
	protected void process(Message message)
	{
		try
		{
			int randomNumber = Helper.randomWithRange(0, 1);
			File randomFile = files[randomNumber];
			
			Helper.botSendFile(message.getChannel(), randomFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}