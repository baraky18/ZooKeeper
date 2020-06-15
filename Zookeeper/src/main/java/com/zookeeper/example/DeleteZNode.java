package com.zookeeper.example;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

public class DeleteZNode {

	private static ZooKeeper zk;
	private static ZkConnector zkConnector;
	
	public static void delete(String path) throws KeeperException, InterruptedException{
		zk.delete(path, zk.exists(path, true).getVersion());
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		String path = "/sampleznode";
		zkConnector = new ZkConnector();
		zk = zkConnector.connect("localhost");
		delete(path);
	}

}
