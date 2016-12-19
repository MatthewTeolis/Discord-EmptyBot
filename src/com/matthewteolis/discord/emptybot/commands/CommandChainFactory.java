package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain chooseCommand = new ChooseCommand(CommandEnum.CHOOSE);
		AbstractCommandChain rngCommand = new RngCommand(CommandEnum.RNG);
		
		AbstractCommandChain coinFlipCommand = new CoinFlipCommand(CommandEnum.COINFLIP);
		
		chooseCommand.setNextCommand(rngCommand);
		rngCommand.setNextCommand(coinFlipCommand);
		
		return chooseCommand;
	}
}