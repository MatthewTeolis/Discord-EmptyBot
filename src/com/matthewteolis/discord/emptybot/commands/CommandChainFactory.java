package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain chooseCommand = new ChooseCommand(CommandEnum.CHOOSE);
		
		return chooseCommand;
	}
}