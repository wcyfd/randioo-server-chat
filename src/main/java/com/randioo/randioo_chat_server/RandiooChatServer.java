package com.randioo.randioo_chat_server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;

import com.randioo.randioo_server_base.module.ServiceManager;
import com.randioo.randioo_server_base.net.ServerConfig;
import com.randioo.randioo_server_base.net.SpringContext;
import com.randioo.randioo_server_base.net.WanServer;
import com.randioo.randioo_server_base.net.protocal.protobuf.ServerMessageCodecFactory;
import com.randioo.randioo_server_base.utils.db.DatabaseInitialization;

/**
 * Hello world!
 *
 */
public class RandiooChatServer 
{
    public static void main( String[] args )
    {
    	int port = 6665;
		SpringContext.initSpringCtx("ApplicationContext.xml");

		DatabaseInitialization databaseInit = (DatabaseInitialization) SpringContext.getBean("databaseInitialization");
		databaseInit.setDatabaseName(databaseInit.getDatabaseName());
		databaseInit.initialize();

		((ServiceManager) SpringContext.getBean("serviceManager")).initServices();

		System.out.println("Hello RandiooChatServer!");
		WanServer.startServer(
				new ProtocolCodecFilter(new ServerMessageCodecFactory(Charset.forName(ServerConfig.getCharSet()))),
				new ServerHandler(), new InetSocketAddress(port));		
    }
}
