package com.matthewteolis.discord.emptybot.commands;

public class CommandChainFactory
{
	public static AbstractCommandChain getChainOfCommands()
	{
		AbstractCommandChain chooseCommand = new ChooseCommand(CommandEnum.CHOOSE);
		AbstractCommandChain rngCommand = new RngCommand(CommandEnum.RNG);
		AbstractCommandChain coinFlipCommand = new CoinFlipCommand(CommandEnum.COINFLIP);
		AbstractCommandChain diceCommand = new DiceCommand(CommandEnum.DICE);
		
		chooseCommand.setNextCommand(rngCommand);
		rngCommand.setNextCommand(coinFlipCommand);
		coinFlipCommand.setNextCommand(diceCommand);
		
		return chooseCommand;
	}
}