package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain chooseCommand = new ChooseCommand(CommandEnum.CHOOSE);
		AbstractCommandChain rngCommand = new RngCommand(CommandEnum.RNG);
		
		chooseCommand.nextCommand = rngCommand;
		
		return chooseCommand;
	}
}