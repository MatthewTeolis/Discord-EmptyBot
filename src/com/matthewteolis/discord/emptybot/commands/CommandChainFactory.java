package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain rngCommand = new ChooseCommand(CommandEnum.CHOOSE);
		
		return rngCommand;
	}
}