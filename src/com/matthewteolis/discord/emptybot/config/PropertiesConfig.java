package com.matthewteolis.discord.emptybot.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig implements BotConfig
{
	private static String token;
	private static String prefix;
	
	public PropertiesConfig(String propertiesFile) throws IOException
	{
		Properties properties = new Properties();
		InputStream inputStream = new FileInputStream(propertiesFile);
		
		properties.load(inputStream);
		
		token = properties.getProperty("token");
		prefix = properties.getProperty("prefix");
		
		inputStream.close();
	}
	
	@Override
	public String getToken()
	{
		return token;
	}
	
	@Override
	public String getPrefix()
	{
		return prefix;
	}
	
}