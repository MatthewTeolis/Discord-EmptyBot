package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain chooseCommand = new ChooseCommand(CommandEnum.CHOOSE);
		AbstractCommandChain coinFlipCommand = new CoinFlipCommand(CommandEnum.COINFLIP);
		
		chooseCommand.setNextCommand(coinFlipCommand);
		
		return chooseCommand;
	}
}