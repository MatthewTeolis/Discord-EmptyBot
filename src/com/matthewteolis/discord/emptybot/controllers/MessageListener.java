package com.matthewteolis.discord.emptybot.controllers;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import com.matthewteolis.discord.emptybot.commands.AbstractCommandChain;
import com.matthewteolis.discord.emptybot.commands.CommandChainFactory;
import com.matthewteolis.discord.emptybot.exceptions.CommandNotFoundException;

public class MessageListener extends ListenerAdapter
{
	private AbstractCommandChain commandChain;
	
	public MessageListener()
	{
		commandChain = CommandChainFactory.getChainOfCommands();
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		// Event specific information
		User author = event.getAuthor();
		Message message = event.getMessage();
		MessageChannel channel = event.getChannel();
		
		boolean bot = author.isBot();
		
		if(!bot)
		{
			try
			{
				commandChain.executeCommand(message);
			}
			catch(CommandNotFoundException e)
			{
//				channel.sendMessage("Command not found").queue();
			}
		}
	}
}