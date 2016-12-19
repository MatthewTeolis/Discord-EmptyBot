package com.matthewteolis.discord.emptybot.commands;

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
		String input = messageContent.replace("sudo rng ", "");
		String[] options = parseOptions(input);
		
		int random = (int) (Math.random() * options.length) + 1;
		
		String result = options[random - 1];
		
		message.getChannel().sendMessage("RNG result: `" + result + "`").queue();
	}
	
	private String[] parseOptions(String message)
	{
	    String[] rawOptions = message.split(";");
	    String[] parsedOptions = new String[rawOptions.length];
	        
	    for(int i = 0; i < rawOptions.length; i++)
	    {
	        parsedOptions[i] = rawOptions[i].trim();
	    }
	        
	    return parsedOptions;
	}
}